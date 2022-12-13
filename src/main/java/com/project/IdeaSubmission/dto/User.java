package com.project.IdeaSubmission.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import java.util.HashMap;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String email;
	private String password;
	private String fname;
	private String lname;
	
	private String role;
	
	private HashMap<Integer, Integer> likes=new HashMap<>();
	private HashMap<Integer, Integer> dislikes=new HashMap<>();
	
	
	public HashMap<Integer, Integer> getLikes() {
		return likes;
	}
	public void setLikes(HashMap<Integer, Integer> likes) {
		this.likes = likes;
	}
	public HashMap<Integer, Integer> getDislikes() {
		return dislikes;
	}
	public void setDislikes(HashMap<Integer, Integer> dislikes) {
		this.dislikes = dislikes;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", fname="
				+ fname + ", lname=" + lname + ", role=" + role + ", topic=" + topic + "]";
	}
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Topic> topic;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Votes votes;
	
	public List<Topic> getTopic() {
		return topic;
	}
	public void setTopic(List<Topic> topic) {
		this.topic = topic;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	
	
	
	
	
	
}
