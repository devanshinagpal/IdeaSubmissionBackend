package com.project.IdeaSubmission.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Votes {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JsonBackReference
	private Ideas ideas;
	
	@OneToOne
	@JsonBackReference
	private User user;
	
	private boolean type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ideas getIdeas() {
		return ideas;
	}

	public void setIdeas(Ideas ideas) {
		this.ideas = ideas;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}
	
	
	
}
