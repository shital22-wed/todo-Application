package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.beans.LoginBean;

import com.task.ToDoServlet;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	static String username;
	static String password;
	static Boolean flag=false;
	static Boolean flag1=false;
	static String firstName;
	static String lastName;
	static int id;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		//System.out.println("hiiiiiii");
 		flag=false;
 		
		
		
		PrintWriter out=response.getWriter();
		
		
		username=request.getParameter("username");
		password=request.getParameter("password");
		UserCheck();
		
		if(flag==true) {
			ToDoServlet.setUid(id);
			response.sendRedirect("todolist.html");
		}
		
		else if(flag1==true) {
			adminController.getUid(id);
			request.getRequestDispatcher("adminController").forward(request, response);
		}
		
	
			/*else {
				HttpSession session = request.getSession();
			}
*/	
		else
		{
		   out.println("<script type=\"text/javascript\">");
		   out.println("alert('User or password incorrect');");
		   out.println("window.location='login/login.jsp';");
		   out.println("</script>");
		}
	}
	
	public static void UserCheck() {
		
		Connection con=null;
		Statement stm=null;
		ResultSet rs=null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root","root");
				
				stm=con.createStatement();
				
				rs=stm.executeQuery("select * from users");
				
				while(rs.next()) {
					
					if(rs.getString("username").equals(username) && rs.getString("password").equals(password) && rs.getString("status").equals("active")) {
						if(rs.getString("useraccess").equals("nonadmin")) {
						flag=true;
						firstName=rs.getString("first_name");
						lastName=rs.getString("last_name");
						id=rs.getInt("id");
						break;
						}
						
						else if(rs.getString("useraccess").equals("admin")) {
							flag1=true;
							firstName=rs.getString("first_name");
							lastName=rs.getString("last_name");
							id=rs.getInt("id");
							break;
						}
	
					}
					
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				con.close();
				stm.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
