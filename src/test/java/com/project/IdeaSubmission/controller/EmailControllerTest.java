package com.project.IdeaSubmission.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.project.IdeaSubmission.AbstractTest;

class EmailControllerTest {

	@Autowired
	   WebApplicationContext webApplicationContext;
	  
	
	  protected MockMvc mvc;
	  
	@Before
	protected void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   }
	
	@Test
	void testSendMail() throws Exception {
		mvc.perform(get("/sendMail")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.recipient").value("devanshi@gmail.com"))
		.andExpect(jsonPath("$.msgBody").value("Hi This is working fine"))
		.andExpect(jsonPath("$.subject").value("Test Case Check"));

	}

}
