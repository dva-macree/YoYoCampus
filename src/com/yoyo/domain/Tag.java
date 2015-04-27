package com.yoyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="yo_car_tag")
public class Tag extends BaseDomain{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int carTagId;
	private String carTagName;
	private int carTagType;

	private List<CarConnTag> carConnTags;
	public Tag() {
		super();
	}

	public Tag(int id, String tagName) {
		super();
		this.carTagId = id;
		this.carTagName = tagName;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "car_tag_id")
	public int getCarTagId() {
		return carTagId;
	}
	public void setCarTagId(int carTagId) {
		this.carTagId = carTagId;
	}
	
	@Column(name="car_tag_name")
	public String getCarTagName() {
		return carTagName;
	}
	public void setCarTagName(String carTagName) {
		this.carTagName = carTagName;
	}
	
	@Override
	public String toString() {
		return "Tag [id=" + carTagId + ", Tag=" + carTagName + "]";
	}

	@OneToMany(mappedBy = "tag",targetEntity=CarConnTag.class, cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	public List<CarConnTag> getCarConnTags() {
		return carConnTags;
	}

	public void setCarConnTags(List<CarConnTag> carConnTags) {
		this.carConnTags = carConnTags;
	}

	@Column(name ="car_tag_type")
	public int getCarTagType() {
		return carTagType;
	}

	public void setCarTagType(int carTagType) {
		this.carTagType = carTagType;
	}

}
