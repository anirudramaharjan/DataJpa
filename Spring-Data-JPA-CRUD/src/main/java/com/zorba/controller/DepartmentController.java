package com.zorba.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zorba.exception.DataNotFound;
import com.zorba.model.Department;
import com.zorba.model.Student;
import com.zorba.repository.DepartmentRepository;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
	
	@Autowired
	DepartmentRepository deptRepo;
	
	@GetMapping(value ="getDepartments")
	public List <Department> getAllDepartment(){
		return (List<Department>) deptRepo.findAll();
	}
	
	//to find individual by dept name
	@GetMapping(value="/getByDept")
	public Optional<Department> getDept(@RequestParam String deptName) {
		return deptRepo.getByDept(deptName);
	}
	

	@PostMapping(value = "postAllDepartments")
	public String addAllDept(@RequestBody List<Department> d) {
		for(Department  dept: d) {
		deptRepo.save(dept);
		}
		return ("posted all dept.");
	}
	
	@PostMapping(value = "postDepartments")
	public void addAllDepartment(@RequestBody Department d) {
		deptRepo.save(d);
		
	}

	
	@GetMapping(value = "getById")
	public Optional<Department> getById(@RequestBody Long id) {
		return deptRepo.findById(id);
	}

	
	@DeleteMapping(value = "delete")
	public void deleteById(@RequestBody Long id) {
		deptRepo.deleteById(id);
	}
	//update entity by id
//	@PutMapping(value = "/{id}")
//	public void updateDepartment(@RequestBody Department d,@PathVariable Long id ) {
//		d.setId(id);
//		deptRepo.save(d);
//		
//	}
	//update entity by deptName
	@PutMapping(value = "/{id}")
	public void updateDept(@PathVariable Long id, @RequestParam String deptName ) {
		deptRepo.updateDeptName(id, deptName);
		
	}
	@GetMapping(value = "/all")
	public Iterable<Department> getAll(){
		return deptRepo.findAll();
	}
	
//	---not work-----
//	@PostMapping(value = "add")
//	public String postValue(@RequestParam String deptName, @RequestParam String contact) {
//		Department d = new Department();
//		d.setDeptName(deptName);
//		d.setContact(contact);
//		return "saved";
//		
//	}


	
	



}
