package com.coding404.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.myweb.command.UserVO;
import com.coding404.myweb.command.loginVO;
import com.coding404.myweb.user.UserService;

@Controller
public class MainController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	
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
	
	
	///////////
	
	//로그인
	@PostMapping("/login_form")
	public String login_form(@Valid loginVO vo, Errors errors, 
							HttpSession session, 
							RedirectAttributes RA,
							Model model) {
		
		//유효성 검사
		if(errors.hasErrors()) {
			List<FieldError> list = errors.getFieldErrors();
			
			for(FieldError err : list) {
				model.addAttribute("valid_" + err.getField(), err.getDefaultMessage());
			}
			
			return "main"; //실패시 로그인페이지로
		}
		
		//로그인
		UserVO userVO = userService.login(vo);
		
		if(userVO != null) { //성공
			RA.addFlashAttribute("msg", userVO.getUser_id() + "님이 로그인 되었습니다.");
			
		} else { //실패
			RA.addFlashAttribute("msg", "로그인에 실패했습니다.");
		}
		
		
		//세션 저장
		session.setAttribute("userVO", userVO);
		
		
		return "redirect:/main";
	}
	
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/main";
	}
	
}
