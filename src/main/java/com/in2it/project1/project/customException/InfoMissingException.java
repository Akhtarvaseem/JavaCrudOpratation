package com.in2it.project1.project.customException;

@SuppressWarnings("serial")
public class InfoMissingException extends RuntimeException{

	public InfoMissingException(String msg) {
		super(msg);
	}
}
