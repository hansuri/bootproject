package com.coding404.myweb.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.myweb.command.UserVO;
import com.coding404.myweb.user.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	
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
	
	
	
	/////////////
	
	//회원가입
	@PostMapping("/signForm")
	public String signForm(@Valid UserVO vo, Errors errors, 
						   RedirectAttributes RA,
						   Model model) {
		
		//유효성 검사
		if(errors.hasErrors()) {
			List<FieldError> list = errors.getFieldErrors();
			
			for(FieldError err : list) {
				model.addAttribute("valid_" + err.getField(), err.getDefaultMessage());
			}
			
			return "user/sign"; //실패시 회원가입 페이지로
		}
		
		
		//join
		int result = userService.join(vo);
		
		if(result == 1) { //성공
			RA.addFlashAttribute("msg", vo.getUser_id() + "님이 가입되었습니다.");
		} else { //실패
			RA.addFlashAttribute("msg", "회원가입에 실패했습니다.");
		}
		
		return "redirect:/main";
	}

}
