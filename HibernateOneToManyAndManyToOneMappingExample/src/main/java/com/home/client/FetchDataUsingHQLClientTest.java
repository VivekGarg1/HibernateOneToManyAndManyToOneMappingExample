package com.home.client;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.home.entities.Address;
import com.home.entities.Employee;
import com.home.util.HibernateUtil;

public class FetchDataUsingHQLClientTest {

	public static void main(String[] args) {
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//getEmployeeById(session);
			getEmployeeFieldsById(session);
			//getAddressById(session);
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
	
	private static void getEmployeeFieldsById(Session session) {
		String HQL="select emp.employeeName,emp.salary,addr.pin from Employee emp left join emp.address addr where emp.employeeId=:empId";
		Query<Object[]> query = session.createQuery(HQL);
		query.setParameter("empId", 1);
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			String employeeName=(String)objects[0];
			Double salary=(Double)objects[1];
			Long pin=(Long)objects[2];
			System.out.println(employeeName+"\t"+salary+"\t"+pin);
		}
		}

	private static void getEmployeeById(Session session) {
		String HQL="from Employee where employeeId=:empId";
		Query<Employee> query = session.createQuery(HQL,Employee.class);
		query.setParameter("empId", 1);
		Employee employee = query.uniqueResult();
		if(employee != null) {
			System.out.println(employee);
			employee.getAddress().forEach(System.out::println);
		}
		}

	
}
