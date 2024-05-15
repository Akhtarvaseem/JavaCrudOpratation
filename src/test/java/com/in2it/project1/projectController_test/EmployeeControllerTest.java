
package com.in2it.project1.projectController_test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.in2it.project1.project.Entity.Employee;
import com.in2it.project1.project.controller.EmployeeController;
import com.in2it.project1.project.dao.EmployeeDao;
import com.in2it.project1.project.dto.EmployeeDto;
import com.in2it.project1.project.service.EmployeeService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EmployeeDto.class)
public class EmployeeControllerTest {

	@InjectMocks
	EmployeeController controller;
	
	@Mock
	EmployeeService service;
	
	
	
	Employee employee;
	EmployeeDto emDto;
	
	// for actual case 
	@BeforeEach
	void setUp() {

		
		System.out.println("welcome to setup");
		emDto=new EmployeeDto(2, "kasyap", 12, 344, LocalDate.now());
		employee=new Employee(emDto.getId(), emDto.getName(), emDto.getAge(), emDto.getSalary(),LocalDate.now());
	
	}
	
	
	// inserting data for testing 
	
	@Test
	public void  insertEmplTest( ){	
		
		when(service.insertEmpl(emDto)).thenReturn(employee);
		Employee ep=service.insertEmpl(emDto);	
	    assertNotNull(ep);
       ResponseEntity<String> st= controller.insertEmpl(emDto);
		
       System.out.println(ep);
		if(ep!=null && st!=null)
		{
			 System.out.println("success");
		}
		else {
			
			System.out.println("failed");
		}

	}
	
	
	// for update
	@Test
	public void updateEmpTest() {
		when(service.getEmployee(emDto.getId())).thenReturn(employee);
		when(service.updateEmployee(emDto)).thenReturn(employee);
        controller.updateEmpl(emDto);
        
		//ResponseEntity<?> fff=new ResponseEntity<>(" csv file has been uploaded successfull",HttpStatus.OK);
		//ResponseEntity<?> ff=controller.updateEmpl(emDto);
		//assertEquals(ff, fff);
       
       
       
	}
	
	
	@Test
	public void deleteEmpTest() {
		when(service.getEmployee(emDto.getId())).thenReturn(employee);

      ResponseEntity<String> st= controller.deleteEmpl(emDto.getId());
       assertNotNull(st);
   		System.out.println("success");
	}
	
	
	
	// get all 
	@Test
	public void getAllEmpTest() {
	    when(service.getAllInfo()).thenReturn(List.of(employee));
	    List<Employee> ls=controller.getEmpl();
	    assertEquals(1, ls.size());
	    System.out.println("success");
	}
	
	
	@Test
	public void getById() {
		when(service.getEmployee(emDto.getId())).thenReturn(employee);
		Employee em=controller.getEmpl(emDto.getId());
		assertNotNull(em);
		System.out.println("success");
	}
	
}
