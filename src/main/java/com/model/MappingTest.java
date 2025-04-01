package com.model;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingTest {

	public static void main(String[] args) {
//		oneToone();
		oneToMany();
		manyTomany();
	}
	static void oneToone() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Address address = new Address();
		address.setCountry("Nepal");
		address.setState("Bagmati");
		address.setCity("kathmandu");
		
		session.save(address);
		
		Employee employee = new Employee();
		employee.setName("Rohan");
		employee.setSalary("1000");
		employee.setAddress(address);
		
		
		session.save(employee);
		session.getTransaction().commit();
		session.close();
			
	}
	
	//	oneToManyMapping
	static void oneToMany() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Address address = new Address();
		address.setCountry("Nepal");
		address.setState("Bagmati");
		address.setCity("kathmandu");
		
		session.save(address);
		
		Employee employee = new Employee();
		employee.setName("Rohan");
		employee.setSalary("1000");
		employee.setAddress(address);
		
		Phone phone1 = new Phone();
		phone1.setNumber("983456777");
		phone1.setType("NTC");
		phone1.setEmployee(employee);
		
		
		
		session.save(phone1);
		
		Phone phone2 = new Phone();
		phone2.setNumber("98653456777");
		phone2.setType("NCELL");
		phone2.setEmployee(employee);
		
		session.save(phone2);
		
		Phone phone3 = new Phone();
		phone3.setNumber("9877455534");
		phone3.setType("SKY");
		phone3.setEmployee(employee);
		session.save(phone3);
		
		Phone phone4 = new Phone();
		phone4.setNumber("984455556");
		phone4.setType("Tele");
		phone4.setEmployee(employee);
		
		session.save(phone4);
		
		employee.setGetPhones(Arrays.asList(phone1,phone2,phone3,phone4));
		
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}
	
	//manyToManyMapping
	static void manyTomany() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Address address = new Address();
		address.setCountry("Nepal");
		address.setState("Bagmati");
		address.setCity("kathmandu");
		
		session.save(address);
		
		Employee employee = new Employee();
		employee.setName("Rohan");
		employee.setSalary("1000");
		employee.setAddress(address);
		
		Phone phone1 = new Phone();
		phone1.setNumber("983456777");
		phone1.setType("NTC");
		phone1.setEmployee(employee);
		
		session.save(phone1);
		
		Phone phone2 = new Phone();
		phone2.setNumber("98653456777");
		phone2.setType("NCELL");
		phone2.setEmployee(employee);
		
		session.save(phone2);
		
		Department department1 = new Department();
		department1.setName("HR");
		session.save(department1);
		
		Department department2 = new Department();
		department1.setName("IT");
		session.save(department2);
		
		employee.setDepartmentList(Arrays.asList(department1,department2));
		
		
		employee.setGetPhones(Arrays.asList(phone1,phone2));
		
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}
}
