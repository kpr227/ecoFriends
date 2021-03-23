package com.goott.eco.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
 
import com.goott.eco.domain.GoodsCommentVO;

public interface GoodsCommentMapper {

	    // 댓글 개수
	    public int commentCount();
	 
	    // 댓글 목록
	    public List<GoodsCommentVO> commentList();
	 
	    // 댓글 작성
	    public int commentInsert(GoodsCommentVO comment);
	    
	    // 댓글 수정
	    public int commentUpdate(GoodsCommentVO comment);
	 
	    // 댓글 삭제
	    public int commentDelete(int GOODS_COMMENT_SEQ);


	 



}
