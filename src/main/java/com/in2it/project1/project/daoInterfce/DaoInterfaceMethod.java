package com.in2it.project1.project.daoInterfce;

import java.util.List;
import java.util.Optional;

import com.in2it.project1.project.Entity.Employee;
import com.in2it.project1.project.dto.EmployeeDto;

public interface DaoInterfaceMethod {

	public Employee  insertEmpl(Employee e);
	

	public Employee updateEmployee( Employee e1) ;
		
	
	
	public int deleteEmployee(int id) throws Exception; 
	public Employee getEmployee(int id);
	
	// find  entity by using name
	public List<Employee> getEmployeeByName(String name);
	
	// find  entity by using name
	public List<Employee> getEmployeeBySalary(double salary) ;

	public List<Employee> getAllInfo();
	
	
	
}
