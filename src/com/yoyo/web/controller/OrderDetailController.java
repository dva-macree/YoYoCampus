package com.yoyo.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.yoyo.service.CarOrderService;
import com.yoyo.service.CarSchoolService;
import com.yoyo.service.MainUserService;
import com.yoyo.domain.Order;

@Controller
public class OrderDetailController {
	@Autowired
	CarSchoolService carSchoolService;
	
	@Autowired
	MainUserService mainUserService;
	
	@Autowired
	CarOrderService carOrderService;
	
	@RequestMapping(value = "/carschool/{id}/detail-info", method = RequestMethod.GET)
	public String showOrderDetail(@PathVariable("id") Integer id,HttpServletRequest request){
		Order order = carOrderService.getOrderInfoByUserId(1).get(0);
		System.out.println(">>>>>>???  "+order);
		request.setAttribute("carSchoolPrice", order.getCarSchoolPrice());
		request.setAttribute("carOrderId", order.getCarOrderId());
		request.setAttribute("carOrderTimestamp", order.getCarOrderTimestampString());
		request.setAttribute("username", order.getMainUser().getUsername());
		request.setAttribute("phonenum", order.getMainUser().getPhoneNum());
		request.setAttribute("carSchoolName", order.getCarSchool().getCarSchoolName());
		request.setAttribute("carSchoolAddr", order.getCarSchool().getCarSchoolAddr());
		request.setAttribute("carOrderState", order.getCarOrderState());

		return "detail-info";
	}
}
