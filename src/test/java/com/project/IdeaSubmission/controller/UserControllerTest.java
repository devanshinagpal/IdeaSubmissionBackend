package com.project.IdeaSubmission.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.project.IdeaSubmission.AbstractTest;
import com.project.IdeaSubmission.dto.User;
import com.project.IdeaSubmission.service.UserService;

public class UserControllerTest extends AbstractTest {

	@Autowired
	UserController userController;
	
	@MockBean
	UserService userService;
	
	 @Test
	   public void getUsers() throws Exception {
	      String uri = "/getusers";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      UserController[] users = super.mapFromJson(content, UserController[].class);
	      assertTrue(users.length > 0);
	   }
	 @Test
	   public void getUsersList() throws Exception {
	      String uri = "/getusers";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      User[] users = super.mapFromJson(content, User[].class);
	      assertTrue(users.length > 0);
	   }
	   
	   @Test
	   public void createUser() throws Exception {
	      String uri = "/adduser";
	      User user = new User();
	      user.setFname("Minnie");
	      user.setLname("Me");
	      user.setEmail("minnieme@gmail.com");
	      user.setPassword("No");
	      user.setRole("admin");
	      user.setUsername("minnie");
	      
//	      Topic topic = new Topic();
//	      topic.setName("Topic For Test");
//	      
//	      user.setTopic((List<Topic>) topic);
	      String inputJson = super.mapToJson(user);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(201, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "User is created");
	   }
	   
	   @Test
	   public void deleteProduct() throws Exception {
	      String uri = "/deleteuser/6";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "User is deleted successsfully");
	   }
}
