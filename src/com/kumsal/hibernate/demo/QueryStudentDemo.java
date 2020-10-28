package com.kumsal.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumsal.demo.entity.Student;


public class QueryStudentDemo {
	public static void main(String[] args) {
		SessionFactory theSessions=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session=theSessions.getCurrentSession();
		
		List<Student> theStudents=session.query
	}
}
