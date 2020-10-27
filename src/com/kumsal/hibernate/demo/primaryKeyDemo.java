package com.kumsal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumsal.demo.entity.Student;

public class primaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=sessionFactory.getCurrentSession();
		
		try {
			Student theStudent=new Student("Yahya", "Alatas", "alatas@gmail.com");
			
			Student theStudent1=new Student("Mehmet", "Uzun", "uzun@gmail.com");
			
			Student theStudent2=new Student("Yasar", "Kemal", "kemal@gmail.com");
			
			
			session.beginTransaction();
			
			session.save(theStudent);
			session.save(theStudent1);
			session.save(theStudent2);
			
			session.getTransaction().commit();
			
			System.out.println("Saved succesfuly");
		} finally {
			// TODO: handle finally clause
		}

	}

}
