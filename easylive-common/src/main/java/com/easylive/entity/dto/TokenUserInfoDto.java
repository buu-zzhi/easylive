package com.easylive.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenUserInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String nickName;
    private String avatar;
    private Long expireAt;
    private String token;
    private Integer fansCount;
    private Integer currentCoinCount;
    private Integer focusCount;
}
