package com.yoyo.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

//ʵ��Serializable�ӿڣ��Ա�JVM�������л�POʵ��
public class BaseDomain implements Serializable{
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
