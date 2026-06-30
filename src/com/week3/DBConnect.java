package com.week3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 1. Create a Java program that connects to MySQL database.
public class DBConnect {
	public Connection dbConnect() throws SQLException {
		String url 		= "jdbc:mysql://localhost:3306/inventory?serverTimezone=UTC";
		String username = "root";
		String password = "root";	
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}
}
