package com.akanksha.library.presentation;

import java.util.Scanner;

public class MyLibrary {
	public static void main(String[] args) {
		StudentUser studentUser = new StudentUserImpl();
		AdminUser adminUser=new AdminUserImpl();
		
		BookIssueUser bookIssueUser = new BookIssueUserImpl();
		BookUser bookUser = new BookUserImpl();
		Integer choice = 0;
		Boolean login;
		Scanner scanner = new Scanner(System.in);
		while (choice != 3) {
			System.out.println("--------------------");
			System.out.println("Wel-Come To Library");
			System.out.println("--------------------");
			System.out.println("1. Admin ");
			System.out.println("2. Student ");
			System.out.println("3. Exit");

			System.out.println("-----------------");
			System.out.println("Enter the choice:");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("--------------------");
				System.out.println("1. Register Admin");
				System.out.println("2. Login Admin");
				System.out.println("--------------------");
				System.out.println("Enter the choice:");
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					adminUser.registerAdmin();

				case 2:
					login = adminUser.inputAdminLogin();
	
					if (login) {
					while (choice != 8) {
						System.out.println("------------------");
						System.out.println("Wel-Come Admin");
						System.out.println("------------------");
						System.out.println("1. Add New Book");
						System.out.println("2. Update Stock ");
						System.out.println("3. Search Book");
						System.out.println("4. Approve Book-Issue");
						System.out.println("5. Display Unreturned Book");
						System.out.println("6. Returned Book");
						System.out.println("7. Display UnIssued Book");
						System.out.println("8. View Users");
						System.out.println("9. Display Issued Book");
						System.out.println("10.Display Fine Details");
						System.out.println("11.Display Returned Book");
						System.out.println("12 Logout");
						choice = scanner.nextInt();
						switch (choice) {
						case 1:
							bookUser.inputAddBook();
							break;
						case 2:
							bookUser.inputUpdateStock();
							break;
						case 3:
							while (choice != 5) {
								System.out.println("----------------------");
								System.out.println("Enter your choice: ");
								System.out.println("----------------------");
								System.out.println("1.Get All Books");
								System.out.println("2.Get Book by Name");
								System.out.println("3.Get Book by Type");
								System.out.println("4.Get Book by Author");
								System.out.println("5.Exit");
								choice = scanner.nextInt();
								switch (choice) {
								case 1:
									bookUser.inputGetAllBooks();
									break;
								case 2:
									bookUser.inputGetBookByName();
									break;
								case 3:
									bookUser.inputGetBookByType();
									break;
								case 4:
									bookUser.inputGetBookByAuthor();
									break;
								case 5:
									System.out.println("Exit");
									break;
								}// case 1: => case 3: Switch end
							} // case 1: => case 3: while end
							break;
						case 4:
							bookIssueUser.inputConfirmIssueBook();
							break;
						case 5:
							//Display Unreturned Book
							bookIssueUser.displayUnreturnedBook();
							break;
						case 6:
							//Display Returned Book
							bookIssueUser.inputReturnBook();
							break;
						case 7:
							//Display UnIssued Book
							bookIssueUser.displayUnIssueBook();
							break;
						case 8:
							while (choice != 4) {
								System.out.println("---------------------");
								System.out.println("Enter your choice: ");
								System.out.println("---------------------");
								System.out.println("1.Get All Student");
								System.out.println("2.Get Student by Name");
								System.out.println("3.Get Student by Id");
								System.out.println("4.Exit");
								choice = scanner.nextInt();
								switch (choice) {
								case 1:
									studentUser.getAllStudent();
									break;
								case 2:
									studentUser.getStudentByName();
									break;
								case 3:
									studentUser.getStudentById();
									break;
								case 4:
									System.out.println("Exit");
								}
							}
							break;
						case 9:
							//Display Issued Book
							bookIssueUser.inputGetIssuedBook();
							break;

						case 10:
							//Display Fine Details
							bookIssueUser.calculateFine();
						case 11:
							bookIssueUser.displayreturnedBook();
							break;
						case 12:
							System.out.println("Admin Logout");
						}// Admin case 1: switch end

					//
					System.out.println("Do you want to continue? Enter Yes or No:");
					String ch = scanner.next();
					if (ch.equals("Yes") || ch.equals("yes")|| ch.equals("y")|| ch.equals("Y")) {

					} else if (ch.equals("No") || ch.equals("no")) {
						System.out.println("Admin does not want to continue.");
						System.out.println("Thank you!");
						System.exit(0);
					} else {
						System.out.println("Invalid input. Please enter Yes or No.");
					}
					}
					
				} 
				}
				break;
			case 2:
				System.out.println("--------------------");
				System.out.println("1. Register Student");
				System.out.println("2. Login Student");
				System.out.println("--------------------");
				System.out.println("Enter the choice:");
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					studentUser.registerStudent();

				case 2:
					login = studentUser.inputStudentLogin();
	
					if (login) {
						while (choice != 10) {
							System.out.println("-----------------");
							System.out.println("Wel-Come Student");
							System.out.println("------------------");
							System.out.println("1. Search Book");
							System.out.println("2. Issue Book");
							System.out.println("3. Return Book");
							System.out.println("4. View Book issue Details");
							System.out.println("5. View Fine Details");
							System.out.println("6. View Profile");
							System.out.println("7. Pay fine");
							System.out.println("8. Show All Book");
							System.out.println("9. Logout");
							choice = scanner.nextInt();
							switch (choice) {
							case 1:
								while (choice != 4) {
									System.out.println("-------------------");
									System.out.println("Enter your choice: ");
									System.out.println("-------------------");
									System.out.println("1.Get Book by Name");
									System.out.println("2.Get Book by Type");
									System.out.println("3.Get Book by Author");
									System.out.println("4.Exit.. ");
									choice = scanner.nextInt();
									switch (choice) {
									case 1:
										bookUser.inputGetBookByName();
										break;
									case 2:
										bookUser.inputGetBookByType();
										break;
									case 3:
										bookUser.inputGetBookByAuthor();
										break;
									case 4:
										System.out.println("Exit");
										break;
									}// Main case 2: => case 1: switch end
								} // Main case 2: => case 1: while end
								break;
							case 2:
								studentUser.bookIssue();
								break;
							case 3:
								bookIssueUser.inputReturnBook();
								break;
							case 4:
								bookIssueUser.inputGetIssuedBook();
								break;
							case 5:
								//
								break;
							case 6:
								studentUser.getStudentById();
								break;
							case 7:
								//
								break;
							case 8:
								bookUser.inputGetAllBooks();
								break;
							case 9:
								System.out.println("Student Logout");

							}
							System.out.println("Do you want to continue? Enter Yes or No:");
							String ch = scanner.next();
							if (ch.equals("Yes") || ch.equals("yes")) {
								System.out.println("Continuing...");
							} else if (ch.equals("No") || ch.equals("no")) {
								System.out.println("Student does not want to continue.");
								System.out.println("Thank you!");
								System.exit(0);
							} else {
								System.out.println("Invalid input. Please enter Yes or No.");
							}
							
						}

					}
				}
				break;
			case 3:
				System.out.println("Thank you!!");
				System.exit(0);
				break;
			}// Main switch end

		} // Main while end

	}
}
