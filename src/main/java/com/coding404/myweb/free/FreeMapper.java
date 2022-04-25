package com.coding404.myweb.free;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.coding404.myweb.command.FreeVO;

@Mapper
public interface FreeMapper {

	public int regist(FreeVO vo); //등록
	public ArrayList<FreeVO> getList(); //목록
	public FreeVO getDetail(int free_list_num); //상세보기
	public int update(FreeVO vo); //수정
	public int delete(int free_list_num); //삭제
	public int viewsUpdate(int free_list_num); //조회수
}
