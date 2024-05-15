package com.in2it.project1.project.dto;

import java.util.List;
import java.util.Set;

import com.in2it.project1.project.Entity.Financial_code2;



public class Financial_code1_dto {

    private int t1_id;


	private String v_code;
	
 
	private List<Financial_code2 >  ls;
	
	

	public Financial_code1_dto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Financial_code1_dto(int t1_id, String v_code, List<Financial_code2> ls) {
		super();
		this.t1_id = t1_id;
		this.v_code = v_code;
		this.ls = ls;
	}

	public int getT1_id() {
		return t1_id;
	}

	public void setT1_id(int t1_id) {
		this.t1_id = t1_id;
	}

	public String getV_code() {
		return v_code;
	}

	public void setV_code(String v_code) {
		this.v_code = v_code;
	}

	public List<Financial_code2> getLs() {
		return ls;
	}

	public void setLs(List<Financial_code2> ls) {
		this.ls = ls;
	}

	@Override
	public String toString() {
		return "Financial_code1 [t1_id=" + t1_id + ", v_code=" + v_code + ", ls=" + ls + "]";
	}

}
