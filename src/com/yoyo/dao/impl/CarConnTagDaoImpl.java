package com.yoyo.dao.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yoyo.dao.inter.CarConnTagDao;
import com.yoyo.domain.CarConnTag;

@Transactional
public class CarConnTagDaoImpl extends BaseDaoImpl<CarConnTag> implements CarConnTagDao{
	private final String GET_CARCONNTAG_BY_ID = "from CarConnTag cct where cct.conn_id = ?0";
	private final String GET_CARCONNTAG_BY_TAG_SCHOOL = "from CarConnTag cct where cct.tag.carTagName = ?0 and cct.carSchool.carSchoolId = ?1";
	private final String GET_CARCONNTAG_BY_CARSCHOOL_ID = "from CarConnTag cct where cct.carSchool.carSchoolId = ?0";
	private final String GET_GOOD_CARCONNTAG_BY_CARSCHOOL_ID = "from CarConnTag cct where cct.carSchool.carSchoolId = ?0 and cct.tag.carTagType = 1";
	private final String GET_NORMAL_CARCONNTAG_BY_CARSCHOOL_ID = "from CarConnTag cct where cct.carSchool.carSchoolId = ?0 and cct.tag.carTagType = -1";
	private final String GET_BAD_CARCONNTAG_BY_CARSCHOOL_ID = "from CarConnTag cct where cct.carSchool.carSchoolId = ?0 and cct.tag.carTagType = -1";
	
	public List<CarConnTag> findAll(){
		List<CarConnTag> list = find("from CarConnTag");
		if(list.size() == 0)
			System.out.println("Empty");
		return list;
	}
	
	public void updateCarConnTag(CarConnTag carConnTag){
		update(carConnTag);
	}
	public CarConnTag getCarConnTagByTagSchool(String tagName,int schoolId){
		List<CarConnTag> list = find(GET_CARCONNTAG_BY_TAG_SCHOOL,tagName,schoolId);
		if(list.size() == 0)
			System.out.println("lsn Empty");
		return list.get(0);
	}
	
	public CarConnTag getCarConnTagById(int id){
		List<CarConnTag> list = find(GET_CARCONNTAG_BY_ID,id);
		if(list.size() == 0)
			System.out.println("Empty");
		return list.get(0);
	}
	
	public List<CarConnTag> getCarConnTagsByCarSchoolId(int id){
		List<CarConnTag> list = find(GET_CARCONNTAG_BY_CARSCHOOL_ID,id);
		if(list.size() == 0)
			System.out.println("Empty");
		return list;
	}
	
	public List<CarConnTag> getGoodCarConnTagsByCarSchoolId(int id){
		List<CarConnTag> list = find(GET_GOOD_CARCONNTAG_BY_CARSCHOOL_ID,id);
		if(list.size() == 0)
			System.out.println("Empty");
		return list;
	}
	
	public List<CarConnTag> getNormalCarConnTagsByCarSchoolId(int id){
		List<CarConnTag> list = find(GET_NORMAL_CARCONNTAG_BY_CARSCHOOL_ID,id);
		if(list.size() == 0)
			System.out.println("Empty");
		return list;
	}
	
	public List<CarConnTag> getBadCarConnTagsByCarSchoolId(int id){
		List<CarConnTag> list = find(GET_BAD_CARCONNTAG_BY_CARSCHOOL_ID,id);
		if(list.size() == 0)
			System.out.println("Empty");
		return list;
	}

	public int getCarConnTagNum(CarConnTag carConnTag) {
		return carConnTag.getCarTagNum();
	}

	@Override
	public CarConnTag setCarConnTagNum(CarConnTag carConnTag,int carTagNum) {
		carConnTag.setCarTagNum(carTagNum);	
		return carConnTag;
	}
	
}
