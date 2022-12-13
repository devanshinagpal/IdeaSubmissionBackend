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

import com.project.IdeaSubmission.dto.User;
import com.project.IdeaSubmission.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired 
	UserService service;
	
	@PostMapping("/loginuser")
	public User userLogin(@RequestBody User user){
		return service.userLogin(user);
	}
	
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}

	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		service.deleteUser(id);
		return "Deleted User with Id : "+id;
	}

	@PutMapping("/updateuser/{id}")
	public User updateUser(@RequestBody User user,@PathVariable("id") int id) {
		return service.updateUser(user,id);
	}

	@GetMapping("/getuser/{id}")
	public User getUserById(@PathVariable("id") int id) {
		User user = service.getUserById(id);
		System.out.println(user);
		return user;
	}
	@GetMapping("/getusers")
	public List<User> getUsers() {
		return service.getUsers();
	}
	@PutMapping("/userlikes/{idea_id}/{user_id}")
	public User userLikes(@PathVariable("idea_id") int idea_id,@PathVariable("user_id") int user_id) {
		return service.updateLikes(idea_id,user_id);
	}
	@PutMapping("/userdislikes/{idea_id}/{user_id}")
	public User userDislikes(@PathVariable("idea_id") int idea_id,@PathVariable("user_id") int user_id) {
		return service.updateDislikes(idea_id,user_id);
	}
}
