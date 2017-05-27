package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create sessionfactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
			// use the java object to save the java object
			System.out.println("Creating the student object");
			//start a transaction
			session.beginTransaction();
			//query the students. Use the bean and attribute names here and not table name
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			//display the students
			displayStudents(theStudents);
			theStudents = session.createQuery("from Student s where s.lastName ='Asokan'").getResultList();
			//display the students
			System.out.println("Students with Lastname Asokan");
			displayStudents(theStudents);
			//display the students
			theStudents = session.createQuery("from Student s where "
					+ "s.firstName='Abhinav'").getResultList();
			System.out.println("Students with Lastname Paul or Asokan");
			
			displayStudents(theStudents);
			
			session.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			session.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student students:theStudents){
			System.out.println(students);
		}
	}

}
