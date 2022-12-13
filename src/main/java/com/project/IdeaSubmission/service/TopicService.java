package com.project.IdeaSubmission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.IdeaSubmission.dto.Topic;
import com.project.IdeaSubmission.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	TopicRepository repository;
	
	public Topic addTopic(Topic topic) {
		return repository.save(topic);
	}
	
	public Topic getTopicById(int id) {
		return repository.findById(id).get();
	}
	public String deleteTopic(int id) {
		Topic topic = getTopicById(id);
		if (topic != null) {
			repository.delete(topic);
			return topic.getName() + " Topic is deleted";
		} else {
			return "No Topic is deleted";
		}
	}
	
	public Topic updateTopic(Topic newtopic) {
		Topic topic = getTopicById(newtopic.getId());
		topic.setName(newtopic.getName());
		topic.setIdeas(newtopic.getIdeas());
		return repository.save(topic);
	}
	
	public List<Topic> getAllTopicByUserId(int id){
		return repository.getAllTopicByUserId(id);
	}
	
	public List<Topic> getAllTopics(){
		return repository.findAll();
		}
}
