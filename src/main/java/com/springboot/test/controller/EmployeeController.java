package com.springboot.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.test.model.Department;
import com.springboot.test.model.Employee;
import com.springboot.test.service.EmpService;
import com.springboot.test.utill.CommanUtill;

@RestController
public class EmployeeController {

	@Autowired
	EmpService empService;
	
	@RequestMapping(value="/employee/all",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<?> getEmployee()
	{
		System.out.println("Get All employee details......");
		
		//List<Department> checkList=empService.getEmployees();
		return empService.getEmployees();
	}
	
	@RequestMapping(value="/employee/byid",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee  getEmployeeById(@RequestBody String Inempid) throws Exception
	{ 
		Integer empid=CommanUtill.requestFilter(Inempid);
		System.out.println("Getting Employee details by ID:");
	    Optional<Employee> emp=empService.getEmployeeById(empid);
	    if(!emp.isPresent())
	    {
	    	throw new Exception("Could not found employee with id:"+empid);
	    }
		return emp.get();
	}
	@RequestMapping(value="/employee/add",method=RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee emp)
	{
		System.out.println("Adding Employee details");
		return empService.addNewEmployee(emp);
		
	}
	
	@RequestMapping(value="/employee/update",method=RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee emp) throws Exception
	{
		System.out.println("Updating Employee details");
		Optional<Employee> findEmp=empService.getEmployeeById(emp.getId());
	    if(!findEmp.isPresent())
	    {
	    	throw new Exception("Employee Details not found:"+emp.getId());
	    }
		return empService.updateEmployee(emp);
	}
	
	@RequestMapping(value="/employee/delete/id",method=RequestMethod.DELETE)
	public void deleteEmployee(@RequestBody String Inempid) throws Exception
	{
        System.out.println("Deleting the Employee by ID");
        Integer empid=CommanUtill.requestFilter(Inempid);
		System.out.println("Getting Employee details by ID:");
	    Optional<Employee> emp=empService.getEmployeeById(empid);
	    if(!emp.isPresent())
	    {
	    	throw new Exception("Could not found employee with id:"+empid);
	    }
	    empService.deleteEmployee(empid);
      
	}
	
	
}
