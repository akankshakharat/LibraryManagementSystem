package com.akanksha.library.service;
import java.util.List;

import com.akanksha.library.entity.Book;

public interface BookService {
	String addBook(Book book);
	List<Book> getAllBooks();
	Book getBookById(Integer bookId);
	List<Book> getBookByName(String bookName);
	List<Book> getBookByType(String bookType);
	List<Book> getBookByAuthor(String authorName);
	public String updateStock(Book book);
}
