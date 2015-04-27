package com.yoyo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "yo_car_conn_school")
public class CarConnSchool {
	private int conn_id;
	private double distance;
	private double carSchoolNorprice;
	private double vipprice;
	private CarSchool carSchool;
	private University university;
	
	@Id
	@GeneratedValue
	@Column(name = "conn_id")
	public int getConn_id() {
		return conn_id;
	}
	public void setConn_id(int conn_id) {
		this.conn_id = conn_id;
	}
	@Column(name ="distance")
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	@Column(name = "car_school_norprice")
	public double getCarSchoolNorprice() {
		return carSchoolNorprice;
	}
	public void setCarSchoolNorprice(double carSchoolNorprice) {
		this.carSchoolNorprice = carSchoolNorprice;
	}
	
	@Column(name = "car_school_vipprice")
	public double getVipprice() {
		return vipprice;
	}
	public void setVipprice(double vipprice) {
		this.vipprice = vipprice;
	}
	
	@ManyToOne(targetEntity=CarSchool.class)  
	@JoinColumn(name = "car_school_id")
	public CarSchool getCarSchool() {
		return carSchool;
	}
	public void setCarSchool(CarSchool carSchool) {
		this.carSchool = carSchool;
	}
	
	@ManyToOne(targetEntity=University.class)
	@JoinColumn(name = "school_id")
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	
	
	
	
	
}
