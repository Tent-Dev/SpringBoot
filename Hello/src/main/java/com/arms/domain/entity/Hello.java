package com.arms.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
public class Hello {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String name;
}

//ไฟล์นี้สร้าง Table
