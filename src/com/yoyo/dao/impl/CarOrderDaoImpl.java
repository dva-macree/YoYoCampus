package com.yoyo.dao.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yoyo.dao.inter.CarOrderDao;
import com.yoyo.domain.CarService;
import com.yoyo.domain.Order;

@Transactional
public class CarOrderDaoImpl extends BaseDaoImpl<Order> implements CarOrderDao {
	private final String GET_ORDER_BY_ID = "from Order s where s.mainUser.uid = ?0";
	public List<Order> findAll() {
		List<Order> list = find("from CarOrder");
		if(list.size() == 0){
			System.out.println("Empty result");
		}
		return list;
	}
	
	public void addOrder(Order order){
		save(order);
	}
	
	public List<Order> getOrderInfoByUserId(int id) {
		List<Order> list = find(GET_ORDER_BY_ID,id);
		if(list.size() == 0){
			System.out.println("Empty Set");
		}
		return list;
	}

}
