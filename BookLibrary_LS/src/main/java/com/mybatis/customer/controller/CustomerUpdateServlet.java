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
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/customer/update")
public class CustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdateServlet() {
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
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String userName = request.getParameter("userName");
		String addr = request.getParameter("addr");
		Customer customer = new Customer(userNo, userName, addr);
		CustomerService cService = new CustomerService();
		int result = cService.updateCustomer(customer);
		
		if(result > 0) {
			customer = cService.selectOneByUserNo(userNo);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("/WEB-INF/views/customer/detail.jsp").forward(request, response);
		}else {
			NavigationUtil.navigateToError(request, response, "404", "데이터가 존재하지 않습니다.");
		}
        	
        
	}

}
