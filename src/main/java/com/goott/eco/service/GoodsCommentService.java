package com.goott.eco.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goott.eco.domain.GoodsCommentVO;
import com.goott.eco.mapper.GoodsCommentMapper;



public interface GoodsCommentService {

	public List<GoodsCommentVO> commentListService();

	public int GoodsCommentInsertService(GoodsCommentVO comment);

	public int GoodsCommentUpdateService(GoodsCommentVO comment);
	
	public int GoodsCommentDeleteService(int GOODS_COMMENT_SEQ);

}
