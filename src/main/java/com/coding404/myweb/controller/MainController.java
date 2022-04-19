package com.coding404.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	
	//메인 화면처리
	@GetMapping("/main")
	public String main() {
		
		return "main";
	}
	
	//정보 화면처리
	@GetMapping("/info")
	public String info() {
		
		return "info";
	}
	
}
