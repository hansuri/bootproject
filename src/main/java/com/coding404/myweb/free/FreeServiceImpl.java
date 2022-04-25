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

	@Override
	public FreeVO getDetail(int free_list_num) {
		return freeMapper.getDetail(free_list_num);
	}

	@Override
	public int delete(int free_list_num) {
		return freeMapper.delete(free_list_num);
	}

	@Override
	public int update(FreeVO vo) {
		return freeMapper.update(vo);
	}

	@Override
	public int viewsUpdate(int free_list_num) {
		return freeMapper.viewsUpdate(free_list_num);
	}



}
