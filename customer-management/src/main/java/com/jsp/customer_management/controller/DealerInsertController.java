package com.jsp.customer_management.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.customer_management.dto.Dealer;
import com.jsp.customer_management.service.CustomerManagementService;

@SuppressWarnings("serial")
@WebServlet(value="/createNewDealer")
public class DealerInsertController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		out.write("<html><body>");
		if (session.getAttribute("adminName")!=null) {
			
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
			Dealer dealer2 = cms.createNewDealer(dealer);
			
			if (dealer2 != null) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("AdminLoggedIn.jsp");
				dispatcher.include(req, resp);
				out.write("<p style= 'color:yellow;'>" + dealer2.getdealerName() + " Successfully Added " + "</p>");
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("AdminLoggedIn.jsp");
				dispatcher.include(req, resp);
				out.write("<p style= 'color:red;'>Some thing went terribly wrong please try again</p>");
			}
			
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Index.jsp");
			out.write("<p style= 'color:red;'>You have been logged out! login again</p>");
			dispatcher.include(req, resp);
		}
		out.write("</html></body>");
		
	}

}
