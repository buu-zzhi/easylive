package com.easylive.exception;

import com.easylive.entity.enums.ResponseEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BusinessException extends BaseException {

    @Getter
    private Integer code;

    @Getter
    private String message;

    public BusinessException(String msg) {
        super(msg);
        this.message = msg;
    }

    public BusinessException(ResponseEnum responseEnum) {
        super(responseEnum.getMsg());
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMsg();
    }

}
