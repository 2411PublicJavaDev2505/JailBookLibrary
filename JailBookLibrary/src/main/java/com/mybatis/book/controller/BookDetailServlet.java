package com.mybatis.book.controller;

import java.io.IOException;


import com.mybatis.book.model.vo.Book;
import com.mybatis.book.service.BookService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookDetailServlet
 */
@WebServlet("/book/detail") //수정삭제!!
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookService bService = new BookService();
		//에러나면 밑에 코드 다시 보기!!
		int bookNo = (request.getParameter("bookNo") != null)
				? Integer.parseInt(request.getParameter("bookNo")) : 1;
		Book book = bService.selectOneByNo(bookNo);
		if(book != null) {
			request.setAttribute("book", book);
			request.getRequestDispatcher("/WEB-INF/views/book/detail.jsp")
			.forward(request, response);
		}else {
			//실패시 에러페이지이동!!
			request.getRequestDispatcher("")
			.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		String bookName = request.getParameter("bookName");
		String bookWrite =request.getParameter("bookWrite");
		int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
		String publisher = request.getParameter("publisher");
		String genre = request.getParameter("genre");
		//생성자!!
		Book book = new Book(bookNo, bookName, bookWrite, bookPrice, publisher, genre);
		int result = new BookService().updateBook(book);
		//System.out.println("테스트");
		if(result > 0) {
			//System.out.println("테스트2");
			response.sendRedirect("/book/list");
		}else {
			//실패시 에러페이지이동
			request.getRequestDispatcher("")
			.forward(request, response);
		}
	}

}
