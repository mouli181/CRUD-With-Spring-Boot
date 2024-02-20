package com.kodnest.fullstack.service;

import java.util.List;

import com.kodnest.fullstack.entity.Student;

public interface StudentService {
	
	public List<Student> getStudent();
	
	public Student getStudentById(Integer id);
	
	public Student getStudentByName(String name);
	
	public Student postStudent(Student st);
	
	public String deleteStudentById(Integer id);
}
