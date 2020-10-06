package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.User;
import com.dao.adminDao;

@WebServlet("/adminController")
public class adminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int uid;
	
	public static void getUid(int x) {
		uid=x;
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		adminDao t=new adminDao();
		List<User>list=t.getUser();
		
		out.println("<!DOCTYPE html>");
 		out.println("<html>");
 		out.println("<head>");
 		out.println("<title>View List</title>");
 		out.println("<link rel=\"stylesheet\"\r\n" + 
 				"	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n" + 
 				"	integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n" + 
 				"	crossorigin=\"anonymous\">\r\n");
 		out.println("</head>");
 		
 		out.println("<body>");
 
 
 		out.println("<h3><center>List of Users</center></h3>");
 	   out.println("<hr>");
 		//out.println("<span><a href='/ReportServlet'><button>Show Report</button></a></span>");
 		out.println("<form action=\"report\" method=\"get\">\r\n" + 
 				"				<button type=\"Submit\">Report</button>\r\n" + 
 				"				</form>");
 	   out.println("<span><a href='login/login.jsp'><button style='float:right;'>Logout</button></a></span>");
 		 out.println("<br>");
 		out.println("<br>");
 	   out.println("<table border='1' widt'100%'");
	  out.print("<tr><th>Id</th><th>firstName</th><th>lastName</th><th>status</th><th>Action</th></tr>");
		                                                                                                                                                                                                                      
		for(User e:list){
			out.print("<td>"+e.getId()+"</td><td>"+e.getFirstName()+"</td><td>"+e.getLastName()+"</td><td>"+e.getStatus()+"</td><td> <button type='submit' class='btn btn-denger'><a href='changeStatus?id="+e.getId()+"'>Change Status</a></button></td></tr>");
		}
		
		
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
	

}
