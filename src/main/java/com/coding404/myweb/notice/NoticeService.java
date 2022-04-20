package com.coding404.myweb.notice;

import java.util.ArrayList;

import org.hibernate.Criteria;

import com.coding404.myweb.command.NoticeVO;

public interface NoticeService {
	
	public int regist(NoticeVO vo);

	public ArrayList<NoticeVO> getList();

//	public int getTotal(Criteria cri);

}
