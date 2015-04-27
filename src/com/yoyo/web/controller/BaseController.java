package com.yoyo.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.yoyo.web.exception.BusinessException;
import com.yoyo.web.exception.ParameterException;

public class BaseController {
	public final String getAppbaseUrl(HttpServletRequest request, String url){
		return request.getContextPath() + url;
	}
	
	@ExceptionHandler
	public String exp(HttpServletRequest request, Exception ex){
		request.setAttribute("ex", ex);
		
		if(ex instanceof BusinessException){
			return "error-business";
		}else if(ex instanceof ParameterException){
			return "error-parameter";
		}else{
			System.out.print(ex);
			return "error";
		}
	}
}