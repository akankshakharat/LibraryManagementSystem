package com.akanksha.library.presentation;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.akanksha.library.entity.Student;
import com.akanksha.library.service.StudentService;
import com.akanksha.library.service.StudentServiceImpl;
import com.akanksha.library.validation.Validation;

public class StudentUserImpl implements StudentUser{
	private Scanner scanner=new Scanner(System.in);
	private StudentService studentService=new StudentServiceImpl();
	private BookUser bookUser=new BookUserImpl();
	private BookIssueUser bookIssueUser=new BookIssueUserImpl();
	private static Integer studentId;

	@Override
	public void registerStudent() {
		boolean flagStudentName = true;
	    boolean flagStudentPassword = true;
	    boolean flagStudentEmailId = true;
	    boolean flagStudentContactNo = true;

	    while (flagStudentName) {
	        System.out.println("Enter the Student Name:");
	        String studentName = scanner.next();
	        if (Validation.isValidStudentName(studentName)) {
	            flagStudentName = false;

	            while (flagStudentEmailId) {
	                System.out.println("Enter the Student Email Id:");
	                String studentEmailId = scanner.next();
	                if (Validation.isValidStudentEmailId(studentEmailId)) {
	                    flagStudentEmailId = false;

	                    while (flagStudentContactNo) {
	                        System.out.println("Enter the Student Contact No:");
	                        String studentContactNo = scanner.next();
	                        if (Validation.isValidStudentContactNo(studentContactNo)) {
	                            flagStudentContactNo = false;

	                            while (flagStudentPassword) {
	                                System.out.println("Enter the Password:");
	                                String studentPassword = scanner.next();
	                                if (Validation.isValidStudentPassword(studentPassword)) {
	                                    flagStudentPassword = false;
	                                    
	                                    System.out.println("Enter the Student Address:");
	                                    String studentAddress = scanner.next();

	                                    Student student = new Student();
	                                    student.setStudentName(studentName);
	                                    student.setStudentEmail(studentEmailId);
	                                    student.setStudentContactNo(studentContactNo);
	                                    student.setStudentAddress(studentAddress);
	                                    student.setStudetPassword(studentPassword);

	                                    System.out.println(studentService.registerStudent(student));
	                                    System.out.println("Student registered successfully!");
	                                } else {
	                                    System.out.println("Please enter a valid password");
	                                }
	                            }
	                        } else {
	                            System.out.println("Please enter a valid contact number.");
	                        }
	                    }
	                } else {
	                    System.out.println("Please enter a valid email address.");
	                }
	            }
	        } else {
	            System.out.println("Please enter a valid student name.");
	        }
	    }
	}

	@Override
	public void getStudentById() {
		System.out.println("Enter the Student Id:");
		Integer studentId=scanner.nextInt();
		Student student=studentService.getStudentById(studentId);
		 if(student!=null) 
		 {
			 System.out.println("+------------+---------------------+------------------------+------------------+-------------------+");
			 System.out.println("| StudentId  | StudentName         | StudentEmail           | StudentContactNo | StudentAddress    |");
			 System.out.println("+------------+---------------------+------------------------+------------------+-------------------+");

			 // Format the output in a tabular structure
			 System.out.printf("| %-10s | %-20s | %-23s | %-16s | %-17s |%n", 
			                   student.getStudentId(), 
			                   student.getStudentName(), 
			                   student.getStudentEmail(), 
			                   student.getStudentContactNo(), 
			                   student.getStudentAddress());
			 System.out.println("+------------+---------------------+------------------------+------------------+-------------------+");

		 	    }
		 else {
	 	    	System.out.println("Student not found......");
	 	    }
	}

	@Override
	public boolean inputStudentLogin() {
		 try {
		        System.out.println("Enter the Student Id:");
		        studentId = scanner.nextInt();
		        scanner.nextLine(); // Consume the newline character

		        System.out.println("Enter the student password:");
		        String studentPassword = scanner.nextLine();

		        Student student = studentService.getStudentById(studentId);

		        if (student != null) {
		            if (studentService.studentLogin(studentId, studentPassword)) {
		                System.out.println("Student Login Successfully");
		                return true;
		            } else {
		                System.out.println("Invalid password");
		            }
		        } else {
		            System.out.println("Invalid student ID");
		        }
		    } catch (InputMismatchException e) {
		        System.out.println("Invalid input. Please enter a valid integer for the student ID.");
		        scanner.nextLine(); // Clear the scanner buffer
		    } catch (Exception e) {
		        System.out.println("An error occurred: " + e.getMessage());
		        e.printStackTrace(); // Print the stack trace for debugging purposes
		    }
		    return false;
		}

		
	@Override
	public void bookIssue() {
		bookUser.inputGetAllBooks();
		System.out.println("studentUserImpl"+studentId);
		bookIssueUser.inputIssueBook(studentId);
	}

	@Override
	public void getAllStudent() {
		List<Student> l=studentService.getAllStudent();
		Iterator<Student> itr=l.iterator();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("StudentId \tStudentName\tStudentEmail\t   StudentContactNo\t   StudentAddress");
		System.out.println("------------------------------------------------------------------------------------------");
		while(itr.hasNext())
		{
			Student s=itr.next();
			System.out.println(s.getStudentId()+"\t   "+s.getStudentName()+"\t      "+s.getStudentEmail()+"\t   "+s.getStudentContactNo()+"\t         "+s.getStudentAddress());
		}
	}

	@Override
	public void getStudentByName() {
		System.out.println("Enter the Student Name:");
        String studentName = scanner.next();

        List<Student> students = studentService.getStudentByName(studentName);

        if (students.isEmpty()) {
            System.out.println("Student not found");
        } else {
        	System.out.println("-------------------------------------------------------------------------------------");
    		System.out.println("StudentId\tStudentName\tStudentEmail\tStudentContactNo\tStudentAddress");
    		System.out.println("--------------------------------------------------------------------------------------");
        	for (Student s : students) {
        		System.out.println(s.getStudentId()+"\t   "+s.getStudentName()+"\t      "+s.getStudentEmail()+"\t   "+s.getStudentContactNo()+"\t         "+s.getStudentAddress());
 	    }
        }
	}
	
}