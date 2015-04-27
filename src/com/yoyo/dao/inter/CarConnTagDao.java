package com.yoyo.dao.inter;

import java.util.List;

import com.yoyo.domain.CarConnSchool;
import com.yoyo.domain.CarConnTag;
import com.yoyo.domain.CarSchool;
import com.yoyo.domain.University;

public interface CarConnTagDao extends BaseDao<CarConnTag>{
	public List<CarConnTag> findAll();
	
	public void updateCarConnTag(CarConnTag carConnTag);
	public CarConnTag getCarConnTagByTagSchool(String tagName,int schoolId);
	public int getCarConnTagNum(CarConnTag carConnTag);
	public CarConnTag setCarConnTagNum(CarConnTag carConnTag,int carConnNum);
	
	public CarConnTag getCarConnTagById(int id);
	public List<CarConnTag> getCarConnTagsByCarSchoolId(int id);
	public List<CarConnTag> getBadCarConnTagsByCarSchoolId(int id);
	public List<CarConnTag> getNormalCarConnTagsByCarSchoolId(int id);
	public List<CarConnTag> getGoodCarConnTagsByCarSchoolId(int id);
	
}
