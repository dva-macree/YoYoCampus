package com.yoyo.dao.impl;

import java.util.List;

import com.yoyo.dao.inter.CarServiceDao;
import com.yoyo.domain.CarService;

public class CarServiceDaoImpl extends BaseDaoImpl<CarService> implements CarServiceDao{
	private final String GET_SERVICE_BY_ID = "from CarService s where s.carServiceId = ?0";
	private final String GET_SERVICE_BY_Name = "from CarService s where s.carServiceName = ?0";
	public List<CarService> findAll(){
		List<CarService> list = find("from Service");
		if(list.size() == 0){
			System.out.println("Empty result");
		}
		return list;
	}
	public void addService(CarService service){
		save(service);
	}
	public CarService findServiceById(int i){
		List<CarService> list = find(GET_SERVICE_BY_ID,i);
		if(list.size() == 0){
			System.out.println("Empty result");
		}
		return list.get(0);
	}
	public CarService findServiceByName(String serviceName) {
		List<CarService> list = find(GET_SERVICE_BY_Name,serviceName);
		if(list.size() == 0){
			System.out.println("Empty Set");
		}
		return list.get(0);
	}
	
	public void updateService(CarService service){
		update(service);
	}
	public void deleteService(CarService service){
		delete(service);
	}
}
