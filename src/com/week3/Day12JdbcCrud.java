package com.week3;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Day12JdbcCrud {

	public static void main(String[] args) {
		String url 		= "jdbc:mysql://127.0.0.1/studentdb?serverTimezone=UTC";
		String username = "root";
		String password = "root";
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			
			// Create table as 'teachers'
			try(Statement st = con.createStatement()) {
				String query = "create table teachers(tId int primary key auto_increment, tName varchar(100) not null)";
				
				// execute query
				st.executeUpdate(query); // used to execute DDL and DML commands
			}
			
			// Insert records in the table 'teachers' using PreparedStatement
			String insertQuery = "insert into teachers(tName) values(?)";
			try(PreparedStatement pst = con.prepareStatement(insertQuery)) {
				
				// set values to be inserted for fields
				pst.setString(1, "Rohini");
				
				// execute the query
				pst.executeUpdate(); // used to execute DDL and DML commands							
			}
			
			// Select and display data
			String selectQuery = "select * from teachers";
			try(Statement st = con.createStatement()) {
				
				// execute the query and assign the table view to ResultSet object
				ResultSet rs = st.executeQuery(selectQuery);
				
				// check if data is there then process it
				while(rs.next()) {
					int tId			= rs.getInt(1);
					String tName 	= rs.getString(2);
					System.out.println("Id: "+tId+" Name: "+tName);
				}
				
				// close the ResultSet object
				rs.close();
			}
			
			// Update records in the table 'teachers' using PreparedStatement
			String updateQuery = "update teachers set tName = ? where tId = ? ";
			try(PreparedStatement pst = con.prepareStatement(updateQuery)) {
				
				// set values for fields to update record
				pst.setString(1, "Sweety");
				pst.setInt(2, 1);
				
				// execute the query
				pst.executeUpdate(); // used to execute DDL and DML commands
			}
			
			// Delete records from the table 'teachers' using PreparedStatement
			String deleteQuery = "delete from teachers where tId = ?";
			try(PreparedStatement pst = con.prepareStatement(deleteQuery)) {
				
				// set values for fields to delete record
				pst.setInt(1, 1);
				
				// execute the query
				pst.executeUpdate(); // used to execute DDL and DML commands
			}
			
			System.out.println("Using JDBC CRUD operations are performed");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		// Output:- 
		/* 
		 	Id: 1 Name: Rohini
			Using JDBC CRUD operations are performed
		*/
	}

}
