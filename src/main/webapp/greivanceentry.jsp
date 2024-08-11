<!DOCTYPE html>
<html>
<head>
    <title>Grievance Entry Form</title>
    <style>
    
        .body {
           background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  height: 100vh;
            
            background-image: url('https://media2.giphy.com/media/SJkU2Tt02Xg5YVjavq/source.gif');
        }
        h3 {
  background-color:#151E3D;
  color: white;
  padding: 25px 40px;
  font-family: 'style font', sans-serif;
  text-align: center;
}
h2{
padding: 25px 40px;
text-align: center;
background-image: url('https://media2.giphy.com/media/SJkU2Tt02Xg5YVjavq/source.gif');

}
h1{
  
text-align: center;
background-image: url('https://64.media.tumblr.com/023b3a5fdf3995f1cfad4b4bd0338005/tumblr_olulm75rwc1qlvwnco6_400.gifv');
}

        .container {
            max-width: 600px;
            margin: 0 auto;
             margin-top: 30px;
            background-color: #151E3D;
            border: 3px solid #151E3D;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            padding: 30px;
            text-align: center;
        }

        .container h2 {
            margin-bottom: 20px;
        }

        label {
            display: block;
            text-align:justify;
            font-weight: normal;
            font-family: 'Helvetica', sans-serif;
        }

        input[type="text"],
        input[type="email"],
        input[type="date"],
        select,
        textarea {
            width: 85%;
            padding: 10px;
            margin-bottom: 20px;
            border: 4px solid grey;
            border-radius: 5px;
        }

        select {
            height: 40px;
        }

        textarea {
            resize: none;
        }

        input[type="submit"] {
            background-color: #ff7200;
            color: #fff;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #ff7200;
        }
 
    </style>
</head>
<body>

 <%@ include file="studentnavbar.jsp" %>
 <h3 align=center>Grievances Entry Form</h3>
 
      <h2> Enter Your Grievance Here..!!
    <div class="container">
        <form action="insertgreivance" method="post">

       
           
            <input type="text" name="id"  placeholder= "Enter Id"   required="required" >
           
            <input type="text" id="name" name="name"  placeholder= "Enter Name" required>

            
            <input type="email" id="email" name="email"   placeholder= "Enter Email Address" required>

            
            <input type="date" id="dob" name="entrydate"  placeholder= "Enter Entry Date" required>

            
            <select id="category" name="category" >
            <option value="Choose Category">choose Category</option>
                <option value="College">College</option>
                <option value="Hostel">Hostel</option>
                <option value="Transport">Transport</option>
                <option value="Sports">Sports</option>
                <option value="Academics">Academics</option>
                <option value="Other">Others</option>
            </select>

           
            <input type="text" id="title" name="title"  placeholder= "Enter Title" required>

            
            <textarea id="description" name="description" rows="4" placeholder= "Grievance Description"  required></textarea>

            <input type="submit" value="Submit">
        </form>
        
 
    </div>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    </h2>
    
    
</body>
</html>