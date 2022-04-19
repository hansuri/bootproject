package com.coding404.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//회원가입 화면처리
	@GetMapping("/sign")
	public String sign() {
		
		return "user/sign";
	}
	
	//이력 화면처리
	@GetMapping("/history")
	public String history() {
		
		return "user/history";
	}
	
	//마이페이지 화면처리
	@GetMapping("/mypage")
	public String mypage() {
		
		return "user/mypage";
	}

}
