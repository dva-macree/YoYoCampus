package com.yoyo.dao.inter;

import java.util.List;

import com.yoyo.domain.Comment;
import com.yoyo.utils.Page;
import com.yoyo.utils.PageParam;

public interface CommentDao {
	public List<Comment> findAll();
	public Comment getCommentById(int i);
	public void addComment(Comment comment);
	public List<Comment> getCommentsByCarSchoolId(int id);
	public List<Comment> queryCommensByCarSchoolIdInPage(int pageNo,int id);
}
