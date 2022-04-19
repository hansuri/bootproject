package com.coding404.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/animal")
public class AnimalController {
	
	//동물등록 화면처리
	@GetMapping("/animal_Reg")
	public String animal_Reg() {
		
		return "animal/animal_Reg";
	}
	
	//동물게시판 화면처리
	@GetMapping("/animal_List")
	public String animal_List() {
		
		return "animal/animal_List";
	}

}
