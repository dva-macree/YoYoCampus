package com.yoyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoyo.dao.inter.TagDao;
import com.yoyo.domain.Tag;
@Service
public class TagService {
	@Autowired
	private TagDao tagDao;
	
	

	
	public TagDao getTagDao() {
		return tagDao;
	}




	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}

	public Tag findTagById(int i){
		return tagDao.findTagById(i);
	}
	
	public void updateTagById(int i,String newTagName){
		Tag tag = findTagById(i);
		tag.setCarTagName(newTagName);
		tagDao.updateTag(tag);
	}
	
	public void deleteTagById(int i){
		Tag tag = findTagById(i);
		tagDao.delete(tag);
	}


	public List<Tag> listTag() {
		return tagDao.findAll();
	}
}
