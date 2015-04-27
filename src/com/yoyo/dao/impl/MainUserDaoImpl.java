package com.yoyo.dao.impl;

import java.util.List;
import java.util.Set;

import com.yoyo.dao.inter.MainUserDao;
import com.yoyo.domain.Comment;
import com.yoyo.domain.MainUser;

public class MainUserDaoImpl extends BaseDaoImpl<MainUser> implements MainUserDao{
	private final String GET_MAINUSER_BY_ID = "from MainUser u where u.uid = ?0";
	private final String GET_MAINUSER_BY_NAME = "from MainUser u where u.username = ?0";
	public List<MainUser> findAll(){
		List<MainUser> list = find("from MainUser");
		if(list.size() == 0)
			System.out.println("Emptuy List");
		return list;
	}
	public MainUser getMainUserById(int i){
		List<MainUser> list = find(GET_MAINUSER_BY_ID, i);
		if(list.isEmpty()){
			System.out.println("isEmpty");
		}
		return list.get(0);
	}
	
	public MainUser getMainUserByName(String name){
		List<MainUser> list = find(GET_MAINUSER_BY_NAME, name);
		if(list.isEmpty()){
			System.out.println("IsEmpty");
		}
		return list.get(0);
	}
	
	public void UpdateMainUser(MainUser mainUser){
		update(mainUser);
	}
	public void DeleteMainUser(MainUser mainUser){
		delete(mainUser);
	}
	
	public void AddMainUser(MainUser mainUser){
		save(mainUser);
	}
	
	public Set<Comment> getAllComments(MainUser mainUser){
		Set<Comment> list = mainUser.getCommentList();
		return list;
	}
}
