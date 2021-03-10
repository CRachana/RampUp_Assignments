package com.hcl.service;

import java.util.List;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hcl.model.Customer;
import com.hcl.utility.Utility;

public class CustomerServImpl implements CustomerService {
	static Session session = Utility.getSession();
	Transaction transaction;

	public Customer saveCustomer(Customer customer) {
		transaction = session.beginTransaction();
		session.save(customer);
		transaction.commit();
		return customer;
	}

	public Customer updateCustomer(Customer customer) {
		session.saveOrUpdate(customer);
		transaction.commit();
		return customer;
	}

	public Customer getCustomer(int Customer_id) {
		Customer customer = (Customer) session.get(Customer.class, Customer_id);
		return customer;
	}

	public void deleteCustomer(int Customer_id) {
		transaction = session.beginTransaction();
		Query q = session.createQuery("delete from Customer where Customer_id=:Id1");
		q.setParameter("Id1", Customer_id);
		q.executeUpdate();
		transaction.commit();
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customers = session.createQuery("from Customer", Customer.class).list();
		return customers;

	}

}