package com.coding404.myweb.notice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding404.myweb.command.NoticeVO;
import com.coding404.myweb.util.Criteria;

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
	public ArrayList<NoticeVO> getList(Criteria cri) {
		return noticeMapper.getList(cri);
	}

	@Override
	public int getTotal(Criteria cri) {

		return noticeMapper.getTotal(cri);
	}

	
	
}
