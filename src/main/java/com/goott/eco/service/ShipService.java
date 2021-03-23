package com.goott.eco.service;

import java.util.List;

import com.goott.eco.domain.ShipVO;

public interface ShipService {

	public int insertShipInfo(ShipVO shipVO);
	
	public int checkShipInfo(ShipVO shipVO);
	
	public List<ShipVO> getPaidShipList();
	
	public int updateShipInfo(ShipVO shipVO);
	
	public List<ShipVO> getShipList(Long order_seq);
	
}
