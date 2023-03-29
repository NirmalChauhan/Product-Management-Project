<%@page import="org.w3c.dom.css.CSSImportRule"%>
<%@page import="com.jsp.customer_management.dto.Dealer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dealer Update Page</title>
</head>
<body>

	<% Dealer dealer = (Dealer)request.getAttribute("getDealer"); %>
	
	<form action="updateDealerData" method ="post">
		<label for="dealerName">dealer Name</label><br> 
				<input type="text" name="dealerName" placeholder="<%= dealer.getdealerName() %>" value="" maxlength="8" required/><br>
				<label for="dealerId">dealer ID</label><br> 
				<input type="text" name="dealerId" value="<%= dealer.getdealerId() %>" readonly/><br> 
				<label for="dealerEmail">dealer Email</label><br> 
				<input type="text" name="dealerEmail" placeholder="<%= dealer.getdealerEmail() %>" value="" required/><br>
				<label for="dealerPhone">Dealer PHone</label><br>
				<input type="text" name="dealerPhone" placeholder="<%= dealer.getdealerPhone() %>" value="" required/><br><br>
				<input type="submit" value="Update"><br>
	</form>

<br><br><hr>

<a href = "AdminLoggedIn.jsp">Go Back</a>

</body>
</html>