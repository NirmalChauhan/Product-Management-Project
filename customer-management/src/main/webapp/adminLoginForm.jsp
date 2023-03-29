<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Form </title>
</head>
<body>
	
	<form action="adminLoginCtrl" method ="post">
	
	<label for="adminName">Admin Name</label><br>
	<input type="text" name="adminName" placeholder="Enter your 8 chr Name" maxlength="8" required/><br>
	
	<label for="adminId">Admin ID</label><br>
	<input type = "text" name= "adminId" placeholder= "Enter your unique AdminId" required/><br>
	
	<input type ="submit" value="Login">
	
	</form>
</body>
</html>