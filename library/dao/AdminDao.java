package com.akanksha.library.dao;
import com.akanksha.library.entity.Admin;


public interface AdminDao {
	String registerAdmin(Admin admin);
	public Admin getAdminById(Integer adminId);
    boolean adminLogin(Integer adminId,String adminPassword);
}
