package com.jsp.customer_management.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.customer_management.service.CustomerManagementService;

@WebServlet(value="/deleteproduct")
public class ProductDeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int productId = Integer.parseInt(req.getParameter("productId"));
		HttpSession session = req.getSession();
		
		
		if(session.getAttribute("dealerLogInSession")!=null) {
			CustomerManagementService cms = new CustomerManagementService();
			cms.deleteProductByProductId(productId);
			RequestDispatcher dispatcher = req.getRequestDispatcher("DealerLoggedInPage.jsp");
			dispatcher.include(req, resp);
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("DealerLogInForm.jsp");
			dispatcher.include(req, resp);
		}
		
	}
	
}
