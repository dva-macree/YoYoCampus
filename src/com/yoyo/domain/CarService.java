package com.yoyo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name ="yo_car_service")
public class CarService {
	private int carServiceId;
	private String carServiceName;
	private String carServiceImg;
	private List<CarSchool> carSchools;
	
	@Id
	@GeneratedValue
	@Column(name ="car_service_id")
	public int getCarServiceId() {
		return carServiceId;
	}
	public void setCarServiceId(int carServiceId) {
		this.carServiceId = carServiceId;
	}
	
	@Column(name = "car_service_name")
	public String getCarServiceName() {
		return carServiceName;
	}
	public void setCarServiceName(String carServiceName) {
		this.carServiceName = carServiceName;
	}
	
	@Column(name = "car_service_img")
	public String getCarServiceImg() {
		return carServiceImg;
	}
	public void setCarServiceImg(String carServiceImg) {
		this.carServiceImg = carServiceImg;
	}
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "services")
	public List<CarSchool> getCarSchools() {
		return carSchools;
	}
	public void setCarSchools(List<CarSchool> carSchools) {
		this.carSchools = carSchools;
	}
	
	
}
