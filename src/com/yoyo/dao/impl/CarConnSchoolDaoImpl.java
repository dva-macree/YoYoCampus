package com.yoyo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.yoyo.dao.inter.CarConnSchoolDao;
import com.yoyo.domain.CarConnSchool;
import com.yoyo.domain.CarSchool;
import com.yoyo.domain.University;

@Transactional
public class CarConnSchoolDaoImpl extends BaseDaoImpl<CarConnSchool> implements CarConnSchoolDao{
	private final String GET_CARSCHOOLS_BY_UNIVERSITYID = "from CarConnSchool ccs where ccs.university.universityId = ?0";
	private final String GET_CARCONNSCHOOL_BY_ID = "from CarConnSchool ccs where ccs.conn_id = ?0";
	private final String GET_CARCONNSCHOOL_BY_UNIVERSITYID = "from CarConnSchool ccs where ccs.university.universityId = ?0";
	private final String GET_UNIVERSITY_BY_CARSCHOOLS = "from CarConnSchool css where css.carSchool.carSchoolId = ?0";
	public List<CarConnSchool> findAll() {
		List<CarConnSchool> list = find("from CarConnSchool");
		if(list.size() == 0){
			System.out.println("Empty");
		}
		return list;
	}

	public CarConnSchool getCarConnSchoolById(int id) {
		List<CarConnSchool> list= find(GET_CARCONNSCHOOL_BY_ID,id);
		if(list.size() == 0)
			System.out.println("Empty");
		return list.get(0);
	}
	
	public List<CarSchool> getCarSchoolsByUniversityId(int id){
		List<CarConnSchool> list = find(GET_CARSCHOOLS_BY_UNIVERSITYID,id);
		List<CarSchool> carSchools = new ArrayList<CarSchool>();
		if(list.size() == 0)
			System.out.println("EmptySet");
		for(CarConnSchool carConnSchool : list){
			carSchools.add(carConnSchool.getCarSchool());
		}
		return carSchools;
	}

	public List<University> getUniversitysByCarSchoolId(int id){
		List<CarConnSchool> list = find(GET_UNIVERSITY_BY_CARSCHOOLS,id);
		List<University>  universities= new ArrayList<University>();;
		if(list.size() == 0)
			System.out.println("EmptySet");
		for(CarConnSchool carConnSchool : list){
			universities.add(carConnSchool.getUniversity());
		}
		return universities;
	}
	
	public List<CarConnSchool> getCarConnSchoolsByUniversityId(int i){
		List<CarConnSchool> list = find(GET_CARCONNSCHOOL_BY_UNIVERSITYID,i);
		if(list.size() == 0)
			System.out.println(list);
		return list;
	}
}
