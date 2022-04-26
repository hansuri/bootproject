package com.coding404.myweb.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

@Controller
@RequestMapping("/rec")
public class RecController {
	


	@Autowired
	@Qualifier("AnimalService")
	private AnimalService animalService;
	
	
	
	//동물게시판 화면처리
	@GetMapping("/rec_list")
	public String animal_List(Model model) {
		
		ArrayList<animalVO> list =  animalService.getdetail();
		
		System.out.println(list.toString());
		model.addAttribute("animal" , list);
		
		
		return "rec/rec_list";
	}
	
	
	
	
	
}
