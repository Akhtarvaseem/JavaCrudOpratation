package com.in2it.project1.project.dto;



import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmployeeDto {


	private int id;
	private String name;
	private int age;
	private double salary;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate joiningDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	  
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDto(int id, String name, int age, double salary, LocalDate joiningDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.joiningDate = joiningDate;
	}

	

	
	
	
	
	
}
