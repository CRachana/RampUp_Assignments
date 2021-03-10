package com.hcl.service;

import java.util.List;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hcl.model.Customer;
import com.hcl.model.CustomerFeedback;
import com.hcl.utility.Utility;

public class FeedbackServImpl implements FeedbackService {
	static Session session = Utility.getSession();
	Transaction transaction;

	public CustomerFeedback saveCustomerFeedback(CustomerFeedback customerfeedback) {
		transaction = session.beginTransaction();
		session.save(customerfeedback);
		transaction.commit();
		return customerfeedback;
	}

	public CustomerFeedback updateCustomerFeedback(CustomerFeedback customerfeedback) {
		session.saveOrUpdate(customerfeedback);
		transaction.commit();
		return customerfeedback;
	}

	public CustomerFeedback getCustomerFeedback(int customer_feedback_id) {
		CustomerFeedback customerfeedback = (CustomerFeedback) session.get(CustomerFeedback.class,
				customer_feedback_id);
		return customerfeedback;
	}

	public void deleteCustomerFeedback(int customer_feedback_id) {
		transaction = session.beginTransaction();
		Query q = session.createQuery("delete from CustomerFeedback where customer_feedback_id=:Id1");
		q.setParameter("Id1", customer_feedback_id);
		q.executeUpdate();
		transaction.commit();
	}

	public List<CustomerFeedback> getAllCustomerFeedbacks() {
		List<CustomerFeedback> customerfeedbacks = session.createQuery("from CustomerFeedback", CustomerFeedback.class)
				.list();
		return customerfeedbacks;

	}

}