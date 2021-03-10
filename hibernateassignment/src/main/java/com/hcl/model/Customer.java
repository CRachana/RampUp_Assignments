package com.hcl.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CustomerId")
	private int Customer_id;
	@Column(name = "CustomerName")
	private String Customer_name;
	@Column(name = "CustomerMobile")
	private String Customer_mobile;
	@Column(name = "CustomerEmail")
	private String Customer_email;
	@Column(name = "CustomerUsername")
	private String Customer_username;
	@Column(name = "CustomerPassword")
	private String Customer_password;
	@Column(name = "CustomerAddress")
	private String Customer_address;

	@ManyToMany
	@JoinTable(name = "Feedbacks", joinColumns = { @JoinColumn(name = "Customer_id") }, inverseJoinColumns = {
			@JoinColumn(name = "customer_feedback_type") })
	private List<CustomerFeedback> CustomerFeedbacks;

	public int getCustomer_id() {
		return Customer_id;
	}

	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}

	public String getCustomer_name() {
		return Customer_name;
	}

	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}

	public String getCustomer_mobile() {
		return Customer_mobile;
	}

	public void setCustomer_mobile(String customer_mobile) {
		Customer_mobile = customer_mobile;
	}

	public String getCustomer_email() {
		return Customer_email;
	}

	public void setCustomer_email(String customer_email) {
		Customer_email = customer_email;
	}

	public String getCustomer_username() {
		return Customer_username;
	}

	public void setCustomer_username(String customer_username) {
		Customer_username = customer_username;
	}

	public String getCustomer_password() {
		return Customer_password;
	}

	public void setCustomer_password(String customer_password) {
		Customer_password = customer_password;
	}

	public String getCustomer_address() {
		return Customer_address;
	}

	public void setCustomer_address(String customer_address) {
		Customer_address = customer_address;
	}

	@Override
	public String toString() {
		return "Customer [Customer_id=" + Customer_id + ", Customer_name=" + Customer_name + ", Customer_mobile="
				+ Customer_mobile + ", Customer_email=" + Customer_email + ", Customer_username=" + Customer_username
				+ ", Customer_password=" + Customer_password + ", Customer_address=" + Customer_address + "]";
	}

	public Customer(int customer_id, String customer_name, String customer_mobile, String customer_email,
			String customer_username, String customer_password, String customer_address) {
		super();
		Customer_id = customer_id;
		Customer_name = customer_name;
		Customer_mobile = customer_mobile;
		Customer_email = customer_email;
		Customer_username = customer_username;
		Customer_password = customer_password;
		Customer_address = customer_address;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
