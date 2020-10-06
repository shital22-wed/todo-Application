package com.controller;

import java.awt.SecondaryLoop;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class changeStatus
 */
@WebServlet("/changeStatus")
public class changeStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public changeStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int tid = Integer.parseInt(request.getParameter("id"));
		System.out.println(tid);

		Connection con = null;
		Statement stm = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "root");

			stm = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

			

			ResultSet rs1 = stm.executeQuery("select status from users where id=" + tid);
			rs1.next();
			if (rs1.getString("status").equals("deactive")) {

				int rs = stm.executeUpdate("update users set status='active' where id=" + tid);
			} else {
				int rs = stm.executeUpdate("update users set status='deactive' where id=" + tid);
			}

			
			response.sendRedirect("adminController");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
