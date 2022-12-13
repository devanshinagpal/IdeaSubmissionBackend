package com.project.IdeaSubmission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.IdeaSubmission.dto.PairIdeas;

@Repository
public interface PairIdeasRepository extends JpaRepository<PairIdeas, Integer>{

}
