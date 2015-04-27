package com.yoyo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yoyo.dao.inter.CommentDao;
import com.yoyo.domain.Comment;
import com.yoyo.utils.Page;
import com.yoyo.utils.PageParam;

@Transactional
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao{
	private final String GET_COMMENT_BY_ID = "from Comment c where c.carCommentId = ?0";
	private final String GET_COMMENTS_BY_CARSCHOOL_ID = "from Comment c where c.carSchool.carSchoolId = ?0";
	public List<Comment> findAll(){
		List<Comment> list = find("from Comment");
		if(list.size() == 0)
			System.out.println("Empty Set");
		return list;
	}
	public Comment getCommentById(int i){
		List<Comment> list = find(GET_COMMENT_BY_ID,i);
		if(list.size() == 0)
			System.out.println("Empty Set");
		return list.get(0);
	}
	public void addComment(Comment comment){
		save(comment);
	}
	public List<Comment> getCommentsByCarSchoolId(int id){
		List<Comment> list = find(GET_COMMENTS_BY_CARSCHOOL_ID,id);
		if(list.size() == 0)
			System.out.println("Empty");
		return list;
		
	}
	
	public List<Comment> queryCommensByCarSchoolIdInPage(int pageNo,int id){
		List<Comment> pageItems = findByPage(GET_COMMENTS_BY_CARSCHOOL_ID,pageNo,id);
		if(pageItems.size() == 0)
			System.out.println("Empty");
		return pageItems;
	}
}
