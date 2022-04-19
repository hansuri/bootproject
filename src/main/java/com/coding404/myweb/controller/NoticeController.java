package com.coding404.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	//공지게시판등록 화면처리
	@GetMapping("/notice_reg")
	public String notice_reg() {
		
		return "notice/notice_reg";
	}
	
	//공지게시판 화면처리
	@GetMapping("/notice")
	public String notice() {
		
		return "notice/notice";
	}

}
