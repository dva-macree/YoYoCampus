package com.yoyo.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tao_hooby")
public class Hobby extends BaseDomain {
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	
	private String hobbyLabel;

	public Hobby() {
		super();
	}

	public Hobby(int id, String hobbyLabel) {
		super();
		this.id = id;
		this.hobbyLabel = hobbyLabel;
	}

	@Id
	@GeneratedValue
	@Column(name="hid")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="hobbylabel")
	public String getHobbyLabel() {
		return hobbyLabel;
	}

	public void setHobbyLabel(String hobbyLabel) {
		this.hobbyLabel = hobbyLabel;
	}

	@Override
	public String toString() {
		return "Hobby [id=" + id + ", hobbyLabel=" + hobbyLabel + "]";
	}
}
