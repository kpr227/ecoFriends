package com.goott.eco.mapper;

import java.util.List;

import com.goott.eco.domain.GoodsVO;


public interface BoardMapper {

	public List<GoodsVO> getsearchedGoodsList(String goods_name);
	
	public int getCateList(int cate_seq);

//	public String getSearchedlist(String goods_name);
}
