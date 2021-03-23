package com.goott.eco.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.goott.eco.domain.GoodsVOtest;

public interface WishMapper {
	
	public List<HashMap<String,Object>> getWishList(String cust_id);
	
	public GoodsVOtest getGoodsInfo(Long goods_seq);
	
	public int delGoodsAtWish(@Param("cust_id") String cust_id, @Param("goods_seq") Long goods_seq);
	
	public int purGoodsAtWish(@Param("cust_id") String cust_id, @Param("goods_seq") Long goods_seq);
	
	public int addGoodsAtWish(HashMap<String,Object> orderInfo);
	
	public Long checkExistWish(HashMap<String,Object> orderInfo);
	
	public Long checkSameGoods(HashMap<String,Object> orderInfo);
	
	public int createWish(HashMap<String,Object> orderInfo);
	
	public int changeQtyAtWish(@Param("cust_id") String cust_id, @Param("goods_seq") Long goods_seq, @Param("qty") Long qty);
	
	public int countWishGoods(String cust_id);

}
