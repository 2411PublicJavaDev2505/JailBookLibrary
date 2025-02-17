package com.mybatis.customer.model.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mybatis.customer.model.vo.Customer;
import com.mybatis.customer.model.vo.SearchVO;

public class CustomerDAO {
	private static Connection conn;

	public List<Customer> selectCustomerSearch(SqlSession session, int currentPage, SearchVO searchVO) {
		int limit = 10;
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Customer> cList = session.selectList("CustomerMapper.selectCustomerSearch", searchVO, rowBounds);
		return cList;
	}

	public List<Customer> selectCustomerList(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Customer> cList = session.selectList("CustomerMapper.selectCustomerList", null, rowBounds);
		return cList;
	}

	public int updateCustomer(SqlSession session, Customer customer) {
		int result = session.update("CustomerMapper.updateCustomer", customer);
		return result;
	}

	public int deleteById(SqlSession session, String userId) {
		int result = session.delete("CustomerMapper.deleteById", userId);
		return result;
	}

	public int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("CustomerMapper.getTotalCount");
		return totalCount;
	}

	public Customer selectOneByUserNo(SqlSession session, int userNo) {
		Customer customer = session.selectOne("CustomerMapper.selectOneByUserNo", userNo);
		return customer;
	}

	public Customer selectOneById(SqlSession session, String userId) {
		return session.selectOne("CustomerMapper.selectOneById", userId);
	}

	public int getSearchListSize(SqlSession session, SearchVO searchVO) {
		return session.selectOne("CustomerMapper.getSearchListSize", searchVO);
	}

	public int insertcustomer(SqlSession session, Customer customer) {
		return session.insert("CustomerMapper.insertcustomer", customer);
	}

}