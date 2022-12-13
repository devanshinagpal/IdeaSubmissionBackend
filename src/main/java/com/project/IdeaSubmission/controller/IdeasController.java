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

import com.project.IdeaSubmission.dto.Ideas;
import com.project.IdeaSubmission.dto.Topic;
import com.project.IdeaSubmission.service.IdeasService;
import com.project.IdeaSubmission.service.TopicService;

@RestController
@CrossOrigin
public class IdeasController {

	@Autowired
	IdeasService service;
	@Autowired
	TopicService topicService;
	
	@PostMapping("/addidea/{topic_id}")
	public Ideas addIdea(@RequestBody Ideas ideas,@PathVariable int topic_id) {
		Topic topic = topicService.getTopicById(topic_id);
		ideas.setTopic(topic);
		return service.addIdea(ideas);
	}

	@DeleteMapping("/deleteidea/{id}")
	public String deleteIdea(@PathVariable("id") int id) {
		service.deleteIdea(id);
		return "Deleted Topic with Id : "+id;
	}

	@PutMapping("/updateidea/{id}")
	public Ideas updateIdea(@RequestBody Ideas ideas) {
		return service.updateIdea(ideas);
	}

	@GetMapping("/getideas/{topic_id}")
	public List<Ideas> getIdeasByTopicId(@PathVariable("topic_id") int topic_id){
		Topic topic =  topicService.getTopicById(topic_id);
		
		return topic.getIdeas();
		}
	
	@PutMapping("like/{id}")
	public Ideas likeIdea(@PathVariable("id") int id) {
		return service.likeIdea(id);
	}
	@PutMapping("dislike/{id}")
	public Ideas dislikeIdea(@PathVariable("id") int id) {
		return service.dislikeIdea(id);
	}

}
