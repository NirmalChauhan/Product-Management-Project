<%@page import="com.jsp.customer_management.dao.CustomerManagementDao"%>
<%@page import="java.util.*"%>
<%@page import="com.jsp.customer_management.dto.Product"%>
<%@page import="com.jsp.customer_management.dto.Dealer"%>
<%@page import="com.jsp.customer_management.service.CustomerManagementService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dealer login successful</title>
</head>
<body>
		<h2>Welcome to Dealer page</h2>
		<p>This page allows dealers to add, update and delete their products.</p>  
		<p>Dealers can also update their contact information in this page. 

	<br>
	<hr>
	
	<!-- Main div class with both insert and display product settings-->	
	<div style="display: flex; justify-content: space-around">
		<div>
			<h4>Create New product</h4>

			<form action="createNewproduct" method="post">

				<label for="productName">product Name</label><br> 
				<input type="text" title="Only 8 character allowed" name="productName" placeholder="Enter product Name" required /><br>
				
				<label for="productId">product ID</label><br> 
				<input type="text" name="productId" placeholder="Enter product ID" required /><br> 
				
				<label for="productPrice">product Price</label><br> 
				<input type="text" name="productPrice" placeholder="Enter product Price" required /><br>
				
				<label for="productAvailability">product Availability</label><br>
				<label>true</label>
				<input type="radio" name="productAvailability" value="true">
				<label>false</label>
				<input type="radio" name="productAvailability" value="false">
				<p>choose true if available and false if not</p>
				
				<input type="submit" value="REGISTER"><br>
	
			</form>
		</div>
		
		<div >
		<!--display product, delete product and update product details settings-->	
			<h4>Product offered By you</h4>
			<%
			//this gets admin data straight from service class
			CustomerManagementDao cmd = new CustomerManagementDao();
			Dealer dealer = (Dealer)session.getAttribute("dealerLogInSession");
			int dealerId = dealer.getdealerId();
			List<Product> product = new ArrayList<Product>();	
			product = cmd.displayProduct(dealerId);
	
			%>

			<table border="2">
				
				
				<tr>
					<th>productId</th>
					<th>productName</th>
					<th>productPrice</th>
					<th>productAvailability</th>
					<th>Delete Operation</th>
					<th>Update Operation</th>
				</tr>
				<%
				for (Product s : product) {
				%>

				<tr>
				
					<td><%=s.getProductId() %></td>
					<td><%=s.getProductName()%></td>
					<td><%=s.getProductPrice()%></td>
					<td><%=s.getProductAvailable()%></td>
					
					<!-- this deletes the selected product from service class straight from here -->
					<td><a href="deleteproduct?productId=<%=s.getProductId()%>"><button
								style='background-color: red'>Delete</button></a></td>
					<!-- this send user to different page to update the ID  -->
					<td><a href="updateproductForm?productId=<%=s.getProductId()%>"><button
								style='background-color: orange'>Update</button></a></td>
					<%}%>	
			</table>
		</div>
	</div>

	<hr>
	<br>
	<a href="DealerlogOut">log out as dealer</a>

	
	

</body>
</html>