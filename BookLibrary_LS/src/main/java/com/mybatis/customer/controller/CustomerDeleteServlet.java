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
public class CustomerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	CustomerService cService = new CustomerService();
	    	
	    	String userId = (request.getParameter("userId") != null) 
                    ? request.getParameter("userId") : "0";
	    	int result = cService.deleteById(userId);
	    	if(result > 0) {
				// 성공시 목록 페이지로 이동
				response.sendRedirect("/customer/list");
				
				}
			
	    	}
		}
