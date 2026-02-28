<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="wrapper">

	
		<%
			String success = (String) request.getAttribute("successMsg");
        	if(success != null){
		%>
    		<h2 style="color:green; text-align:center;">
            	<%= success %>
        	</h2>
		<%
			}
		%>
	
	
	<div class="containerR">
		
		
		<h3 id="sign_in">Sign Up</h3> 
		
		<% 
        	String error = (String) request.getAttribute("errorMsg");
        	if(error != null){
    	%>
        	<h3 style="color:red; text-align:center;"><%= error %></h3>
    	<% } %>
    	
    	<form action="registerForm" method="post">
		
			<input class="label" type="text" name="name" placeholder="Name"> <br><br><br>
			<input class="label" type="password" name="userPassword" placeholder="Password"> <br><br><br>
			<input class="label" type="email" name="userEmail" placeholder="email"> <br><br><br>
			<input class="label" type="number" name="userMob" placeholder="Contact"> <br><br><br>
			<input class="submit" type="submit" name="regButton"><br><br>
			<a href="login.jsp"> Login</a>
	
		</form>
	</div>
</div>	
</body>
</html>