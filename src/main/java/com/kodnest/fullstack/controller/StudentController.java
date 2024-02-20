package com.kodnest.fullstack.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kodnest.fullstack.entity.Student;
import com.kodnest.fullstack.serviceimpl.StudentServiceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class StudentController {
	
	@Autowired
	StudentServiceimpl ss;

	@GetMapping(value = "/getstu")
	public List<Student> getStudent() {
		return ss.getStudent();
	}
	
	@GetMapping(value = "/get/{id}")
	public Student getStudentById(@PathVariable Integer id) {
		return ss.getStudentById(id);
	}
	@GetMapping(value = "/getname/{name}")
	public Student getStudentByName(@PathVariable String name) {
		return ss.getStudentByName(name);
	}
	
	@PostMapping(value = "/post")
	public Student postStudent(@RequestBody Student student) {
		return ss.postStudent(student);
	}
	
	@PutMapping("put/{id}")
	public String putStudentById(@PathVariable Integer id, @RequestBody Student student) {
		return ss.putStudentById(id,student);
	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteStudentById(@PathVariable Integer id) {
		return ss.deleteStudentById(id);
	}
	
}
