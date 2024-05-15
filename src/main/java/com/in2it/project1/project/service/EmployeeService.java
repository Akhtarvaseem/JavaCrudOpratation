package com.in2it.project1.project.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.DateFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in2it.project1.project.Entity.Employee;
import com.in2it.project1.project.customException.IdInvalidException;
import com.in2it.project1.project.customException.InfoMissingException;
import com.in2it.project1.project.customException.UserNotFoundException;
import com.in2it.project1.project.dao.EmployeeDao;
import com.in2it.project1.project.dto.EmployeeDto;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;

	public Employee insertEmpl(EmployeeDto e) {

		Employee emp = new Employee();

		if (isValidUsername(e.getName()) && isValidAge(e.getAge()) && isValidSalary(e.getSalary())
				&& e.getJoiningDate()!=null) {

			emp.setName(e.getName());
			emp.setAge(e.getAge());
			emp.setSalary(e.getSalary());
			emp.setJoiningDate(e.getJoiningDate());
			return dao.insertEmpl(emp);
		} else {

			throw new InfoMissingException("Invalid info ! Please add valid user informaation.");

		}
	}

	
	// update the employee details
	public Employee updateEmployee(EmployeeDto e1) {
		Employee em=null;
		try {
		
			em = dao.getEmployee(e1.getId());
			if (e1 != null) {

				if (e1.getName() != null && isValidUsername(e1.getName())) {
					em.setName(e1.getName());

				} else if (e1.getAge() != 0 && isValidAge(e1.getAge())) {
					em.setAge(e1.getAge());

				} else if (e1.getSalary() != 0 && isValidSalary(e1.getSalary())) {

					em.setSalary(e1.getSalary());

				} else if (e1.getJoiningDate() != null) {
					em.setJoiningDate(e1.getJoiningDate());
				}

			}
		} catch (Exception e) {
			throw new UserNotFoundException("Sorry ! please try agin User not found.");
		}

		return em;
	}

	
	// deleting data from database
	public int deleteEmployee(int id) {
		try {
			Employee em= dao.getEmployee(id);
			if (em !=null) {
				return dao.deleteEmployee(id);
			}
		}catch (Exception e) {
			
			throw new IdInvalidException("Id not found. Please ! add correct id.");
		}
		
		return 0;
	}

	
	// find single entity by using id
	public Employee getEmployee(int id) {
		Employee em=null;
		try {
			em= dao.getEmployee(id);
		} catch (Exception e) {
			throw new UserNotFoundException("Sorry ! please try agin User not found.");
		}
		return em;
		

	}

	// find by name
	public List<Employee> getEmployeeByName(String name) {

		List<Employee> ls= dao.getEmployeeByName(name);
		if(!ls.isEmpty()) {
			return ls;
		}
		
		throw new UserNotFoundException("Sorry ! please try agin User not found.");
	}

	// find by salary

	public List<Employee> getEmployeeBysalary(double salary) {

		List<Employee> e = dao.getEmployeeBySalary(salary);
		if(!e.isEmpty()) {
			return e;
		}
		throw new UserNotFoundException("Sorry ! please try agin User not found.");
	}

	// get all entities from database

	public List<Employee> getAllInfo() {

		List<Employee> ls= dao.getAllInfo();
		if(!ls.isEmpty()) {
			return ls;
		}
		throw new UserNotFoundException("Sorry ! please try agin User not found.");
	}

	
	
	
	
	// Function to validate the name
	public static boolean isValidUsername(String name) {
//  
		// Regex to check valid name.
		String regex = "^[a-zA-Z]+(?:\\s+[a-zA-Z]+)*$";

		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		// If the name is empty
		// return false
		if (name == null) {
			return false;
		}

		// Pattern class contains matcher() method
		// to find matching between given name
		// and regular expression.
		Matcher m = p.matcher(name);

		// Return if the name
		// matched the ReGex
		return m.matches();
	}

	// Function to validate the name
	public static boolean isValidAge(int age) {

		// If the name is empty
		// then then throw exception

		if (age > 18) {
			System.out.println("valid ");
			return true;
		}

		throw new InfoMissingException("Invalid age. Please ! add valid information. Ex- min: 19");
	}

	public static boolean isValidSalary(Double salary) {

		// If the name is empty
		// return false
		if (salary > 0) {
			return true;
		}

		throw new InfoMissingException("Insufficient salary. Please ! add valid information.");

	}
	
	

}
