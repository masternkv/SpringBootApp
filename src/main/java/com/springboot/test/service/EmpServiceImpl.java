package com.springboot.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.test.dao.DeptDaoRepository;
import com.springboot.test.dao.EmpDaoRepository;
import com.springboot.test.model.Department;
import com.springboot.test.model.Employee;
@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmpDaoRepository empDaoRepo;
	@Autowired
	DeptDaoRepository deptDaoRepo;
	
	@Override
	public List<?> getEmployees() {
		// TODO Auto-generated method stub
		//return empDaoRepo.findAll();
		//String s="Niru";
	/*	return empDaoRepo.findAllByEmployee();*/
		/*List<Department> empList=new ArrayList<Department>();
		for(Department dept:deptDaoRepo.findAll())
		{
			System.out.println("Checking Value:"+dept.toString());
			empList.add(dept);
		}*/
		return deptDaoRepo.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(int empid) {
		// TODO Auto-generated method stub
		return empDaoRepo.findById(empid);
	}

	@Override
	public Employee addNewEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empDaoRepo.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empDaoRepo.save(emp);
	}

	@Override
	public void deleteEmployee(int empid) {
		// TODO Auto-generated method stub
		empDaoRepo.deleteById(empid);
		
	}

	@Override
	public void deleteAllEmployee () {
		// TODO Auto-generated method stub
		empDaoRepo.deleteAll();
		
	}

}
