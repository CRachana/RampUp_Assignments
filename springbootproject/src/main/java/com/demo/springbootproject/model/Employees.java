package com.demo.springbootproject.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employees implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int employeeid;
	@Column
	private String employeename;
	@Column
	private String gender;
	@Column
	private String department;
	@Column
	private Date doj;
	@Column
	private String address;

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employees [employeeid=" + employeeid + ", employeename=" + employeename + ", gender=" + gender
				+ ", department=" + department + ", doj=" + doj + ", address=" + address + "]";
	}

	public Employees(Integer employeeid, String employeename, String gender, String department, Date doj,
			String address) {
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.gender = gender;
		this.department = department;
		this.doj = doj;
		this.address = address;
	}

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

}
