package com.akanksha.library.service;

import com.akanksha.library.entity.Admin;

public interface AdminService {
	String registerAdmin(Admin admin);
	 Admin getAdminById(Integer adminId);
    boolean adminLogin(Integer adminId,String adminPassword);
}
