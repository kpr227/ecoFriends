package com.goott.eco.common;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

//정상 작동안함. 수정필요. 
//@ControllerAdvice 
//@Log4j
public class CommonExceptionAdvice {
/*
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		
		log.error("Exception......."+ex.getMessage());		
		model.addAttribute("exception",ex);
		log.error(model);
		return "/error_page"; 
	}
	

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		System.out.println("@@@@@@@@errorrororor   "+ex);
		return "/error_404";
	}
*/
	
}
