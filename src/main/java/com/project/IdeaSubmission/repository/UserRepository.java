package com.project.IdeaSubmission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.IdeaSubmission.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User getByEmail(String email);
}
