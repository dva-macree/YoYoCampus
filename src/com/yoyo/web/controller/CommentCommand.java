package com.yoyo.web.controller;

import java.util.Date;

public class CommentCommand {
	private int commentId;
	private String commentContent;
	private String commentUserName;
	private String commentUserImg;
	private Date commentDate;
	
	public CommentCommand(int commentId,String commmentContent,String commentUserName,String commentUsrImg,Date commDate){
		this.commentId = commentId;
		this.commentContent = commmentContent;
		this.commentUserName = commentUserName;
		this.commentUserImg = commentUsrImg;
		this.commentDate = commDate;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentUserName() {
		return commentUserName;
	}
	public void setCommentUserName(String commentUserName) {
		this.commentUserName = commentUserName;
	}
	public String getCommentUserImg() {
		return commentUserImg;
	}
	public void setCommentUserImg(String commentUserImg) {
		this.commentUserImg = commentUserImg;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	
}
