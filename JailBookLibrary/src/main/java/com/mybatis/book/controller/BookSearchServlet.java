package com.mybatis.book.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.mybatis.book.service.BookService;
import com.mybatis.book.model.vo.Book;
import com.mybatis.book.model.vo.SearchVo;

/**
 * Servlet implementation class BookSearchServlet
 */
@WebServlet("/book/search")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bService = new BookService();
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");
		SearchVo search = new SearchVo(searchCondition, searchKeyword);
		List<Book> searchList = bService.selectSearchList(search);
		if(searchList != null && !searchList.isEmpty()) {
			//성공시 검색결과 페이지로이동!!
			int totalCount = bService.getTotalCount();
			int boardLimit = 10;
			int maxPage = (int)Math.ceil((double)totalCount/boardLimit);
			int currentPage = request.getParameter("currentPage") != null
					? Integer.parseInt(request.getParameter("currentPage")) :1;
			
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
			request.getRequestDispatcher("/WEB-INF/views/book/search.jsp")
			.forward(request, response);
		}else {
			//실패시 에러페이지 이동
			request.getRequestDispatcher("")
			.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
