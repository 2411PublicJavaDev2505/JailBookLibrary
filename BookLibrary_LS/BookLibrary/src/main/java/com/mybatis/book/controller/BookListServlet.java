package com.mybatis.book.controller;

import java.io.IOException;
import java.util.List;

import com.mybatis.book.model.service.BookService;
import com.mybatis.book.model.vo.Book;

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
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookService bService = new BookService();
		List<Book> bList = bService.selectListAll();
		if(bList.size() > 0) {
			request.setAttribute("bList", bList);
			request.getRequestDispatcher("/WEB-INF/views/book/list.jsp")
			.forward(request, response);
		}else {
			//실패시 에러페이지이동!
			request.getRequestDispatcher("")
			.forward(request, response);
			
		}
	}

}
