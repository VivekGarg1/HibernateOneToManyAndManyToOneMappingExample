package com.home.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="employee_table")
@DynamicUpdate
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;
	
	@Column(name = "employee_name",length = 100, nullable = false)
	private String employeeName;
	
	@Column(name = "email",unique = true)
	private String email;
	
	@Column(name = "date_of_joining")
	private Date doj;
	
	@Column(name = "salary")
	private double salary;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
	 /*
	 * @JoinTable(name="employee_address_table",joinColumns
	 * = @JoinColumn(name="employee_id"),inverseJoinColumns
	 * = @JoinColumn(name="address_id"))
	 */
	 
	private List<Address> address = new ArrayList<>();
	
	public  List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email + ", doj="
				+ doj + ", salary=" + salary + ", address=" + address + "]";
	}

}
