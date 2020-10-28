package com.kumsal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumsal.demo.entity.Student;

import sun.print.resources.serviceui_zh_TW;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=sessionFactory.getCurrentSession();
		
		try {
			int id=13;
			session.beginTransaction();
			Student theStudent=session.get(Student.class, id);
//			session.delete(theStudent);
			System.out.println("Delete succes");
			
			session.getTransaction().commit();
			
			session=sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete from Student where first_name='Experiment'")
					.executeUpdate();
		} finally {
			// TODO: handle finally clause
		}

	}

}
