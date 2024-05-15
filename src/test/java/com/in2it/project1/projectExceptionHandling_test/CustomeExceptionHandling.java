package com.in2it.project1.projectExceptionHandling_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.WebRequest;

import com.in2it.project1.project.Entity.Employee;
import com.in2it.project1.project.customException.ExceptionStatus;
import com.in2it.project1.project.customException.GlobalExceptionHandler;
import com.in2it.project1.project.customException.IdInvalidException;
import com.in2it.project1.project.customException.InfoMissingException;



@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Employee.class)
public class CustomeExceptionHandling {
	
	@InjectMocks
   GlobalExceptionHandler glEx;	
	
	@Mock
	WebRequest request;
	
	
	@Test
	public void handleIdInvalidException() {
		
		IdInvalidException idEx=new IdInvalidException("Id not found. Please ! add correct id.");

		when(request.getDescription(false)).thenReturn("uri=/employee/emp-get/11");
		
         ResponseEntity<?> re=glEx.idInvalidExceptionhandler(idEx, request);
         
         ExceptionStatus exStatus=new ExceptionStatus(LocalDateTime.now(),  HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), idEx.getMessage(), request.getDescription(false));
     
         assertEquals(HttpStatus.NOT_FOUND, re.getStatusCode());
         
         assertEquals(404, exStatus.getStatus());
         assertEquals(idEx.getMessage(), exStatus.getMessage());
       
         
	}
	

	// HANDLING INFOMISSING EXCEPTION
	@Test
	public void handleInfoMissingException() {
		
		InfoMissingException idEx=new InfoMissingException("Invalid info ! Please add valid user informaation.");

		when(request.getDescription(false)).thenReturn("uri=/employee/emp-save");
		
         ResponseEntity<?> re=glEx.InfoMissingExceptionhandler(idEx, request);
         
         ExceptionStatus exStatus=new ExceptionStatus(LocalDateTime.now(),  HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), idEx.getMessage(), request.getDescription(false));
     
         assertEquals(HttpStatus.NOT_FOUND, re.getStatusCode());
         
         assertEquals(404, exStatus.getStatus());
         assertEquals(idEx.getMessage(), exStatus.getMessage());
       
         
	}
	
	
//	 HNDLING USER NOT FOUND 
	
	@Test
	public void handleUserNotFoundException() {
		
		InfoMissingException idEx=new InfoMissingException("Sorry ! please try agin User not found.");

		when(request.getDescription(false)).thenReturn("uri=/employee/emp-get/11");
		
         ResponseEntity<?> re=glEx.InfoMissingExceptionhandler(idEx, request);
         
         ExceptionStatus exStatus=new ExceptionStatus(LocalDateTime.now(),  HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), idEx.getMessage(), request.getDescription(false));
     
         assertEquals(HttpStatus.NOT_FOUND, re.getStatusCode());
         
         assertEquals(404, exStatus.getStatus());
         assertEquals(idEx.getMessage(), exStatus.getMessage());
       
         
	}
}
