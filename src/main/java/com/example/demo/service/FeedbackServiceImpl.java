package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Feedback;
import com.example.demo.repository.FeedbackRepository;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class FeedbackServiceImpl  implements FeedbackService
{
	
	@Autowired
	private FeedbackRepository feedbackRepository;

	@Override
	public String submitFeedback(Feedback feedback) 
	{
		try {
            feedbackRepository.save(feedback);
            return "Feedback submitted successfully.";
		}
		
		catch (Exception e) {
            return   "Feedback failed.";
		}
	}

	

	

}
