package com.goott.eco.service;

import java.util.HashMap;

import com.goott.eco.domain.PointVO;

public interface GameService {

	public HashMap<String,Object> getCustPointSum(String cust_id);
	
	public int useItem(Long item_seq, String cust_id);
	
	
	
}
