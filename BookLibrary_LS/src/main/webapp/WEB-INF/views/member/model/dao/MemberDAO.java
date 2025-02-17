package com.ddomybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.ddomybatis.member.model.vo.Member;

public class MemberDAO {
	
	//window->perspective에서 숏컷?들어가면 xml파일등
	// 설정방법있음!
	//Service에서 넘어옴!로그인!
	public Member selectOneByLogin(SqlSession session, Member member) {
		Member result = session.selectOne("MemberMapper.selectOneByLogin",member);
		return result;
	}
	//Service에서 넘어옴!! 회원가입
	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember",member); //()안에 누락주의!!!
		return result;
	}

}
