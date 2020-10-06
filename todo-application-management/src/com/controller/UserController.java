
package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.User;
import com.dao.UserDao;

@WebServlet("/register")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		register(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("register/register.jsp");
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
   
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rep_password = request.getParameter("rep_password");
		String status = request.getParameter("status");
		
		if(password.equals(rep_password)) {
			
		
		

		User employee = new User();
		//employee.setId(id);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setGender(gender);
		employee.setPhone(phone);
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setRep_password(rep_password);
		employee.setStatus(status);

		try {
			int result = userDao.registerEmployee(employee);
			if(result == 1) {
				request.setAttribute("NOTIFICATION", "User Registered Successfully!");
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("register/register.jsp");
		dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("NOTIFICATION", "Enter confirm password same as password ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("register/register.jsp");
			dispatcher.forward(request, response);
		}
	}
}
