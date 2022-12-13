package com.project.IdeaSubmission.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.IdeaSubmission.dto.Votes;

public interface VotesRepository extends JpaRepository<Votes, Integer> {

}
