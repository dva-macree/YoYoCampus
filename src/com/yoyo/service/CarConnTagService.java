package com.yoyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoyo.dao.inter.CarConnTagDao;
import com.yoyo.domain.CarConnTag;

@Service
public class CarConnTagService {
	@Autowired
	CarConnTagDao carConnTagDao;
	
	public void updateCarConnTag(CarConnTag carConnTag){
		carConnTagDao.updateCarConnTag(carConnTag);
	}
	public CarConnTag getCarConnTagByTagSchool(String tagName,int schoolId){
		return carConnTagDao.getCarConnTagByTagSchool(tagName, schoolId);
	}
	public int getCarConnTagNum(CarConnTag carConnTag){
		return carConnTagDao.getCarConnTagNum(carConnTag);
	}
	public CarConnTag setCarConnTagNum(CarConnTag carConnTag,int carConnNum){
		return carConnTagDao.setCarConnTagNum(carConnTag,carConnNum);
	}
	
	public CarConnTag getCarConnTagById(int i) {
		return carConnTagDao.getCarConnTagById(i);
	}
	
	public List<CarConnTag> getCarConnTagsByCarSchoolId(int id){
		return carConnTagDao.getCarConnTagsByCarSchoolId(id);
	}
	
	public List<CarConnTag> getGoodCarConnTagsByCarSchoolId(int id){
		return carConnTagDao.getGoodCarConnTagsByCarSchoolId(id);
	}
	
	public List<CarConnTag> getBadCarConnTagsByCarSchoolId(int id){
		return carConnTagDao.getBadCarConnTagsByCarSchoolId(id);
	}
	
}
