package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create sessionfactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
//Delete 1
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Student where id='3'").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done!");
			
//Delete 2
			int studentId = 4;
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student myStudent = session.get(Student.class,studentId);
			session.delete(myStudent);
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
