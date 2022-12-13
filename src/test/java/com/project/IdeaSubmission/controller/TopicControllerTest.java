package com.project.IdeaSubmission.controller;



import org.junit.jupiter.api.AfterAll;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.IdeaSubmission.service.TopicService;


class TopicControllerTest {

	@Mock
	private TopicService topicService;
	
	@Autowired
	private TopicController topicController;
	
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}


}
