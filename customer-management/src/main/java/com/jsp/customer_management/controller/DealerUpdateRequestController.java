package com.jsp.customer_management.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.customer_management.dto.Dealer;
import com.jsp.customer_management.service.CustomerManagementService;

@SuppressWarnings("serial")
@WebServlet(value="/updateDealerForm")
public class DealerUpdateRequestController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int dealerId = Integer.parseInt(req.getParameter("dealerId"));
		
		CustomerManagementService cms = new CustomerManagementService();
		
		Dealer dealer = cms.displaySingleDealer(dealerId);
		
		req.setAttribute("getDealer", dealer);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("DealerUpdatePage.jsp");
		dispatcher.forward(req, resp);
		
	}

}
