package com.coding404.myweb.notice;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.hibernate.Criteria;

import com.coding404.myweb.command.NoticeVO;

@Mapper
public interface NoticeMapper {

	public int regist(NoticeVO vo); //등록
	
	public ArrayList<NoticeVO> getList();
	
	//public int getTotal(Criteria cri);
	
}
