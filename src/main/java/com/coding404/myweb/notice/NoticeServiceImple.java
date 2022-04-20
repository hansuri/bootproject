package com.coding404.myweb.notice;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding404.myweb.command.NoticeVO;

@Service("noticeService")
public class NoticeServiceImple implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public int regist(NoticeVO vo) {
		
		int result = noticeMapper.regist(vo);
		
		
		return result;
	}

	@Override
	public ArrayList<NoticeVO> getList() {
		return noticeMapper.getList();
	}

//	@Override
//	public int getTotal(Criteria cri) {
//		return noticeMapper.getTotal(cri);
//	}

	
	
}
