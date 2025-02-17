package com.mybatis.library.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mybatis.customer.model.vo.Customer;
import com.mybatis.library.model.vo.Library;
import com.mybatis.library.model.vo.Search;


public class LibraryDAO {

	public List<Library> selectList(SqlSession session) {
		List<Library> lList = session.selectList("LibraryMapper.selectList");
		return lList;
	}

	public int selectBookNo(SqlSession session, String bName) {
		int result = session.selectOne("LibraryMapper.selectBookNo", bName);
		return result;
	}

	public int deleteLibrary(SqlSession session, int leaseNo) {
		int result = session.delete("LibraryMapper.deleteLibrary", leaseNo);
		return result;
	}

	public int insertLibrary(SqlSession session, Library library) {
		int result = session.insert("LibraryMapper.insertLibrary", library);
		return result;
	}

//	public List<Library> selectSearchList(SqlSession session, Search search) {
//		List<Library> searchList = session.selectList("LibraryMapper.selectSearchList", search);
//		return searchList;
//	}
//	public List<Library> selectList(SqlSession session, int currentPage) {
//		int limit = 10;
//		int offset = (currentPage-1)*limit;
//		// currentPage가 1이면 offset은 0
//		// currnetPage가 2이면 offset은 10
//		// currentPage가 3이면 offset은 20
//		RowBounds rowBounds = new RowBounds(offset, limit);
////		List<Notice> nList = session.selectList("NoticeMapper.selectList");
//		List<Library> lList = session.selectList("LibraryMapper.selectList", null, rowBounds);
//		return lList;
//	}
//
//	public Library selectOneByNo(SqlSession session, int noticeNo) {
//		Library notice = session.selectOne("LibraryMapper.selectOneByNo", noticeNo);
//		return notice;
//	}
//
//	public int getTotalCount(SqlSession session) {
//		int totalCount = session.selectOne("LibraryMapper.getTotalCount");
//		return totalCount;
//	}
}
