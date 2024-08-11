<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>

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
  padding: 35px 40px;
  font-family: 'style font', sans-serif;
  text-align: center;
}
th{

  border: 10px solid #44476a;
 
}
td {
  border: 10px solid rgba(238, 167, 126, 0.604);
}

.container{
margin-top:40px;
}

.button {
  display: inline-block;
  padding: 10px 20px;
  background-color: red;
  color: white;
  text-align: center;
  text-decoration: none;
  font-size: 16px;
  border: none;
  cursor: pointer;
}
h2{
color:white;
 text-align: center;
 font-family:cursive;
 background-color:#151a59;;
}
</style>
</head>
<body>
 <%@ include file="admnavbar.jsp" %>
  <h3 align=center> </h3>
    <div class="container">
       <h2>DELETE GRIEVANCE BY ID</h2>
         
        <table class="table table-striped">
            <thead >
              
              
              <tr>
<td>ID</td> 
<td>NAME</td> 
<td>EMAIL ID</td> 
<td>ENTRY DATE</td> 
<td>CATEGORY</td> 
<td>TITLE</td> 
<td>DESCRIPTION</td>
</tr> 
 
<c:forEach items="${grevdata}"  var="grev"> 
<tr> 
<td><c:out value="${grev.id}" /></td> 
<td><c:out value="${grev.name}" /></td> 
<td><c:out value="${grev.email}" /></td> 
<td><c:out value="${grev.entrydate}" /></td> 
<td><c:out value="${grev.category}" /></td> 
<td><c:out value="${grev.title}" /></td> 
<td><c:out value="${grev.description}" /></td> 
<td>
<a href='<c:url value="delete/${grev.id}"></c:url>' class="button">Delete </a>
</td>
 
</tr> 
</c:forEach> 
 
</table> 
    </div>
</body>
</html>