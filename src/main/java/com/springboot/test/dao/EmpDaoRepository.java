package com.springboot.test.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.springboot.test.model.Employee;

/*@Repository
public interface EmpDaoRepository extends JpaRepository<Employee, Integer> {

}*/


@Repository
public interface EmpDaoRepository extends JpaRepository<Employee, Integer>{
	//@Query("FROM Employee")
	/*public List<Employee> findAByName(String name);*/
	//public List<Employee> findAllByEmployee();
    
	
}