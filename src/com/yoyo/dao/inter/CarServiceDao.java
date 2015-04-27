package com.yoyo.dao.inter;

import java.util.List;

import com.yoyo.domain.CarService;

public interface CarServiceDao extends BaseDao<CarService>{
	public List<CarService> findAll();
	public void addService(CarService service);
	public CarService findServiceById(int i);
	public CarService findServiceByName(String serviceName);
	public void updateService(CarService service); 
	public void deleteService(CarService service);
}
