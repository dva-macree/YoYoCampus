package com.yoyo.dao.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yoyo.dao.inter.TagDao;
import com.yoyo.domain.Tag;

@Transactional
public class TagDaoImpl extends BaseDaoImpl<Tag> implements TagDao{
	private final String FIND_TAG_BY_ID = "from Tag g where g.carTagId = ?0";
	public List<Tag> findAll(){
		List<Tag> list=find("from Tag");
		if (list.isEmpty()) {
			System.out.println("isEmpty");
		}
		return list;
	}
	public void addTag(Tag tag){
		save(tag);
	}
	public Tag findTagById(int i){
		List<Tag> list = find(FIND_TAG_BY_ID, i);
		if(list.isEmpty()){
			System.out.println("isEmpty");
		}
		return list.get(0);
	}
	
	public void updateTag(Tag tag){
		update(tag);
	}
	public void deleteTag(Tag tag){
		delete(tag);
	}
}
