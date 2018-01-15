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
@WebServlet("/StudentLoadServlet")
public class StudentLoadServlet extends HttpServlet {
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
			loadStudent(request,response);
		} catch( Exception e) {
			throw new ServletException(e);
		}
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String updateid = request.getParameter("studentId");
		Student editstu = studentdbutil.getStudent(updateid);
		request.setAttribute("edit_student", editstu);
		RequestDispatcher dispatcher = request.getRequestDispatcher("update-student-form.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
