package com.sp.javabrains.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sp.javabrains.entity.UserDetails;

public class DemoApp {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(UserDetails.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			System.out.println("Creating new student object...");
			UserDetails tempStudent1 = new UserDetails("Paul", "Doe",
					"paul@luv2code.com");
			UserDetails tempStudent2 = new UserDetails("sant", "pan",
					"san@luv2code.com");
			UserDetails tempStudent3 = new UserDetails("beenu ek mirgi", "pan",
					"beenu@luv2code.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			System.out.println(tempStudent1);
			// commit transaction
			session.getTransaction().commit();

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id:primary key
			System.out.println("getting student id " + tempStudent1.getId());

			UserDetails mystudent = session.get(UserDetails.class,
					tempStudent1.getId());
			System.out.println("get complete : " + mystudent);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
