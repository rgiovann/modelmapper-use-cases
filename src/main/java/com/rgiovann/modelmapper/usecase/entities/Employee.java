package com.rgiovann.modelmapper.usecase.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String name;
	public String lastName;
	public String email;
	public String driverLicenseId;
	public String cpfId;
	public String nisId;
	
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	public Department department;
	
	public Employee() {
	}

 
	public Employee(Long id, String name, String lastname, String email, String driverLicenseId, String cpfId,
			String nisId, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastname;
		this.email = email;
		this.driverLicenseId = driverLicenseId;
		this.cpfId = cpfId;
		this.nisId = nisId;
		this.department = department;
	}


	public String getLastname() {
		return lastName;
	}


	public void setLastname(String lastname) {
		this.lastName = lastname;
	}


	public String getDriverLicenseId() {
		return driverLicenseId;
	}



	public void setDriverLicenseId(String driverLicenseId) {
		this.driverLicenseId = driverLicenseId;
	}



	public String getCpfId() {
		return cpfId;
	}



	public void setCpfId(String cpfId) {
		this.cpfId = cpfId;
	}



	public String getNisId() {
		return nisId;
	}



	public void setNisId(String nisId) {
		this.nisId = nisId;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
