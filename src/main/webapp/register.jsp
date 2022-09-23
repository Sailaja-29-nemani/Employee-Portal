<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<link type="text/css" rel="stylesheet" href="home.css">
<body>
<div class="container">
	<div class="screen">
		<div class="screen__content">
		<form action="register" method="post">
					<div class="login__field">
						<i class="login__icon fas fa-user"></i> <input type="text"
							name="empId" class="login__input" placeholder="Employee ID">
					</div>
					<div class="login__field">
						<i class="login__icon fas fa-lock"></i> <input type="text"
							name="empName" class="login__input" placeholder="Employee Name">
					</div>

					<div class="login__field">
						<i class="login__icon fas fa-lock"></i> <input type="email"
							name="empEmail" class="login__input" placeholder="Employee Email">
					</div>
					<button class="button login__submit">
					<span class="button__text">Sign Up</span>
					<i class="button__icon fas fa-chevron-right"></i>
				</button>				
			</form>
			</div>
		<div class="screen__background">
			<span class="screen__background__shape screen__background__shape4"></span>
			<span class="screen__background__shape screen__background__shape3"></span>		
			<span class="screen__background__shape screen__background__shape2"></span>
			<span class="screen__background__shape screen__background__shape1"></span>
		</div>
	</div>
	</div>
	</body>
	</html>
	