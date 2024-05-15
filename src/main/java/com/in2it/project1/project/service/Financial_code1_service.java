package com.in2it.project1.project.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.project1.project.Entity.Financial_code1;
import com.in2it.project1.project.Entity.Financial_code2;

import com.in2it.project1.project.dao.Financial_code1_dao;
import com.in2it.project1.project.dto.Financial_code2_dto;

@Service
public class Financial_code1_service {

	@Autowired
	Financial_code1_dao dao;

	public boolean hasCsvFormat(MultipartFile file) {
		String type = "text/csv";
		if (!type.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	
	// FOR GET DATA FROM CSV FILE AND FORMATING
	public List<Financial_code1> csvToDb(InputStream stream) {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

			CSVParser parser = new CSVParser(reader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

			List<CSVRecord> csvRecords = parser.getRecords();
			
			List<Financial_code2_dto> ls = new ArrayList<>();
		
			// set v_code 
			HashSet<String> st=new HashSet<>();
			
		
			Financial_code1 fs = new Financial_code1();
		
			for (CSVRecord rd1 : csvRecords) {

					Financial_code2_dto fss = new Financial_code2_dto();
					
					
                    // here set vaiable_code in financial_code1 entity					
					fs.setV_code(rd1.get("Variable_code"));
					
					// here setting details in financial_code2_dto 	
					fss.setYear(Integer.parseInt(rd1.get("Year")));
					fss.setI_aggregation(rd1.get("Industry_aggregation_NZSIOC"));
					fss.setI_code(rd1.get("Industry_code_NZSIOC"));
					fss.setI_name(rd1.get("Industry_name_NZSIOC"));
					fss.setUnit(rd1.get("Units"));
					fss.setV_code(rd1.get("Variable_code"));
					fss.setV_name(rd1.get("Variable_name"));
					fss.setV_category(rd1.get("Variable_category"));
				    fss.setValue("Value");
					fss.setInd_code(rd1.get("Industry_code_ANZSIC06"));
     
					
					ls.add(fss);
					st.add(fs.getV_code());	
					
			}
			
			// for storing all v_code
			List<Financial_code1> st1=new ArrayList<>();
			
			// for storing return object as list 
			List<Financial_code1> ffs = new ArrayList<>();

				List<Financial_code2> fcl2=new ArrayList<>();
				for( String vcode : st) {
					Financial_code1 fs1 = new Financial_code1();
					fs1.setV_code(vcode);
					st1.add(fs1);
				}
				
			ffs=dao.save_Financial_code1(st1);
			
			
			// this logic used for storing list data in database i.e. many object
				for(Financial_code2_dto dt:ls) {
					
						   Financial_code2 fc2=new Financial_code2();
						    
							fc2.setYear(dt.getYear());
							fc2.setI_aggregation(dt.getI_aggregation());
							fc2.setI_code(dt.getI_code());
							fc2.setI_name(dt.getI_name());
							fc2.setUnit(dt.getUnit());
							
							fc2.setV_name(dt.getV_name());
							fc2.setV_category(dt.getV_category());
							
							fc2.setValue(dt.getValue());
							fc2.setInd_code(dt.getInd_code());
							
							for( Financial_code1 fd:ffs) {
								if(((fd.getV_code()).equalsIgnoreCase(dt.getV_code()) )) {
									
									fc2.setFc2(fd);
								}
							}
							
							fcl2.add(fc2);
					}
				
				dao.save_Financial_code2(fcl2);

					return null;
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Arrays.asList();
	}
	
	
	


}
