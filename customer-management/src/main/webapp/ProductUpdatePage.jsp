<%@page import="com.jsp.customer_management.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dealer Update Page</title>
</head>
<body>

<% Product product = (Product)session.getAttribute("fetchProductForUpdate");%>

<form action = "udpateProductData" method = "post">

	<label for="productId" >Product ID</label>
	<input type = "text" name="productId" value="<%= product.getProductId()%>" readonly><br>
	
	<label for="productName">Product Name</label>
	<input type= "text" name = "productName" placeholder="<%=product.getProductName()%>" value="" required/><br>
	
	<label for="productPrice">Product Price</label>
	<input type ="text" name = "productPrice" placeholder="<%=product.getProductPrice()%>" value="" required/><br>
	
	<label for="productAvailability">product Availability</label>
	<input type ="text" name = "productAvailability" placeholder="<%=product.getProductAvailable()%>" value="" required/><br>
	
	<input type="submit" value="Update"><br>
</form>

<br><br><hr>
<a href = "DealerLoggedInPage.jsp">Go Back</a>

</body>
</html>