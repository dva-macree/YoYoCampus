package com.yoyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoyo.dao.inter.CarSchoolDao;
import com.yoyo.domain.CarSchool;

@Service
public class CarSchoolService {
	@Autowired
	private CarSchoolDao carSchoolDao;
	
	public void addCarSchool(CarSchool carSchool){
		carSchoolDao.AddCarSchool(carSchool);
	}
	
	public List<CarSchool> getAllCarSchools(){
		return carSchoolDao.findAll();
	}
	
	public CarSchool getCarSchoolById(int i){
		return carSchoolDao.getCarSchoolById(i);
	}
	
	public CarSchool getCarSchoolByName(String carSchoolName) {
		return carSchoolDao.getCarSchoolByName(carSchoolName);
	}
	
	public int getCarSchoolId(CarSchool carSchool){
		return carSchoolDao.getCarSchoolId(carSchool);
	}
}
