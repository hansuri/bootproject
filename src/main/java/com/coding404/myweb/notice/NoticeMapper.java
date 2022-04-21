package com.coding404.myweb.notice;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;


import com.coding404.myweb.command.NoticeVO;
import com.coding404.myweb.util.Criteria;

@Mapper
public interface NoticeMapper {

	public int regist(NoticeVO vo); //등록
	
	public ArrayList<NoticeVO> getList(Criteria cri);
	
	public int getTotal(Criteria cri);
	
}
