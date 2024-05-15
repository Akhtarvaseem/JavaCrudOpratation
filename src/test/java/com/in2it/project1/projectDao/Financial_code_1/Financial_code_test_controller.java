package com.in2it.project1.projectDao.Financial_code_1;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.project1.project.Entity.Financial_code1;
import com.in2it.project1.project.controller.Financial_code1_controller;
import com.in2it.project1.project.service.Financial_code1_service;



@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Financial_code1.class)
public class Financial_code_test_controller {

	
	@Mock
	Financial_code1_service service;
	
	@InjectMocks
	Financial_code1_controller controller;
	
	@Test
	public void save_Financial_survey(){
		
	
		File f= new File("C:/Users/Vaseem.akhtar/Downloads/annual-enterprise-survey-2021-financial-year-provisional-csv (1).csv");
		byte[] fb;
		try {
			
			fb = Files.readAllBytes(f.toPath());
			MultipartFile mf = new MockMultipartFile("f", f.getName(), "text/csv", fb);
			
			// CHECK FOR METHOD WHERE WE CAN INSERT OUR INPUTSTREEM
			when(service.hasCsvFormat(mf)).thenReturn(true);
			List<Financial_code1> ls=new ArrayList<>();
			assertEquals(service.csvToDb(mf.getInputStream()), ls);
			
			
			// CHECK CONTROLLER CLASS
			ResponseEntity<?> fff=new ResponseEntity<>(" csv file has been uploaded successfull",HttpStatus.OK);
			ResponseEntity<?> ff=controller.save_Financial_survey(mf);
			assertEquals(ff, fff);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
