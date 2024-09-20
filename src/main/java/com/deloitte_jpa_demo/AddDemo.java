package com.deloitte_jpa_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AddDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			
			Employee newEmployee = new Employee("Soni", 85.25);

			session.beginTransaction();

			session.save(newEmployee);

			session.getTransaction().commit();

			System.out.println("Done...");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			factory.close();
		}
	}
}


