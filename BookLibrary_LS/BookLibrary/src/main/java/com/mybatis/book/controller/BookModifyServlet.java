package com.mybatis.book.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookModifyServlet
 */
@WebServlet("/book/modify")
public class BookModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//BookService bService = new BookService();
		//int BookNo = request.getParameter("BookNo") != null ? Integer.parseInt(request.getParameter("BookNo")) : 1;
		
		//Book book = bService.selectOneByNo(BookNo);
		//if(book != null) {
			//request.setAttribute("book", book);

			//request.getRequestDispatcher("/WEB-INF/views/notice/modify.jsp")
			//.forward(request, response);
		//}else {
			//실패시 에러페이지 이동
			//request.getRequestDispatcher("")
			//.forward(request, response);
	//	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	int bookNo = Integer.parseInt(request.getParameter("bookNo"));
	//	String bookName = request.getParameter("bookName");
	//	String bookWrite =request.getParameter("bookWrite");
	//	int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
	//	String publisher = request.getParameter("publisher");
		//Book book = new Book(bookName, bookWrite, bookPrice, publisher, publisher);
		//int result = new BookService().updateBook(book);
		//if(result > 0) {
			//response.sendRedirect("/book/list");
		//}else {
			//실패시 에러페이지 이동!!
			//request.getRequestDispatcher("")
			//.forward(request, response);
	//	}
	}

}
