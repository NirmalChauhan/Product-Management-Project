package com.jsp.customer_management.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value="/DealerlogOut")
public class DealerLogOutController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		
		if(session.getAttribute("dealerLogInSession")!=null){
			session.invalidate();	
			RequestDispatcher dispatcher = req.getRequestDispatcher("Index.jsp");
			dispatcher.include(req, resp);
		}else {
			session.invalidate();	
			RequestDispatcher dispatcher = req.getRequestDispatcher("DealerLogInForm.jsp");
			dispatcher.include(req, resp);
		}
	}

	
}
