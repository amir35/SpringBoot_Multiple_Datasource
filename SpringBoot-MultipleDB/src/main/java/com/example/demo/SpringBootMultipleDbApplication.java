package com.example.demo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Student;
import com.example.demo.repository.employee.EmployeeRepository;
import com.example.demo.repository.student.StudentRepository;

@SpringBootApplication
public class SpringBootMultipleDbApplication {

	
	
	/*
	 * @Autowired private EmployeeRepository empRepository;
	 * 
	 * @Autowired private StudentRepository stuRepository;
	 * 
	 * @PostConstruct public void addData2DB() { empRepository.saveAll(Stream.of(new
	 * Employee(744, "John", 23, "Software Engineer"), new Employee(455, "Pitter",
	 * 25, "Dentist")).collect(Collectors.toList()));
	 * stuRepository.saveAll(Stream.of(new Student(111, "Amir Ahmad", 23), new
	 * Student(222,"Zakiya Inamdar", 26)).collect(Collectors.toList())); }
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultipleDbApplication.class, args);
	}

}
