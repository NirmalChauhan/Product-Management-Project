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

@SuppressWarnings("serial")
@WebServlet(value="/updateproductForm")
public class ProductUpdateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productId= Integer.parseInt(req.getParameter("productId"));
		
		HttpSession session = req.getSession();
		CustomerManagementService cms = new CustomerManagementService();
		
		PrintWriter out = resp.getWriter();
		out.write("<html><body>");
		if(session.getAttribute("dealerLogInSession")!=null) {
			
			Product product = cms.fetchProductById(productId);
			if(product!=null) {
				//creation of object to fetch while updating of data will be done from here 
				session.setAttribute("fetchProductForUpdate", product);
				RequestDispatcher dispatcher = req.getRequestDispatcher("ProductUpdatePage.jsp");
				dispatcher.include(req, resp);	
			}else {
				out.write("<p>Please check your prodcut id and session manager as product it does not exist");
				RequestDispatcher dispatcher = req.getRequestDispatcher("DealerLoggeInPage.jsp");
				dispatcher.include(req, resp);		
			}
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("DealerLogInForm.jsp");
			dispatcher.include(req, resp);
		}
	}
}
