package com.mybatis.customer.controller;

import java.io.IOException;
import java.util.List;

import com.mybatis.customer.model.service.CustomerService;
import com.mybatis.customer.model.vo.Customer;
import com.mybatis.customer.model.vo.SearchVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/customer/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	 public SearchServlet() {
	        super();
	 }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerService cService = new CustomerService();
        String searchCondition = request.getParameter("searchCondition");
        String searchKeyword = request.getParameter("searchKeyword");
        SearchVO search = new SearchVO(searchCondition, searchKeyword);
        List<Customer> searchList = cService.selectSearchList(search);
      
        if(searchList != null && !searchList.isEmpty()) {
			int totalCount = cService.getTotalCount();
			int boardLimit = 10;
			int maxPage = (int)Math.ceil((double)totalCount/boardLimit);
			int currentPage = request.getParameter("currentPage") != null 
						? Integer.parseInt(request.getParameter("currentPage")) : 1;
			int naviCountPerPage = 5;
			int startNavi = (currentPage-1)/naviCountPerPage*naviCountPerPage+1;
			int endNavi = (startNavi-1) + naviCountPerPage;
			if(endNavi > maxPage) {
				endNavi = maxPage;
			}
	        request.setAttribute("searchList", searchList);
			request.setAttribute("startNavi", startNavi);
			request.setAttribute("endNavi", endNavi);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("searchKeyword", searchKeyword);
			request.setAttribute("searchCondition", searchCondition);
        
        request.getRequestDispatcher("/WEB-INF/views/customer/Search.jsp").forward(request, response);
        }else {
        	request.getRequestDispatcher("/WEB-INF/views/notice/error.jsp")
			.forward(request, response);
        	
        }
       }
     }

