package com.mybatis.book.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mybatis.book.model.vo.Book;
import com.mybatis.book.model.vo.SearchVo;

public class BookDAO {
	
	//리스트(전체조회)
	public List<Book> selectList(SqlSession session, int currentPage) {
		// TODO Auto-generated method stub
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		//List<Book> bList = session.selectList("BookMapper.selectList",session);
		List<Book> bList = session.selectList("BookMapper.selectList",null,rowBounds);
		return bList;
	}
	//책 등록 !!
	public int insertBook(SqlSession session, Book book) {
		int result = session.insert("BookMapper.insertBook",book);
		return result;
	}
	//책수정!!(detail것도!)
	public Book selectOneByNo(SqlSession session, int bookNo) {
		// TODO Auto-generated method stub
		Book book = session.selectOne("BookMapper.selectOneByNo",bookNo);
		return book;
	}
	//책수정!!(dopost)
	public int updateBook(SqlSession session, Book book) {
		// TODO Auto-generated method stub
		int result = session.update("BookMapper.updateBook",book);
		return result;
	}
	//책삭제!
	public int deleteBook(SqlSession session, int bookNo) {
		// TODO Auto-generated method stub
		int result = session.delete("BookMapper.deleteBook",bookNo);
		return result;
	}
	//서치리스트(서비스에서)
	public List<Book> selectSearchList(SqlSession session, SearchVo search) {
		// TODO Auto-generated method stub
		List<Book> searchList = session.selectList("BookMapper.selectSearchList",search);
		return searchList;
	}
	//리스트서블릿(페이징처리)
	public int getTotalCount(SqlSession session) {
		// TODO Auto-generated method stub
		int totalCount = session.selectOne("BookMapper.getTotalCount");
		return totalCount;
	}
	
}
