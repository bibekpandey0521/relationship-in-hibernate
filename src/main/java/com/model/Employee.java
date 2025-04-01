package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String salary;
	
	@OneToOne
	@JoinColumn(name="address_id")//FK
	private Address address;
	
	@OneToMany(mappedBy="employee")
	private List<Phone> getPhones;
	
	@ManyToMany
	@JoinTable(name="employee_department",joinColumns= {@JoinColumn(name="empid")},inverseJoinColumns ={@JoinColumn(name="deptId")})
	private List<Department> departmentList;
	
	public List<Department> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Phone> getGetPhones() {
		return getPhones;
	}
	public void setGetPhones(List<Phone> getPhones) {
		this.getPhones = getPhones;
	}
	@Override
	public String toString() {
		return "\nEmployee [id=" + id + ", name=" + name + ", salary=" + salary + ", address=" + address + "]";
	}
	
}
