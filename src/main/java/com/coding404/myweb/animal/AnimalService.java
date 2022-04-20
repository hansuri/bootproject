package com.coding404.myweb.animal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.coding404.myweb.command.animalVO;

public interface AnimalService {
	
	public int regist(animalVO vo , MultipartFile f); //등록
	
	public ArrayList<animalVO> getdetail(); //상세정보
	
	
	
}
