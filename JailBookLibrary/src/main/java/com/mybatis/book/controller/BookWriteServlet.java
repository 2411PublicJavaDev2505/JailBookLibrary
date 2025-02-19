package com.mybatis.book.controller;

import java.io.IOException;

import com.mybatis.book.service.BookService;
import com.mybatis.book.model.vo.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookWriteServlet
 */
@WebServlet("/book/write")
public class BookWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/book/write.jsp")
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 번호: <input type="number" name="bookNo"> <br>
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		String bookName = request.getParameter("bookName");
		String bookWrite =request.getParameter("bookWrite");
		int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
		String publisher = request.getParameter("publisher");
		String genre = request.getParameter("genre");
		//Book book = new Book(bookNo, bookName, bookWrite, bookPrice, publisher, genre);
		Book book = new Book(bookName, bookWrite, bookPrice, publisher, genre);
		BookService bService = new BookService();
		int result = bService.insertBook(book);
		if(result > 0) {
			response.sendRedirect("/book/list");
		}else {
			//실패시 에러페이지로이동!!
			request.getRequestDispatcher("")
			.forward(request, response);
		}
		
	}

}
