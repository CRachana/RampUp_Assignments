package com.hcl.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class CustomerFeedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FeedbackId")
	private int customer_feedback_id;
	@Column(name = "FeedbackTitle")
	private String customer_feedback_title;
	@Column(name = "FeedbackType")
	private String customer_feedback_type;
	@Column(name = "FeedbackComment")
	private String customer_feedback_comment;
	@Column(name = "FeedbackDescription")
	private String customer_feedback_description;

	@ManyToMany(mappedBy = "CustomerFeedbacks")
	private List<Customer> Customers;

	public int getCustomer_feedback_id() {
		return customer_feedback_id;
	}

	public void setCustomer_feedback_id(int customer_feedback_id) {
		this.customer_feedback_id = customer_feedback_id;
	}

	public String getCustomer_feedback_title() {
		return customer_feedback_title;
	}

	public void setCustomer_feedback_title(String customer_feedback_title) {
		this.customer_feedback_title = customer_feedback_title;
	}

	public String getCustomer_feedback_type() {
		return customer_feedback_type;
	}

	public void setCustomer_feedback_type(String customer_feedback_type) {
		this.customer_feedback_type = customer_feedback_type;
	}

	public String getCustomer_feedback_comment() {
		return customer_feedback_comment;
	}

	public void setCustomer_feedback_comment(String customer_feedback_comment) {
		this.customer_feedback_comment = customer_feedback_comment;
	}

	public String getCustomer_feedback_description() {
		return customer_feedback_description;
	}

	public void setCustomer_feedback_description(String customer_feedback_description) {
		this.customer_feedback_description = customer_feedback_description;
	}

	@Override
	public String toString() {
		return "CustomerFeedback [customer_feedback_id=" + customer_feedback_id + ", customer_feedback_title="
				+ customer_feedback_title + ", customer_feedback_type=" + customer_feedback_type
				+ ", customer_feedback_comment=" + customer_feedback_comment + ", customer_feedback_description="
				+ customer_feedback_description + "]";
	}

	public CustomerFeedback(int customer_feedback_id, String customer_feedback_title, String customer_feedback_type,
			String customer_feedback_comment, String customer_feedback_description) {
		super();
		this.customer_feedback_id = customer_feedback_id;
		this.customer_feedback_title = customer_feedback_title;
		this.customer_feedback_type = customer_feedback_type;
		this.customer_feedback_comment = customer_feedback_comment;
		this.customer_feedback_description = customer_feedback_description;
	}

	public CustomerFeedback() {
		super();
		// TODO Auto-generated constructor stub
	}

}
