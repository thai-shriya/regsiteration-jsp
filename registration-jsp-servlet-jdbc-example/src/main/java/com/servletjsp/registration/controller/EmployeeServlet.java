package com.servletjsp.registration.controller;

import java.io.IOException;
import com.servletjsp.registration.model.Employee;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.servletjsp.registration.DAO.EmployeeDao;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	//}

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String username=request.getParameter("userName");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		
		Employee emp=new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setUserName(username);
		emp.setPassword(password);
		emp.setAddress(address);
		
		EmployeeDao employeeDao=new EmployeeDao();
		try {
			employeeDao.employeeRegister(emp);
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		response.sendRedirect("employeeDetails.jsp");
		
		
		
		
	}

}
