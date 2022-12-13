package com.project.IdeaSubmission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.IdeaSubmission.dto.Ideas;
import com.project.IdeaSubmission.repository.IdeasRepository;

@Service
public class IdeasService {

	@Autowired
	IdeasRepository repository;
	@Autowired
	EmailService emailService;
	
	public Ideas addIdea(Ideas ideas) {
//		emailService.sendSimpleMail(ideas);
		return repository.save(ideas);
	}
	
	public Ideas getIdeaById(int id) {
		return repository.findById(id).get();
	}
	public String deleteIdea(int id) {
		Ideas ideas = getIdeaById(id);
		if (ideas != null) {
			repository.delete(ideas);
			return "Deleted";
		} else {
			return "No Topic is deleted";
		}
	}
	
	public Ideas updateIdea(Ideas newideas) {
		Ideas ideas = getIdeaById(newideas.getId());
		ideas.setDescription(newideas.getDescription());
		
		return repository.save(ideas);
	}
	
	public List<Ideas> getIdeasByTopicId(int id){
		return repository.getIdeasByTopicId(id);
	}

	public Ideas likeIdea(int id) {
		// TODO Auto-generated method stub
		Ideas ideas =getIdeaById(id);
		ideas.setLikes(ideas.getLikes()+1);
		if(ideas.getDislikes()>0)
			ideas.setDislikes(ideas.getDislikes()-1);
		
		updateIdea(ideas);
		return ideas;
	}
	public Ideas dislikeIdea(int id) {
		// TODO Auto-generated method stub
		Ideas ideas =getIdeaById(id);
		if(ideas.getLikes()>0)
			ideas.setLikes(ideas.getLikes()-1);
		
		ideas.setDislikes(ideas.getDislikes()+1);
		updateIdea(ideas);
		return ideas;
	}
}
