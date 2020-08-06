package com.home.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address_table")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;
	
	@Column(name = "street_name",length = 50)
	private String street;
	
	@Column(name = "city_name",length = 50)
	private String city;
	
	@Column(name="state_name")
	private String state;
	
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	@Column(name = "pin_code")
	private Long pin;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPin() {
		return pin;
	}

	public void setPin(Long pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", pin=" + pin + "]";
	}

}
