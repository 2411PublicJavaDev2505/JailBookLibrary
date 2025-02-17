package com.mybatis.book.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mybatis.book.model.vo.Book;

public class BookDAO {
	
	//리스트(전체조회)
	public List<Book> selectList(SqlSession session) {
		// TODO Auto-generated method stub
		int offset = 0;
		int limit = 10;
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
	
}
