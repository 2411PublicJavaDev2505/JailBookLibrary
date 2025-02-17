package com.mybatis.customer.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import com.mybatis.book.model.vo.Book;
import com.mybatis.common.NavigationUtil;
import com.mybatis.customer.model.service.CustomerService;
import com.mybatis.customer.model.vo.Customer;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/customer/detail")
public class CustomerDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		Customer customer = new CustomerService().selectOneByUserNo(userNo);
		if(customer != null) {
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("/WEB-INF/views/customer/detail.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/customer/error.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
        String userName = request.getParameter("userName");
        int userAge = Integer.parseInt(request.getParameter("userAge"));
        String addr = request.getParameter("addr");
        String gender = request.getParameter("gender");

        Customer Customer = new Customer(userId, userName, userAge, addr, gender);
        CustomerService cService = new CustomerService();
        int result = cService.insertCustomer(Customer);
        if(result >0) {
        	response.sendRedirect("/customer/list");
        }else {
        	NavigationUtil.navigateToError(request, response, "404", "데이터가 존재하지 않습니다.");
        }
        
	}

}