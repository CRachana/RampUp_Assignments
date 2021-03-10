package com.demo.SampleSpringBoot2.service;

import java.util.List;

import com.demo.SampleSpringBoot2.model.Employee;

public interface EmployeeService {

	List<Employee> get();

	Employee get(int id);

	void save(Employee employee);

	void delete(int id);

	// List<employeedetails> gets();

	// void save(employeedetails employeeObj);

	// void save(employeedetails employees);
}
