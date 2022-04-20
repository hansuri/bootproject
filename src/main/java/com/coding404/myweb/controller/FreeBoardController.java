package com.coding404.myweb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding404.myweb.command.FreeVO;
import com.coding404.myweb.free.FreeService;

@Controller
@RequestMapping("/free")
public class FreeBoardController {

	@Autowired
	@Qualifier("freeService")
	private FreeService freeService;
	
	
	//자유게시판등록 화면처리
	@GetMapping("free_reg")
	public String free_reg() {
		
		return "free/free_reg";
	}
	
	//자유게시판 화면처리
	@GetMapping("free_list")
	public String free_list(Model model) {
		
		ArrayList<FreeVO> list = freeService.getList();
		
		model.addAttribute("list", list);
		
		return "free/free_list";
	}
	
	//자유게시판상세보기 화면처리
	@GetMapping("free_detail")
	public String free_detail() {
		
		return "free/free_detail";
	}
	
	//자유게시판 등록 폼
	@PostMapping("/freeForm")
	public String freeForm(FreeVO vo) {
		
		int result = freeService.regist(vo);
		
		return "redirect:/free/free_list";
	}
}
