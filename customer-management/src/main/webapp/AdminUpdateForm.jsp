<%@page import="com.jsp.customer_management.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

Admin admin = (Admin)request.getAttribute("updateAdmin");

%>


	 <form action="adminUpdateForm" method="post">

				<label for="adminName">Admin Name</label><br> 
				<input type="text" name="adminName" placeholder="<%=admin.getAdminName()%>" value="" maxlength="8" required/><br>
				<label for="adminId">Admin ID</label><br> 
				<input type="text" name="adminId" value="<%=admin.getAdminId()%>" readonly/><br> 
				<label for="adminEmail">Admin Email</label><br> 
				<input type="text" name="adminEmail" placeholder="<%=admin.getAdminEmail()%>" value="" required/><br><br>
				<input type="submit" value="Update"><br>
			</form> 	 
			
<br><br><hr>

<a href = "Index.jsp">Go Back</a>
			

</body>
</html>