package com.demo.springbootproject.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.demo.springbootproject.model.Employees;


@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employees, Integer> {

	Page<Employees> findByDepartment(String department, Pageable pageable);

}