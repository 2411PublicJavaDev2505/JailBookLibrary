package com.mybatis.customer.controller;

import java.io.IOException;

import com.mybatis.common.NavigationUtil;
import com.mybatis.customer.model.service.CustomerService;
import com.mybatis.customer.model.vo.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class CustomerAddServlet
 */
@WebServlet("/customer/insert")
public class CustomerInsertServlet extends HttpServlet {
	
		public CustomerInsertServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			CustomerService cService = new CustomerService();
			int userNo = Integer.parseInt(request.getParameter("userNo"));
			String userId = request.getParameter("userId");
	        String userName = request.getParameter("userName");
	        int userAge = Integer.parseInt(request.getParameter("userAge"));
	        String addr = request.getParameter("addr");
	        String gender = request.getParameter("gender");
		
			Customer customer = new Customer(userNo, userId, userName, userAge, addr, gender,null);
			
			int result = cService.insertCustomer(customer);
			if(result > 0) {
				response.sendRedirect("/customer/list");
			}else {
				NavigationUtil.navigateToError(request, response, "404", "데이터가 존재하지 않습니다.");
			}
		}

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.getRequestDispatcher("/WEB-INF/views/customer/insert.jsp").forward(request, response);
	    }
	}