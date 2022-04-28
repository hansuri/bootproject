package com.coding404.myweb.free;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.coding404.myweb.command.CommentVO;
import com.coding404.myweb.command.FreeVO;
import com.coding404.myweb.util.Criteria;
import com.coding404.myweb.util.Criteria3;

@Mapper
public interface FreeMapper {

	public int regist(FreeVO vo); //등록
	public ArrayList<FreeVO> getList(Criteria3 cri); //목록
	public FreeVO getDetail(int free_list_num); //상세보기
	public int update(FreeVO vo); //수정
	public int delete(int free_list_num); //삭제
	public int viewsUpdate(int free_list_num); //조회수
	public int getTotal (Criteria3 cri);
	//--------------------댓글----------------
	public int CommentRegist(CommentVO vo); //댓글 등록
	public ArrayList<CommentVO> getCommentList(int free_list_num);//댓글 목록
//	public int CommentUpdate(CommentVO vo); //댓글 수정
}
