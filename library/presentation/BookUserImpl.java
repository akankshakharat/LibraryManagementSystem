package com.akanksha.library.presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.akanksha.library.entity.Book;
import com.akanksha.library.service.BookService;
import com.akanksha.library.service.BookServiceImpl;

public class BookUserImpl implements BookUser {
	private Scanner scanner = new Scanner(System.in);
	private BookService bookService = new BookServiceImpl();

	@Override
	public void inputAddBook() {
		System.out.println("Enter the Book Name:");
		String bookName = scanner.next();
		System.out.println("Enter the Book Auther Name:");
		String autherName = scanner.next();
		System.out.println("Enter the Book Quantity:");
		int bookQuentity = scanner.nextInt();
		System.out.println("Enter the Book Type:");
		String bookType = scanner.next();

		Book book = new Book();
		book.setBookName(bookName);
		book.setAuthorName(autherName);
		book.setBookType(bookType);
		book.setQuantity(bookQuentity);
		
		System.out.println(bookService.addBook(book));
	}

	@Override
	public void inputGetAllBooks() {
		List<Book> l = bookService.getAllBooks();
		Iterator<Book> itr = l.iterator();
		System.out.println("+--------+----------------------+----------------------+-----------+---------+");
		System.out.println("| BookId | BookName             | AuthorName           | BookType  | Quantity|");
		System.out.println("+--------+----------------------+----------------------+-----------+---------+");

		while (itr.hasNext()) {
		    Book b = itr.next();
		    System.out.printf("| %-6s | %-20s | %-20s | %-9s | %-7s |%n",
		                      b.getBookId(),
		                      b.getBookName(),
		                      b.getAuthorName(),
		                      b.getBookType(),
		                      b.getQuantity());
		}

		System.out.println("+--------+----------------------+----------------------+-----------+---------+");
		

	}

	@Override
	public void inputGetBookById() {
		System.out.println("Enter the Book Id:");
		Integer bookId = scanner.nextInt();
		Book book = bookService.getBookById(bookId);
		if (book != null) {
			System.out.println("+--------+----------------------+----------------------+-----------+---------+");
			System.out.println("| BookId | BookName             | AuthorName           | BookType  | Quantity|");
			System.out.println("+--------+----------------------+----------------------+-----------+---------+");
			System.out.printf("| %-6s | %-20s | %-20s | %-9s | %-7s |%n",
					book.getBookId(),
					book.getBookName(),
					book.getAuthorName(),
					book.getBookType(),
					book.getQuantity());


           System.out.println("+--------+----------------------+----------------------+-----------+---------+");
		} else {
			System.out.println("Book Id not found");
		}
	}

	@Override
	public void inputGetBookByName() {
		System.out.println("Enter the Book Name:");
		String bookName = scanner.next();

		List<Book> books = bookService.getBookByName(bookName);

		if (books.isEmpty()) {
			System.out.println("Book not found");
		} else {
			System.out.println("+--------+----------------------+----------------------+-----------+---------+");
			System.out.println("| BookId | BookName             | AuthorName           | BookType  | Quantity|");
			System.out.println("+--------+----------------------+----------------------+-----------+---------+");
			for (Book book : books) {
				System.out.printf("| %-6s | %-20s | %-20s | %-9s | %-7s |%n",
						book.getBookId(),
						book.getBookName(),
						book.getAuthorName(),
						book.getBookType(),
						book.getQuantity());


	           System.out.println("+--------+----------------------+----------------------+-----------+---------+");
			}
		}
	}

	@Override
	public void inputGetBookByType() {
		System.out.println("Enter the Book Type:");
		String bookType = scanner.next();

		List<Book> books = bookService.getBookByType(bookType);

		if (books.isEmpty()) {
			System.out.println("Book not found");
		} else {
			System.out.println("+--------+----------------------+----------------------+-----------+---------+");
			System.out.println("| BookId | BookName             | AuthorName           | BookType  | Quantity|");
			System.out.println("+--------+----------------------+----------------------+-----------+---------+");
			for (Book book : books) {
				System.out.printf("| %-6s | %-20s | %-20s | %-9s | %-7s |%n",
						book.getBookId(),
						book.getBookName(),
						book.getAuthorName(),
						book.getBookType(),
						book.getQuantity());


	           System.out.println("+--------+----------------------+----------------------+-----------+---------+");
			}
		}
	}

	@Override
	public void inputUpdateStock() {
		System.out.println("Enter the Book Id::");
		Integer bookId = scanner.nextInt();
		System.out.println("Enter the Book Quantity::");
		Integer quentity = scanner.nextInt();

		Book book = new Book();

		book.setBookId(bookId);
		book.setQuantity(quentity);
		System.out.println(bookService.updateStock(book));
	}

	@Override
	public void inputGetBookByAuthor() {
		System.out.println("Enter the Book Author:");
		String authorName = scanner.next();

		List<Book> books = bookService.getBookByAuthor(authorName);

		if (books.isEmpty()) {
			System.out.println("Book not found");
		} else {
			System.out.println("+--------+----------------------+----------------------+-----------+---------+");
			System.out.println("| BookId | BookName             | AuthorName           | BookType  | Quantity|");
			System.out.println("+--------+----------------------+----------------------+-----------+---------+");
			for (Book book : books) {
				System.out.printf("| %-6s | %-20s | %-20s | %-9s | %-7s |%n",
						book.getBookId(),
						book.getBookName(),
						book.getAuthorName(),
						book.getBookType(),
						book.getQuantity());


	           System.out.println("+--------+----------------------+----------------------+-----------+---------+");

			}
		}
	}

}
