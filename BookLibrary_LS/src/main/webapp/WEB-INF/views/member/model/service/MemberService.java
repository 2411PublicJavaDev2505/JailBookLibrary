package com.ddomybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.ddomybatis.common.SqlSessionTemplate;
import com.ddomybatis.member.model.dao.MemberDAO;
import com.ddomybatis.member.model.vo.Member;

public class MemberService {
	
	
	
	//1.밑에 코드적고 MemberDAO 만들고 임포트!
	private MemberDAO mDao;
	
	//**서비스가 사용될!!
	private SqlSession session;
	
	//2.서비스 만들고 안에 MemberDAO넣기 
	public MemberService() {
		mDao = new MemberDAO();
		
		//멤버변수
		session = SqlSessionTemplate.getSqlSession();
	}
	
	
	//loginServlet에서 넘어옴 로그인!!
	public Member selectOneByLogin(Member member) {
		// TODO Auto-generated method stub
		//3.lib에 마이바티스 파일넣어주고 아래코드 적고 아이바티스로 임포트후
		//SqlSessionTemplate 클래스 만들어주기 그리고 아래코드는
		//쓸필요가 없으니 지워준다!주석처리함!
	//	SqlSession session = null;
		Member result = mDao.selectOneByLogin(session, member);
		
		return result;
	}

	//RegisterServlet에서 넘어옴(회원가입)
	//결과는 int로 나옴
	//return 0 -> return result;
	public int insertMember(Member member) {
		//여기선 위에 int니깐 int result로 !!
		int result = mDao.insertMember(session, member);
		return result;
	}

}
