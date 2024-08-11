package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="feedback_table")
public class Feedback
{
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)	       
	   private Long id;

	   @Column(nullable = false)   
	   private Integer rating;

	   @Column(nullable = false)   
	   private String comments;
	  
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", rating=" + rating + ", comments=" + comments + "]";
	}
	   
	   
	   
	   
	   
	   
}
