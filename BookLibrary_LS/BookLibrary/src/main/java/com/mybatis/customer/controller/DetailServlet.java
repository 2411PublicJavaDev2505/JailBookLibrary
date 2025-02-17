package com.mybatis.customer.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.mybatis.book.model.service.BookService;
import com.mybatis.book.model.vo.Book;
import com.mybatis.customer.model.service.CustomerService;
import com.mybatis.customer.model.vo.Customer;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/customer/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService cService = new CustomerService();
		String userId = request.getParameter("userId");
		if (userId == null || userId.trim().isEmpty()) {
            response.sendRedirect("/customer/list");
            return;
        }else {
        	request.setAttribute("error", "해당 회원 정보를 찾을 수 없습니다.");
        }
		Customer customer = cService.selectOneById(userId);
		request.setAttribute("userId", userId);

		request.getRequestDispatcher("/WEB-INF/views/customer/detail.jsp")
		.forward(request, response);
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
        int result = cService.addCustomer(Customer);
        if(result >0) {
        	response.sendRedirect("/customer/list");
        }else {
        	request.getRequestDispatcher("/WEB-INF/views/error.jsp")
			.forward(request, response);
        }
        
	}

}