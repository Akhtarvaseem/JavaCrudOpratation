package com.in2it.project1.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in2it.project1.project.Entity.Employee;




public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	  public List<Employee> findByName(String name);
	  public List<Employee> findBySalary(double salary);

}
