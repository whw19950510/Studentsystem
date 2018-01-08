package com.seu.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Testservlet
 */
@WebServlet("/Testservlet")
public class Testservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/web_student_tracker")
	private DataSource datasource;
    /**
     * Default constructor. 
     */
    public Testservlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. set up print writer
		PrintWriter wr = response.getWriter();
		//2. connect to database
		java.sql.Connection myconn = null;
		Statement mystment = null;
		ResultSet myrs = null;
		
		try {
			myconn = datasource.getConnection();
			String sqlquery = "select * from student";
			mystment = myconn.createStatement();
			
			myrs = mystment.executeQuery(sqlquery);
			
			while(myrs.next()) {
				String email = myrs.getString("email");
				wr.println(email);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
