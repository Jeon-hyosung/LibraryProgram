package com.kh.jdbc.practice.book.controller;

import java.util.List;

import com.kh.jdbc.practice.book.model.dao.BookDAO;
import com.kh.jdbc.practice.book.model.vo.Book;

public class BookController {

	/**
	 * 도서 전체 조회
	 * @return
	 */
	public List<Book> printAll() {
		BookDAO bDao = new BookDAO();
		List<Book> bList = bDao.selectAll();
		return bList;
	}
	public Book selectByNo(int bookNo) {
		BookDAO bDao = new BookDAO();
		Book book = bDao.findByNo(bookNo);
		return book;
	}
	public List<Book> selectByName(String bookName) {
		BookDAO bDao = new BookDAO();
		List<Book> bList = bDao.findByName(bookName);
		return bList;
	}
	public int registerBook(Book book) {
		BookDAO bDao = new BookDAO();
		int result = bDao.insertBook(book);
		return result;
	}
	public int removeBook(int bookNo) {
		BookDAO bDao = new BookDAO();
		int result = bDao.deleteBook(bookNo);
		return result;
	}
	public int modifyBook(Book book) {
		BookDAO bDao = new BookDAO();
		int result = bDao.updateBook(book);
		return result;
	}
}
