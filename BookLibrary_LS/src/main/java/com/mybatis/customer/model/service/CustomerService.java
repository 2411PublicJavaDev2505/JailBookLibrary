package com.mybatis.customer.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.common.SqlSessionTemplate;
import com.mybatis.customer.model.dao.CustomerDAO;
import com.mybatis.customer.model.vo.Customer;
import com.mybatis.customer.model.vo.SearchVO;

public class CustomerService {
	
	private CustomerDAO cDao;
	private SqlSession session;
	
	public CustomerService() {
		cDao = new CustomerDAO();
		session = SqlSessionTemplate.getSqlSession();
	}
	
	public List<Customer> selectCustomerList(int currentPage) {
		List<Customer> cList = cDao.selectCustomerList(session, currentPage);
		return cList;
	}
	
	public List<Customer> selectCustomerSearch(int currentPage, SearchVO searchVO) {
		List<Customer> cList = cDao.selectCustomerSearch(session, currentPage, searchVO);
		return cList;
	}
	
	public int getTotalCount() {
		int totalCount = cDao.getTotalCount(session);
		return totalCount;
	}
	
	public int insertCustomer(Customer customer) {
		return cDao.insertcustomer(session, customer);
	}

	public Customer selectOneByUserNo(int userNo) {
		return cDao.selectOneByUserNo(session, userNo);
	}


	public int updateCustomer(Customer Customer) {
		int result = cDao.updateCustomer(session, Customer);
		return result;
	}

	public int deleteById(String userId) {
		int result = cDao.deleteById(session, userId);
		return result;
	}

	public int getSearchListSize(SearchVO searchVO) {
		return cDao.getSearchListSize(session, searchVO);
	}

	public Customer selectOneById(String userId) {
		return cDao.selectOneById(session, userId);
	}

	

	

}
