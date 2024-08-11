package com.example.demo.service;

import java.util.List;

import com.example.demo.model.GrievanceEntry;

import jakarta.servlet.http.HttpServletRequest;


public interface GrievanceEntryService 
{
	 public String addgreivance(GrievanceEntry grievanceEntry);
	  public List<GrievanceEntry> viewgrievances();
	  
	  public List<GrievanceEntry> viewbycategory(String category);
	  public GrievanceEntry ViewGrievanceByID(int gid);
	  
	  public List<GrievanceEntry> ViewGrievanceByEmail(String name);
	  public String deletegrev(int id);
	  
	   public List<GrievanceEntry> viewcomplaintsbyuser(HttpServletRequest request);
	  
}
