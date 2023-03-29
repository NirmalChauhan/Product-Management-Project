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

import com.jsp.customer_management.dto.Product;
import com.jsp.customer_management.service.CustomerManagementService;

@WebServlet(value="/udpateProductData")
public class ProductUpdateDataController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int productID = Integer.parseInt(req.getParameter("productId"));
		String productName = req.getParameter("productName");
		double productPrice = Double.parseDouble(req.getParameter("productPrice"));
		boolean productAva = Boolean.parseBoolean(req.getParameter("productAvailability"));
		
		HttpSession session = req.getSession();
		//here we are fetching the old
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html><body>");
		
		if(session.getAttribute("dealerLogInSession")!=null) {
			
			Product product = new Product();
			product.setProductId(productID);
			product.setProductName(productName);
			product.setProductPrice(productPrice);
			product.setProductAvailable(productAva);
			
			CustomerManagementService cms = new CustomerManagementService();
			 
			int updateConfirmation = cms.updateProductData(product);
			if(updateConfirmation!=0) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("DealerLoggedInPage.jsp");
				dispatcher.include(req, resp);
			}else {
				out.println("<p>Something went wrong in backend code</p>");
				RequestDispatcher dispatcher = req.getRequestDispatcher("ProductUpdatePage.jsp");
				dispatcher.include(req, resp);
			}
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("DealerLogInPage.jsp");
			out.print("<p>You were logged out please login again</p>");
			dispatcher.include(req, resp);
		}
		
		out.println("</html></body>");
	}

}
