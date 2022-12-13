package com.project.IdeaSubmission.service;

import com.project.IdeaSubmission.dto.EmailDetails;

public interface EmailService {

	String sendSimpleMail(EmailDetails details);
}
