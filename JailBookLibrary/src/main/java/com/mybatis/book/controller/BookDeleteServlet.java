package com.mybatis.book.controller;

import java.io.IOException;

import com.mybatis.book.service.BookService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookDeleteServlet
 */
@WebServlet("/book/delete")
public class BookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookService bService = new BookService();
		int bookNo = (request.getParameter("bookNo") != null)
				? Integer.parseInt(request.getParameter("bookNo")) : 0;
		//int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		int result = bService.deleteBook(bookNo);
		if(result > 0) {
			//성공시 리스트페이지로이동
			response.sendRedirect("/book/list");
		}else {
			//실패시 에러페이지로 이동!
			request.getRequestDispatcher("")
			.forward(request, response);
		}
	}

}
