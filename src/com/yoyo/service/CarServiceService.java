package com.yoyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoyo.dao.inter.CarServiceDao;
import com.yoyo.domain.CarService;
@Service
public class CarServiceService {
	@Autowired
	CarServiceDao carServiceDao;
	

	public CarService findServiceById(int i){
		return carServiceDao.findServiceById(i);
	}
	
	public void updateServiceById(int i,String newServiceName){
		CarService service = findServiceById(i);
		service.setCarServiceName(newServiceName);
		carServiceDao.updateService(service);
	}
	
	public void deleteCarServiceById(int i){
		CarService carService = findServiceById(i);
		carServiceDao.delete(carService);
	}


	public List<CarService> listCarServices() {
		return carServiceDao.findAll();
	}
}
