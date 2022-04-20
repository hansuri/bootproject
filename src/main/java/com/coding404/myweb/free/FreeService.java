package com.coding404.myweb.free;

import java.util.ArrayList;

import com.coding404.myweb.command.FreeVO;

public interface FreeService {

	public int regist(FreeVO vo); //등록
	public ArrayList<FreeVO> getList(); //목록
}
