package com.yoyo.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tao_mainusers")
public class MainUser extends BaseDomain{
	private int uid;
	private String userimage;
	private String username;
	private String qq;
	private String phoneNum;
	private String phonePublic;
	private int score;
	private String sign;
	private int sex;
	private String home_city;
	private String home_province;
	private Date birthday;
	private String school;
	private int schoolTime;
	private int collectionPublic;
	private Date signinDate;
	private String homeArea;
	private Set<Comment> commentList;
	private Set<Order> orderList;
	
	@Id
	@GeneratedValue
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUserimage() {
		return userimage;
	}
	public void setUserimage(String userimage) {
		this.userimage = userimage;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	@Column(name="phonenum")
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	@Column(name="phonepublic")
	public String getPhonePublic() {
		return phonePublic;
	}
	public void setPhonePublic(String phonePublic) {
		this.phonePublic = phonePublic;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getHome_city() {
		return home_city;
	}
	public void setHome_city(String home_city) {
		this.home_city = home_city;
	}
	public String getHome_province() {
		return home_province;
	}
	public void setHome_province(String home_province) {
		this.home_province = home_province;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	@Column(name = "schooltime")
	public int getSchoolTime() {
		return schoolTime;
	}
	public void setSchoolTime(int schoolTime) {
		this.schoolTime = schoolTime;
	}
	
	@Column(name = "collectionpublic")
	public int getCollectionPublic() {
		return collectionPublic;
	}
	public void setCollectionPublic(int collectionPublic) {
		this.collectionPublic = collectionPublic;
	}
	@Column(name = "signin_date")
	public Date getSigninDate() {
		return signinDate;
	}
	public void setSigninDate(Date signinDate) {
		this.signinDate = signinDate;
	}
	@Column(name = "home_area")
	public String getHomeArea() {
		return homeArea;
	}
	public void setHomeArea(String homeArea) {
		this.homeArea = homeArea;
	}
	
	@OneToMany(mappedBy = "mainUser",targetEntity=Comment.class, cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(Set<Comment> commentList) {
		this.commentList = commentList;
	}
	
	@OneToMany(mappedBy = "mainUser",targetEntity = Order.class,cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(Set<Order> orderList) {
		this.orderList = orderList;
	}
	
	
}
