package com.yoyo.dao.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yoyo.dao.inter.CarSchoolDao;
import com.yoyo.domain.CarSchool;

@Transactional
public class CarSchoolDaoImpl extends BaseDaoImpl<CarSchool> implements CarSchoolDao{
	private final String GET_CAR_SCHOOL_BY_NAME = "from CarSchool c where c.carSchoolName = ?0";
	private final String GET_CAR_SCHOOL_BY_ID = "from CarSchool c where c.carSchoolId = ?0";
	public void AddCarSchool(CarSchool carSchool){
		save(carSchool);
	}
	public void DeleteCarSchool(CarSchool carSchool){
		delete(carSchool);
	}
	public CarSchool getCarSchoolByName(String carSchoolName){
		 List<CarSchool> carSchools = (List<CarSchool>)find(GET_CAR_SCHOOL_BY_NAME,carSchoolName);
	        if (carSchools.size() == 0) {
	            return null;
	        }else{
	            return carSchools.get(0);
	        }
	}
	public List<CarSchool> findAll(){
		return find("from CarSchool");
	}
	public CarSchool getCarSchoolById(int id){
		List<CarSchool> carSchools = (List<CarSchool>)find(GET_CAR_SCHOOL_BY_ID,id);
        if (carSchools.size() == 0) {
            return null;
        }else{
            return carSchools.get(0);
        }
	}
	@Override
	public int getCarSchoolId(CarSchool carSchool) {
		return carSchool.getCarSchoolId();
	}
	
	
}
