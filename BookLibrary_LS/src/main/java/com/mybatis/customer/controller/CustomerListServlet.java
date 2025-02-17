package com.mybatis.customer.controller;

import java.io.IOException;
import java.util.List;

import com.mybatis.common.NavigationUtil;
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
public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService cService = new CustomerService();
		int totalCount = cService.getTotalCount();
		int boardLimit = 10;
		int maxPage = (int)Math.ceil((double)totalCount/boardLimit);
		
		int currentPage = request.getParameter("currentPage") != null
				? Integer.parseInt(request.getParameter("currentPage")) : 1;
		List<Customer> cList = cService.selectCustomerList(currentPage);
		if(cList.size() >0) {
			int naviCountPerPage = 5;
			int startNavi = (currentPage-1)/naviCountPerPage*naviCountPerPage+1;
			int endNavi = (startNavi -1) + naviCountPerPage;
			if(endNavi > maxPage) {
				endNavi = maxPage;
			}
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("cList", cList);
			request.setAttribute("startNavi", startNavi);
			request.setAttribute("endNavi", endNavi);
			request.setAttribute("maxPage", maxPage);
			request.getRequestDispatcher("/WEB-INF/views/customer/list.jsp")
			.forward(request, response);
		}else {
			NavigationUtil.navigateToError(request, response, "404", "데이터가 존재하지 않습니다.");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
