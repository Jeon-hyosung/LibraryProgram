package com.kh.jdbc.practice.book.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.practice.book.model.vo.Book;

public class BookDAO {

	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER = "STUDENT";
	private final String PASSWORD = "STUDENT";
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	
	public List<Book> selectAll() {
		String sql = "SELECT * FROM BOOK_TBL ORDER BY BOOK_NO";
		Book book = null;
		List<Book> bList = null;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			bList = new ArrayList<Book>();
			while(rset.next()) {
				book = new Book();
				book.setBookNo(rset.getInt("BOOK_NO"));
				book.setBookName(rset.getString("BOOK_NAME"));
				book.setAuthor(rset.getString("AUTHOR"));
				book.setGenre(rset.getString("GENRE"));
				book.setStockingDate(rset.getDate("STOCKING_DATE"));
				book.setRental(rset.getString("RENTAL"));
				book.setBookLender(rset.getString("BOOK_LENDER"));
				book.setReturnDate(rset.getDate("RETURN_DATE"));
				bList.add(book);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bList;
	}
	
	public Book findByNo(int bookNo) {
		Book book = null;
		String sql = "SELECT * FROM BOOK_TBL WHERE BOOK_NO = '"+bookNo+"'";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			if(rset.next()) {
				book = new Book();
				book.setBookNo(rset.getInt("BOOK_NO"));
				book.setBookName(rset.getString("BOOK_NAME"));
				book.setAuthor(rset.getString("AUTHOR"));
				book.setGenre(rset.getString("GENRE"));
				book.setStockingDate(rset.getDate("STOCKING_DATE"));
				book.setRental(rset.getString("RENTAL"));
				book.setBookLender(rset.getString("BOOK_LENDER"));
				book.setReturnDate(rset.getDate("RETURN_DATE"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public List<Book> findByName(String bookName) {
		Book book = null;
		List<Book> bList = null;
		String sql = "SELECT * FROM BOOK_TBL WHERE BOOK_NAME = '"+bookName+"'";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			bList = new ArrayList<Book>();
			while(rset.next()) {
				book = new Book();
				book.setBookNo(rset.getInt("BOOK_NO"));
				book.setBookName(rset.getString("BOOK_NAME"));
				book.setAuthor(rset.getString("AUTHOR"));
				book.setGenre(rset.getString("GENRE"));
				book.setStockingDate(rset.getDate("STOCKING_DATE"));
				book.setRental(rset.getString("RENTAL"));
				book.setBookLender(rset.getString("BOOK_LENDER"));
				book.setReturnDate(rset.getDate("RETURN_DATE"));
				bList.add(book);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bList;
	}
	
	public int insertBook(Book book) {
		String sql = "INSERT INTO BOOK_TBL VALUES(SEQ_BOOK_NO.NEXTVAL,?,?,?,DEFAULT,'대여가능',NULL,NULL)";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getGenre());
//			pstmt.setString(5, "NULL");
//			pstmt.setString(6, "NULL");
//			pstmt.setDate(7, "SYSDATE + 7");
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteBook(int bookNo) {
		String sql = "DELETE FROM BOOK_TBL WHERE BOOK_NO = ?";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookNo);
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateBook(Book book) {
		String sql = "UPDATE BOOK_TBL SET(?,?) WHERE = ?";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "RENTAL = " + book.getRental());
			pstmt.setString(2, "BOOK_LENDER = " + book.getBookLender());
			pstmt.setString(3, "BOOK_NO = " + book.getBookNo());
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
