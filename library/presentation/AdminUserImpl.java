package com.akanksha.library.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.akanksha.library.entity.Admin;
import com.akanksha.library.service.AdminService;
import com.akanksha.library.service.AdminServiceImpl;
import com.akanksha.library.validation.Validation;

public class AdminUserImpl implements AdminUser {
	private Scanner scanner = new Scanner(System.in);
	private AdminService adminService=new AdminServiceImpl();
	private static Integer adminId;

	@Override
	public void registerAdmin() {
		 boolean flagAdminName = true;
		    boolean flagAdminPassword = true;
		    boolean flagAdminEmailId = true;
		    boolean flagAdminContactNo = true;

		    while (flagAdminName) {
		        System.out.println("Enter the Admin Name:");
		        String adminName = scanner.nextLine();

		        if (Validation.isValidAdminName(adminName)) {
		            flagAdminName = false;

		            while (flagAdminEmailId) {
		                System.out.println("Enter the Admin Email Id:");
		                String adminEmailId = scanner.nextLine();

		                if (Validation.isValidAdminEmailId(adminEmailId)) {
		                    flagAdminEmailId = false;

		                    while (flagAdminContactNo) {
		                        System.out.println("Enter the Admin Contact No:");
		                        String adminContactNo = scanner.nextLine();

		                        if (Validation.isValidAdminContactNo(adminContactNo)) {
		                            flagAdminContactNo = false;

		                            while (flagAdminPassword) {
		                                System.out.println("Enter the Password:");
		                                String adminPassword = scanner.nextLine();

		                                if (Validation.isValidAdminPassword(adminPassword)) {
		                                    flagAdminPassword = false;
		                                    
		                                    System.out.println("Enter the Admin address:");
			                                String adminAddress = scanner.nextLine();

		                                    Admin admin = new Admin();
		                                    admin.setAdminName(adminName);
		                                    admin.setAdminEmail(adminEmailId);
		                                    admin.setAdminContactNo(adminContactNo);
		                                    admin.setAdminAddress(adminAddress);
		                                    admin.setAdminPassword(adminPassword);
		                                    
		                                    System.out.println(adminService.registerAdmin(admin));
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
		            System.out.println("Please enter a valid admin name.");
		        }
		    }
	}

	@Override
	public void getAdminById() {
		System.out.println("Enter the admin Id:");
		Integer adminId = scanner.nextInt();
		Admin admin = adminService.getAdminById(adminId);
		if (admin != null) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("| %-8s | %-15s | %-20s | %-15s | %-20s |%n", 
			        "AdminId", "AdminName", "AdminEmail", "AdminContactNo", "AdminAddress");
			System.out.println("---------------------------------------------------------------");
			System.out.printf("| %-8s | %-15s | %-20s | %-15s | %-20s |%n", 
			        admin.getAdminId(), admin.getAdminName(), admin.getAdminEmail(),
			        admin.getAdminContactNo(), admin.getAdminAddress());
			System.out.println("---------------------------------------------------------------");

		} else {
			System.out.println("Admin not found......");
		}
	}

	@Override
	public boolean inputAdminLogin() {
		try {
	        System.out.println("Enter the Admin Id:");
	        adminId = scanner.nextInt();
	        scanner.nextLine(); // Consume the newline character
	        
	        System.out.println("Enter the Admin password:");
	        String adminPassword = scanner.nextLine();
	        
	        Admin admin = adminService.getAdminById(adminId);
	        
	        if (admin != null) {
	            if (adminService.adminLogin(adminId, adminPassword)) {
	                System.out.println("Admin Login Successfully");
	                return true;
	            } else {
	                System.out.println("Invalid password");
	            }
	        } else {
	            System.out.println("Invalid admin ID");
	        }
	    } catch (InputMismatchException e) {
	        System.out.println("Invalid input. Please enter a valid integer for the admin ID.");
	        scanner.nextLine(); // Clear the scanner buffer
	    } catch (Exception e) {
	        System.out.println("An error occurred: " + e.getMessage());
	        e.printStackTrace(); // print the stack trace for debugging purposes
	    }
	    return false;
}
}
