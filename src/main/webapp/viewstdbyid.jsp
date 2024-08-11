<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %>
 
<html> 
<head> 
 
<link type="text/css" rel="stylesheet" href="css/style.css"> 
 
<style> 
 .body
 {
 
   background-image: url('https://media2.giphy.com/media/SJkU2Tt02Xg5YVjavq/source.gif');
 }
 
</style> 
</head> 
<body> 


<%@ include file="studentnavbar.jsp" %>

ID : ${std.id}<br>
Name : ${std.name}<br>
Email : ${std.email}<br>
Gender : ${emp.gender}<br>
DateofBirth : ${emp.dateofbirth}<br>
Department : ${emp.department}<br>
Salary : ${emp.salary}<br>

Location : ${emp.location}<br>
Contact No : ${emp.contact}<br>
Status : ${emp.active}

</body>
</html>