package com.mybatis.library.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Library {
	private int leaseNo;
	private int bookNo;
	private String bookName;
	private String userId;
	private Date leaseDate;
	private Date returnDate;

	public Library() {}

	public Library(int leaseNo, int bookNo, String userId, Date leaseDate, Date returnDate) {
		super();
		this.leaseNo = leaseNo;
		this.bookNo = bookNo;
		this.userId = userId;
		this.leaseDate = leaseDate;
		this.returnDate = returnDate;
	}

	
	public Library(int leaseNo, int bookNo, String userId) {
		super();
		this.leaseNo = leaseNo;
		this.bookNo = bookNo;
		this.userId = userId;
	}

	
	
	public Library(int leaseNo, String bookName, String userId) {
		super();
		this.leaseNo = leaseNo;
		this.bookName = bookName;
		this.userId = userId;
	}

	public int getLeaseNo() {
		return leaseNo;
	}

	public int getBookNo() {
		return bookNo;
	}

	public String getBookName() {
		return bookName;
	}

	public String getUserId() {
		return userId;
	}

	public Date getLeaseDate() {
		return leaseDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	@Override
	public String toString() {
		return "Library [leaseNo=" + leaseNo + ", bookNo=" + bookNo + ", bookName=" + bookName + ", userId=" + userId
				+ ", leaseDate=" + leaseDate + ", returnDate=" + returnDate + "]";
	}


	
}



