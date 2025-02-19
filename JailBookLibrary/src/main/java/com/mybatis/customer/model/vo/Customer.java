package com.mybatis.customer.model.vo;

import java.sql.Date;

public class Customer {
	private int userNo;
    private String userId;
    private String userPw;
    private String userName;
    private int userAge;
    private String addr;
    private String gender;
    private Date enrollDate;
    
    
    
	public Customer(int userNo, String userName, String addr) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.addr = addr;
	}
	
	
	
	public Customer(int userNo, String userId, String userName, int userAge, String addr, String gender) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
		this.addr = addr;
		this.gender = gender;
	}



	public Customer(String userId, String userPw, String userName, int userAge, String addr, String gender) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userAge = userAge;
		this.addr = addr;
		this.gender = gender;
	}
	/**
	 * @return the userNo
	 */
	public int getUserNo() {
		return userNo;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @return the userPw
	 */
	public String getUserPw() {
		return userPw;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @return the userAge
	 */
	public int getUserAge() {
		return userAge;
	}
	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @return the enrollDate
	 */
	public Date getEnrollDate() {
		return enrollDate;
	}
	
	
	
	@Override
	public String toString() {
		return "Customer [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", userAge=" + userAge + ", addr=" + addr + ", gender=" + gender + ", enrollDate=" + enrollDate + "]";
	}
	
    
    

}
