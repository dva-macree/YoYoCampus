package com.yoyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoyo.dao.inter.CarOrderDao;
import com.yoyo.dao.inter.MainUserDao;
import com.yoyo.domain.Order;

@Service
public class CarOrderService {
	@Autowired
	private CarOrderDao carOrderDao;
	
	@Autowired
	private MainUserDao mainUserDao;
	
	public void addOrder(Order order){
		carOrderDao.addOrder(order);
	}
	
	public List<Order> getOrderInfoByUserId(int i){
		return carOrderDao.getOrderInfoByUserId(i);
	}
}
