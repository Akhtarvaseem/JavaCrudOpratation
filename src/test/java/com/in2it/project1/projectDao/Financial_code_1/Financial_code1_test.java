package com.in2it.project1.projectDao.Financial_code_1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.in2it.project1.project.Entity.Financial_code1;
import com.in2it.project1.project.Entity.Financial_code2;
import com.in2it.project1.project.dao.Financial_code1_dao;
import com.in2it.project1.project.dto.Financial_code1_dto;
import com.in2it.project1.project.dto.Financial_code2_dto;
import com.in2it.project1.project.repo.Financial_code2_Repo;
import com.in2it.project1.project.repo.Finanicial_code1_Repo;


@SpringBootTest

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Financial_code1.class)
public class Financial_code1_test {
	
	
  @Mock
  Finanicial_code1_Repo repo1;
  
  @Mock
  Financial_code2_Repo repo2;
  
  @InjectMocks
  Financial_code1_dao dao;
  
  
  Financial_code1 fc1;
  Financial_code1_dto fcd1;
  
  @InjectMocks
  Financial_code2 fc2;
  
  Financial_code2 fcd2;
  
  
  List<Financial_code2> ls=new ArrayList<>();
  @BeforeEach
  public void setUp() {
     
	  fc2.setT2_id(1);
	  fc2.setYear(2021);
	  fc2.setI_aggregation("Level 1");
	  fc2.setI_code("99999");
	  fc2.setI_name("All industries");
	  fc2.setUnit("Dollars (millions)");
	  fc2.setV_name("Total income");
	  fc2.setV_category("Financial performance");
	  fc2.setValue("757504");
	  fc2.setInd_code("ANZSIC06 divisions K6330, L67 ");
	  
	  Financial_code2 fc2_1 = new Financial_code2(2, 2021, "Level 1", "99999", "All industries", "Dollars (millions)", "Total income", "Financial performance", "757504", "ANZSIC06  excluding classes K6330", fc1);
	  ls.add(fc2);
	  ls.add(fc2_1);
	  
	  fcd1=new Financial_code1_dto(1, "H01", ls);
	  
	  
	   fc1=new Financial_code1();
	   fc1.setT1_id(fcd1.getT1_id());
	   fc1.setV_code(fcd1.getV_code());
	   fc1.setLs(fcd1.getLs());
	   
	   
//	   	HERE WE ARE SETTING OBJECT OF FINANCIAL_CODE1 INSIDE FINANCIAL_CODE2
	   fc2.setFc2(fc1);
  }
  
  
  @Test
  public void save_Financial_test1() { 
	  System.out.println("Inside Financial code test");
	  
	  when(repo1.save(fc1)).thenReturn(fc1);
      
	  
	  assertEquals(fc1.getT1_id(), fcd1.getT1_id());
	  assertEquals(fc1.getV_code(), fcd1.getV_code());
	  assertEquals(fc1.getLs(), fcd1.getLs());

	  System.out.println("Successfull ");
  }
  
  
  @Test
  public void save_Financial_test2() {
	  System.out.println("Inside Financial2 Class");
	  List<Financial_code2> ls2=new ArrayList<>();
	  
	  when(repo2.saveAll(ls)).thenReturn(ls2);
	  
	  assertEquals( dao.save_Financial_code2(ls), ls2);
	  
	 System.out.println("success");
  }

}
