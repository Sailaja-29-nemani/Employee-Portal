<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
<%
session.removeAttribute("empName");
session.removeAttribute("uid");
session.invalidate();
%>
Logged out successfully
<br/>
<a href="index.jsp">Login again</a>
</body>
</html>