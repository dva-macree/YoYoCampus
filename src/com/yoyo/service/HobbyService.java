package com.yoyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoyo.dao.inter.HobbyDao;
import com.yoyo.domain.Hobby;

//@Service
public class HobbyService {
	@Autowired
	private HobbyDao hobbyDao;

	public HobbyDao getHobbyDao() {
		return hobbyDao;
	}

	public void setHobbyDao(HobbyDao hobbyDao) {
		this.hobbyDao = hobbyDao;
	}

	public List<Hobby> listHobby() {
		return hobbyDao.findAll();
	}
}
