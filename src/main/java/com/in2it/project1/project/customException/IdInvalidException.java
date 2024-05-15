package com.in2it.project1.project.customException;

@SuppressWarnings("serial")
public class IdInvalidException extends RuntimeException{
	
	public IdInvalidException(String msg) {
		
		super(msg);
	}

}
