package com.akanksha.library.validation;
public class Validation {
	public static boolean isValidAdminName(String adminName) {
		   return adminName.matches("^[a-zA-Z]*$");
	   }
	public static boolean isValidAdminPassword(String adminPassword) {
	    return adminPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[a-zA-Z]).{8,}$");
	}

	   public static boolean  isValidAdminEmailId(String adminEmailId)
	   {
		     return adminEmailId.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
		     }
	   
	   public static boolean  isValidAdminContactNo(String adminContactNo)
	   {
		     return adminContactNo.length()==10 && adminContactNo.matches("\\d+");
		     }
	   
	   public static boolean isValidStudentName(String studentName) {
		   return studentName.matches("^[a-zA-Z]*$");
	   }
	   
	   public static boolean isValidStudentPassword(String studentPassword) {
		    return studentPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[a-zA-Z]).{8,}$");
		}
	   
	   public static boolean  isValidStudentEmailId(String studentEmailId) 
	   {
		     return studentEmailId.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
	   }
	   
	   public static boolean  isValidStudentContactNo(String studentContactNo)
	   {
		     return studentContactNo.length()==10 && studentContactNo.matches("\\d+");
		     }
	   
	   public static boolean isValidName(String name) 
	   {
		   return name.matches("^[a-zA-Z]*$");
	   }
	
	
}

