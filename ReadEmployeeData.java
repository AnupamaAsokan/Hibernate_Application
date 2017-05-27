package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;
import com.luv2code.hibernate.demo.entity.Student;

public class ReadEmployeeData {

	public static void main(String[] args) {
		//Create a session factory
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		//create a session from session factory
		Session session = factory.getCurrentSession();
		try{
		
			//Put an entry into the table
			Employee employee1 = new Employee("Nirmal", "Kumar", "IBM");
			session.beginTransaction();
			session.save(employee1);
			session.getTransaction().commit();
			
			//retirve data using the id
			session = factory.getCurrentSession();
			session.beginTransaction();
			Employee emp = session.get(Employee.class,employee1.getId());
			System.out.println("The new Employee " 
			+emp.getFirstName()+emp.getLastName()+ "works for "+emp.getCompany());
			session.getTransaction().commit();
			
			//retrieve all the list of employees in the company
			session = factory.getCurrentSession();
			session.beginTransaction();
			List<Employee> employeeList = session.createQuery("from Employee").getResultList();
			System.out.println("All the Employees");
			for(Employee employee:employeeList){
			System.out.println(employee);
			}
			session.getTransaction().commit();
			
			//retrieve employees for a given company
			session = factory.getCurrentSession();
			session.beginTransaction();
			List<Employee> employeeList1 = session.createQuery("from Employee").getResultList();
			employeeList1 = session.createQuery("from Employee s where s.company ='IBM'").getResultList();
			for(Employee employee:employeeList1){
				System.out.println("All the Employees in TCS");
				System.out.println(employee);
				}
			session.getTransaction().commit();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
