package com.project.IdeaSubmission.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.IdeaSubmission.dto.User;
import com.project.IdeaSubmission.repository.UserRepository;

@Service
public class UserService {

	@Autowired 
	UserRepository repository;
	
	
	public User addUser(User user) {
		return repository.save(user);
	}
	
	public void deleteUser(int id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}
	}
	
	public User getUserById(int id) {
		return repository.findById(id).get();
	}
	public User updateUser(User updated_user, int id) {
		User user=getUserById(id);
		user.setUsername(updated_user.getUsername());
		user.setFname(updated_user.getFname());
		user.setLname(updated_user.getLname());
		user.setPassword(updated_user.getPassword());
		user.setRole(updated_user.getRole());
		return repository.save(user);
	}
	
	public List<User> getUsers() {
		return repository.findAll();
	}
	
	public User getByEmail(String email) {
		return repository.getByEmail(email);
	}
	public User userLogin(User user) {
		User check=getByEmail(user.getEmail());
		if(check==null)
			return check;
		if(check.getPassword().equals(user.getPassword()))
			return check;
		return null;
	}

	public User updateLikes(int idea_id, int user_id) {
		User user = getUserById(user_id);
		HashMap<Integer, Integer> likes = user.getLikes();
		if(!likes.containsKey(idea_id)) {
			likes.put(idea_id, 1);
			user.setLikes(likes);
			
		}
		HashMap<Integer, Integer> dislikes = user.getDislikes();
		if(dislikes.containsKey(idea_id)) {
			dislikes.remove(idea_id);
			user.setDislikes(dislikes);
			
		}
		updateUser(user, user_id);
		return user;
	}
	public User updateDislikes(int idea_id, int user_id) {
		User user = getUserById(user_id);
		HashMap<Integer, Integer> dislikes = user.getDislikes();
		if(!dislikes.containsKey(idea_id)) {
			dislikes.put(idea_id, 1);
			user.setDislikes(dislikes);
			
		}
		HashMap<Integer, Integer> likes = user.getLikes();
		if(likes.containsKey(idea_id)) {
			likes.remove(idea_id);
			user.setLikes(likes);
			
		}
		updateUser(user, user_id);
		return user;
	}
}
