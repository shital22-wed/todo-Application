package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import com.beans.User;
import com.utils.JDBCUtils;

public class UserDao {

	public int registerEmployee(User employee) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO users"
				+ "  (first_name, last_name, gender, phone, username, password, rep_password, status,registerDate) VALUES "
				+ " (?, ?, ?, ?,?,?,?,?,?);";

		int result = 0;
		int id=0;
		try (Connection connection = JDBCUtils.getConnection();
			
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			//preparedStatement.setInt(1,employee.getId()+1);
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getGender());
			preparedStatement.setString(4, employee.getPhone());
			preparedStatement.setString(5, employee.getUsername());
			preparedStatement.setString(6, employee.getPassword());
			preparedStatement.setString(7, employee.getRep_password());
			preparedStatement.setString(8, "active");
			Statement stm2=connection.createStatement();
			ResultSet rs2=stm2.executeQuery("select curdate()");
			
			while(rs2.next()) {
				System.out.println(rs2.getDate(1));
				Date d=rs2.getDate(1);
				preparedStatement.setDate(9, d);
			}
			System.out.println(preparedStatement);
			
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			JDBCUtils.printSQLException(e);
		}
		return result;
	}

}
