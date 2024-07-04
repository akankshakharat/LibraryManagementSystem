package com.akanksha.library.presentation;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.akanksha.library.entity.Book;
import com.akanksha.library.entity.BookIssue;
import com.akanksha.library.entity.Student;
import com.akanksha.library.service.BookIssueService;
import com.akanksha.library.service.BookIssueServiceImpl;
import com.akanksha.library.service.BookService;
import com.akanksha.library.service.BookServiceImpl;
import com.akanksha.library.service.StudentService;
import com.akanksha.library.service.StudentServiceImpl;

public class BookIssueUserImpl implements BookIssueUser {
	private Scanner scanner = new Scanner(System.in);
	private BookIssueService bookIssueService = new BookIssueServiceImpl();
	private BookService bookService = new BookServiceImpl();
	private StudentService studentService = new StudentServiceImpl();
	private Integer bookId;
	private Integer studentId;
	

	@Override
	public void inputIssueBook(Integer studentId) {
		System.out.println("bookIssueUserImpl" + studentId);
		System.out.println("Enter the book Id");
		bookId = scanner.nextInt();

		Book book1 = bookService.getBookById(studentId);
		Student student1 = studentService.getStudentById(studentId);
		BookIssue bookIssue = new BookIssue();

		// Creating a new BookIssue object and setting its properties
		BookIssue bookIssue1 = new BookIssue();
		bookIssue.setBook(book1);
		bookIssue.setStudent(student1);
		bookIssue.setIssueDate(bookIssue.getIssueDate());
		bookIssue.setDueDate(bookIssue.getDueDate());
		bookIssue.setReturnDate(bookIssue.getReturnDate());
		bookIssue.setBookStatus(bookIssue.getBookStatus());
		bookIssue.setFine(bookIssue.getFine());
		System.out.println(bookIssueService.issueBook(bookIssue));	 
	}
	@Override
	public void inputReturnBook() {
		System.out.println("Enter the student Id:");
		int studentId = scanner.nextInt();
		System.out.println("Enter the issue Id:");
		int issueId = scanner.nextInt();

		try {
		    // Fetch bookIssue record by issueId
		    BookIssue bookIssue = bookIssueService.getBookIssuedById(issueId);

		    if (bookIssue != null && bookIssue.getStudent().getStudentId() == studentId) {
		        // Check if the book is already returned
		        if (bookIssue.getReturnDate() == null) {
		            // Update return date to the current date
		            bookIssue.setReturnDate(LocalDate.now());

		            // Update book status to "RETURNED"
		            bookIssue.setBookStatus("RETURNED");

		            // Fetch the corresponding Book object
		            Book book = bookService.getBookById(bookIssue.getBook().getBookId());

		            if (book != null) {
		                // Increase the book quantity by 1
		                book.setQuantity(book.getQuantity() + 1);

		                // Update the book quantity in the database
		                bookService.updateStock(book);

		                // Update the bookIssue entity with the changes
		                //bookIssueService.updateBookIssue(bookIssue);

		                System.out.println("Book returned successfully.");
		            } else {
		                System.out.println("Book not found with ID: " + bookIssue.getBook().getBookId());
		            }
		        } else {
		            System.out.println("Book has already been returned.");
		        }
		    } else {
		        System.out.println("Book issue record not found for the given book and student.");
		    }
		} catch (InputMismatchException e) {
		    System.out.println("Invalid input. Please enter valid integer values for student and issue IDs.");
		    scanner.nextLine(); // Clear the scanner buffer
		} catch (Exception e) {
		    System.out.println("An error occurred: " + e.getMessage());
		    e.printStackTrace(); // Print the stack trace for debugging purposes
		}
	}

	@Override
	public void inputGetIssuedBook() {
		List<BookIssue> l = bookIssueService.getIssuedBook();
		Iterator<BookIssue> itr = l.iterator();	
		System.out.println("+--------+----------------------+----------------------+-----------+-----------+");
		System.out.println("| IssueId | IssueDate           | ReturnDate           | DueDate   | BookStatus|");
		System.out.println("+--------+----------------------+----------------------+-----------+-----------+");
		while (itr.hasNext()) {
			BookIssue b = itr.next();
			System.out.printf("| %-6s | %-20s | %-20s | %-9s | %-7s |%n",
                    b.getIssueId(),
                    b.getIssueDate(),
                    b.getReturnDate(),
                    b.getDueDate(),
                    b.getBookStatus());
            System.out.println("+--------+----------------------+----------------------+-----------+----------+");

		}
	}

	@Override
	public void inputgetBookIssuedById() {
		System.out.println("Enter the BookIssue Id:");
		Integer issueId = scanner.nextInt();
		BookIssue bookIssue = bookIssueService.getBookIssuedById(issueId);
		if (bookIssue != null) {

			System.out.println("Book Id is:" + bookIssue.getIssueId());
			System.out.println("Book Name is:" + bookIssue.getIssueDate());
			System.out.println("Book Auther Name is:" + bookIssue.getReturnDate());
			System.out.println("Book Quentity is:" + bookIssue.getDueDate());
			System.out.println("Book Type is:" + bookIssue.getBookStatus());

		} else {
			System.out.println("BookIssued not found......");
		}

	}

