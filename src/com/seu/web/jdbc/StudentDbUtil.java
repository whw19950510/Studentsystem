package com.seu.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {
	private DataSource datasource;
	public StudentDbUtil(DataSource datasource) {
		this.datasource = datasource;
	}
	public List<Student> getStudents() throws Exception{
		List<Student> students = new ArrayList<>();
		Connection myconn = null;
		Statement myst = null;
		ResultSet myrs = null;
		
		try {
			myconn = datasource.getConnection();
			String sqlqu = "select * from student order by last_name";
			myst = myconn.createStatement();
			myrs = myst.executeQuery(sqlqu);
			while(myrs.next()) {
				int Id = myrs.getInt("id");
				String Firstname = myrs.getString("first_name");
				String Lastname = myrs.getString("last_name");
				String Email = myrs.getString("email");
				Student curstu = new Student(Firstname, Lastname, Id, Email);
				students.add(curstu);
			}
			return students;
		} finally {
			close(myconn,myst,myrs);
		}		
	}
	private void close(Connection myconn, Statement myst, ResultSet myrs) {
		// TODO Auto-generated method stub
		try {
			if(myconn != null) myconn.close();
			if(myst != null) myst.close();
			if(myrs != null) myrs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void addStudent(Student newstudent) throws SQLException {
		Connection myconn = null;
		PreparedStatement myst = null;
		try {
			myconn = datasource.getConnection();
			String sqlqu = "insert into student (first_name, last_name, email) values (?, ?, ?)";
			myst = myconn.prepareStatement(sqlqu);
			myst.setString(1, newstudent.getFirstname());
			myst.setString(2, newstudent.getLastname());
			myst.setString(3, newstudent.getEmail());
			myst.execute();
		} catch(Exception e) {
			throw new SQLException(e);
		} finally {
			close(myconn,myst,null);
		}
		
	}
	public Student getStudent(String id) throws SQLException {
		Student tobefind = null;
		Connection myconn = null;
		PreparedStatement myst = null;
		ResultSet myrs = null;
		int studentid = Integer.parseInt(id);
		try {
			myconn = datasource.getConnection();
			String sqlqu = "select * from student where id=? ";
			myst = myconn.prepareStatement(sqlqu);
			myst.setInt(1, studentid);
			myrs = myst.executeQuery();
			if(myrs.next()) {
				String Firstname = myrs.getString("first_name");
				String Lastname = myrs.getString("last_name");
				String Email = myrs.getString("email");
				tobefind = new Student(Firstname, Lastname, studentid, Email);
			}
		} catch(Exception e) {
			throw new SQLException(e);
		} finally {
			close(myconn,myst,myrs);
		}
		return tobefind;
	}
public void updateStudent(Student theStudent) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = datasource.getConnection();
			
			// create SQL update statement
			String sql = "update student "
						+ "set first_name=?, last_name=?, email=? "
						+ "where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theStudent.getFirstname());
			myStmt.setString(2, theStudent.getLastname());
			myStmt.setString(3, theStudent.getEmail());
			myStmt.setInt(4, theStudent.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}
	public void deleteStudent(String deleteid) throws SQLException {
		int todelete = Integer.parseInt(deleteid);
		Connection myconn = null;
		PreparedStatement myst = null;
		try {
			myconn = datasource.getConnection();
			String sqlqu = "delete from student where id=?";
			myst = myconn.prepareStatement(sqlqu);
			myst.setInt(1, todelete);
			myst.execute();
		} finally {
			close(myconn, myst, null);
		}
	}
}
