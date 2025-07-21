package com.java.dao;

import java.util.List;

import com.java.model.Student;

public interface AdminDao {

	public void registerStudent(Student student);
	public void deleteStudentById(String id);
	public List<Student> getAllStudent();
	public Student getStudentByEmail(String email);
	public Student getStudentById(String id);
	public boolean login(String email, String password);
	public boolean adminLogin(String email, String password);
	public boolean updateStudent(Student student) ;
}
