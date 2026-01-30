package com.easylive.mapper;

import com.easylive.entity.po.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserInfoMapper {
	@Select("select * from user_info where user_id=#{id}")
    UserInfo getById(Long id);

    @Select("select * from user_info where email=#{email}")
    UserInfo getByEmail(String email);

    @Select("select * from user_info where nick_name=#{nickName}")
    UserInfo getByNickName(String nickName);

	@Delete("delete from user_info where user_id=#{id}")
	void deleteById(Long id);

	@Insert("insert into user_info (user_id, nick_name, email, password, sex, birthday, school, person_introduction, join_time, last_login_time, last_login_ip, status, notice_info, total_coin_count, current_coin_count, theme) " +
		"values (#{userId}, #{nickName}, #{email}, #{password}, #{sex}, #{birthday}, #{school}, #{personIntroduction}, #{joinTime}, #{lastLoginTime}, #{lastLoginIp}, #{status}, #{noticeInfo}, #{totalCoinCount}, #{currentCoinCount}, #{theme})")
	void insert(UserInfo userInfo);

	void updateById(UserInfo userInfo);

}