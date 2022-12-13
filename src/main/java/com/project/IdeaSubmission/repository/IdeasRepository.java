package com.project.IdeaSubmission.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.IdeaSubmission.dto.Ideas;

@Repository
public interface IdeasRepository extends JpaRepository<Ideas, Integer> {

	public List<Ideas> getIdeasByTopicId(int id);
}
