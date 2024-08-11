package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="g_table")
public class GrievanceEntry
{
	@Id
	@Column(name="g_id")
	private int id;
	
	@Column(name="g_name",nullable=false,length = 50)
	private String name;
	
	@Column(name="g_email",nullable=false,length = 30)
	private String email;
	
	@Column(name="g_dob",nullable=false,length = 20)
	private String entrydate;
	
	@Column(name="g_category",nullable=false,length = 20)
	private String category;
	@Column(name="g_title",nullable=false,length = 20)
	private String title;
	
	@Column(name="g_description",nullable=false,length = 200)
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "GrievanceEntry [id=" + id + ", name=" + name + ", email=" + email + ", entrydate=" + entrydate
				+ ", category=" + category + ", title=" + title + ", description=" + description + "]";
	}

	
	

}
