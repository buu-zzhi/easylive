package com.easylive.service;

import com.easylive.entity.dto.TokenUserInfoDto;

public interface UserInfoService {
    void register(String email, String nickName, String registerPassword);

    TokenUserInfoDto login(String email, String password, String ip);
}
