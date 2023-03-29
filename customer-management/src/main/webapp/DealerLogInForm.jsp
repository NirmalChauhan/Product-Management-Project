<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dealer LoginPage</title>
</head>
<body>

	<form action="dealerLoginCtrl" method="post">
	
	<label for="dealerName"> Dealer Name</label><br>
	<input type="text" name="dealerName" placeholder="Enter your name" maxlength = "15" required/><br>
	
	<label for="dealerEmail">Dealer Email</label><br>
	<input type="text" name="dealerEmail" placeholder="Enter your email address" required/><br>
	
	<input type="submit" value="login">
	</form>

</body>
</html>	