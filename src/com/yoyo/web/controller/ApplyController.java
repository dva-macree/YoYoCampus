package com.yoyo.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yoyo.domain.CarSchool;
import com.yoyo.domain.MainUser;
import com.yoyo.domain.Order;
import com.yoyo.service.CarOrderService;
import com.yoyo.service.CarSchoolService;
import com.yoyo.service.MainUserService;

@Controller
public class ApplyController {
	
	@Autowired
	MainUserService mainUserService;
	
	@Autowired
	CarSchoolService carSchoolService;
	
	@Autowired
	CarOrderService carOrderService;
	
	@RequestMapping(value = "/carschool/apply", method = RequestMethod.GET)
	public String showApply(HttpServletRequest request){
		return "apply";
	}
		
	@ResponseBody
	@RequestMapping(value = "/carschool/apply/apply", method = RequestMethod.GET)
	public OrderString submitApply(@RequestParam(value="carSchoolName",required=true)String carSchoolName,
			@RequestParam(value="userName",required=true)String userName,
			@RequestParam(value="phonenum",required=true)String phoneNum,
			@RequestParam(value="carSchoolClass",required=true)String carSchoolClass,
			@RequestParam(value="carSchoolPrice",required=true)String carSchoolPrice,
			@RequestParam(value="carOrderTimestamp",required=true)String carOrderTimestamp){
		MainUser mainUser = mainUserService.getMainUserByName(userName);
		CarSchool carSchool = carSchoolService.getCarSchoolByName(carSchoolName);
		
		Double price = Double.valueOf(carSchoolPrice).doubleValue();
		int schoolClass = 0;
		if (carSchoolClass == "normal"){
			schoolClass = 1;
		}
		else 
			schoolClass = 99;
		
		int carOrderState = 1;
		Order order = new Order(mainUser,phoneNum,carSchool,price,schoolClass,carOrderTimestamp,carOrderState);

		carOrderService.addOrder(order);
		
		OrderString resultString = new OrderString("OK");
		return resultString;
	}
	
}
