package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo empRepo;
	

	public Iterable<Employee> getEmps(){
		return empRepo.findAll();
	}
	
	public Employee addEmployee(Employee emp) {
		emp.setName(emp.getName());
		emp.setAge(emp.getAge());
		emp.setAddress(emp.getAddress());
		emp.setPurchase(emp.getPurchase());
		return empRepo.save(emp);
	}
	
	public  Optional<Employee> fetchEmpByName(String name) {
		return empRepo.findByName(name);
	}
	
	public   List<Employee> fetchByName(String name) {
		return empRepo.findListByName(name);
	}
	
	public void deleteByName(String name) {
		empRepo.deleteById(name);
	}
	
	
	public  List<Employee> getAllEmps() {
		Iterable<Employee> emps= empRepo.findAll();
		//convert Iterable to list and return the list
		List<Employee> list= new ArrayList<>();
		emps.forEach(list :: add);
		return list;
	}

}
