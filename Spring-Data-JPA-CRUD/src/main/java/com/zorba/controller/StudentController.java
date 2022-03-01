package com.zorba.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zorba.model.Student;
import com.zorba.repository.StudentRepository;

@RestController
@RequestMapping(value = "/student")

public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping(value = "getStudents")
	public List<Student> getAllStudent() {
		return (List<Student>) studentRepository.findAll();	
	}
	
	@PostMapping(value = "postStudents")
	public void addAllStudents(@RequestBody Student s) {
		studentRepository.save(s);
	}

	@GetMapping(value = "getById")
//	public Optional<Student> getById(@RequestBody Long id) {
//		return studentRepository.findById(id);
//	}
	
	public Student getStudent(@RequestBody Long id ) {
		Optional<Student> s =  studentRepository.findById(id);
		Student student = s.get();
		return student;
	}
	
	
	@DeleteMapping(value = "delete")
	public void deleteById(@RequestBody Long id) {
		studentRepository.deleteById(id);
	}
	
	@PutMapping(value = "update")
	public void update(@RequestBody Long id) {
		Optional<Student> em = studentRepository.findById(id);
		Student s = em.get();
		studentRepository.save(s);
	}	

	
}
