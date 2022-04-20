package com.coding404.myweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.myweb.animal.AnimalService;
import com.coding404.myweb.command.animalVO;



@Controller
@RequestMapping("/animal")
public class AnimalController {
	
	@Autowired
	@Qualifier("AnimalService")
	private AnimalService animalService;
	
	//동물등록 화면처리
	@GetMapping("/animal_Reg")
	public String animal_Reg() {
			
		return "animal/animal_Reg";
	}
	
	//동물게시판 화면처리
	@GetMapping("/animal_List")
	public String animal_List(Model model) {
		
		ArrayList<animalVO> list =  animalService.getdetail();
		
		System.out.println(list.toString());
		model.addAttribute("animal" , list);
		
		
		return "animal/animal_List";
	}
	
	
	
	//등록
	@PostMapping("/RegForm")
	public String regform(animalVO vo,
						 RedirectAttributes ra,
						 @RequestParam("file") MultipartFile f) {
		
		//파일확인(form형식을 multipart타입으로 반드시 선언)
//		for(MultipartFile f: list) {
//			System.out.println(f.isEmpty()); //비어있다면 true
//			System.out.println(f.getContentType()); //파일의 타입
//		}
		
		
		//1.빈 형태로 넘어오는 이미지 제거
//		list = list.stream().filter((f) -> f.isEmpty() == false).collect(Collectors.toList());
		
		
		//2.업로드 된 확장자가 이미지만 가능하도록 처리
//		for(MultipartFile f : list) {
			if(f.getContentType().contains("image") == false) { //이미지를 포함하고 있지 않은경우
				ra.addFlashAttribute("msg", "jpg,png,jpeg 이미지 형식만 등록가능");
				return "redirect:/animal/animal_reg";
				
			}
		
		
		//3.파일 업로드 코드는 서비스 영역으로 위임
		//vo를 등록
		int result = animalService.regist(vo,f);
		
		
		
		
		
		
		return "redirect:/animal/animal_List";
	}
	
	
	
	
	
	
}
