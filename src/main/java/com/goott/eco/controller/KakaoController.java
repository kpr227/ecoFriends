package com.goott.eco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goott.eco.service.KakaoPay;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class KakaoController {
	
	@Setter(onMethod_ = @Autowired)
    private KakaoPay kakaopay;
    
//    @Autowired
//    public KakaoController(KakaoPay kakaopay) {
//		this.kakaopay = kakaopay;
//	}

	@GetMapping("/kakaoPay")
    public void kakaoPayGet() {
        
    }
    
    @PostMapping("/kakaoPay")
    public String kakaoPay() {
        log.info("kakaoPay post............................................");
        
        return "redirect:" + kakaopay.kakaoPayReady();
 
    }
    
    @GetMapping("/kakaoPaySuccess")
    public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
        log.info("kakaoPaySuccess get............................................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);
        
    }
}
