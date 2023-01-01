package com.kh.jdbc.practice.book.model.vo;

import java.sql.Date;

public class Book {

	private int bookNo;
	private String bookName;
	private String author;
	private String genre;
	private Date stockingDate;
	private String rental;
	private String bookLender;
	private Date returnDate;
	
	public Book() {}
	
	public Book(int bookNo, String bookName, String author, String genre, Date stockingDate, String rental,
			String bookLender, Date returnDate) {
		super();
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.author = author;
		this.genre = genre;
		this.stockingDate = stockingDate;
		this.rental = rental;
		this.bookLender = bookLender;
		this.returnDate = returnDate;
	}
	
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getStockingDate() {
		return stockingDate;
	}
	public void setStockingDate(Date stockingDate) {
		this.stockingDate = stockingDate;
	}
	public String getRental() {
		return rental;
	}
	public void setRental(String rental) {
		this.rental = rental;
	}
	public String getBookLender() {
		return bookLender;
	}
	public void setBookLender(String bookLender) {
		this.bookLender = bookLender;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", bookName=" + bookName + ", author=" + author + ", genre=" + genre
				+ ", stockingDate=" + stockingDate + ", rental=" + rental + ", bookLender=" + bookLender
				+ ", returnDate=" + returnDate + "]";
	}
	
	
	
}
