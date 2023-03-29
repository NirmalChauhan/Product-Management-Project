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
@WebServlet(value="/updateDealerData")
public class DealerUpdateFormController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int dealerId = Integer.parseInt(req.getParameter("dealerId"));
		String dealerName = req.getParameter("dealerName");
		String dealerEmail = req.getParameter("dealerEmail");
		long dealerPhone = Long.parseLong(req.getParameter("dealerPhone"));
		
		Dealer dealer = new Dealer();
		dealer.setdealerId(dealerId);
		dealer.setdealerName(dealerName);
		dealer.setdealerEmail(dealerEmail);
		dealer.setdealerPhone(dealerPhone);
		
		CustomerManagementService cms = new CustomerManagementService();
		
		Dealer dealer2 = cms.updateDealer(dealer);
		if(dealer2!=null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("AdminLoggedIn.jsp");
			dispatcher.include(req, resp);
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Index.jsp");
			dispatcher.include(req, resp);
		}
		
	} 

}
