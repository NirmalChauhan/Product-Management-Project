package com.jsp.customer_management.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.customer_management.dto.Admin;
import com.jsp.customer_management.service.CustomerManagementService;

@SuppressWarnings("serial")
@WebServlet(value="/adminLoginCtrl")

public class AdminLoginController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name = req.getParameter("adminName");
		int id = Integer.parseInt(req.getParameter("adminId"));
		
		Admin admin = new Admin();
		admin.setAdminName(name);
		admin.setAdminId(id);
		CustomerManagementService cms = new CustomerManagementService();
		
		Admin admin2 = new Admin(); 
		admin2 = cms.getAdminLoggedIn(admin);

		HttpSession httpSession = req.getSession();
		
		
		if(admin2!=null) {
			httpSession.setAttribute("adminName", admin);
			RequestDispatcher dispatcher = req.getRequestDispatcher("AdminLoggedIn.jsp");
			dispatcher.forward(req, resp);
			
		}
		else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("adminLoginForm.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
}
