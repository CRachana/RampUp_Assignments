package com.hcl.service;

import java.util.List;
import com.hcl.model.Customer;

public interface CustomerService {
	public Customer saveCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer getCustomer(int Customer_id);

	public void deleteCustomer(int Customer_id);

	public List<Customer> getAllCustomers();

}
