package com.yoyo.dao.inter;

import java.util.List;

import com.yoyo.domain.Tag;

public interface TagDao extends BaseDao<Tag>{
	public List<Tag> findAll();
	public void addTag(Tag tag);
	public Tag findTagById(int i);
	public void updateTag(Tag tag); 
	public void deleteTag(Tag tag);
}
