package com.goott.eco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.goott.eco.domain.ShipVO;

public interface ShipMapper {
	
	public int insertShipInfo(ShipVO shipVO);
	
	public List<ShipVO> getPaidShipList();
	
	public int updateShipInfo(ShipVO shipVO);
	
	public List<ShipVO> getShipList(Long order_seq);
	
	public Long findShipNum(ShipVO shipVO);
	
	public int updateCheckoutShipInfo(ShipVO shipVO);

}
