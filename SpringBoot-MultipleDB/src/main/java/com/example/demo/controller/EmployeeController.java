package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Student;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee emp)
	{
		return empService.addEmployee(emp);
	}
	
	@GetMapping("/getEmployee")
	public List<Employee> getEmployees()
	{
		return empService.getEmployees();
	}

}
