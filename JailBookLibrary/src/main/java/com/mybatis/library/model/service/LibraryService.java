package com.mybatis.library.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.common.SqlSessionTemplate;
import com.mybatis.customer.model.vo.Customer;
import com.mybatis.library.model.dao.LibraryDAO;
import com.mybatis.library.model.vo.Library;
import com.mybatis.library.model.vo.Search;


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

//	public List<Library> selectSearchList(Search search) {
//		List<Library> searchList = lDao.selectSearchList(session, search);
//		return searchList;
//	}

//	public List<Library> selectListAll(int currentPage) {
//		List<Library> lList = lDao.selectList(session, currentPage);
//		return lList;
//	}
//
//	public Library selectOneByNo(int noticeNo) {
//		Library notice = lDao.selectOneByNo(session, noticeNo);
//		return notice;
//	}
//
//	public int getTotalCount() {
//		int totalCount = lDao.getTotalCount(session);
//		return totalCount;
//	}

}
