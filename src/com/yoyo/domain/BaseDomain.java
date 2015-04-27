package com.yoyo.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

//实现Serializable接口，以便JVM可以序列化PO实例
public class BaseDomain implements Serializable{
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
