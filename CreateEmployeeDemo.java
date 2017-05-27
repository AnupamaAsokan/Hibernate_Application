package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		// create a sessionfactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		// create a session form session factory
		Session session = factory.getCurrentSession();
		try {

			// create the java object
			System.out.println("Creating the Employee object");
			Employee employee = new Employee("Anupama", "Asokan", "TCS");
			Employee employee1 = new Employee("Divya", "Vim", "TCS");
			Employee employee2 = new Employee("Roel", "Rox", "TCS");

			// begin the transaction
			System.out.println("Beginning the transaction");
			session.beginTransaction();

			// save the transaction
			System.out.println("Saving the Employee object");
			session.save(employee);
			session.save(employee1);
			session.save(employee2);
			
			// commit the transaction
			System.out.println("transaction committed");
			session.getTransaction().commit();
			System.out.println("Done");

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
