package com.employee.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//	@Query("select * from T_EMPLOYEE where salary >= ?1")
//	public List<Employee> getEmployeeBySalary(Long salary);
}
