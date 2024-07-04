package com.akanksha.library.service;
import java.util.List;

import com.akanksha.library.dao.StudentDao;
import com.akanksha.library.dao.StudentDaoImpl;
import com.akanksha.library.entity.Student;

public class StudentServiceImpl implements StudentService{
	private static StudentDao studentDao=new StudentDaoImpl();

	@Override
	public String registerStudent(Student student) {
		return studentDao.registerStudent(student);
	}

	public Student getStudentById(Integer studentId) {
		return studentDao.getStudentById(studentId);
	}

	@Override
	public boolean studentLogin(Integer studentId, String studentPassword) {
		return studentDao.studentLogin(studentId, studentPassword);
	}

	@Override
	public List<Student> getAllStudent() {
		return studentDao.getAllStudent();
	}

	@Override
	public List<Student> getStudentByName(String studentName) {
		return studentDao.getStudentByName(studentName);
	}
}
