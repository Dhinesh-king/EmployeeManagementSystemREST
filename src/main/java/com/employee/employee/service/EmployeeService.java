package com.employee.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employee.entity.Employee;
import com.employee.employee.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	public Employee saveEmployee(Employee employee) {
		
		Employee savedEmp = empRepo.save(employee);
		
		return savedEmp;
	}
	
	
	public List<Employee> getAllEmployees() {
		
		List<Employee> empList = empRepo.findAll();
	   
		return empList;
	}
	
	
	public Employee getEmployeeById(Integer id) {
		
		Optional<Employee> empOpt = empRepo.findById(id);
		
		if(empOpt.isEmpty()) {
			throw new RuntimeException("Employee is not found");
		}
		
		return empOpt.get();
		
	}
	
	public String deleteEmployeeById(Integer id) {
		
		empRepo.deleteById(id);
		
		return "Employee data deleted Successfully";
	}
	
	
}
