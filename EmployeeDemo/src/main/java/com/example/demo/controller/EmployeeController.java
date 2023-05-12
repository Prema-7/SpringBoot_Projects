package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/list")
	public Iterable<Employee> getEmployeesList() {
		return empService.getEmps();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addNewEmp(@RequestBody Employee emp) {
		return new ResponseEntity<Employee>(empService.addEmployee(emp), HttpStatus.OK);
	}
	
	@GetMapping("/getEmp/{emp}")
	public Optional<Employee> getEmpByName(@PathVariable String emp) {
		
		return empService.fetchEmpByName(emp);
		 
	}
	
	@GetMapping("/getEmps/{emps}")
	public List<Employee> getEmpsByName(@PathVariable Employee emps) {
		
		return empService.fetchByName(emps.getName());
		 
	}
	
	@DeleteMapping("/delEmp/{name}")
	public void deleteEmp(String name) {
		empService.deleteByName(name);
	}
	
	@GetMapping("/findAllEmps")
	public List<Employee> getAllEmps() {
		return empService.getAllEmps();
	}
	
	
}
