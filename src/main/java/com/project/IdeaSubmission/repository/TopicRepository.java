package com.project.IdeaSubmission.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.IdeaSubmission.dto.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

//	@Query("select t.topic from user u where t.id =:userId")
	public List<Topic> getAllTopicByUserId(int id);
}
