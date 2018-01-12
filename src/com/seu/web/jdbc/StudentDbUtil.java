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
				long Id = myrs.getInt("id");
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
}
