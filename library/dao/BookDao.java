package com.akanksha.library.dao;
import java.util.List;

import com.akanksha.library.entity.Book;

public interface BookDao {
	String addBook(Book book);
	List<Book> getAllBooks();
	Book getBookById(Integer issueId);
	List<Book> getBookByName(String bookName);
	List<Book> getBookByType(String bookType);
	List<Book> getBookByAuthor(String authorName);
	public String updateStock(Book book);
}

