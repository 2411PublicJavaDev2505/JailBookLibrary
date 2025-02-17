package com.mybatis.customer.controller;

import java.io.IOException;
import java.util.List;

import com.mybatis.customer.model.service.CustomerService;
import com.mybatis.customer.model.vo.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/customer/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService cService = new CustomerService();
		int totalCount = cService.getTotalCount();
		int currentPage = request.getParameter("currentPage") != null 
				? Integer.parseInt(request.getParameter("currentPage")) : 1;
		List<Customer> cList = cService.selectListAll();
		if(cList.size() >0) {
			request.setAttribute("cList", cList);
			request.getRequestDispatcher("/WEB-INF/views/customer/list.jsp").forward(request,response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/customer/error.jsp")
			.forward(request, response);
		}
	}

}
