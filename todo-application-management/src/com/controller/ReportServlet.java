package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/report")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int new_user;
	static int active_user;
	static int new_task;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter out= response.getWriter();
		
		Count();
		
		
		response.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<script>\r\n" + 
				"	window.onload = function() {\r\n" + 
				"\r\n" + 
				"		var chart = new CanvasJS.Chart(\"chartContainer\", {\r\n" + 
				"			animationEnabled : true,\r\n" + 
				"			theme : \"light2\",\r\n" + 
				"			title : {\r\n" + 
				"				text : \"Report of 7 days\"\r\n" + 
				"			},\r\n" + 
				"			axisY : {\r\n" + 
				"				title : \"\"\r\n" + 
				"			},\r\n" + 
				"			data : [ {\r\n" + 
				"				type : \"column\",\r\n" + 
				"				showInLegend : true,\r\n" + 
				"				legendMarkerColor : \"blue\",\r\n" + 
				"				legendText : \"list of report\",\r\n" + 
				"				dataPoints : [\r\n" + 
				"					{ y:"+new_user+", label: \"New User\" },\r\n" + 
				"					{ y:"+active_user+",  label: \"Active User\" },\r\n" + 
				"					{ y: "+new_task+",  label: \"New Task\" }\r\n" + 
				"				 ]\r\n" + 
				"			} ]\r\n" + 
				"		});\r\n" + 
				"		chart.render();\r\n" + 
				"\r\n" + 
				"	}\r\n" + 
				"</script>\r\n" + 
				"</head>\r\n" + 
				"<body style='background-color: black'>\r\n" +
				"<form action=\"adminController\" method=\"get\" id=\"list\">\r\n" + 
				"<button type=\"submit\" class=\"btn btn-success\">Go Back</button>\r\n" +
				"<button style='float:right;'><a href=\"login/login.jsp\" id=\"signuplink\">Logout</a></button>"+
				"</form>"+
				"	<div id=\"chartContainer\"\r\n" + 
				"		style=\"height: 370px; max-width: 920px; margin: 0px auto;\"></div>\r\n" + 
				"	<script src=\"canvasjs.min.js\"></script>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
		
	}
	
	public static void Count() {
	//System.out.println("inside count");
		
		Connection con=null;
		Statement stm=null;
		ResultSet rs= null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root","root");
				
				stm=con.createStatement();
				rs=stm.executeQuery("select * from users where registerDate >= (curdate() - interval 7 day)");
				new_user=0;
				active_user=0;
				
				while(rs.next()) {
					new_user++;
					if(rs.getString("status").equals("active")) {
						active_user++;
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
		
		
		
		
		Connection con1=null;
		Statement stm1=null;
		ResultSet rs1= null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root","root");
				
				stm1=con1.createStatement();
				rs1=stm1.executeQuery("select * from taskinfo where curdate >= (curdate() - interval 7 day)");
				new_task=0;
				
				while(rs1.next()) {
					new_task++;
				
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
				con1.close();
				stm1.close();
				rs1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
			
   
}
}
