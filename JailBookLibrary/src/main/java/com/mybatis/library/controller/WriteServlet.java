package com.mybatis.library.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.mybatis.library.model.service.LibraryService;
import com.mybatis.library.model.vo.Library;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/library/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/library/write.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibraryService lService = new LibraryService();
		String bName = request.getParameter("bookName");
		int leaseNo = Integer.parseInt(request.getParameter("leaseNo"));
		int bookNo = lService.selectBookNo(bName);
		String userId = request.getParameter("userId");
		Library library = new Library(leaseNo, bookNo, userId);
		int result = lService.insertLibrary(library);
		if(result > 0) {
			response.sendRedirect("/library/list");
		}else {
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
			.forward(request, response);
		}
	}

}
