package com.model;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;



public class Test { 
	public static void main(String[] args) {
//		add();
		getAll();
//		update();
		delete();
	}
	
	

	//add student
	
	static void add() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Student s = new Student();
		s.setFname("ram");
		s.setLname("XYZ");
		s.setCollege("ncc");
		s.setCity("ktm");
		s.setAge(45);
		
		session.save(s);
		session.getTransaction().commit();
		session.close();
	}
	//	get all student
	static void getAll() {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		//select all from student  where college = 'KIST'
		Criteria crt = session.createCriteria(Student.class);
			crt.add(Restrictions.eq("college","ncc"));
			crt.add(Restrictions.eq("city","ktm"));
		List<Student> sList = crt.list();
		
		
		System.out.println(sList);
	}
	static void update() {
		// TODO Auto-generated method stub
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Student student = (Student) session.get(Student.class, 2);
		student.setAge(33);
		student.setCity("Butwal");
		
		session.update(student);
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	static void delete() {
		// TODO Auto-generated method stub
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Student student = (Student) session.get(Student.class, 3);
		
		
		session.delete(student);//deletesql
		session.getTransaction().commit();
		session.close();
		
		
	}
	
}
