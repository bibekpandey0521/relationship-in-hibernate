package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "student")

public class Student {
	@Id //PK
	@GeneratedValue //Auto-Increment
	@Column
	private int id;
	@Column
	private String fname;
	@Column
	private String lname;
	@Column
	private String college;
	@Column
	private String city;
	@Column
	private int age;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "\nStudent [id=" + id + ", fname=" + fname + ", lname=" + lname + ", college=" + college + ", city=" + city
				+ ", age=" + age + "]";
	}
	
	
}
