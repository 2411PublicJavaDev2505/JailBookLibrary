package com.ddomybatis.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.ddomybatis.member.model.service.MemberService;
import com.ddomybatis.member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 사용자가 입력한 아이디, 패스워드를 받아야함
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		Member member = new Member(memberId, memberPw);
		//2. Service -DAO를 거쳐서 아이디, 패스워드로 검색되는 데이터가 있는지 확인(비지니스 로직)
		MemberService mService = new MemberService();
		Member result = mService.selectOneByLogin(member);
		//3. 결과값에 따른 페이지 이동(리다이렉트,에러페이지)
		if(result != null) {
			//성공시 메인페이지로 이동 -> 리다이렉션
			//세션에 로그인 정보 저장(인증정보저장)
			HttpSession session = request.getSession();
			session.setAttribute("memberId", result.getMemberId());;
			session.setAttribute("memberName", result.getMemberName());
			response.sendRedirect("/");
		}else {
			//실패시 에러페이지로 이동 --> error.jsp로 이동
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
			.forward(request, response);
		}
		
	}

}
