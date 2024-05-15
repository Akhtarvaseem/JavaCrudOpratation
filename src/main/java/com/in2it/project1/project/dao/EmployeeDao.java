package com.in2it.project1.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in2it.project1.project.Entity.Employee;
import com.in2it.project1.project.customException.InfoMissingException;
import com.in2it.project1.project.daoInterfce.DaoInterfaceMethod;
import com.in2it.project1.project.dto.EmployeeDto;
import com.in2it.project1.project.repo.EmployeeRepo;

@Service
public class EmployeeDao implements DaoInterfaceMethod{

	@Autowired
	EmployeeRepo repo;
	
	// inserting data in database
	@Override
	public Employee  insertEmpl(Employee e1){
		
	    if(e1!=null)
	    {
	    	
	    	Employee e=repo.save(e1);
	    	return e;
	    }
	    
		return null;
}
	
	// update info in our database
	
     @Override
	public Employee updateEmployee( Employee e1) {
    	
	    return	repo.save(e1);
	}
	
	// deleting data from database
	@Override
	public int deleteEmployee(int id) {
	
			repo.deleteById(id);
		
			return 1;	
	}
	
	// find single entity by using id
	@Override
	public Employee getEmployee(int id) {
		
		Employee e=repo.findById(id).get();
	return	e;
}
	
	// find  entity by using name
	@Override
	public List<Employee> getEmployeeByName(String name) {
		
		List<Employee> e=repo.findByName(name);	
	return	e;
}
	
	// find  entity by using name
	@Override
	public List<Employee> getEmployeeBySalary(double salary) {
		
		List<Employee> e=repo.findBySalary(salary);	
		return	e;
	}
	
	// get all entities from database
	
	@Override
	public List<Employee> getAllInfo(){

		return repo.findAll();
	}
	
	
}
