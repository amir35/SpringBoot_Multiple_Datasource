package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService stuService;
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student stu)
	{
		return stuService.addStudent(stu);
	}
	
	@GetMapping("/getStudent")
	public List<Student> getStudent()
	{
		return stuService.getStudent();
	}

}
