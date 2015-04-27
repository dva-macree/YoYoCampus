package com.yoyo.domain;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "yo_car_comment")
@JsonIgnoreProperties(value={"mainUser","carSchool"})
public class Comment extends BaseDomain{
	private int carCommentId;
	private String carCommentContent;
	private MainUser mainUser;
	private CarSchool carSchool;
	private java.util.Date commentDate;
	
	public Comment(){
		System.out.println(">>> Constructor Comment");
	}
	public Comment(String carCommentContent,MainUser mainUser,CarSchool carSchool,String commentTimestamp){	
		try {
			DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date;
			date = fmt.parse(commentTimestamp);
			setCommentDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		setCarCommentContent(carCommentContent);
		setMainUser(mainUser);
		setCarSchool(carSchool);	
	}
	
	@Id
	@GeneratedValue
	@Column(name = "car_comment_id")
	public int getCarCommentId() {
		return carCommentId;
	}
	public void setCarCommentId(int carCommentId) {
		this.carCommentId = carCommentId;
	}
	@Column(name = "car_comment_content")
	public String getCarCommentContent() {
		return carCommentContent;
	}
	public void setCarCommentContent(String carCommentContent) {
		this.carCommentContent = carCommentContent;
	}
	@ManyToOne(targetEntity=MainUser.class)  
	@JoinColumn(name = "user_id")
	public MainUser getMainUser() {
		return mainUser;
	}
	public void setMainUser(MainUser mainUser) {
		this.mainUser = mainUser;
	}
	
	@ManyToOne(targetEntity=CarSchool.class)
	@JoinColumn(name="car_school_id")
	public CarSchool getCarSchool() {
		return carSchool;
	}
	public void setCarSchool(CarSchool carSchool) {
		this.carSchool = carSchool;
	}
	
	@Column(name="car_comment_date")
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	
	
	
	
	
}
