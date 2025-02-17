package com.mybatis.library.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.library.model.vo.Library;

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

}
