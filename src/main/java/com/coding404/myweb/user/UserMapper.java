package com.coding404.myweb.user;

import org.apache.ibatis.annotations.Mapper;

import com.coding404.myweb.command.UserVO;
import com.coding404.myweb.command.loginVO;

@Mapper
public interface UserMapper {
	
	public int join(UserVO vo); //회원가입
	
	public UserVO login(loginVO vo); //로그인

	public int userUpdate(UserVO vo); //회원정보수정
}
