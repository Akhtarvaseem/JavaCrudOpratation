package com.in2it.project1.project.customException;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String msg) {
		super(msg);
	}
	
}
