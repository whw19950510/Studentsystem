package com.seu.web.jdbc;
import com.seu.web.jdbc.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentUpdateServlet
 */
@WebServlet("/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private StudentDbUtil studentdbutil;
	@Resource(name = "jdbc/web_student_tracker")
	private DataSource datasource;
    /**
     * @see HttpServlet#HttpServlet()
     */
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
			updateStudent(request,response);
		} catch( Exception e) {
			throw new ServletException(e);
		}
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read data from form
		int curId = Integer.parseInt(request.getParameter("studentId"));
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		// create new student object & update the database
		Student updatestu = new Student(firstname, lastname, curId, email);
		studentdbutil.updateStudent(updatestu);
		// send back to list students
		//response.sendRedirect("/Studentsystem");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/StudentControllerServlet");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
