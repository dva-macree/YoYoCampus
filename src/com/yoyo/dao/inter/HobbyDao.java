package com.yoyo.dao.inter;


import java.util.List;

import com.yoyo.domain.Hobby;



public interface HobbyDao extends BaseDao<Hobby> {
	public List<Hobby> findAll();
}