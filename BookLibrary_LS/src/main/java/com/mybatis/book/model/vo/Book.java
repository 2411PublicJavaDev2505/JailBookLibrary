package com.mybatis.book.model.vo;

public class Book {
	private int bookNo; //책번호
	private String bookName; //제목
	private String bookWrite; //글쓴이
	private int bookPrice; //가격
	private String publisher; //출판사
	private String genre; //장르
	
	public Book() {}

	
	//책수정!!
	

	

	//등록!int bookNo, 수정!
	public Book(String bookName, String bookWrite, int bookPrice, String publisher, String genre) {
		super();
		//this.bookNo = bookNo;
		this.bookName = bookName;
		this.bookWrite = bookWrite;
		this.bookPrice = bookPrice;
		this.publisher = publisher;
		this.genre = genre;
	}

	//수정!!
	public Book(int bookNo, String bookName, String bookWrite, int bookPrice, String publisher, String genre) {
		super();
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.bookWrite = bookWrite;
		this.bookPrice = bookPrice;
		this.publisher = publisher;
		this.genre = genre;
	}

	public int getBookNo() {
		return bookNo;
	}

	


	public String getBookName() {
		return bookName;
	}

	public String getBookWrite() {
		return bookWrite;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getGenre() {
		return genre;
	}

	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", bookName=" + bookName + ", bookWrite=" + bookWrite + ", bookPrice="
				+ bookPrice + ", publisher=" + publisher + ", genre=" + genre + "]";
	} 
	
	
}
