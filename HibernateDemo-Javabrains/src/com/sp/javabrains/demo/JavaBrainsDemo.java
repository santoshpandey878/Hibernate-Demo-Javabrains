package com.sp.javabrains.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sp.javabrains.entity.User;

public class JavaBrainsDemo {

	public static void main(String[] args) {

		User u = new User();
		u.setUserId(1);
		u.setDate(new Date());
		u.setDescription("this is hibernate using javabrains");
		u.setUserName("santosh pandey");

		// create session factory
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();

		// create session and saved object
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		session.close();
		 
		// create session and fetch object
		session = factory.openSession();
		session.beginTransaction();
		User user = session.get(User.class, 1);
		System.out.println("User retrieved : "+user);
		session.close();
	}

}
