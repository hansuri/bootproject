package com.coding404.myweb.free;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding404.myweb.command.FreeVO;

@Service("freeService")
public class FreeServiceImpl implements FreeService{

	@Autowired
	private FreeMapper freeMapper;
	
	//등록
	@Override
	public int regist(FreeVO vo) {
		return freeMapper.regist(vo);
	}
	
	//목록
	@Override
	public ArrayList<FreeVO> getList() {
		return freeMapper.getList();
	}

}
