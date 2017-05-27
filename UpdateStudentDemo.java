package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create sessionfactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
			int studentId = 1;
			// use the java object to save the java object
			System.out.println("Creating the student object");
			session = factory.getCurrentSession();
			session.beginTransaction();
			//retrieving
			Student myStudent = session.get(Student.class,studentId);
			//updating
			myStudent.setFirstName("bobby");
			session.getTransaction().commit();
			System.out.println("Done!");
			
//Update
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='xxx@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
