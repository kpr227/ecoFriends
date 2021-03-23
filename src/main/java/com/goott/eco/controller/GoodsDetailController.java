package com.goott.eco.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.goott.eco.service.GoodsService;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/goods/*")
public class GoodsDetailController {
	
	private GoodsService goodsService;
	
	@Autowired
	public GoodsDetailController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	
	//상품 상세 조회  
		@GetMapping(value="/info/{goods_seq}",			
				produces= {"application/json; charset=UTF-8"})
		public ResponseEntity<Map<String,Object>> getGoodsDetailInfo(
				@PathVariable("goods_seq") int goods_seq){
			log.info("상품상세 goods_seq : "+goods_seq);
			Map<String,Object> result = goodsService.goodsDetail(goods_seq);
			log.info("jsp로 넘겨질 데이터: "+result);
			
			return new ResponseEntity<>(result,HttpStatus.OK);
			
		}
		
	
}
