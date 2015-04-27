package com.yoyo.dao.inter;

import java.util.List;

import com.yoyo.domain.Order;

public interface CarOrderDao extends BaseDao<Order>{
	public List<Order> findAll();
	public void addOrder(Order order);
	public List<Order> getOrderInfoByUserId(int id);
}
