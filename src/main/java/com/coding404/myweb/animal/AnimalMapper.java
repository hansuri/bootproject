package com.coding404.myweb.animal;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.coding404.myweb.command.animalVO;

@Mapper
public interface AnimalMapper {
	
	public int regist(animalVO vo);
	
	public ArrayList<animalVO> getdetail(); //상세정보
	
}
