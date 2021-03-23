package com.goott.eco.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.goott.eco.domain.CartVO;
import com.goott.eco.domain.GoodsVOtest;

public interface WishService {
	
	public List<HashMap<String,Object>> getWishList(String cust_id);
	
//	public GoodsVOtest getGoodsInfo(Long goods_seq);
	
	public int deleteGoodsAtWish(String cust_id,Long goods_seq);
	
	public int purGoodsAtWish(String cust_id, Long goods_seq);
	
	public int addGoodsAtWish(HashMap<String,Object> orderInfo);
	
	public int changeQtyAtWish(String cust_id, Long goods_seq, Long qty);

	public int countWishGoods(String cust_id);
}
