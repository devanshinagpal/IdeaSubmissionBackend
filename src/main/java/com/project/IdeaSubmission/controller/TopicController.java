package com.project.IdeaSubmission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.IdeaSubmission.dto.Topic;
import com.project.IdeaSubmission.dto.User;
import com.project.IdeaSubmission.service.TopicService;
import com.project.IdeaSubmission.service.UserService;


@RestController
@CrossOrigin
public class TopicController {

	@Autowired
	TopicService service;
	@Autowired
	UserService userService;
	
	@PostMapping("/addtopic/{user_id}")
	public Topic addTopic(@RequestBody Topic topic,@PathVariable int user_id) {
		User user = userService.getUserById(user_id);
		topic.setUser(user);
		return service.addTopic(topic);
	}

	@DeleteMapping("/deletetopic/{id}")
	public String deleteTopic(@PathVariable("id") int id) {
		service.deleteTopic(id);
		return "Deleted Topic with Id : "+id;
	}

	@PutMapping("/updatetopic")
	public Topic updateTopic(@RequestBody Topic topic) {
		return service.updateTopic(topic);
	}

	@GetMapping("/getbyuser/{user_id}")
	public List<Topic> getAllTopicByUserId(@PathVariable int user_id){
		User user = userService.getUserById(user_id);
		return user.getTopic();
		 
	}
	
	@GetMapping("/gettopics")
	public List<Topic> getAllTopics() {
		return service.getAllTopics();
	}
}
