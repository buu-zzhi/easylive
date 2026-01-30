package com.easylive.web.controller;

import com.easylive.component.RedisComponent;
import com.easylive.entity.constants.Constants;
import com.easylive.entity.constants.ExceptionConstants;
import com.easylive.entity.dto.TokenUserInfoDto;
import com.easylive.exception.BaseException;
import com.easylive.result.Result;
import com.easylive.service.UserInfoService;
import com.easylive.utils.StringTools;
import com.wf.captcha.SpecCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/account")
@Validated
@Slf4j
public class AccountController extends ABaseController {
    @Resource
    private UserInfoService userInfoService;

    @Resource
    private RedisComponent redisComponent;

    @RequestMapping("/checkCode")
    public Result checkCode() {
        // 改用 SpecCaptcha 或 GiftCaptcha，它们不使用 ScriptEngine
        SpecCaptcha captcha = new SpecCaptcha(130, 48, 5);
        String code = captcha.text();
        String checkCodeKey = redisComponent.saveCheckCode(code);
        String checkCodeBase64 = captcha.toBase64();
        Map<String, String> result = new HashMap<>();
        result.put("checkCode", checkCodeBase64);
        result.put("checkCodeKey", checkCodeKey);
        return Result.success(result);
    }

    @RequestMapping("/register")
    public Result register(@NotEmpty @Email @Size(max = 150) String email,
                           @NotEmpty @Size(max = 20) String nickName,
                           @NotEmpty @Pattern(regexp = Constants.REGEX_PASSWORD) String registerPassword,
                           @NotEmpty String checkCodeKey,
                           @NotEmpty String checkCode) {
        try {
            if (!checkCode.equals(redisComponent.getCheckCode(checkCodeKey))) {
                throw new BaseException(ExceptionConstants.CAPTCHA_ERROR);
            }
            userInfoService.register(email, nickName, registerPassword);
            return Result.success("注册成功");
        } finally {
            redisComponent.cleanCheckCode(checkCodeKey);
        }
    }

    @RequestMapping("/login")
    public Result login(HttpServletRequest request, HttpServletResponse response,
                        @NotEmpty @Email String email,
                        @NotEmpty String password,
                        @NotEmpty String checkCodeKey,
                        @NotEmpty String checkCode) {
        try {
            if (!checkCode.equals(redisComponent.getCheckCode(checkCodeKey))) {
                throw new BaseException(ExceptionConstants.CAPTCHA_ERROR);
            }
            String ip = getIpAddr();
            TokenUserInfoDto tokenUserInfoDto = userInfoService.login(email, password, ip);
            saveToken2Cookie(response, tokenUserInfoDto.getToken());
            // TODO 设置粉丝数 硬币数 关注数
            return Result.success(tokenUserInfoDto);
        } finally {
            // 清除验证码 和 删除cookie中已有的管理员token
            redisComponent.cleanCheckCode(checkCodeKey);
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                String token = null;
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(Constants.TOKEN_WEB)) {
                        token = cookie.getValue();
                    }
                }
                if (!StringTools.isEmpty(token)) {
                    redisComponent.cleanToken(token);
                }
            }
        }
    }

    @RequestMapping("/autoLogin")
    public Result login(HttpServletResponse response) {
        TokenUserInfoDto tokenUserInfoDto = getTokenUserInfoDto();
        if (tokenUserInfoDto == null) {
            return Result.error(ExceptionConstants.NOT_LOGIN);
        }
        if (tokenUserInfoDto.getExpireAt() - System.currentTimeMillis() < Constants.REDIS_KEY_EXPIRES_ONE_DAY) {
            redisComponent.saveToKenInfo(tokenUserInfoDto);  //续期
        }
        saveToken2Cookie(response, tokenUserInfoDto.getToken());
        // TODO 设置粉丝数 硬币数 关注数
        return Result.success(tokenUserInfoDto);
    }

    @RequestMapping("/logout")
    public Result logout(HttpServletResponse response) {
        cleanCookie(response);
        return Result.success(null);
    }
}
