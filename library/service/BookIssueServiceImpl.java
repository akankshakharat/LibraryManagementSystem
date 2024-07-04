package com.akanksha.library.service;

import java.util.List;

import com.akanksha.library.dao.BookIssueDao;
import com.akanksha.library.dao.BookIssueDaoImpl;
import com.akanksha.library.entity.BookIssue;

public class BookIssueServiceImpl implements BookIssueService{
	private BookIssueDao bookIssueDao=new BookIssueDaoImpl();

	@Override
	public String issueBook(BookIssue bookIssue) {
		return bookIssueDao.issueBook(bookIssue);
	}

	@Override
	public List<BookIssue> returnBook(BookIssue bookIssue) {
		return bookIssueDao.returnBook(bookIssue);
	}

	@Override
	public List<BookIssue> getIssuedBook() {
		return bookIssueDao.getIssuedBook();
	}

	@Override
	public BookIssue getBookIssuedById(Integer issueId) {
		return bookIssueDao.getBookIssuedById(issueId);
	}

	@Override
	public void inputConfirmIssueBook() {
		
	}

	@Override
	public List<BookIssue> displayUnIssuedBook() {
		return bookIssueDao.displayUnIssueBook();
	}

	@Override
	public BookIssue findRecordByIssueId(Integer issueId) {
		return bookIssueDao.getBookIssuedById(issueId);
	}

	@Override
	public String confirmIssueBook(BookIssue bookIssue) {
		return bookIssueDao.confirmIssueBook(bookIssue);
	}

	@Override
	public List<BookIssue> displayreturnedBook() {
		return bookIssueDao.displayreturnedBook();
	}

	@Override
	public List<BookIssue> displayUnreturnedBook() {
		return bookIssueDao.displayUnreturnedBook();
	}

	@Override
	public double calculateFine(long daysOverdue) {
		return bookIssueDao.calculateFine(daysOverdue);
	}

}
