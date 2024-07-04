package com.akanksha.library.presentation;

import java.time.LocalDate;

public interface BookIssueUser {
	void inputIssueBook(Integer studentId);
	void inputReturnBook();
	void inputGetIssuedBook();
	void inputgetBookIssuedById();
	void inputConfirmIssueBook();
	void displayUnIssueBook();
	void displayreturnedBook();
	void displayUnreturnedBook();
	void calculateFine();
	long calculateDaysOverdue(LocalDate dueDate);

}
