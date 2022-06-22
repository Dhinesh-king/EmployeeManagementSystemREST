package com.employee.employee.dto;

import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

public class EmployeeDto {

	@NonNull
	private Integer id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String email ;
	
	private Long salary;
	
	private String department;
	

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public EmployeeDto() {
		super();
	}

	public EmployeeDto(Integer id, String name, String email, Long salary, String department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.department = department;
	}
	
	
}
