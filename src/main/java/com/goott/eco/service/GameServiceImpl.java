package com.goott.eco.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goott.eco.domain.CustVO;
import com.goott.eco.domain.GameImageVO;
import com.goott.eco.domain.GameItemVO;
import com.goott.eco.domain.PointVO;
import com.goott.eco.mapper.GameMapper;

@Service
public class GameServiceImpl implements GameService{

	
	private GameMapper gameMapper;

	@Autowired
	public GameServiceImpl(GameMapper gameMapper) {
		this.gameMapper = gameMapper;
	}

	@Override
	public HashMap<String,Object> getCustPointSum(String cust_id) {
		Long plus = gameMapper.getCustPointPlusSum(cust_id);
		Long minus = gameMapper.getCustPointMinusSum(cust_id);
		Long result = plus - minus;
		
		HashMap<String,Object> userPointInfo = new HashMap<String,Object>();
		userPointInfo.put("point_amount", result);
		userPointInfo.put("totalUsedItem_amount",minus);
		
		if(minus<1000L) {
			userPointInfo.put("gage_bar",minus/10);
			GameImageVO gameImageInfo = gameMapper.getGameImageInfo(1);
			userPointInfo.put("GameImageVO",gameImageInfo);
		}else if(1000L<=minus&&minus<2000L) {
			userPointInfo.put("gage_bar",(minus-1000L)/10);
			GameImageVO gameImageInfo = gameMapper.getGameImageInfo(2);
			userPointInfo.put("GameImageVO",gameImageInfo);
		}else if(2000L<=minus&&minus<3000L) {
			userPointInfo.put("gage_bar",(minus-2000L)/10);
			GameImageVO gameImageInfo = gameMapper.getGameImageInfo(3);
			userPointInfo.put("GameImageVO",gameImageInfo);
		}else if(3000L<=minus&&minus<4000L) {
			userPointInfo.put("gage_bar",(minus-3000L)/10);
			GameImageVO gameImageInfo = gameMapper.getGameImageInfo(4);
			userPointInfo.put("GameImageVO",gameImageInfo);
		}
		
		
		return userPointInfo;
	}

	@Override
	public int useItem(Long item_seq,String cust_id) {
		
		int insertResult = gameMapper.insertUseItem(item_seq,cust_id);
	
		return insertResult>0? 1 : 0;
	}
	
	
	
	
}
