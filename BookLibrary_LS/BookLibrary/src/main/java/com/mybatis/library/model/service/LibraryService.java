package com.mybatis.library.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.common.SqlSessionTemplate;
import com.mybatis.library.model.dao.LibraryDAO;
import com.mybatis.library.model.vo.Library;

public class LibraryService {
	
	private LibraryDAO lDao ;
	private SqlSession session;
	
	public LibraryService() {
		lDao = new LibraryDAO();
		
		session = SqlSessionTemplate.getSqlSession();
	}
	
	public int insertLibrary(Library library) {
		int result = lDao.insertLibrary(session, library);
		return result;
	}

	public List<Library> selectListAll() {
		List<Library> lList = lDao.selectList(session);
		return lList;
	}

	public int deleteLibrary(int leaseNo) {
		int result = lDao.deleteLibrary(session, leaseNo);
		return result;
	}

	public int selectBookNo(String bName) {
		int result = lDao.selectBookNo(session, bName);
		return result;
	}

}
