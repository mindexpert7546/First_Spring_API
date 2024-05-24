package com.mdp.iic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdp.iic.exception.ResourceNotFoundException;
import com.mdp.iic.model.Employee;
import com.mdp.iic.repository.EmployeeRepo;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@GetMapping("/allEmployees")
	public List<Employee> 	getAllEmployees(){
		return employeeRepo.findAll();
	}
	
	//create employee rest api 
	@PostMapping("/addEmployees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepo.save(employee);
	}
	
	//get the employee by id rest api
	@GetMapping("/employee/{id}")
	public  ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee =  employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Exist" + id));
		return ResponseEntity.ok(employee);
	}
	
	//Update the data 
	@PutMapping("/employee/{id}")
	public  ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
		Employee employee =  employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Exist" + id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());
		
		Employee updateEmployee = employeeRepo.save(employee);
		return ResponseEntity.ok(updateEmployee);
		
		
	}
	
	
	
}
