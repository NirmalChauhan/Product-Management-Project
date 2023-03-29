package com.jsp.customer_management.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.customer_management.dto.Admin;
import com.jsp.customer_management.service.CustomerManagementService;

@SuppressWarnings("serial")
@WebServlet(value="/adminUpdateForm")
public class AdminUpdateFormController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("adminId"));
		String name = req.getParameter("adminName");
		String email = req.getParameter("adminEmail");
		
		Admin admin = new Admin();
		admin.setAdminId(id);
		admin.setAdminName(name);
		admin.setAdminEmail(email);
		
		CustomerManagementService cms = new CustomerManagementService();
		
		PrintWriter out = resp.getWriter();
		out.write("<html><body>");
		
		if(cms.updateAdmin(admin)!=null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Index.jsp");
			dispatcher.include(req, resp);
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Index.jsp");
			dispatcher.include(req, resp);
			out.write("<p style='color:red;'>Something went wrong while updating</p>");
		}
		out.write("</html></body>");
	}

}
