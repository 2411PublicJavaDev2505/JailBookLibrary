package com.mybatis.book.controller;

import java.io.IOException;
import java.util.List;

import com.mybatis.book.model.vo.Book;
import com.mybatis.book.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/book/list")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 페이징처리할때 mapper에서 resultType부분 있음!!! 그거 vo에있는 book 번호가 int니깐 -int인듯!!
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookService bService = new BookService();
		int totalCount = bService.getTotalCount();
		int boardLimit = 10;
		int maxPage = (int)Math.ceil((double)totalCount/boardLimit);
		
		int currentPage = request.getParameter("currentPage") != null
						? Integer.parseInt(request.getParameter("currentPage")) : 1;
		List<Book> bList = bService.selectListAll(currentPage);
		if(bList.size() > 0) {
			int naviCountPerPage = 5;
			int startNavi = (currentPage-1)/naviCountPerPage*naviCountPerPage+1;
			int endNavi = (startNavi-1) + naviCountPerPage;
			if(endNavi > maxPage) {
				endNavi = maxPage;
			}
			request.setAttribute("bList", bList);
			request.setAttribute("startNavi", startNavi);
			request.setAttribute("endNavi", endNavi);
			request.setAttribute("maxPage", maxPage);
			request.getRequestDispatcher("/WEB-INF/views/book/list.jsp")
			.forward(request, response);
		}else {
			//실패시 에러페이지이동!
			request.getRequestDispatcher("")
			.forward(request, response);
			
		}
	}

}
