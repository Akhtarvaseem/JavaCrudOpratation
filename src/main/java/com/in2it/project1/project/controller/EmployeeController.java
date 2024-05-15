package com.in2it.project1.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.in2it.project1.project.Entity.Employee;
import com.in2it.project1.project.customException.IdInvalidException;
import com.in2it.project1.project.customException.InfoMissingException;
import com.in2it.project1.project.dto.EmployeeDto;
import com.in2it.project1.project.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	// save employee 
	@PostMapping("/emp-save")
	public ResponseEntity<String> insertEmpl(@RequestBody EmployeeDto e1) {
		Employee ep = service.insertEmpl(e1);
		if (ep != null) {
			return ResponseEntity.ok("Your data Inserted successfully." + ep);
		}
		throw new InfoMissingException("Sorry! Please add valid information.");
	}
	
	

	// update Employee information
	@PutMapping("/emp-update")
	public ResponseEntity<String> updateEmpl(@RequestBody EmployeeDto e1) {

		Employee ep= service.updateEmployee(e1);
		if (ep != null) {
			return ResponseEntity.ok("Your data updated successfully." + ep);
		}
		throw new InfoMissingException("Sorry! Please add valid information.");
	}

	
	
	@GetMapping("/emp-get/{id}")
	public Employee getEmpl(@PathVariable int id) {
		return service.getEmployee(id);
	}

	
	// deleting data using id 
	@DeleteMapping("/emp-delete/{id}")
	public ResponseEntity<String> deleteEmpl(@PathVariable int id) {
		int i = service.deleteEmployee(id);
		if (i != 0) {
			return ResponseEntity.ok("Your data delete successfully.");
		} else {
			throw new IdInvalidException("Id not found. Please ! add correct id.");
		}
	}

	// getting data by name
	@GetMapping("/emp-getByName")
	@ResponseBody
	public List<Employee> getEmployeeByName(@RequestParam(required = false) String name) {

		return service.getEmployeeByName(name);
	}

	// getting data by name
	@GetMapping("/emp-getBySalary")
	@ResponseBody
	public List<Employee> getEmployeeBySalary(@RequestParam(required = false) double salary) {
	
		return service.getEmployeeBysalary(salary);
	}


// get all employee details
	@GetMapping("/emp-getAll")
	public List<Employee> getEmpl() {
		return service.getAllInfo();

	}

}
