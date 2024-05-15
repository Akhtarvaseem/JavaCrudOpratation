package com.in2it.project1.project.dao;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in2it.project1.project.Entity.Financial_code1;
import com.in2it.project1.project.Entity.Financial_code2;
import com.in2it.project1.project.daoInterfce.DaoInterface_financial_code1;
import com.in2it.project1.project.repo.Financial_code2_Repo;
import com.in2it.project1.project.repo.Finanicial_code1_Repo;

@Repository
public class Financial_code1_dao implements DaoInterface_financial_code1{
	
	@Autowired 
	Finanicial_code1_Repo repo1;
	
	@Autowired
	Financial_code2_Repo repo2;
	
	

	
//	FIRST SAVE DATA IN OUR DATABASE AND RETURN LIST OF OBEJECT SAVE ONT TO MANEY
	@Override
	  public List<Financial_code1> save_Financial_code1(List<Financial_code1> st1) {
		  
	                 return repo1.saveAll(st1);
	   
	  }
	
	  // SAVE DATA MANEY TO ONE AS A LIST 
	  @Override
	  public List<Financial_code2> save_Financial_code2( List<Financial_code2> fs2) {
		
	      return repo2.saveAll(fs2);
		  
	  }
}
