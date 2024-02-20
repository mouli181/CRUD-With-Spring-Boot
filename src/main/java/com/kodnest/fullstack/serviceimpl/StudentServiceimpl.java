package com.kodnest.fullstack.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.fullstack.entity.Student;
import com.kodnest.fullstack.repository.StudentRepository;
import com.kodnest.fullstack.service.StudentService;

@Service
public class StudentServiceimpl implements StudentService {
	@Autowired
	StudentRepository sr;
	
	public List<Student> getStudent() {
		return sr.findAll();
	}

	public Student getStudentById(Integer id) {
		Optional<Student> student = sr.findById(id);
		return student.orElse(null);
		
	}

	public Student getStudentByName(String name) {
		Student stu = sr.findbyName(name);
		return stu;
	}
	
	
	public Student postStudent(Student student) {
		Student st = sr.save(student);
		return st;
	}

	public String deleteStudentById(Integer id) {
		sr.deleteById(id);
		return "Delete success";		
	}

	public String putStudentById(Integer id, Student updatingStudent) {
		
		// get the record from db
		Optional<Student> updating = sr.findById(id);
		
		if(updating.isPresent()) {
		
		//modify the app layer
		Student s = updating.get();
		s.setName(updatingStudent.getName());
		
		//save the update record
		sr.save(s);
		return "Update success";
		}
		else {
		return "Record Not Found";
	}
	}
	
}
