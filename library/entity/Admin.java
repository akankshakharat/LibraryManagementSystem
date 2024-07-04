package com.akanksha.library.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;
	@Column(length = 20)
	private String adminName;
	@Column(length = 20)
	private String adminEmail;
	@Column(length = 10)
	private String adminContactNo;
	@Column(length = 20)
	private String adminAddress;
	@Column(length = 20)
	private String adminPassword;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy  = "admin")
    private List<BookIssue> bookIssues;

	@OneToMany(cascade = CascadeType.ALL,mappedBy  = "admin")
    private List<Book> books;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminContactNo() {
		return adminContactNo;
	}

	public void setAdminContactNo(String adminContactNo) {
		this.adminContactNo = adminContactNo;
	}

	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public List<BookIssue> getBookIssues() {
		return bookIssues;
	}

	public void setBookIssues(List<BookIssue> bookIssues) {
		this.bookIssues = bookIssues;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	

	
	
	
	
}
