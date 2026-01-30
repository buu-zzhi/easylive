package com.easylive.service.impl;

import com.easylive.component.RedisComponent;
import com.easylive.entity.constants.Constants;
import com.easylive.entity.constants.ExceptionConstants;
import com.easylive.entity.dto.TokenUserInfoDto;
import com.easylive.entity.enums.UserSexEnum;
import com.easylive.entity.enums.UserStatusEnum;
import com.easylive.entity.po.UserInfo;
import com.easylive.exception.BusinessException;
import com.easylive.redis.RedisUtils;
import com.easylive.utils.StringTools;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.easylive.service.UserInfoService;
import com.easylive.mapper.UserInfoMapper;

import java.util.Date;

@Service
public class UserUserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoMapper userInfoMapper;
    @Autowired
    private RedisComponent redisComponent;

    @Override
    public void register(String email, String nickName, String registerPassword) {
        UserInfo userInfo = userInfoMapper.getByEmail(email);
        if (userInfo != null) {
            throw new BusinessException(ExceptionConstants.EMAIL_EXISTED);
        }
        userInfo = userInfoMapper.getByNickName(nickName);
        if (userInfo != null) {
            throw new BusinessException(ExceptionConstants.NICKNAME_EXISTED);
        }
        String userId = StringTools.getRandomNumber(Constants.length_10);
        userInfo = UserInfo.builder()
                .userId(userId)
                .nickName(nickName)
                .email(email)
                .password(StringTools.enCodeByMd5(registerPassword))
                .joinTime(new Date())
                .status(UserStatusEnum.ENABLE.getStatus())
                .sex(UserSexEnum.SECRET.getStatus())
                .theme(Constants.DEFAULT_THEME)
                .currentCoinCount(Constants.DEFAULT_COIN_COUNT)
                .totalCoinCount(Constants.DEFAULT_COIN_COUNT)
                .build();
        // TODO 硬币初始化
        userInfoMapper.insert(userInfo);
    }

    @Override
    public TokenUserInfoDto login(String email, String password, String ip) {
        UserInfo userInfo = userInfoMapper.getByEmail(email);
        if (userInfo  == null || !userInfo.getPassword().equals(password)) {
            throw new BusinessException(ExceptionConstants.ACCOUNT_OR_PASSWORD_ERROR);
        }
        if (userInfo.getStatus().equals(UserStatusEnum.DISABLE.getStatus())) {
            throw new BusinessException(ExceptionConstants.ACCOUNT_DISABLED);
        }

        userInfo.setLastLoginIp(ip);
        userInfo.setLastLoginTime(new Date());
        userInfoMapper.updateById(userInfo);

        TokenUserInfoDto tokenUserInfoDto = new TokenUserInfoDto();
        BeanUtils.copyProperties(userInfo, tokenUserInfoDto);
        redisComponent.saveToKenInfo(tokenUserInfoDto);

        return tokenUserInfoDto;
    }

}
