package com.in2it.project1.project.controller;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.in2it.project1.project.service.Financial_survey_service;

@RestController
@RequestMapping("/Financial-survey")
public class Financial_survey_controller {

	@Autowired
	Financial_survey_service service;
	
	
	
	// GET CSV FILE FROM 
	@PostMapping("/save/csv")
	public ResponseEntity<?> save_Financial_survey(@RequestParam("file") MultipartFile file) {

     if (service.hasCsvFormat(file)) {
    	 
    	 try {
			service.csvToDb(file.getInputStream());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	 
    	 return ResponseEntity.status(HttpStatus.OK).body(" csv file has been uploaded successfull");
     }
     
     return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Please upload csv file");
     
	}
	

}
