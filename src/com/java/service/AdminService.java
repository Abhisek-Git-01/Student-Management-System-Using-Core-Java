package com.java.service;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.java.dao.AdminDao;
import com.java.dao.AdminDaoImpl;
import com.java.model.Student;

public class AdminService {
	

		private AdminDao adminDao = new AdminDaoImpl();;
		private Student student = new Student();
		
		public void registerUser(Student s) {
		  String studentId = s.getStudentId();
            if(studentId != null && adminDao.getStudentById(studentId) == null) {
		    adminDao.registerStudent(s);
		    System.out.println("Student added successfully");
            }
            else {
            	System.out.println("Student already exists");
            }

		}
		public void deleteStudentById(String id) {
			Student student = adminDao.getStudentById(id);
			if( student != null){
			adminDao.deleteStudentById(id);
			System.out.println("Student deleted successfully");
			}
			else {
				System.out.print("Student not Exits!!!!");
			}
		}

		public boolean login(String email, String password) {
			boolean log = adminDao.login(email, password);
			if(log == true) {
				return true;
			}
			return false;
		}
		
		public void getAllStudent(){
			List<Student> students = adminDao.getAllStudent() ;
			if(student== null ||  students.isEmpty()) {
				System.out.print("No student available");
			}
			else {
			    System.out.println(students);
			}
		}
		public Student getStudentById(String id) {
			
			
				Student student =  adminDao.getStudentById(id);
				if(student == null) {
					System.out.println("Student does not Exits");
			
				}
				else {
					System.out.println(student);
				}
				return student;
			
		}
		public boolean adminLogin(String email, String password) {
			boolean authentication = adminDao.adminLogin(email,password);
			if(authentication == true) {
				return true;
			}
			return false;						
		}
		public void updateStudent(Student student) {
			 boolean result = adminDao.updateStudent(student);
			 if(result == true) {
				 System.out.println("Student updated successfully");
				 logToFile(student);
			 }
			 else {
			 System.out.println("Student not exist!!! ");
				}
		}
		private void logToFile(Student student) {
		    try (FileWriter fw = new FileWriter("student_updates.log", true);
		         PrintWriter pw = new PrintWriter(fw)) {

		        pw.println("Student updated: " +
		            "ID=" + student.getStudentId() + ", " +
		            "Name=" + student.getStudentName() + ", " +
		            "Email=" + student.getStudentEmail() + ", " +
		            "Department=" + student.getDepartment());
		    } catch (IOException e) {
		        System.err.println("Failed to write log: " + e.getMessage());
		    }
		}
			}
		


	



