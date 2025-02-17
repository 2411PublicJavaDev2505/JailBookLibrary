package com.mybatis.customer.controller;

import java.io.IOException;
import java.util.List;

import com.mybatis.common.NavigationUtil;
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
public class CustomerSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	 public CustomerSearchServlet() {
	        super();
	 }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerService cService = new CustomerService();
        int currentPage = request.getParameter("currentPage") != null
				? Integer.parseInt(request.getParameter("currentPage")) : 1;
        
        String searchCondition = request.getParameter("searchCondition");
        String searchKeyword = request.getParameter("searchKeyword");
        SearchVO searchVO = new SearchVO(searchCondition, searchKeyword);
        int totalCount = cService.getSearchListSize(searchVO);
		int boardLimit = 10;
		int maxPage = (int)Math.ceil((double)totalCount/boardLimit);

		List<Customer> cList = cService.selectCustomerSearch(currentPage, searchVO);
      
        if(cList != null && !cList.isEmpty()) {
        	int naviCountPerPage = 5;
			int startNavi = (currentPage-1)/naviCountPerPage*naviCountPerPage+1;
			int endNavi = (startNavi -1) + naviCountPerPage;
			if(endNavi > maxPage) {
				endNavi = maxPage;
			}
			
			request.setAttribute("startNavi", startNavi);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("endNavi", endNavi);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("cList", cList);
			request.getRequestDispatcher("/WEB-INF/views/customer/search.jsp")
			.forward(request, response);
        }else {
        	NavigationUtil.navigateToError(request, response, "404", "�����Ͱ� �������� �ʽ��ϴ�.");
        	
        }
       }
     }

