package com.yoyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoyo.dao.inter.CommentDao;
import com.yoyo.domain.Comment;

@Service
public class CommentService {
	@Autowired
	private CommentDao commentDao;
	
	public List<Comment> findAll(){
		List<Comment> list = commentDao.findAll();
		return list;
	}
	
	public void addComment(Comment comment){
		commentDao.addComment(comment);
	}
	
	public Comment getCommentById(int id){
		return commentDao.getCommentById(id);
	}
	
	public List<Comment> getCommentsByCarSchoolId(int id){
		return commentDao.getCommentsByCarSchoolId(id);
	}
	
	public List<Comment> getCommentsByCarSchoolIdInPage(int pageNo,int id){
		return commentDao.queryCommensByCarSchoolIdInPage(pageNo, id);
	}
}
