package com.mybatis.book.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.book.model.dao.BookDAO;
import com.mybatis.book.model.vo.Book;
import com.mybatis.book.model.vo.SearchVo;
import com.mybatis.common.SqlSessionTemplate;

public class BookService {
	
	private BookDAO bDao;
	
	private SqlSession session;
	
	public BookService() {
		bDao = new BookDAO();
		session = SqlSessionTemplate.getSqlSession();
	}
	//1.list서블릿에서 넘어옴!!(전체조회)
	public List<Book> selectListAll(int currentPage) {
		// TODO Auto-generated method stub
		List<Book> bList = bDao.selectList(session,currentPage);
		return bList;
	}
	//2.write서블릿에서~!
	public int insertBook(Book book) {
		int result = bDao.insertBook(session,book);
		return result;
	}
	//modify서블릿에서!(수정)doget에서!!(순서는바뀌었지만 detail에서!
	public Book selectOneByNo(int bookNo) {
		// TODO Auto-generated method st
		Book book = bDao.selectOneByNo(session, bookNo);
		return book;
	}
	//modify서블릿(수정)dopost
	public int updateBook(Book book) {
		// TODO Auto-generated method stub
		int result = bDao.updateBook(session,book);
		return result;
	}
	//책삭제
	public int deleteBook(int bookNo) {
		// TODO Auto-generated method stub
		int result = bDao.deleteBook(session,bookNo);
		return result;
	}
	//서치 서블릿에서!!
	public List<Book> selectSearchList(SearchVo search) {
		// TODO Auto-generated method stub
		List<Book> searchList = bDao.selectSearchList(session, search);
		return searchList;
	}
	//리스트서블릿(페이징처리)
	public int getTotalCount() {
		// TODO Auto-generated method stub
		int totalCount = bDao.getTotalCount(session);
		return totalCount;
	}
	
}
