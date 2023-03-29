package com.jsp.customer_management.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.customer_management.dto.Dealer;
import com.jsp.customer_management.dto.Product;
import com.jsp.customer_management.service.CustomerManagementService;

@SuppressWarnings("serial")
@WebServlet(value="/createNewproduct")
public class productInsertController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Dealer dealer = (Dealer)session.getAttribute("dealerLogInSession");
		
		if(session.getAttribute("dealerLogInSession")!=null) {
			
			int dealerId = dealer.getdealerId();
			String productName= req.getParameter("productName");
			int productId= Integer.parseInt(req.getParameter("productId"));
			double productPrice = Double.parseDouble(req.getParameter("productPrice"));
			boolean productAvailability = Boolean.parseBoolean(req.getParameter("productAvailability"));
			
			Product product = new Product();
			 
			product.setProductName(productName);
			product.setProductId(productId);
			product.setProductPrice(productPrice);
			product.setProductAvailable(productAvailability);
			
			CustomerManagementService cms = new CustomerManagementService();
			cms.insertProduct(product, dealerId);
			RequestDispatcher dispatcher = req.getRequestDispatcher("DealerLoggedInPage.jsp");
			dispatcher.include(req, resp);
			
		}else {
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("DealerLogInForm.jsp");
			dispatcher.include(req, resp);
		}
		
		
	}

}
