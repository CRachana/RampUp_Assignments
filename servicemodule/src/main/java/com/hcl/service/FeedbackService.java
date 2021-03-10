package com.hcl.service;

import java.util.List;

import com.hcl.model.CustomerFeedback;

public interface FeedbackService {

	public CustomerFeedback saveCustomerFeedback(CustomerFeedback customerfeedback);

	public CustomerFeedback updateCustomerFeedback(CustomerFeedback customerfeedback);

	public CustomerFeedback getCustomerFeedback(int customer_feedback_id);

	public void deleteCustomerFeedback(int customer_feedback_id);

	public List<CustomerFeedback> getAllCustomerFeedbacks();

}
