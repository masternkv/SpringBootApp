package com.springboot.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.test.model.Department;

@Repository
public interface  DeptDaoRepository  extends JpaRepository<Department,Integer>{
	

}
