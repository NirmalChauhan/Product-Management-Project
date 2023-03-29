<%@page import="java.util.List"%>
<%@page import="com.jsp.customer_management.dto.Dealer"%>
<%@page import="com.jsp.customer_management.service.CustomerManagementService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome admin</title>
</head>
<body>
	
		<h2>Welcome to Admin page</h2>

	<br>
	<hr>

	<div style="display: flex; justify-content: space-around">
		<div>

			<h4>Create New Dealer</h4>

			<form action="createNewDealer" method="post">

				<label for="dealerName">dealer Name</label><br> <input
					type="text" title="Only 8 character allowed" name="dealerName"
					placeholder="Enter dealer Name" maxlength="15" required /><br>
				<label for="dealerId">dealer ID</label><br> <input type="text"
					name="dealerId" placeholder="Enter dealer ID" required /><br> <label
					for="dealerEmail">dealer Email</label><br> <input type="text"
					name="dealerEmail" placeholder="Enter dealer Email" required /><br>
				<label for="dealerPhone">dealer phone</label><br>
				<input type = "text" name="dealerPhone" placeholder = "Enter dealer phonenumber" required><br><br>
				<input type="submit" value="REGISTER"><br>
	
			</form>

		</div>
		<div >
			<h4>Available Dealer</h4>
			<%
			//this gets admin data straight from service class
			CustomerManagementService cms = new CustomerManagementService();
			List<Dealer> dealer = cms.displayAllDealer();
			%>

			<table border="2">
				<tr>
					<th>dealerId</th>
					<th>dealerName</th>
					<th>dealerEmail</th>
					<th>dealerPhone</th>
					<th>Delete Operation</th>
					<th>Update Operation</th>
				</tr>
				<%
				for (Dealer s : dealer) {
				%>

				<tr>
				
					<td><%=s.getdealerId() %></td>
					<td><%=s.getdealerName()%></td>
					<td><%=s.getdealerEmail()%></td>
					<td><%=s.getdealerPhone()%></td>
					
					<!-- this deletes the selected dealer from service class straight from here -->
					<td><a href="deletedealer?dealerId=<%=s.getdealerId()%>"><button
								style='background-color: red'>Delete</button></a></td>
					<!-- this send user to different page to update the ID  -->
					<td><a href="updateDealerForm?dealerId=<%=s.getdealerId()%>"><button
								style='background-color: orange'>Update</button></a></td>
					<%}%>	
			</table>
		</div>
	</div>

	<hr>
	<br>

	<a href="adminLogout?">Log out admin</a>

</body>
</html>