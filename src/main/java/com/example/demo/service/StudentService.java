package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService
{
    public String addstudent(Student student);
    public Student checkstdlogin(String email,String pwd);
   
    public List<Student>  viewallstudents();
	
    public String updatestudent(Student student);
    public Student viewbyid(int id);
    
    
    public Student ViewStudentByID(int studentid);
     //  public String getEmailById(Long id);
     
}
