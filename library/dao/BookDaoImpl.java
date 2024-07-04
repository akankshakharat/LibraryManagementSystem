package com.akanksha.library.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.akanksha.library.entity.Book;

public class BookDaoImpl implements BookDao {
	EntityManager entityManager = MyConnection.getEntityManagerObject();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	Query query;

	@Override
	public String addBook(Book book) {
		entityTransaction.begin();
		entityManager.persist(book);
		entityTransaction.commit();
		return "Book Registered";
	}

	@Override
	public List<Book> getAllBooks() {
		String jpql = "select b from Book b";
		query = entityManager.createQuery(jpql);
		List<Book> list = query.getResultList();
		return list;

	}

	@Override
	public Book getBookById(Integer bookId) {
		Book book = entityManager.find(Book.class, bookId);
		return book;
	}

	@Override
	public List<Book> getBookByName(String bookName) {
		// "select b from Book b where b.bookName like "+bookName+"%"
		String jpql = "SELECT b FROM Book b WHERE b.bookName LIKE :bookName";
		query = entityManager.createQuery(jpql);
		query.setParameter("bookName", "%" + bookName + "%");
		List<Book> list = query.getResultList();
		return list;
	}

	@Override
	public List<Book> getBookByType(String bookType) {
		String jpql = "SELECT b FROM Book b WHERE b.bookType LIKE :bookType";
		query = entityManager.createQuery(jpql);
		query.setParameter("bookType", "%" + bookType + "%");
		List<Book> list = query.getResultList();
		return list;
	}

	@Override
	public String updateStock(Book book) {
		entityTransaction.begin();
		query = entityManager.createQuery("update Book b set b.quantity=b.quantity+?1 where b.bookId=?2");
		query.setParameter(1, book.getQuantity());
		query.setParameter(2, book.getBookId());
		query.executeUpdate();
		entityTransaction.commit();
		entityManager.clear();
		return "Stock updated";
	}

	@Override
	public List<Book> getBookByAuthor(String authorName) {
		String jpql = "select b from Book b where b.authorName=?1";
		query = entityManager.createQuery(jpql);
		query.setParameter(1, authorName);
		List<Book> list = query.getResultList();
		return list;
	}

}
