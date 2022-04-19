package com.coding404.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/free")
public class FreeBoardController {

	//자유게시판등록 화면처리
	@GetMapping("free_reg")
	public String free_reg() {
		
		return "free/free_reg";
	}
	
	//자유게시판 화면처리
	@GetMapping("free_list")
	public String free_list() {
		
		return "free/free_list";
	}
	
	//자유게시판상세보기 화면처리
	@GetMapping("free_detail")
	public String free_detail() {
		
		return "free/free_detail";
	}
	
}
