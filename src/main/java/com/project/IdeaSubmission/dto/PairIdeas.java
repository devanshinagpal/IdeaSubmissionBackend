package com.project.IdeaSubmission.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class PairIdeas {

	@Id
	@GeneratedValue
	int id;
	
	private Ideas ideas;
}
