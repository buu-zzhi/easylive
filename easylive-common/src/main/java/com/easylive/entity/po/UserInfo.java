package com.easylive.entity.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 用户信息
 * @date: 2025/12/23
 * @author: 不知知
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
	/**
	 * 用户id
	 */
	private String userId;

	/**
	 * 
	 */
	private String nickName;

	/**
	 * 
	 */
	private String email;

	/**
	 * 
	 */
	private String password;

	/**
	 * 0:女 1:男 2:未知
	 */
	private Integer sex;

	/**
	 * 出生日期
	 */
	private String birthday;

	/**
	 * 学校
	 */
	private String school;

	/**
	 * 个人介绍
	 */
	private String personIntroduction;

	/**
	 * 
	 */
	private Date joinTime;

	/**
	 * 最后登录时间
	 */
	private Date lastLoginTime;

	/**
	 * 最后登录ip
	 */
	private String lastLoginIp;

	/**
	 * 
	 */
	private Integer status;

	/**
	 * 空间公告
	 */
	private String noticeInfo;

	/**
	 * 
	 */
	private Integer totalCoinCount;

	/**
	 * 
	 */
	private Integer currentCoinCount;

	/**
	 * 
	 */
	private Integer theme;

}