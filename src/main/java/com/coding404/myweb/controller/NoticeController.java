package com.coding404.myweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.myweb.command.NoticeVO;
import com.coding404.myweb.notice.NoticeService;
import com.coding404.myweb.util.PageVO;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	@Qualifier("noticeService")
	private NoticeService noticeService;
	
	
	//공지게시판등록 화면처리
	@GetMapping("/notice_reg")
	public String notice_reg() {
		
		return "notice/notice_reg";
	}
		
	@PostMapping("/noticeForm")
	public String noticeForm(NoticeVO vo,
							 RedirectAttributes RA) {
		

		int result = noticeService.regist(vo);
		
		if(result == 1) { //성공 
			RA.addFlashAttribute("msg", vo.getAd_list_title() + "이 정상 등록되었습니다");
		} else { //실패 
			RA.addFlashAttribute("msg", "등록 실패, 다시 작성해주세요");
		}
		return "redirect:/notice/notice";
	}
	
	
//	@PostMapping("/noticeUpdate")
//	public String noticeUpdate(@Valid NoticeVO vo,
//							   Errors errors,
//							   RedirectAttributes RA,
//							   Model model ) {
//		
//		if(errors.hasErrors() ) { //유효성 검사 실패시 true
//					
//			List<FieldError> list = errors.getFieldErrors(); //유효성 검사 실패 목록확인 
//					
//			for(FieldError err : list) {
//				
//				if(err.isBindingFailure() ) { //자바측 에러인 경우 
//					model.addAttribute("valid_" + err.getField(), "형식을 확인하세요"); //직접 에러메세지 생성
//				} else {
//					model.addAttribute("valid_" + err.getField(), err.getDefaultMessage() ); //유효성 검사 실패 메세지 
//				}
//				
//			}
//			
//			model.addAttribute("noticeVO", vo);
//		
//			return "notice/notice";
//			}
//	}
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	//공지게시판 화면처리
	@GetMapping("/notice")
	public String notice() {
		
		
		ArrayList<NoticeVO> list = noticeService.getList();
		
		
		return "notice/notice";
	}

}
