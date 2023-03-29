<%@page import="java.util.List"%>
<%@page import="com.jsp.customer_management.dto.Admin"%>
<%@page import="com.jsp.customer_management.service.CustomerManagementService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Management</title>
</head>
<style>
table, body {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<body>

	<h2>Welcome to super user page</h2>

	<br>
	<hr>

	<div style="display: flex; justify-content: space-around">
		<div>

			<h4>Create New Admin</h4>

			<form action="registerAdmin" method="post">

				<label for="adminName">Admin Name</label><br> <input
					type="text" title="Only 8 character allowed" name="adminName"
					placeholder="Enter Admin Name" maxlength="8" required /><br>
				<label for="adminId">Admin ID</label><br> <input type="text"
					name="adminId" placeholder="Enter admin ID" required /><br> <label
					for="adminEmail">Admin Email</label><br> <input type="text"
					name="adminEmail" placeholder="Enter admin Email" required /><br><br>
				<input type="submit" value="REGISTER"><br>
			</form>

		</div>
		<div >
			<h4>Available Admins</h4>
			<%
			//this gets admin data straight from service class
			CustomerManagementService cms = new CustomerManagementService();
			List<Admin> admin = cms.displayAllAdmin();
			%>

			<table border="2">
				<tr>
					<th>AdmimName</th>
					<th>AdminEmail</th>
					<th>Delete Operation</th>
					<th>Update Operation</th>
				</tr>
				<%
				for (Admin s : admin) {
				%>

				<tr>
				
					<td><%=s.getAdminName()%></td>
					<td><%=s.getAdminEmail()%></td>
					
					<!-- this deletes the selected admin from service class straight from here -->
					<td><a href="deleteAdmin?AdminId=<%=s.getAdminId()%>"><button
								style='background-color: red'>Delete</button></a></td>
					<!-- this send user to different page to update the ID  -->
					<td><a href="updateForm?AdminId=<%=s.getAdminId()%>"><button
								style='background-color: orange'>Update</button></a></td>
					<%}%>	
			</table>
		</div>
	</div>

	<hr>
	<br>
	<a href="adminLoginForm.jsp">Log in as Admin</a>
	<a href="DealerLogInForm.jsp">Log in as customer</a>

	<br>
	<hr>
	<br>
		
</body>
</html>