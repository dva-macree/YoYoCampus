package com.yoyo.domain;

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
@Table(name = "tao_university")
public class University {
	private int universityId;
	private String universityName;
	private Set<CarConnSchool> carConnSchools;
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getUniversityId() {
		return universityId;
	}
	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}
	
	@Column(name = "name")
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	@OneToMany(mappedBy = "university",targetEntity=CarConnSchool.class, cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<CarConnSchool> getCarConnSchools() {
		return carConnSchools;
	}
	public void setCarConnSchools(Set<CarConnSchool> carConnSchools) {
		this.carConnSchools = carConnSchools;
	}
	
	
	

}
