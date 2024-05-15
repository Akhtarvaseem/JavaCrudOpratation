package com.in2it.project1.project.dto;

public class Financial_survey_dto {
	private int id;
	private int year;

	private String i_aggregation;

	
	private String i_code;
	
	private String i_name;

	private String unit;

	
	private String v_code;


	private String v_name;
	
	private String v_category;

	private String value;

	
	private String ind_code;


	public Financial_survey_dto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Financial_survey_dto(int id, int year, String i_aggregation, String i_code, String i_name, String unit,
			String v_code, String v_name, String v_category, String value, String ind_code) {
		super();
		this.id = id;
		this.year = year;
		this.i_aggregation = i_aggregation;
		this.i_code = i_code;
		this.i_name = i_name;
		this.unit = unit;
		this.v_code = v_code;
		this.v_name = v_name;
		this.v_category = v_category;
		this.value = value;
		this.ind_code = ind_code;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getI_aggregation() {
		return i_aggregation;
	}


	public void setI_aggregation(String i_aggregation) {
		this.i_aggregation = i_aggregation;
	}


	public String getI_code() {
		return i_code;
	}


	public void setI_code(String i_code) {
		this.i_code = i_code;
	}


	public String getI_name() {
		return i_name;
	}


	public void setI_name(String i_name) {
		this.i_name = i_name;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public String getV_code() {
		return v_code;
	}


	public void setV_code(String v_code) {
		this.v_code = v_code;
	}


	public String getV_name() {
		return v_name;
	}


	public void setV_name(String v_name) {
		this.v_name = v_name;
	}


	public String getV_category() {
		return v_category;
	}


	public void setV_category(String v_category) {
		this.v_category = v_category;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getInd_code() {
		return ind_code;
	}


	public void setInd_code(String ind_code) {
		this.ind_code = ind_code;
	}


	@Override
	public String toString() {
		return "Financial_survey_dto [id=" + id + ", year=" + year + ", i_aggregation=" + i_aggregation + ", i_code="
				+ i_code + ", i_name=" + i_name + ", unit=" + unit + ", v_code=" + v_code + ", v_name=" + v_name
				+ ", v_category=" + v_category + ", value=" + value + ", ind_code=" + ind_code + "]";
	}
	
	

}
