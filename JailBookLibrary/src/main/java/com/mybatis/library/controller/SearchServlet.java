package com.mybatis.library.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.mybatis.library.model.service.LibraryService;
import com.mybatis.library.model.vo.Library;
import com.mybatis.library.model.vo.Search;

/**
 * Servlet implementation class SearchServlet
 */
//@WebServlet(name = "lSearchServlet", urlPatterns = { "/library/search" })
//public class SearchServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public SearchServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
////	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////		LibraryService lService = new LibraryService();
//		String searchCondition = request.getParameter("searchCondition");
//		String searchKeyword = request.getParameter("searchKeyword");
//		Search search = new Search(searchCondition, searchKeyword);
//		List<Library> searchList = lService.selectSearchList(search);
//		if(searchList != null && !searchList.isEmpty()) {
//			request.setAttribute("searchList", searchList);
//			request.getRequestDispatcher("/WEB-INF/views/library/search.jsp")
//			.forward(request, response);
//		}else {
//			request.getRequestDispatcher("WEB-INF/views/common/error.jsp")
//			.forward(request, response);
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}
