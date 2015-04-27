package com.yoyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoyo.dao.inter.CarConnSchoolDao;
import com.yoyo.domain.CarConnSchool;
import com.yoyo.domain.CarSchool;
import com.yoyo.domain.University;

@Service
public class CarConnSchoolService {
	@Autowired
	CarConnSchoolDao carConnSchoolDao;
	
	public List<CarSchool>  getCarSchoolsByUniversityId(int id){
		return carConnSchoolDao.getCarSchoolsByUniversityId(id);
	}
	
	public List<University> getUniversitiesByCarSchoolId(int id){
		return carConnSchoolDao.getUniversitysByCarSchoolId(id);
	}
	
	public List<CarConnSchool> getCarConnSchoolsByUniversityId(int id){
		return carConnSchoolDao.getCarConnSchoolsByUniversityId(id);
	}
	
	public CarConnSchool getCarConnSchoolById(int id){
		return carConnSchoolDao.getCarConnSchoolById(id);
	}
	
}
