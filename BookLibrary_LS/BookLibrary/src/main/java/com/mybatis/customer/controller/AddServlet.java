package com.mybatis.customer.controller;

import java.io.IOException;

import com.mybatis.customer.model.service.CustomerService;
import com.mybatis.customer.model.vo.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/customer/add")
public class AddServlet extends HttpServlet {
	 

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String userId = request.getParameter("userId");
	        String userPw = request.getParameter("userPw");
	        String userName = request.getParameter("userName");
	        int userAge = Integer.parseInt(request.getParameter("userAge"));
	        String addr = request.getParameter("addr");
	        char gender = request.getParameter("gender").charAt(0);

	        Customer Customer = new Customer(userId, userPw, userName, userAge, addr, gender);
	        CustomerService cService = new CustomerService();
	        int result = cService.addCustomer(Customer);
	        
	        if(result >0) {
	        	response.sendRedirect("/customer/list");
	        }else {
	        	request.getRequestDispatcher("/WEB-INF/views/error.jsp")
				.forward(request, response);
	        }
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.getRequestDispatcher("/WEB-INF/views/customer/add.jsp").forward(request, response);
	    }
	}