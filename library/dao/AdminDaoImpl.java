package com.akanksha.library.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.akanksha.library.entity.Admin;

public class AdminDaoImpl implements AdminDao {
	EntityManager entityManager = MyConnection.getEntityManagerObject();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	

	@Override
	public String registerAdmin(Admin admin) {
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		return "Admin Registration done\nAdminId :" + admin.getAdminId();
    }
	

	@Override
	public Admin getAdminById(Integer adminId) {
		return entityManager.find(Admin.class, adminId);
	}

	@Override
	public boolean adminLogin(Integer adminId, String adminPassword) {
		Admin admin = entityManager.find(Admin.class, adminId);
		if (admin != null && adminPassword != null) {
			return adminPassword.equals(admin.getAdminPassword());
		}
		return false;
	}
}
