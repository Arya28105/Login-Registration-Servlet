<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<div class="container">
	
		<h3 id="sign_in">Sign In</h3> <br>
		
		<%
			String message = (String) request.getAttribute("msg");
			String color = (String) request.getAttribute("color");

			if(message != null){
		%>
    			<h3 style="color:red; text-align:center;">
        			<%= message %>
    			</h3>
		<%
			}
		%>
	
		<form action="loginForm" method="post">
	
			<input class="label" id="name" type="text" name="userName" placeholder="Username"> <br><br><br>
			<input class="label" id="pass" type="password" name="userPassword" placeholder="Password"> <br><br><br>
			<input class="submit" type="submit" name="submitButton" value="login"> <br><br>
			<a href="register.jsp"> Register</a>
	
		</form>
	</div>
</body>
</html>