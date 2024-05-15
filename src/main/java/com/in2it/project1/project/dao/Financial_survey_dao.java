package com.in2it.project1.project.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.in2it.project1.project.Entity.Financial_survey;
import com.in2it.project1.project.daoInterfce.DaoInterface_Financial_survey;
import com.in2it.project1.project.repo.Financial_survey_Repo;

@Repository
public class Financial_survey_dao implements DaoInterface_Financial_survey{

	@Autowired
	Financial_survey_Repo repo;

	
	@Override
	public List<Financial_survey> save_Financial_survey(List<Financial_survey> ls) {
		
		     if(!ls.isEmpty()) {
		    	 
		    	 repo.saveAll(ls);
		     }
			return Arrays.asList();
		

	}

	

}
