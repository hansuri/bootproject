package com.coding404.myweb.user;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.coding404.myweb.command.HistoryVO;
import com.coding404.myweb.command.UserVO;
import com.coding404.myweb.command.loginVO;

@Mapper
public interface UserMapper {
	
	public int join(UserVO vo); //회원가입
	
	public UserVO login(loginVO vo); //로그인

	public int userUpdate(UserVO vo); //회원정보수정
	
	public ArrayList<HistoryVO> getHistory(String user_id); //이력 list 조회
}
