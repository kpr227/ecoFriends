package com.goott.eco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.goott.eco.domain.DeliveryVO;
import com.goott.eco.domain.GoodsVO;
import com.goott.eco.domain.OrderVO;

public interface DeliveryMapper {
	
	public List<DeliveryVO>  getallDeliveryList();

	public List<DeliveryVO> getDeliveryList(Long invoice_no);
	
	public List<GoodsVO> getPaidGoodsList();
	
	public List<DeliveryVO> getmyDeliveryList(String cust_id);
}
