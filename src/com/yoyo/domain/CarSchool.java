package com.yoyo.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="yo_car_school")
public class CarSchool extends BaseDomain{
	private int carSchoolId;
	private String carSchoolName;
	private String carSchoolAddr;
	private String carSchoolBooklet;
	private double carSchoolNorOriPrice;
	private double carSchoolVipOriPrice;
	private String specialService;
	private String description;
	private String procedure;
	private String timetable;
	private Set<Comment> comments;
	private Set<CarService> services;
	private Set<CarConnSchool> carConnSchools;
	private Set<CarConnTag> carConnTags;
	private int studentNum;
	private String carSchoolImg;
	private Set<Order> orderList;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="car_school_id")
	public int getCarSchoolId() {
		return carSchoolId;
	}
	public void setCarSchoolId(int carSchoolId) {
		this.carSchoolId = carSchoolId;
	}
	@Column(name="car_school_name")
	public String getCarSchoolName() {
		return carSchoolName;
	}
	public void setCarSchoolName(String carSchoolName) {
		this.carSchoolName = carSchoolName;
	}
	@Column(name="car_school_addr")
	public String getCarSchoolAddr() {
		return carSchoolAddr;
	}
	public void setCarSchoolAddr(String carSchoolAddr) {
		this.carSchoolAddr = carSchoolAddr;
	}
	@Column(name="car_school_booklet")
	public String getCarSchoolBooklet() {
		return carSchoolBooklet;
	}
	public void setCarSchoolBooklet(String carSchoolBooklet) {
		this.carSchoolBooklet = carSchoolBooklet;
	}
	@Column(name="car_school_nororiprice")
	public double getCarSchoolNorOriPrice() {
		return carSchoolNorOriPrice;
	}
	public void setCarSchoolNorOriPrice(double carSchoolNorOriPrice) {
		this.carSchoolNorOriPrice = carSchoolNorOriPrice;
	}
	@Column(name="car_school_viporiprice")
	public double getCarSchoolVipOriPrice() {
		return carSchoolVipOriPrice;
	}
	public void setCarSchoolVipOriPrice(double carSchoolVipOriPrice) {
		this.carSchoolVipOriPrice = carSchoolVipOriPrice;
	}
	@Column(name="car_school_spservice")
	public String getSpecialService() {
		return specialService;
	}
	public void setSpecialService(String specialService) {
		this.specialService = specialService;
	}
	@Column(name="car_school_description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="car_school_procedure")
	public String getProcedure() {
		return procedure;
	}
	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}
	@Column(name="car_school_timetable")
	public String getTimetable() {
		return timetable;
	}
	public void setTimetable(String timetable) {
		this.timetable = timetable;
	}
	
	@OneToMany(mappedBy = "carSchool",targetEntity=Comment.class, cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
//	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//	@JoinTable(name = "yo_car_conn_tag",
//	joinColumns = {
//			@JoinColumn(name = "car_school_id", referencedColumnName = "car_school_id")},
//	inverseJoinColumns = {@JoinColumn(name = "car_tag_id", referencedColumnName ="car_tag_id")})
//	public Set<Tag> getTags() {
//		return tags;
//	}
//	public void setTags(Set<Tag> tags) {
//		this.tags = tags;
//	}
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name="yo_car_conn_service",
	joinColumns = {
			@JoinColumn(name = "car_school_id",referencedColumnName="car_school_id")},
	inverseJoinColumns = {
			@JoinColumn(name ="car_service_id", referencedColumnName="car_service_id")})
	public Set<CarService> getServices() {
		return services;
	}
	public void setServices(Set<CarService> services) {
		this.services = services;
	}
	
	@OneToMany(mappedBy = "carSchool",targetEntity=CarConnSchool.class, cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<CarConnSchool> getCarConnSchools() {
		return carConnSchools;
	}
	public void setCarConnSchools(Set<CarConnSchool> carConnSchools) {
		this.carConnSchools = carConnSchools;
	}
	
	@Column(name = "studentNum")
	public int getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	
	@OneToMany(mappedBy = "carSchool",targetEntity=CarConnTag.class, cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<CarConnTag> getCarConnTags() {
		return carConnTags;
	}
	public void setCarConnTags(Set<CarConnTag> carConnTags) {
		this.carConnTags = carConnTags;
	}
	
	@Column(name ="car_school_img")
	public String getCarSchoolImg() {
		return carSchoolImg;
	}
	public void setCarSchoolImg(String carSchoolImg) {
		this.carSchoolImg = carSchoolImg;
	}
	
	
	@OneToMany(mappedBy="carSchool",targetEntity = Order.class,cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(Set<Order> orderList) {
		this.orderList = orderList;
	}
	
	
	
	
	
	
}
