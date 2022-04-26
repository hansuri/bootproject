package com.coding404.myweb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.myweb.command.CommentVO;
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
	@GetMapping("/free_detail")
	public String free_detail(@RequestParam("free_list_num") int free_list_num,
							  Model model) {
		
		FreeVO freeVO = freeService.getDetail(free_list_num);
		freeService.viewsUpdate(free_list_num);
		model.addAttribute("freeVO", freeVO);
		
		ArrayList<CommentVO> list = freeService.getCommentList(free_list_num);
		model.addAttribute("list", list);
		
		
		return "free/free_detail";
	}
	

	
	//자유게시판 등록 폼
	@PostMapping("/freeForm")
	public String freeForm(FreeVO vo) {
		
		int result = freeService.regist(vo);
		
		return "redirect:/free/free_list";
	}
	
	//수정
	@PostMapping("/updateForm")
	public String updateForm(FreeVO vo,
							Model model) {
		
		freeService.update(vo);
		
		model.addAttribute("freeVO", vo);
		
		return "redirect:/free/free_list";
	}
	
	//삭제
	@PostMapping("/freeDelete")
	public String FreeDelete(FreeVO vo,
							 RedirectAttributes RA) {
		
		System.out.println(vo);
			
		int result = freeService.delete(vo.getFree_list_num());
		
		if(result == 1) {
			RA.addFlashAttribute("msg", "게시글을 삭제 했습니다");
		} else {
			RA.addFlashAttribute("msg", "게시글삭제를 실패했습니다");
		}
		
		return "redirect:/free/free_list";
	}
	
	//댓글등록
	@PostMapping("/commentReg")
	public String commentReg(CommentVO vo) {
		
		System.out.println(vo);
		int result = freeService.CommentRegist(vo);
		
		return "redirect:/free/free_list";
	}
	
}
