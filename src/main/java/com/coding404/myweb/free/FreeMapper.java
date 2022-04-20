package com.coding404.myweb.free;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.coding404.myweb.command.FreeVO;

@Mapper
public interface FreeMapper {

	public int regist(FreeVO vo); //등록
	public ArrayList<FreeVO> getList(); //목록
}
