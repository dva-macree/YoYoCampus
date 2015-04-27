package com.yoyo.dao.inter;

import java.util.List;
import java.util.Set;

import com.yoyo.domain.CarConnSchool;
import com.yoyo.domain.CarSchool;
import com.yoyo.domain.University;

public interface CarConnSchoolDao extends BaseDao<CarConnSchool>{
	public List<CarConnSchool> findAll();
	public CarConnSchool getCarConnSchoolById(int id);
	public List<CarSchool> getCarSchoolsByUniversityId(int id);
	public List<University> getUniversitysByCarSchoolId(int id);
	public List<CarConnSchool> getCarConnSchoolsByUniversityId(int i);
}
