package com.kh.jdbc.practice.book.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.practice.book.model.vo.Book;

public class BookView {

	public int mainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== === 도서 관리 프로그램 === ===");
		System.out.println("1. 전체 도서 목록");
		System.out.println("2. 도서 번호로 조회");
		System.out.println("3. 도서 제목으로 조회");
		System.out.println("4. 도서 등록");
		System.out.println("5. 도서 삭제");
		System.out.println("6. 도서 대여");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		int choice = sc.nextInt();
		return choice;
	}
	
	public void showBookInfo(List<Book> book, String Message) {
		System.out.println("=== === "+ Message +"조회 === ===");
		for(Book bOne : book) {
			System.out.print("도서 번호 : " + bOne.getBookNo());
			System.out.print(", 도서 제목 : " + bOne.getBookName());
			System.out.print(", 저자 : " + bOne.getAuthor());
			System.out.print(", 장르 : " + bOne.getGenre());
			System.out.print(", 입고일 : " + bOne.getStockingDate());
			System.out.print(", 대여 여부 : " + bOne.getRental());
			System.out.print(", 대여자 : " + bOne.getBookLender());
			System.out.println(", 반납 날짜 : " + bOne.getReturnDate());
		}
	}
	
	public void showOneBook(Book book) {
		System.out.print("도서 번호 : " + book.getBookNo());
		System.out.print(", 도서 제목 : " + book.getBookName());
		System.out.print(", 저자 : " + book.getAuthor());
		System.out.print(", 장르 : " + book.getGenre());
		System.out.print(", 입고날짜 : " + book.getStockingDate());
		System.out.print(", 대여여부 : " + book.getRental());
		System.out.print(", 대여자 : " + book.getBookLender());
		System.out.println(", 반납기한 : " + book.getReturnDate());
	}
	public Book addBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== === === 도서 정보 입력 === ==== ===");
		System.out.print("도서 제목 : ");
		String bookName = sc.next();
		System.out.print("저자 : ");
		sc.nextLine();
		String author = sc.nextLine();
		System.out.print("장르 : ");
		String genre = sc.next();
		
		Book book = new Book();
		book.setBookName(bookName);
		book.setAuthor(author);
		book.setGenre(genre);	
		return book;
	}
	
	public Book modifyRental(Book book) {
		Scanner sc = new Scanner(System.in);
		System.out.print("대여(대여중 입력) : ");
		//sc.nextLine();
		String rental = sc.nextLine();
		System.out.print("대여자 이름 : ");
		String bookLender = sc.nextLine();
			
		book = new Book();
		book.setRental(rental);
		book.setBookLender(bookLender);
		return book;
	}
	
	public int printInputNo(String Message) {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== === 도서 번호로 조회 === ===");
		System.out.print(Message + "할 도서 번호 입력 : ");
		int bookNo = sc.nextInt();
		return bookNo;
	}
	
	public String printInputName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== === 도서 제목으로 조회 === ===");
		System.out.print("조회할 도서 제목 입력 : ");
		String bookName = sc.next();
		return bookName;
	}
	
	
	public void printMessage(String Message) {
		System.out.println("[처리 결과] : " + Message);
	}
	
	
	
	
	
	
}
