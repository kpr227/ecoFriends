package com.goott.eco.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.goott.eco.domain.GameItemVO;
import com.goott.eco.service.GameService;

import lombok.extern.log4j.Log4j;

@RequestMapping("/game")
@Controller
@Log4j
public class GameController {

	
	private GameService gameService;
	
	@Autowired
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}
	
	//마일리지 조회
	@GetMapping(value="/info/{cust_id}",
	produces= {"application/json; charset=UTF-8"})
	public ResponseEntity<HashMap<String,Object>> getCustPointSum(
			@PathVariable("cust_id") String cust_id){
		
		HashMap<String,Object> getCustPointSumResult =  gameService.getCustPointSum(cust_id);
		
		log.info(getCustPointSumResult);
		return new ResponseEntity<>(getCustPointSumResult,HttpStatus.OK);
}
	
	//아이템 사용
	@GetMapping(value="/item/{item_seq}/{cust_id}",
	produces= {"application/json; charset=UTF-8"})
	public ResponseEntity<String> useItem(
			@PathVariable("item_seq") Long item_seq,
			@PathVariable("cust_id") String cust_id){
		
		gameService.useItem(item_seq,cust_id);
		
		return new ResponseEntity<>("성공",HttpStatus.OK);
}
	

	
	

}
