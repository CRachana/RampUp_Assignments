package com.demo.springbootproject.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.springbootproject.Repository.EmployeeRepository;
import com.demo.springbootproject.model.Employees;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employees> getAllEmployees() {
		List<Employees> employees = new ArrayList<Employees>();
		employeeRepository.findAll().forEach(employees1 -> employees.add(employees1));
		return employees;
	}

	public Employees getEmployeesById(int id) {
		return employeeRepository.findById(id).get();
	}

	public void saveorUpdate(Employees employees) {
		employeeRepository.save(employees);
	}

	public void delete(int id) {
		employeeRepository.deleteById(id);
	}

	public void update(Employees employees, int employeeid) {
		employeeRepository.save(employees);
	}

	public Page<Employees> findByDepartment(String department, Pageable pageable) {
		// TODO Auto-generated method stub
		return employeeRepository.findByDepartment(department, pageable);
	}

	public Page<Employees> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return employeeRepository.findAll(pageable);

	}

}
