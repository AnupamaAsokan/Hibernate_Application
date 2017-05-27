package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create sessionfactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
	
		try {
			Session session = factory.getCurrentSession();
			// use the java object to save the java object
			System.out.println("Creating the student object");
			Student student = new Student("Anupama", "Asokan",
					"ashok@gmail.com");
			// begin the transaction
			System.out.println("Beginning the transaction");
			session.beginTransaction();
			// save the student object
			System.out.println("Saving the student object");
			session.save(student);
			// commit the transaction
			session.getTransaction().commit();
			
			//create another session for retrieveing
			session = factory.getCurrentSession();
			session.beginTransaction();
			//generated student id
			System.out.println("Auto-Generated ID "+student.getId());
			//retrieve the student data
			Student myStudent = session.get(Student.class,student.getId());
			System.out.println("The student is " +myStudent.getFirstName()+myStudent.getLastName());
			// commit the transaction
			System.out.println("transaction committed");
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
