<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>

<html lang="en" dir="ltr">
   <head>
     
      <title>Faculty Add Announcements</title>
      
     <link type="text/css" rel="stylesheet" href="css/announcements.css">
    
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
       
   </head>
   <body>
     
    
     
      
      <div class="container" style="overflow-y: auto;">
  
         <div class="form-outer">
            <form action="addannouncement" method="post">
               <div class="page slide-page">
                  <div class="title">
                    <center><h2>Announcements</h2></center>
                  </div>
                  <div class="field">
                     <div class="label">
                         Department ID
                     </div>
                     <input type="number" name="did" value="${faculty.department_id}" required="required" readonly="readonly">
                  </div>
                <!-- <div class="field">
                     <div class="label">
                        Course ID
                     </div>
                     <input type="number" name="cid" required="required"> 
                  </div> -->  
                   <div class="field">
                     <div class="label">
                        Enter your Announcement
                     </div>
                     <textarea id="announcement" name="announcement" rows="4" cols="50" required></textarea>                
                  </div>
                  <div class="field">
                     <div class="label">
                        Select Start Date and Time:
                     </div>
                     <input type="datetime-local" id="selectedDateTime" name="startDateTime"  required="required">
                  </div>
                  <div class="field">
                     <div class="label">
                        Select End Date and Time:
                     </div>
                     <input type="datetime-local"  id="selectedDateTime" name="endDateTime" required="required"> 
                  </div>
                  
                  <div class="field btns">
                     <button class="submit" value="add">Add announcement</button>
                  </div>
               </div>
          
            </form>
         </div>
      </div>
      
      <script>
    
     
      const submitBtn = document.querySelector(".submit");
    
      </script>
   </body>
</html>