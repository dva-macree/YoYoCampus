package com.yoyo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "yo_car_conn_tag")
public class CarConnTag {
	private int conn_id;
	private Tag tag;
	private CarSchool carSchool;
	private int carTagNum;
	
	public CarConnTag() {
		System.out.println(">>> Constructor CarConnTag");
	}
	public CarConnTag(int connId,Tag tag,CarSchool carSchool,int carTagNum){
		setConn_id(connId);
		setTag(tag);
		setCarSchool(carSchool);
		setCarTagNum(carTagNum);
	}
	
	@Id
	@GeneratedValue
	public int getConn_id() {
		return conn_id;
	}
	public void setConn_id(int conn_id) {
		this.conn_id = conn_id;
	}
	
	@ManyToOne(targetEntity=Tag.class)
	@JoinColumn(name = "car_tag_id")
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
	@ManyToOne(targetEntity=CarSchool.class)  
	@JoinColumn(name = "car_school_id")
	public CarSchool getCarSchool() {
		return carSchool;
	}
	public void setCarSchool(CarSchool carSchool) {
		this.carSchool = carSchool;
	}
	

	@Column(name ="car_tag_num")
	public int getCarTagNum() {
		return carTagNum;
	}
	public void setCarTagNum(int carTagNum) {
		this.carTagNum = carTagNum;
	}
	
	
	
}
