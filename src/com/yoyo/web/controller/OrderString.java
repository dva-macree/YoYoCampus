package com.yoyo.web.controller;

public class OrderString {
	private String validateString;
	
	public String getValidateString() {
		return validateString;
	}

	public void setValidateString(String validateString) {
		this.validateString = validateString;
	}

	public OrderString(String validate){
		setValidateString(validate);
	}
	
	
}
