<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<link type="text/css" rel="stylesheet" href="css.css">
<div class="parent clearfix">
    <div class="bg-illustration">
      <img src="images/ss logo.jpg" alt="logo">

      <div class="burger-btn">
        <span></span>
        <span></span>
        <span></span>
      </div>

    </div>
    
    <div class="login">
      <div class="container">
        <h1>Employee Login<br /></h1>
    
        <div class="login-form">
          <form action="login" method="post">
            <input type="text" name="empId" placeholder="Employee ID">
            <input type="text" name="empName" placeholder="Employee Name">

            <div class="remember-form">
              <input type="checkbox">
              <span>Remember me</span>
            </div>
            <div class="forget-pass">
              <a href="#">Forgot Password ?</a>
            </div>
            <button type="submit">LOG-IN</button>
            
<a href="register.jsp">Register here</a>
</form>
</body>
</html>