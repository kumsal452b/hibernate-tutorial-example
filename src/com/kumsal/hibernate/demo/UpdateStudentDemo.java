package com.kumsal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumsal.demo.entity.Student;

import sun.print.resources.serviceui_zh_TW;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=sessionFactory.getCurrentSession();
		
		try {
			int id=1;
			session.beginTransaction();
			Student theStudent=session.get(Student.class, id);
			theStudent.setLastName("Alatas");
			theStudent.setEmail("kms@gmail.com");
			session.getTransaction().commit();
		} finally {
			// TODO: handle finally clause
		}

	}

}
