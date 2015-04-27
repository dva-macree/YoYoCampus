package com.yoyo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="yo_car_order")
public class Order extends BaseDomain{
	private int carOrderId;
	private MainUser mainUser;
	private CarSchool carSchool;
	private double carSchoolPrice;
	private int carSchoolClass;
	private String carOrderTimestampString;
	private int carOrderState;
	
	public Order() {
		System.out.println(">>> Constructor Order");
	}
	
	public Order(MainUser mainUser,String phoneNum,CarSchool carSchool,double carSchoolPrice,int carSchoolClass,String carOrderTimestamp,int carOrderState){
		this.mainUser = mainUser;
		this.mainUser.setPhoneNum(phoneNum);
		this.carSchool = carSchool;
		this.carSchoolPrice = carSchoolPrice;
		this.carSchoolClass = carSchoolClass;
		this.carOrderTimestampString = carOrderTimestamp;
		this.carOrderState = carOrderState;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "car_order_id")
	public int getCarOrderId() {
		return carOrderId;
	}
	public void setCarOrderId(int carOrderId) {
		this.carOrderId = carOrderId;
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
	
	@Column(name = "car_school_price")
	public double getCarSchoolPrice() {
		return carSchoolPrice;
	}
	public void setCarSchoolPrice(double carSchoolPrice) {
		this.carSchoolPrice = carSchoolPrice;
	}
	@Column(name = "car_school_class")
	public int getCarSchoolClass() {
		return carSchoolClass;
	}
	public void setCarSchoolClass(int carSchoolClass) {
		this.carSchoolClass = carSchoolClass;
	}
	@Column(name = "car_order_timestamp")
	public String getCarOrderTimestampString() {
		return carOrderTimestampString;
	}
	public void setCarOrderTimestampString(String carOrderTimestampString) {
		this.carOrderTimestampString = carOrderTimestampString;
	}
	@Column(name = "car_order_state")
	public int getCarOrderState() {
		return carOrderState;
	}
	public void setCarOrderState(int carOrderState) {
		this.carOrderState = carOrderState;
	}
}
