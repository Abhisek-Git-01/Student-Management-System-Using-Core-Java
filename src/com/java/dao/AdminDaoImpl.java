package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.model.Student;
import com.util.java.DBUtil;

public class AdminDaoImpl implements AdminDao{

	public void registerStudent(Student student) {
		String sql = "INSERT INTO users (studentId,studentName,studentEmail,password,department) VALUES(?,?,?,?,?)";
		try {
	    Connection conn = DBUtil.getConnection();
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setString(1, student.getStudentId());
	    stmt.setString(2, student.getStudentName());
	    stmt.setString(3, student.getStudentEmail());
	    stmt.setString(4, student.getPassword());
	    stmt.setString(5, student.getDepartment());
	    stmt.executeUpdate();
		}
		catch(Exception e) {
			 e.printStackTrace();
			 
		}
	}
	public void deleteStudentById(String id) {
	
		String sql = "Delete from users where studentId = ?";
		try {
		    Connection conn = DBUtil.getConnection();
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setString(1, id);
		    stmt.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	public List<Student> getAllStudent(){
		String sql = "Select * from users ";
		List<Student> students = new ArrayList<>(); 
	   try {
		   Connection conn = DBUtil.getConnection();
		   PreparedStatement stmt = conn.prepareStatement(sql);
		   ResultSet rs =stmt.executeQuery();
		   while(rs.next()) {
		   Student student = new Student();	   
		   student.setStudentId(rs.getString("studentId"));
		   student.setStudentName(rs.getString("studentName"));
		   student.setStudentEmail(rs.getString("studentEmail"));
		   student.setPassword(rs.getString("password"));
		   student.setDepartment(rs.getString("department"));
           students.add(student);
           
		   }
		   
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return students;
	}
	public Student getStudentByEmail(String email) {
		String sql = "Select * from users where studentEmail = ?";
		  Student student = new Student();	
		   try {
			   Connection conn = DBUtil.getConnection();
			   PreparedStatement stmt = conn.prepareStatement(sql);
			   stmt.setString(1, email);
			 ResultSet rs =  stmt.executeQuery();
			 if(rs.next()) {
				    
				   student.setStudentId(rs.getString("studentId"));
				   student.setStudentName(rs.getString("studentName"));
				   student.setStudentEmail(rs.getString("studentEmail"));
				   student.setPassword(rs.getString("password")); 
				   student.setDepartment(rs.getString("department"));
			 }
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   return student;
	}
	public Student getStudentById(String id) {
		String sql = "Select * from users where studentId = ?";
		  Student student = null;	
		   try {
			   Connection conn = DBUtil.getConnection();
			   PreparedStatement stmt = conn.prepareStatement(sql);
			   stmt.setString(1, id);
			 ResultSet rs =  stmt.executeQuery();
			 
			 if(rs.next()) {
				   student = new Student();
				   student.setStudentId(rs.getString("studentId"));
				   student.setStudentName(rs.getString("studentName"));
				   student.setStudentEmail(rs.getString("studentEmail"));
				   student.setPassword(rs.getString("password")); 
				  
			 }
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		  
		   return student;
	}
	public boolean login(String email, String password) {
		String sql = "select * from users where studentEmail = ? and password = ?";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet  rs = stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean adminLogin(String email, String password) {
		String sql = "select * from admin where email = ? and password = ?";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateStudent(Student student) {
		String sql = "update users set studentName = ? , studentEmail = ? , department = ? where studentId = ? ";
		try {
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, student.getStudentName());
		stmt.setString(2, student.getStudentEmail());
		stmt.setString(3, student.getDepartment());
		stmt.setString(4, student.getStudentId());
		int rowsAffected = stmt.executeUpdate();
		if(rowsAffected > 0) {
			return true;
		}
		stmt.close();
		conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
