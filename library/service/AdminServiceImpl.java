package com.akanksha.library.service;

import com.akanksha.library.dao.AdminDao;
import com.akanksha.library.dao.AdminDaoImpl;
import com.akanksha.library.entity.Admin;

public class AdminServiceImpl implements AdminService{
	private static AdminDao adminDao=new AdminDaoImpl();

	@Override
	public String registerAdmin(Admin admin) {
		return adminDao.registerAdmin(admin);
	}

	@Override
	public Admin getAdminById(Integer adminId) {
		return adminDao.getAdminById(adminId);
	}

	@Override
	public boolean adminLogin(Integer adminId, String adminPassword) {
		return adminDao.adminLogin(adminId, adminPassword);
	}

}
