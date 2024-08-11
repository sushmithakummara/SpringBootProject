
<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %>
 
<html> 
<head> 
 
<link type="text/css" rel="stylesheet" href="css/viewstudentbyid.css"> 
 
<style> 
 

 
 
</style> 
</head> 
<body> 
<%@ include file="admnavbar.jsp" %>
<h3>VIEW STUDENT</h3>
<br/>
<div id="car">
    <h2>STUDENT DETAILS</h2>
    <table>
      <tr>
        <td>ID:</td>
        <td>${s.id}</td>
      </tr>
      <tr>
        <td>Name:</td>
        <td>${s.name}</td>
      </tr>
      <tr>
        <td>Gender:</td>
        <td>${s.gender}</td>
      </tr>
      <tr>
        <td>Email:</td>
        <td>${s.email}</td>
      </tr>
      <tr>
        <td>Year:</td>
        <td>${s.contact}</td>
      </tr>
      <tr>
        <td>Date of Birth:</td>
        <td>${s.dateofbirth}</td>
      </tr>
      <tr>
        <td>Department:</td>
        <td>${s.department}</td>
      </tr>
      <tr>
        <td>Section:</td>
        <td>${s.year}</td>
      </tr>
      <tr>
        <td>Gender:</td>
        <td>${s.section}</td>
      </tr>
      <tr>
        <td>Location:</td>
        <td>${s.address}</td>
      </tr>
      <tr>
        <td>Contact No:</td>
        <td>${s.contact}</td>
      </tr>
    </table>
  </div>





</body>
</html>
