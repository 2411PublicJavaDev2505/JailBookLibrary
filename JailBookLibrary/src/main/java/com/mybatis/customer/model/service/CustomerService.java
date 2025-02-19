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

		public int getSearchListSize(SearchVO searchVO) {
			return cDao.getSearchListSize(session, searchVO);
		}

		public int updateCustomer(Customer customer) {
			return cDao.updateCustomer(session, customer);
		}

		public Customer selectOneByUserNo(int userNo) {
			return cDao.selectOneByUserNo(session, userNo);
		}

		public int insertCustomer(Customer customer) {
			return cDao.insertCustomer(session, customer);
		}

		public int deleteByNo(int userNo) {
			return cDao.deleteByNo(session, userNo);
		}

		
		
	
	

}
