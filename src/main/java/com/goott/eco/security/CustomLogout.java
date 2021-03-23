package com.goott.eco.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

//@Controller
@Log4j
public class CustomLogout {

	
	//@GetMapping("/sample/logout")
	public String loginInput(String error, String logout, Model model) {
		
		log.info("error: "+ error);
		log.info("logout: "+ logout);
		
		if(error != null) {
			model.addAttribute("error","Login Error Check Your Account");
		}
		
		if(logout !=null) {
			model.addAttribute("logout","Logout!!!");
		}
		
		return "/home/index";
	}
	
}
