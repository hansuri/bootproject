package com.coding404.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rec")
public class RecController {
	
	//회원가입 화면처리
	@GetMapping("/rec_list")
	public String rec_list() {
		
		return "rec/rec_list";
	}

}
