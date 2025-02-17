package com.ddomybatis.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ddomybatis.member.model.service.MemberService;
import com.ddomybatis.member.model.vo.Member;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/member/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//로그인 과 로그아웃 만들면 회원가입(register서블릿)만들기!!get과 post!!아래코드 작성후
		//아래경로에 폴더랑 만들고 register.jsp를 만들고 밑에 목적지 적어줌!!
		request.getRequestDispatcher("/WEB-INF/views/member/register.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * request.getParameter("");!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * ()안에 작성시 register.jsp 안에 name값을 입력해줘야한다!!!
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//register.jsp만들어주고 연결잘되는지 확인해주고 아래코드작성!!
		//작성시 register.jsp랑 model.vo에 Member 랑일치시켜주는게 좋음!!
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String memberName = request.getParameter("memberName");
		String gender = request.getParameter("gender");
		int age= Integer.parseInt(request.getParameter("age"));
		Member member = new Member(memberId, memberPwd, memberName, gender, age); //5개 만들러!!
		//서비스로 넘겨주는코드!
		MemberService mService = new MemberService();
		int result = mService.insertMember(member);
		if(result > 0) {
			//성공시 메인페이지로 이동
			response.sendRedirect("/");
		}else {
			//실패시 에러페이지로 이동
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
			.forward(request, response);
		}
		
		

	}

}
