package com.employee.employee.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employee.dto.EmployeeDto;
import com.employee.employee.entity.Employee;
import com.employee.employee.exception.EmployeeMgmtException;
import com.employee.employee.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private Validator validator;
	
	public Employee saveEmployee(EmployeeDto employeeDto) {
		
		validator.validate(employeeDto);
		
		Employee employee = new Employee();
		
		employee.setId(employeeDto.getId());
		employee.setName(employeeDto.getName());
		employee.setDepartment(employeeDto.getDepartment());
		employee.setEmail(employeeDto.getEmail());
		employee.setSalary(employeeDto.getSalary());
		
		Employee savedEmp = empRepo.save(employee);
		
		return savedEmp;
	}
	
	
	public List<Employee> getAllEmployees() throws EmployeeMgmtException {
		
		List<Employee> empList = empRepo.findAll();
		
	    if(empList.isEmpty()) {
	    	throw new EmployeeMgmtException("The Employee List is Empty", "4001");
	    }
		return empList;
	}
	
	
	public Employee getEmployeeById(Integer id) throws EmployeeMgmtException {
		
		Optional<Employee> empOpt = empRepo.findById(id);
		
		if(empOpt.isEmpty()) {
			
			throw new EmployeeMgmtException("The given Employee ID is not present in the database", "4001");
			
		}
		
		return empOpt.get();
		
	}
	
	public String deleteEmployeeById(Integer id) throws EmployeeMgmtException {
		
		if(empRepo.existsById(id)) {
			
			empRepo.deleteById(id);
			
		}
		else {
			
			throw new EmployeeMgmtException("The given Employee ID is not present in the database", "4001");
		}
		
		return "Employee data deleted Successfully";
	}
	
	
}