	@Override
	public void inputConfirmIssueBook() {
		
		  /*displayUnIssueBook();
		  System.out.println("Do you want to issue any book to the student(yes/no)");
		  String ans=scanner.next(); 
		  System.out.println("Enter issued Id:"); 
		  Integer issueId=scanner.nextInt(); BookIssue
		  bookIssue=bookIssueService.findRecordByIssueId(issueId);
		  bookIssue.setIssueDate(LocalDate.now());
		  bookIssue.setDueDate(LocalDate.now().plusDays(5));
		  bookIssue.setBookStatus("Issued"); Book
		  book=bookService.getBookById(bookIssue.getIssueId());
		  book.setQuantity(book.getQuantity()-1); bookService.updateStock(book);
		  System.out.println(bookIssueService.confirmIssueBook(bookIssue)); 
		  }
		 */
		displayUnIssueBook();
		System.out.println("Do you want to issue any book to the student (yes/no)");
		String ans = scanner.next();

		if (ans.equalsIgnoreCase("yes")) {
		    System.out.println("Enter issued Id:");
		    Integer issueId = scanner.nextInt();

		    BookIssue bookIssue = bookIssueService.findRecordByIssueId(issueId);

		    if (bookIssue != null) {
		        Integer bookId = bookIssue.getBook().getBookId();  // Use the correct variable to get the book ID

		        if (bookId != null) {
		            Book book = bookService.getBookById(bookId);

		            if (book != null) {
		                if (book.getQuantity() > 0) {
		                    try {
		                        bookIssue.setIssueDate(LocalDate.now());
		                        bookIssue.setDueDate(LocalDate.now().plusDays(5));
		                        bookIssue.setBookStatus("Issued");

		                        book.setQuantity(book.getQuantity() - 1);
		                        bookService.updateStock(book);

		                        System.out.println("Book issued successfully.");
		                    } catch (Exception e) {
		                        System.out.println("Failed to update book quantity: " + e.getMessage());
		                    }
		                } else {
		                    System.out.println("Book is out of stock.");
		                }
		            } else {
		                System.out.println("Book not found with ID: " + bookId);
		            }
		        } else {
		            System.out.println("Book ID is null in bookIssue.");
		        }

		        System.out.println(bookIssueService.confirmIssueBook(bookIssue));
		    } else {
		        System.out.println("Book issue record not found.");
		    }
		}
	}

		

	@Override
	public void displayUnIssueBook() {
		List<BookIssue> list = bookIssueService.displayUnIssuedBook();
		if (list == null) {
			System.out.println("No Book Is available For Confirm");
		} else {
			System.out.println("+--------+----------------------+----------------------+-----------+-----------+");
			System.out.println("| IssueId | IssueDate           | ReturnDate           | DueDate   | BookStatus|");
			System.out.println("+--------+----------------------+----------------------+-----------+-----------+");
			for (BookIssue bi : list) {
				System.out.printf("| %-6s | %-20s | %-20s | %-9s | %-7s |%n",
						bi.getIssueId(),
						bi.getIssueDate(),
						bi.getReturnDate(),
						bi.getDueDate(),
						bi.getBookStatus());
	            System.out.println("+--------+----------------------+----------------------+-----------+----------+");

			}

		}
	}

	@Override
	public void displayreturnedBook() {
		 // Fetch all books that have been returned
        List<BookIssue> list = bookIssueService.displayreturnedBook();

        if (list.isEmpty()) {
            System.out.println("No Books have been returned yet.");
        } else {
        	System.out.println("+--------+----------------------+----------------------+-----------+-----------+");
			System.out.println("| IssueId | IssueDate           | ReturnDate           | DueDate   | BookStatus|");
			System.out.println("+--------+----------------------+----------------------+-----------+-----------+");

            for (BookIssue bi : list) {
                if (bi.getReturnDate() != null) {
                	System.out.printf("| %-6s | %-20s | %-20s | %-9s | %-7s |%n",
    						bi.getIssueId(),
    						bi.getIssueDate(),
    						bi.getReturnDate(),
    						bi.getDueDate(),
    						bi.getBookStatus());
    	            System.out.println("+--------+----------------------+----------------------+-----------+----------+");
                }
            }
        }

	}

	@Override
	public void displayUnreturnedBook() {
		// Fetch all issued books
	    List<BookIssue> list = bookIssueService.getIssuedBook();

	    if (list.isEmpty()) {
	        System.out.println("No Books are currently issued.");
	    } else {
	        boolean unreturnedBooksExist = false;
	        System.out.println("+--------+----------------------+----------------------+-----------+-----------+");
			System.out.println("|IssueId | IssueDate            |ReturnDate            |DueDate    |BookStatus |");
			System.out.println("+--------+----------------------+----------------------+-----------+-----------+");

	        for (BookIssue bi : list) {
	            if (bi.getReturnDate() == null) {
	            	System.out.printf("| %-6s | %-20s | %-20s | %-9s | %-7s |%n",
							bi.getIssueId(),
							bi.getIssueDate(),
							bi.getReturnDate(),
							bi.getDueDate(),
							bi.getBookStatus());
		            System.out.println("+--------+----------------------+----------------------+-----------+----------+");
	                unreturnedBooksExist = true;
	            }
	        }

	        if (!unreturnedBooksExist) {
	            System.out.println("No Books are currently issued and unreturned.");
	        }
	    }
	}

	@Override
	public void calculateFine() {
		// Display unreturned books
        bookIssueService.displayUnreturnedBook();

        // Calculate fine for a certain number of days overdue
        long daysOverdue = 5; // Replace this with the actual number of days a book is overdue
        double fine = bookIssueService.calculateFine(daysOverdue);
        System.out.println("Fine for " + daysOverdue + " days overdue: $" + fine);
    
}

	@Override
	public long calculateDaysOverdue(LocalDate dueDate) {
		LocalDate currentDate = LocalDate.now();
	    return ChronoUnit.DAYS.between(dueDate, currentDate);
	}
}