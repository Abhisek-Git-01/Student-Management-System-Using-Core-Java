package com.java.model;



public class Student {

     private String studentId;
     private String studentName;
     private String StudentEmail;
     private String password;
     @Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", Studentemail=" + StudentEmail
				+ ", password=" + password + ", department=" + department + "]";
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return StudentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.StudentEmail = studentEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	private String department;
     
		
	}

