package com.employee.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.entity.Employee;
import com.employee.employee.service.EmployeeService;


@RestController
public class EmployeeController {


	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/details")
	public ResponseEntity<List<Employee>> getEmployees() {
		
		List<Employee> empList = empService.getAllEmployees();
		
		return new ResponseEntity<>(empList , HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmp(@RequestBody Employee employee) {
		
		Employee savedEmployee = empService.saveEmployee(employee);
		
		return new ResponseEntity<>(savedEmployee , HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable("id") Integer id, Model model) {
		
		String message = empService.deleteEmployeeById(id);
		
		return new ResponseEntity<>(message , HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee employee) {
		
		Employee saveEmployee = empService.saveEmployee(employee);
		
		return new ResponseEntity<>(saveEmployee , HttpStatus.ACCEPTED);
		
	}
	
}
