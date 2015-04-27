package com.yoyo.dao.inter;

import java.util.List;
import java.util.Set;

import com.sun.jmx.snmp.UserAcl;
import com.yoyo.domain.Comment;
import com.yoyo.domain.MainUser;

public interface MainUserDao {
	public List<MainUser> findAll();
	public MainUser getMainUserById(int i);
	public MainUser getMainUserByName(String name);
	public void UpdateMainUser(MainUser mainUser);
	public void DeleteMainUser(MainUser mainUser);
	public void AddMainUser(MainUser mainUser);
	public Set<Comment> getAllComments(MainUser mainUser);
}
