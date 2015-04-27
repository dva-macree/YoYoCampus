


package com.yoyo.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yoyo.dao.inter.HobbyDao;
import com.yoyo.domain.Hobby;

@Transactional
@Repository
public class HobbyDaoImpl extends BaseDaoImpl<Hobby> implements HobbyDao {
	public List<Hobby> findAll() {
		return find("from Hobby");
	}
}