package com.yoyo.dao.inter;

import java.util.List;

import com.yoyo.domain.CarSchool;
import com.yoyo.domain.Comment;
import com.yoyo.domain.Hobby;

public interface CarSchoolDao extends BaseDao<CarSchool>{
	public void AddCarSchool(CarSchool carSchool);
	public void DeleteCarSchool(CarSchool carSchool);
	public List<CarSchool> findAll();
	public CarSchool getCarSchoolByName(String carSchoolName);
	public CarSchool getCarSchoolById(int id);
	public int getCarSchoolId(CarSchool carSchool);
}
