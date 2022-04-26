package com.coding404.myweb.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.myweb.animal.AnimalService;
import com.coding404.myweb.command.animalVO;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;



@Controller
@RequestMapping("/animal")
public class AnimalController {
	
	@Autowired
	@Qualifier("AnimalService")
	private AnimalService animalService;
	
	//동물등록 화면처리
	@GetMapping("/animal_Reg")
	public String animal_Reg(Model model) {
		
		
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String nowdate = sd.format(new Date());
		
		model.addAttribute("anivo", new animalVO());
		model.addAttribute("nowdate", nowdate);
		
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
	public String regform(@Valid animalVO vo,
						  Errors errors,
						 RedirectAttributes ra,
						 @RequestParam("file") MultipartFile f,
						 Model model) {
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String nowdate = sd.format(new Date());
		
		model.addAttribute("nowdate", nowdate);
		
		
		if(errors.hasErrors() ) {
			List<FieldError> list = errors.getFieldErrors();
			
			for( FieldError err : list) {
				
				
				if(err.isBindingFailure()) {
					model.addAttribute("valid_" + err.getField(), "형식을 확인하세요");
				}else {
					model.addAttribute("valid_" + err.getField(), err.getDefaultMessage());
				}
			}
			
			model.addAttribute("anivo", vo);
			
			return "animal/animal_Reg";
			
		}
		
		
		
		//파일확인(form형식을 multipart타입으로 반드시 선언)
//		for(MultipartFile f: list) {
//			System.out.println(f.isEmpty()); //비어있다면 true
//			System.out.println(f.getContentType()); //파일의 타입
//		}
		
		
		//1.빈 형태로 넘어오는 이미지 제거
//		list = list.stream().filter((f) -> f.isEmpty() == false).collect(Collectors.toList());
//		if(vo.getANIMAL_FILENAME() ==null) {
//			ra.addAttribute("msg", "사진은 필수입니다");
//			return "redirect:/animal/animal_reg";
//		}
		
		//2.업로드 된 확장자가 이미지만 가능하도록 처리
//		for(MultipartFile f : list) {
			if(f.getContentType().contains("image") == false) { //이미지를 포함하고 있지 않은경우
				ra.addFlashAttribute("msg", "jpg,png,jpeg 이미지 형식만 등록가능");
				
				return "redirect:/animal/animal_Reg";
				
			}
		
		
		//3.파일 업로드 코드는 서비스 영역으로 위임
		//vo를 등록
		int result = animalService.regist(vo,f);
		
		if(result == 1 ) {
			ra.addAttribute("msg", "동물을 등록했습니다.");
		} else {
			ra.addAttribute("msg", "동물 등록에 실패했습니다.");
		}
		
		
		
		
		
		
		return "redirect:/animal/animal_List";
	}
	
	
	
	
	
	
}
