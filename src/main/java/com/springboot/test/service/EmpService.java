package com.springboot.test.service;

import java.util.List;
import java.util.Optional;

import com.springboot.test.model.Department;
import com.springboot.test.model.Employee;

public interface EmpService {
	
	public List<?> getEmployees();
	public Optional<Employee> getEmployeeById(int empid);
	public Employee addNewEmployee(Employee emp);
	public Employee updateEmployee(Employee emp);
	public void deleteEmployee(int empid);
	public void deleteAllEmployee();

}
