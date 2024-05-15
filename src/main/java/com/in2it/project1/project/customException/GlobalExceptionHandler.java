package com.in2it.project1.project.customException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(InfoMissingException.class)
//	public  Map<String, String> InfoMissingExceptionhandler(InfoMissingException ex){
//
//		Map<String, String> ermap=new HashMap<>();
//		String str=ex.getMessage();
//		ermap.put("errorMessage",str );
//		return ermap;
//
//	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(InfoMissingException.class)
	public  ResponseEntity<?> InfoMissingExceptionhandler(InfoMissingException ex ,WebRequest request){

   ExceptionStatus status=new ExceptionStatus(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getDescription(false));		
		
		return new ResponseEntity(status,HttpStatus.NOT_FOUND);

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(IdInvalidException.class)
	public  ResponseEntity<?>  idInvalidExceptionhandler(IdInvalidException ex ,WebRequest request){
		
//		Map<String, String> ermap=new HashMap<>();
//		String str=ex.getMessage();
//		ermap.put("errorMessage",str );
//		return ermap;
		
		 ExceptionStatus status=new ExceptionStatus(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getDescription(false));		
			
			return new ResponseEntity(status,HttpStatus.NOT_FOUND);
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(UserNotFoundException.class)
	public  ResponseEntity<?> UserNotFoundExceptionhandler(UserNotFoundException ex, WebRequest request){
		
//		Map<String, String> ermap=new HashMap<>();
//		String str=ex.getMessage();
//		ermap.put("errorMessage",str );
//		return ermap;
		 ExceptionStatus status=new ExceptionStatus(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getDescription(false));		
			
			return new ResponseEntity(status,HttpStatus.NOT_FOUND);
		
	}
}
