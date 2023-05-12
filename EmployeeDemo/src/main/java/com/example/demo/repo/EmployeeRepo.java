package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;


@Repository
public interface EmployeeRepo extends CrudRepository<Employee, String>{
	public Optional<Employee> findByName(String name);
	public List<Employee> findListByName(String name);
}
