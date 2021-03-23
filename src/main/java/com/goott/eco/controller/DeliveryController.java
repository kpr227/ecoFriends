package com.goott.eco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goott.eco.domain.DeliveryVO;
import com.goott.eco.domain.OrderVO;
import com.goott.eco.service.DeliveryService;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/delivery/*")
public class DeliveryController {
	
	private DeliveryService deliveryService;
	
	@Autowired
	public DeliveryController(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}
	
	//배송 리스트 조회 
	@GetMapping(value="/list/{invoice_no}",
			produces= {"application/json; charset=UTF-8"})
	public ResponseEntity<List<DeliveryVO>> getDeliveryList(
			@PathVariable("invoice_no")Long invoice_no){

		System.out.println("송장번호: "+ invoice_no);
		return new ResponseEntity<>(deliveryService.getDeliveryList(invoice_no),HttpStatus.OK);
	}
	
	//결제완료된(3) 주문 리스트
	@GetMapping(value="/list",
			produces= {"application/json; charset=UTF-8"})
	public ResponseEntity<List> getDeliveryList(){
	
		System.out.println("주문상태: " );
		return null;
	}
			
	
	
			
	
	

}
	




