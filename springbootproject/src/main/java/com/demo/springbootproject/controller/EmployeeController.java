package com.demo.springbootproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootproject.model.Employees;
import com.demo.springbootproject.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/getall")
	private List<Employees> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/get/{employeeid}")
	private Employees getEmployees(@PathVariable("employeeid") int employeeid) {
		return employeeService.getEmployeesById(employeeid);
	}

	@DeleteMapping("/delete/{employeeid}")
	private void deleteEmployee(@PathVariable("employeeid") int employeeid) {
		employeeService.delete(employeeid);
	}

	@PostMapping("/create")
	private int saveEmployee(@RequestBody Employees employees) {
		employeeService.saveorUpdate(employees);
		return employees.getEmployeeid();
	}

	@PutMapping("/update")
	private Employees update(@RequestBody Employees employees) {
		employeeService.saveorUpdate(employees);
		return employees;
	}

	@GetMapping("/employees")
	public Page<Employees> getAllEmployees(Pageable pageable) {
		return employeeService.findAll(pageable);
	}

	@GetMapping("/api/department/{department}")
	public Page<Employees> getAllByDepartment(@PathVariable String department, Pageable pageable) {
		return employeeService.findByDepartment(department, pageable);
	}

}
