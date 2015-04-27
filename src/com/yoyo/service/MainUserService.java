package com.yoyo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoyo.dao.inter.MainUserDao;
import com.yoyo.domain.MainUser;

@Service
public class MainUserService {
	@Autowired
	private MainUserDao mainUserDao;
	
	public boolean checkPassword(String username,String password){
		MainUser mainUser = mainUserDao.getMainUserByName(username);
		return true;
	}
	public MainUser getMainUserById(int id){
		return mainUserDao.getMainUserById(id);
	}
	public MainUser getMainUserByName(String name){
		return mainUserDao.getMainUserByName(name);
	}
	
}
