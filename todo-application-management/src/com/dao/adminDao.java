
package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.User;
import com.utils.JDBCUtils;

public class adminDao {

	public List<User> getUser() {
		// TODO Auto-generated method stub
   List<User>list = new ArrayList<User>();
   Connection con = JDBCUtils.getConnection();
   Statement st=null;
   ResultSet rs=null;
   String query="select * from Users";
   try {
	   st=con.createStatement();
	   rs=st.executeQuery(query);
	   while (rs.next()) {
		  int id=rs.getInt(1);
		  System.out.println(id);
		   String firstName=rs.getString(2);
		   String lastName=rs.getString(3);
		   String gender=rs.getString(4);
		   String phone=rs.getString(5);
		   String username=rs.getString(6);
		   String password=rs.getString(7);
		   String rep_password=rs.getString(8);
		   String status=rs.getString(9);
		   
		   User u=new User();
		   u.setId(id);
		   System.out.println(u.getId());
		   u.setFirstName(firstName);
		   u.setLastName(lastName);
		   u.setGender(gender);
		   u.setPhone(phone);
		   u.setUsername(username);
		   u.setPassword(password);
		   u.setRep_password(rep_password);
		   u.setStatus(status);
		   list.add(u);
		   
	   }
	   System.out.println(list);
	   
   }catch(SQLException e) {
	   e.printStackTrace();
   }
   return list;
   

       
	}
	

}
