package com.project.IdeaSubmission.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class PairIdeas {

	@Id
	@GeneratedValue
	int id;
	
	@OneToMany
	@JoinColumn(name="idea_id")
	private List<Ideas> ideas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Ideas> getIdeas() {
		return ideas;
	}

	public void setIdeas(List<Ideas> ideas) {
		this.ideas = ideas;
	}
	
	
}
