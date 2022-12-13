package com.project.IdeaSubmission.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Ideas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	
	private int likes;
	private int dislikes;
	
	@ManyToOne()
	@JoinColumn(name="topic_id")
	@JsonBackReference
	private Topic topic;
	
	@OneToOne
	@JsonBackReference
	private Votes votes;
	
	@ManyToOne()
	@JoinColumn(name="pairIdeas_id")
	@JsonBackReference
	private PairIdeas pairIdeas;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
