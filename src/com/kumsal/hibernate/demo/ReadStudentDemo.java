package com.kumsal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumsal.demo.entity.Student;

import sun.print.resources.serviceui_zh_TW;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=sessionFactory.getCurrentSession();
		
		try {
			Student theStudent=new Student("Experiment", "Person", "person@gmail.com");
			
			session.beginTransaction();
			
			session.save(theStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Saved succesfuly");
			
			System.out.println("New procces starting...");
			
			session=sessionFactory.getCurrentSession();
			session.beginTransaction();
			System.out.println(theStudent.getId());
			Student theStudent1=session.get(Student.class, theStudent.getId());
			System.out.println("Take a student information ");
			System.out.println("First Name :"+theStudent1.getFirstName());
			
			System.out.println("First Name :"+theStudent1.getLastName());

			session.getTransaction().commit();
		} finally {
			// TODO: handle finally clause
		}

	}

}
