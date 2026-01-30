package com.easylive.web.exception;

import com.easylive.entity.constants.ExceptionConstants;
import com.easylive.exception.BusinessException;
import com.easylive.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.net.BindException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Result ex(Exception e) {
        if (e instanceof ConstraintViolationException || e instanceof BindException) {
            // 注册传递参数错误
            return Result.error(ExceptionConstants.PARAMS_ERROR);
        } else if (e instanceof BusinessException) {
            return Result.error(e.getMessage());
        } else {
            return Result.error(e.getMessage());
        }
    }
}
