<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>

     <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   
<style>
     h3 {
  background-color:#151E3D;
  color: white;
  padding: 15px 40px;
  font-family: 'style font', sans-serif;
  text-align: center;
}
th{

  border: 10px solid #2e4f75;
 
}
td {
  border: 10px solid #c3e0f6;
}

.container{
 margin-top:60px;
 margin: 0 auto;
   background-image: url('https://media2.giphy.com/media/SJkU2Tt02Xg5YVjavq/source.gif');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
 
}
.button {
  display: inline-block;
  padding: 10px 20px;
  background-color: #04AA6D; /* Change this color to your desired one */
  color: white;
  text-align: center;
  text-decoration: none;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

  
    </style>

</head>

<body>

 <%@ include file="studentnavbar.jsp" %>
  <h3 align=center>View Grievances </h3>
  <div class="container1">
 
  <form:form method="post" action="displaystudent">
  
   <div class="container">
     <br/>
    <table class="table table-striped">
     <!-- 
        <tr>
            <td>Select ID:</td>
            <td>
                <select name="sid" required>
                    <option value="">---Select---</option>
                    <c:forEach items="${studentlist}" var="student">
                        <option value="${student.id}" ${student.id == sid ? 'selected' : ''}>${student.id}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="View" class="button">
            </td>
        </tr>
       -->   
        <c:if test="${sid != null}">
           <tr>
                <th scope="col">ID NO</th>
                <th scope="col">NAME</th>
                <th scope="col">EMAIL ADDRESS</th>
                <th scope="col">Entry Date</th>
                <th scope="col">CATEGORY</th>
                <th scope="col">TITLE</th>
                <th scope="col">DESCRIPTION</th>
                <th scope="col"> STATUS </th>   
              </tr>
            <c:forEach items="${studentlist}" var="student">
                <c:if test="${student.id == sid}">
                    <tr> 
<td><c:out value="${student.id}" /></td> 
<td><c:out value="${student.name}" /></td> 
<td><c:out value="${student.email}" /></td> 
<td><c:out value="${student.entrydate}" /></td> 
<td><c:out value="${student.category}" /></td> 
<td><c:out value="${student.title}" /></td> 
<td><c:out value="${student.description}" /></td> 
<td>

<a href="response" class="button">View Status</a>
</td>
 
</tr> 
                </c:if>
            </c:forEach>
        </c:if>
    </table>
    </div>
</form:form>
  </div>
</body>

</html>