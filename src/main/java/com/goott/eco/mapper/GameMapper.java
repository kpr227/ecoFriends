package com.goott.eco.mapper;

import org.apache.ibatis.annotations.Param;

import com.goott.eco.domain.GameImageVO;

public interface GameMapper {
	
	public Long getCustPointPlusSum(String cust_id);
	public Long getCustPointMinusSum(String cust_id);
	
	
	public int insertUseItem(@Param("item_seq") Long item_seq, @Param("cust_id") String cust_id);
	
	public GameImageVO getGameImageInfo(int game_level);
}
