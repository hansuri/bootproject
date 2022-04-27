package com.coding404.myweb.animal;

import java.util.ArrayList;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.coding404.myweb.command.RecVO;
import com.coding404.myweb.command.animalVO;
import com.coding404.myweb.util.Criteria;

@Mapper
public interface AnimalMapper {
	
	public int regist(animalVO vo);
	
	public ArrayList<animalVO> getdetail(Criteria cri); //상세정보
	
	public ArrayList<RecVO> getrec(String User_id);
	
	public int getTotal(Criteria cri);
	
	public animalVO modalview(String pk); //모달
	
}
