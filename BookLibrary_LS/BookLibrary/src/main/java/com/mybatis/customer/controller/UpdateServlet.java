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
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/customer/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			CustomerService cService = new CustomerService();
			String userId = request.getParameter("userId") != null ?  request.getParameter("userId") : "guest";
	        Customer Customer = cService.selectOneById(userId);
	        if(Customer != null) {
	        	request.setAttribute("Customer", Customer);
	        	request.getRequestDispatcher("/WEB-INF/views/Customer/list.jsp").forward(request, response);
	        	
	        }else {
	        	request.getRequestDispatcher("/WEB-INF/views/Customer/error.jsp").forward(request, response);

	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        String userName = request.getParameter("userName");
        int userAge = Integer.parseInt(request.getParameter("userAge"));
        String addr = request.getParameter("addr");
        char gender = request.getParameter("gender").charAt(0);

        Customer Customer = new Customer(userId, userPw, userName, userAge, addr, gender);
        CustomerService cService = new CustomerService();
        int result = cService.updateCustomer(Customer);
        
        if(result >0) {
        	response.sendRedirect("/customer/list");
        	
        }else {
        	request.getRequestDispatcher("/WEB-INF/views/error.jsp")
			.forward(request, response);
        }
	}

}
