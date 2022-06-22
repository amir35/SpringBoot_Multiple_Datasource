package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.employee.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	public Employee addEmployee(Employee emp)
	{
		return repo.save(emp);
	}

	public List<Employee> getEmployees() {
		
		return repo.findAll();
	}

}
