package com.akanksha.library.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.akanksha.library.entity.Student;

public class StudentDaoImpl implements StudentDao {
	EntityManager entityManager = MyConnection.getEntityManagerObject();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	Query query;

	@Override
	public String registerStudent(Student student) {
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return "Student Registration done\nStudentId :" + student.getStudentId();	}

	@Override
	public Student getStudentById(Integer studentId) {
		return entityManager.find(Student.class, studentId);
	}

	@Override
	public boolean studentLogin(Integer studentId, String studentPassword) {
		Student student = entityManager.find(Student.class, studentId);
		if (student != null && studentPassword != null) {
			return studentPassword.equals(student.getStudetPassword());
		}
		return false;
	}

	@Override
	public List<Student> getAllStudent() {
		String jpql = "select s from Student s";
		query = entityManager.createQuery(jpql);
		List<Student> list = query.getResultList();
		return list;
	}

	@Override
	public List<Student> getStudentByName(String studentName) {
		String jpql = "SELECT s FROM Student s WHERE s.studentName LIKE :studentName";
		query = entityManager.createQuery(jpql);
		query.setParameter("studentName", "%" + studentName + "%");
		List<Student> list = query.getResultList();
		return list;
	}
}
