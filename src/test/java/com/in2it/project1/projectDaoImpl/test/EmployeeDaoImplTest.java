package com.in2it.project1.projectDaoImpl.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.in2it.project1.project.Entity.Employee;
import com.in2it.project1.project.dao.EmployeeDao;
import com.in2it.project1.project.dto.EmployeeDto;
import com.in2it.project1.project.repo.EmployeeRepo;
import com.in2it.project1.project.service.EmployeeService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EmployeeDto.class)
public class EmployeeDaoImplTest {
	
	
	
	
//	@InjectMocks
//	EmployeeService service;
	
	@InjectMocks
	EmployeeDao dao;
	
	@Mock
	EmployeeRepo employeeRepo;
	
	Employee employee;
	EmployeeDto dto;
	
	// for actual case 
	
	@BeforeEach
	void setUp() {

		
		System.out.println("welcome to setup");
		
		dto=new EmployeeDto(2, "kasyap", 12, 344, LocalDate.now());
		employee=new Employee(dto.getId(), dto.getName(), dto.getAge(), dto.getSalary(),LocalDate.now());
		
	
	}
	

	
	// its for inserting data 
	@Test
	public void test_save_employee(){

		   when(employeeRepo.save(employee)).thenReturn(employee);
		
		   assertEquals("moh", "moh");
           Employee employee2= dao.insertEmpl(employee);
             
           System.out.println(employee2);
            assertNotNull(employee2);
            assertEquals(employee2.getId(), dto.getId());
            assertEquals(employee2.getName(), dto.getName());
            assertEquals(employee2.getAge(), dto.getAge());
            assertEquals(employee2.getSalary(), dto.getSalary());
            assertEquals(employee2.getJoiningDate(), dto.getJoiningDate());
            
            System.out.println("success");
		
		}
	
	
	
	// for updating 
	@Test
	public void updateEmployeeTest() {
		
		
		 when(employeeRepo.findById(2)).thenReturn(Optional.of(employee));
		 when(employeeRepo.save(employee)).thenReturn(employee);
		 
		 Employee employee2= dao.updateEmployee(employee);
         
          System.out.println(employee2);
    
          assertNotNull(employee2);
          assertEquals(employee2.getId(), dto.getId());
          assertEquals(employee2.getName(), dto.getName());
          assertEquals(employee2.getAge(), dto.getAge());
          assertEquals(employee2.getSalary(), dto.getSalary());
          assertEquals(employee2.getJoiningDate(), dto.getJoiningDate());
          
          System.out.println("success");
		 
	}
	
	// deleting 
	@Test
	public void deleteEmployeeTest() {
		
		 when(employeeRepo.findById(2)).thenReturn(Optional.of(employee));
		
	    dao.deleteEmployee(employee.getId());
//	    assertFalse(employee==null);
	    
	    assertNotNull(employee);
	    verify(employeeRepo).deleteById(2);
	    System.out.println("success");
	    
	}
	
	
	
	// find all method
	@Test
	public void getAllEmpTest() {
	    when(employeeRepo.findAll()).thenReturn(List.of(employee));
	    List<Employee> ls=dao.getAllInfo();
	    assertEquals(1, ls.size());
	    System.out.println(ls.size());
	}
	
	
	
	// find by id
	@Test
	public void getByIdTest() {
		when(employeeRepo.findById(2)).thenReturn(Optional.of(employee));
		
	Optional<Employee> em=	employeeRepo.findById(2);
	assertNotNull(em);	
	}
	
	// find by name
		@Test
      public void getByNameTest() {
			when(employeeRepo.findByName(employee.getName())).thenReturn(List.of(employee));
			
			List<Employee> ls=dao.getEmployeeByName(employee.getName());
			assertNotNull(ls);
			
			System.out.println("Success");
      }
}
