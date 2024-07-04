package com.akanksha.library.service;
import java.util.List;

import com.akanksha.library.dao.BookDao;
import com.akanksha.library.dao.BookDaoImpl;
import com.akanksha.library.entity.Book;

public class BookServiceImpl implements BookService{
	BookDao bookDao=new BookDaoImpl();

	@Override
	public String addBook(Book book) {
		return bookDao.addBook(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	public Book getBookById(Integer bookId) {
		return bookDao.getBookById(bookId);
	}

	@Override
	public List<Book> getBookByName(String bookName) {
		return bookDao.getBookByName(bookName);
	}

	@Override
	public List<Book> getBookByType(String bookType) {
		return bookDao.getBookByType(bookType);
	}

	@Override
	public String updateStock(Book book) {
		return bookDao.updateStock(book);
	}

	@Override
	public List<Book> getBookByAuthor(String authorName) {
		return bookDao.getBookByAuthor(authorName);
	}

	
}
