package com.kh.jdbc.practice.book.run;

import java.util.List;

import com.kh.jdbc.practice.book.controller.BookController;
import com.kh.jdbc.practice.book.model.vo.Book;
import com.kh.jdbc.practice.book.view.BookView;

public class BookRun {

	public static void main(String [] args) {
		BookView bView = new BookView();
		BookController bCon = new BookController();
		Book book = null;
		List<Book> bList = null;
		int bookNo = 0;
		int result = 0;
		String bookName = null;
		END:
		while(true) {
			int choice = bView.mainMenu();
			switch(choice) {
			case 1:
				// 전체 조회
				bList = bCon.printAll();
				bView.showBookInfo(bList, "전체 도서");
				break;
			case 2:
				//도서 번호로 조회
				bookNo = bView.printInputNo("조회");
				book = bCon.selectByNo(bookNo);
				bView.showOneBook(book);
				break;
			case 3:
				//도서 제목으로 조회
				bList = bCon.selectByName(bookName);
				bookName = bView.printInputName();
				if(!bList.isEmpty()) {
					bView.showBookInfo(bList, "도서");
				}
				else {
					bView.printMessage("일치하는 도서가 없습니다.");
				}
				break;
			case 4:
				//도서 등록
				book = bView.inputBook();
				result = bCon.registerBook(book);
				if(result > 0) {
					bView.printMessage("도서 등록 성공");
				}
				else {
					bView.printMessage("도서 등록 실패");
				}
				break;
			case 5:
				bookNo = bView.printInputNo("삭제");
				result = bCon.removeBook(bookNo);
				if(result > 0) {
					bView.printMessage("도서 삭제 성공");
				}
				else {
					bView.printMessage("도서 삭제 실패");
				}
				break;
			case 6:
				bookNo = bView.printInputNo("대여");
				book = bCon.selectByNo(bookNo);
				if(book != null) {
					book = bView.modifyRental(book);
					bCon.modifyBook(book);
				}
				else {
					bView.printMessage("대여 실패");
				}
				break;
			case 0:
				break END;
			default:
				break;
			}
		}
	}
}
