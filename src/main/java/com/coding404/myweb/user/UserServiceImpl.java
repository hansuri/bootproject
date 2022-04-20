package com.coding404.myweb.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding404.myweb.command.UserVO;
import com.coding404.myweb.command.loginVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public int join(UserVO vo) {         //회원가입
		return userMapper.join(vo);
	}

	@Override
	public UserVO login(loginVO vo) {    //로그인
		return userMapper.login(vo);
	}



	

}
