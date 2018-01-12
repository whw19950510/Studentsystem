package com.seu.web.jdbc;

import com.seu.web.jdbc.*;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentCreateServlet
 */
@WebServlet("/StudentCreateServlet")
public class StudentCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private StudentDbUtil studentdbutil;
	@Resource(name = "jdbc/web_student_tracker")
	private DataSource datasource;
   
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			studentdbutil = new StudentDbUtil(datasource);
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			addStudent(request,response);
		} catch( Exception e) {
			throw new ServletException(e);
		}
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read parameter from forms
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		Student newstu = new Student(firstname,lastname,email);
		// add to database
		studentdbutil.addStudent(newstu);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/StudentControllerServlet");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
