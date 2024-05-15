package com.in2it.project1.project.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.project1.project.Entity.Financial_survey;
import com.in2it.project1.project.dao.Financial_survey_dao;


@Service
public class Financial_survey_service {

	@Autowired
	Financial_survey_dao dao;
	
	
	

	public boolean hasCsvFormat(MultipartFile file) {
		String type = "text/csv";
		if (!type.equals(file.getContentType())) {
			return false;
		}

		return true;
	}


	//FOR GET DATA FROM CSV FILE AND FORMATING 
	public List<Financial_survey> csvToDb(InputStream stream) {
		
		try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
				
				CSVParser parser = new CSVParser(reader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			
			List<Financial_survey> ls = new ArrayList<>();
			List<CSVRecord> csvRecords = parser.getRecords();

			for (CSVRecord rd : csvRecords) {
                  
                  
				if(rd.get(0) != null &&rd.get(1) != null &&rd.get(2) != null
						&&rd.get(3) != null &&rd.get(4) != null && rd.get(5) != null
						&&rd.get(6) != null && rd.get(7) != null && rd.get(8) != null
						&&rd.get(9) != null) {
					
				
				
				Financial_survey fs = new Financial_survey();
				
				fs.setYear(Integer.parseInt(rd.get("Year")));
				fs.setI_aggregation(rd.get("Industry_aggregation_NZSIOC"));
				fs.setI_code(rd.get("Industry_code_NZSIOC"));
				fs.setI_name(rd.get("Industry_name_NZSIOC"));
				fs.setUnit(rd.get("Units"));
				fs.setV_code(rd.get("Variable_code"));
				fs.setV_name(rd.get("Variable_name"));
				fs.setV_category(rd.get("Variable_category"));
			    fs.setValue("Value");
				fs.setInd_code(rd.get("Industry_code_ANZSIC06"));

				ls.add(fs);
				
				}
				else {
					Arrays.asList();
				}
			}
			
         
			return dao.save_Financial_survey(ls);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Arrays.asList();
	}
	
	
}
