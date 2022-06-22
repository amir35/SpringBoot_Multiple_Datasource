package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Student;
import com.example.demo.repository.student.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public Student addStudent(Student stu)
	{
		return repo.save(stu);
	}

	public List<Student> getStudent() {
		
		return repo.findAll();
	}

}
