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

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/library/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibraryService lService = new LibraryService();
		List<Library> lList = lService.selectListAll();
		if(lList.size() > 0) {
			request.setAttribute("lList", lList);
			request.getRequestDispatcher("/WEB-INF/views/library/list.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}
}
