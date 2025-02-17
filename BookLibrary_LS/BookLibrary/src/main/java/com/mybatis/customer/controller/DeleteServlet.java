package com.mybatis.customer.controller;

import java.io.IOException;

import com.mybatis.customer.model.service.CustomerService;
import com.mybatis.customer.model.vo.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet( "/customer/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	CustomerService cService = new CustomerService();
	    	HttpSession session = request.getSession();
	    	Customer searchOne =(Customer)session.getAttribute("result");
	    	if(searchOne !=null) {
		    	String userId = searchOne.getUserId();
				int result = cService.deleteCustomer(userId);
				if(result > 0) {
				
					response.sendRedirect("/WEB-INF/views/customer/list.jsp");
				}else {
					request.getRequestDispatcher("/WEB-INF/views/notice/error.jsp")
					.forward(request, response);
					
				}
			
	    	}
		}

	}