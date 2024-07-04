package com.akanksha.library.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.akanksha.library.entity.BookIssue;

public class BookIssueDaoImpl implements BookIssueDao {
	EntityManager entityManager = MyConnection.getEntityManagerObject();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	Query query;

	@Override
	public String issueBook(BookIssue bookIssue) {
		entityTransaction.begin();
		entityManager.persist(bookIssue);
		entityTransaction.commit();
		return "Book issue request sended to the Admin";
	}

	@Override
	public List<BookIssue> returnBook(BookIssue bookIssue) {
		String jpql = "select bi from BookIssue bi where bi.bookStatus='RETURN'";
		query = entityManager.createQuery(jpql);
		List<BookIssue> list = query.getResultList();
		return list;
	}

	@Override
	public List<BookIssue> getIssuedBook() {
		String jpql = "select bi from BookIssue bi where bi.bookStatus='ISSUED'";
		query = entityManager.createQuery(jpql);
		List<BookIssue> list = query.getResultList();
		return list;
	}

	@Override
	public BookIssue getBookIssuedById(Integer issueId) {
		BookIssue bookIssue = entityManager.find(BookIssue.class, issueId);
		return bookIssue;

	}

	@Override
	public List<BookIssue> displayUnIssueBook() {
		String jpql = "SELECT bi FROM BookIssue bi WHERE bi.bookStatus = 'NOT ISSUED'";
		query = entityManager.createQuery(jpql);
		List<BookIssue> list = query.getResultList();
		return list;
	}

	@Override
	public BookIssue findRecordByIssueId(Integer issueId) {
		return entityManager.find(BookIssue.class, issueId);
	}

	@Override
	public String confirmIssueBook(BookIssue bookIssue) {
		BookIssue bookIssue1 = entityManager.find(BookIssue.class, bookIssue.getIssueId());
		entityTransaction.begin();
		bookIssue.setBookStatus(bookIssue.getBookStatus());
		entityTransaction.commit();
		entityManager.clear();
		return "Book is Confirmed";
	}

	@Override
	public List<BookIssue> displayreturnedBook() {
		String jpql = "select bi from BookIssue bi where bi.bookStatus='RETURNED'";
		query = entityManager.createQuery(jpql);
		List<BookIssue> list = query.getResultList();
		return list;
	}

	@Override
	public List<BookIssue> displayUnreturnedBook() {
		String jpql = "SELECT bi FROM BookIssue bi WHERE bi.bookStatus = 'NOT RETURNED'";
		query = entityManager.createQuery(jpql);
		List<BookIssue> list = query.getResultList();
		return list;
	}

	@Override
	public double calculateFine(long daysOverdue) {
		// Your logic to calculate fine based on days overdue
        double finePerDay = 2.0; // Sample fine per day overdue

        // Calculating fine amount
        return finePerDay * daysOverdue;
	}
}
