package com.jsp.customer_management.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
@WebServlet(value="/dealerLoginCtrl")

public class DealerLoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();	
		
		String name = req.getParameter("dealerName");
	 	String email = req.getParameter("dealerEmail");
	
		CustomerManagementService cms = new CustomerManagementService();
		
		List<Dealer> dealerSingleList = cms.dealerLoginRqst(name,email);
		
		Dealer dealer = dealerSingleList.get(0);
	
		PrintWriter out= resp.getWriter();
	 	out.write("<html><body>");
		if(dealer!=null) {		
			session.setAttribute("dealerLogInSession", dealer);
	 		RequestDispatcher dispatcher = req.getRequestDispatcher("DealerLoggedInPage.jsp");
	 		dispatcher.include(req, resp);
	 		
	 	}else {
	 		
	 		RequestDispatcher dispatcher = req.getRequestDispatcher("DealerLogInForm.jsp");
	 		dispatcher.include(req, resp);	 
	 		out.write("<p>something went wrong while logging in please try again</p>");
	 	}
	 	out.write("</body></html>");
	}
}
