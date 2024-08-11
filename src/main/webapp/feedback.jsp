<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>
<html lang="en">
<head>
  
  <title>Feedback Form</title>
  <link rel="stylesheet" href="css/feedback.css">
</head>
<body>
  <div class="container">
    <h1>Feedback Form</h1>
    <form action="feedback" method="post">
      <div class="form-group">
        <label for="rating">Rating:</label>
        <select name="rating" id="rating" required>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
        </select>
      </div>

      <div class="form-group">
        <label for="comments">Comments:</label>
        <textarea name="comments" id="comments" rows="5" required></textarea>
      </div>

      <div class="form-group">
        <button type="submit" class="btn">Submit Feedback</button>
      </div>
    </form>
  </div>
</body>
</html>
