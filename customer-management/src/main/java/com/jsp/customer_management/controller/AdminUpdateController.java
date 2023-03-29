package com.jsp.customer_management.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.customer_management.dto.Admin;
import com.jsp.customer_management.service.CustomerManagementService;

@SuppressWarnings("serial")
@WebServlet(value="/updateForm")
public class AdminUpdateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int adminId = Integer.parseInt(req.getParameter("AdminId"));
		CustomerManagementService cms = new CustomerManagementService();
		Admin admin = cms.displaySingleAdmin(adminId);
		req.setAttribute("updateAdmin", admin);
		RequestDispatcher dispatcher = req.getRequestDispatcher("AdminUpdateForm.jsp");
		dispatcher.include(req, resp);
		
	}

}
