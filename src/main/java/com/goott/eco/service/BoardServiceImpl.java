package com.goott.eco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goott.eco.domain.GoodsVO;
import com.goott.eco.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
private BoardMapper boardMapper;
	
	@Autowired
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	@Override
	public List<GoodsVO> getsearchedGoodsList(String goods_name) {
		return boardMapper.getsearchedGoodsList(goods_name);
	}

	@Override
	public int getCateList(int cate_seq) {
		return boardMapper.getCateList(cate_seq);
	}

//	@Override
//	public String getSearchedlist(String goods_name) {
//		return boardMapper.getSearchedlist(goods_name);
//	}

}
