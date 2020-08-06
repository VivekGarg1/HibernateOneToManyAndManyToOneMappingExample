package com.home.client;

import java.util.Date;

import org.hibernate.Session;

import com.home.entities.Address;
import com.home.entities.Employee;
import com.home.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//createEmployee(session);
			getEmployeeById(session);
			getAddressById(session);
			//updateEmployeeById(session);
			//deleteEmployeeById(session);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void getAddressById(Session session) {
		Address address=session.get(Address.class, 1);
		if(address != null) {
			System.out.println(address);
			System.out.println(address.getEmployee());
		}
		else
			System.out.println("Address does not exist!!!");
		}

	private static void deleteEmployeeById(Session session) {
		Employee employee=session.get(Employee.class, 1);
		if(employee != null) {
			session.beginTransaction();
			session.delete(employee);
			session.getTransaction().commit();
		}
	}

	private static void updateEmployeeById(Session session) {
		session.beginTransaction();
		Employee employee=session.get(Employee.class, 1);
		if(employee != null) {
			employee.setEmployeeName("Vivek Garg");
		    employee.setEmail("vivek.garg@gmail.com");
		    employee.setSalary(10000.00);
		    session.update(employee);
		    session.getTransaction().commit();
		}
		else
			System.out.println("Employee does not exist!!!");
		}

	private static void getEmployeeById(Session session) {
		Employee employee=session.get(Employee.class, 1);
		if(employee != null) {
			System.out.println(employee);
		}
		else
			System.out.println("Employee does not exist!!!");
		}

	private static void createEmployee(Session session) {
		session.beginTransaction();
		Employee employee=new Employee();
		employee.setEmployeeName("Vivek");
		employee.setEmail("vivek@gmail.com");
		employee.setDoj(new Date());
		employee.setSalary(16000.00);
		
		Address address1=new Address();
		address1.setCity("Bulandshahr");
		address1.setState("U.P");
		address1.setStreet("Hanuman Chowck");
		address1.setPin(123456L);
		
		
		Address address2=new Address();
		address2.setCity("Hapur");
		address2.setState("U.P");
		address2.setStreet("Pakka bagh");
		address2.setPin(453456L);
		
		employee.getAddress().add(address1);
		employee.getAddress().add(address2);
		
		address1.setEmployee(employee);
		address2.setEmployee(employee);
		
		session.save(employee);
		
		session.getTransaction().commit();
	}
}
