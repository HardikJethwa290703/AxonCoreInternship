package com.week3;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Day13JdbCrud {

	private static final String url 		= "jdbc:mysql://localhost:3306/studentdb?serverTimezone=UTC";
	private static final String username 	= "root";
	private static final String password 	= "root";
	
	public static void main(String[] args) {
		
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			
			System.out.println("Connected to database.");

			// Create record in database table
			insertQuery(con, "Rohit", "rohit67@test.com");
			// Output:- Record inserted successfully.
			
			// Read record from database table
			selectQuery(con);
			// Output:-
			/*
				Student Details:
				Name: Rajan Email: rajan12@test.com
				Name: Rohini Email: rohini67@test.com
				Name: Rohit Email: rohit67@test.com
			*/
			
			// Update record in database table
			updateQuery(con, "Rajan", "rajan45@test.com");
			// Output:- Record updated successfully.
			
			// Read record from database table after updating the record
			selectQuery(con);
			// Output:-
			/*
				Student Details:
				Name: Rajan Email: rajan45@test.com
				Name: Rohini Email: rohini67@test.com
				Name: Rohit Email: rohit67@test.com
			*/

			// Delete record from database table
			deleteQuery(con, "Rohit");
			// Output:- Record deleted successfully.
			
			// Read record from database table after deleting the record
			selectQuery(con);
			// Output:-
			/*
				Student Details:
				Name: Rajan Email: rajan45@test.com
				Name: Rohini Email: rohini67@test.com
			*/
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// insert method for inserting records in the database table
	private static void insertQuery(Connection con, String name, String email) throws SQLException {
		
		// create insert query
		String insertQuery = "insert into students(sName, sEmail) values(?,?)";
		
		// create PreparedStatement object for pre-compiled queries
		try(PreparedStatement pst = con.prepareStatement(insertQuery)) {
			// set values for fields
			pst.setString(1, name);
			pst.setString(2, email);
			
			// execute query
			int rowsInserted = pst.executeUpdate();
			if(rowsInserted > 0) {
				System.out.println("Record inserted successfully.");
			}
		}
	}
	
	// select method for retrieving records from the database table
	public static void selectQuery(Connection con) throws SQLException {
		
		// create select query
		String selectQuery = "select * from students";
		
		// create PreparedStatement object for pre-compiled queries
		try(Statement st = con.createStatement()) {
			
			// execute query and assign the result to ResultSet object
			ResultSet rs = st.executeQuery(selectQuery);
			boolean rowsExist = rs.next();
			if(rowsExist) {
				System.out.println("Student Details:");	
				while(rowsExist) {
					System.out.println("Name: "+rs.getString(2)+" Email: "+rs.getString(3));
					rowsExist = rs.next();
				}
			}
			
			// close the ResultSet object
			rs.close();
		}
	}
	
	// update method for updating records in the database table
	public static void updateQuery(Connection con, String name, String email) throws SQLException {
		
		// create update query
		String updateQuery = "update students set sEmail = ? where sName = ?";
		
		// create PreparedStatement object for pre-compiled queries
		try(PreparedStatement pst = con.prepareStatement(updateQuery)) {
			// set values for fields
			pst.setString(1, email);
			pst.setString(2, name);
			
			// execute query
			int rowsUpdated = pst.executeUpdate();
			if(rowsUpdated > 0) {
				System.out.println("Record updated successfully.");
			}
		}
	}
	
	// delete method for deleting records from the database table
	public static void deleteQuery(Connection con, String name) throws SQLException {
		
		// create delete query
		String deleteQuery = "delete from students where sName = ?";
		
		// create PreparedStatement object for pre-compiled queries
		try(PreparedStatement pst = con.prepareStatement(deleteQuery)) {
			// set values for fields			
			pst.setString(1, name);
			
			// execute query
			int rowsDeleted = pst.executeUpdate();
			if(rowsDeleted > 0) {
				System.out.println("Record deleted successfully.");
			}
		}
	}

}
