package com.jsp.customer_management.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.customer_management.service.CustomerManagementService;

@SuppressWarnings("serial")
@WebServlet(value="/deletedealer")
public class DealerDeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("dealerId"));
		
		CustomerManagementService cms = new CustomerManagementService();
		
		cms.deleteDealer(id);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("AdminLoggedIn.jsp");
		dispatcher.include(req, resp);		

	}
	
	
}
