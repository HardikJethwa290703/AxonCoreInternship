package com.week3;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Day13PracticeJdbc {

	private static final String url 		= "jdbc:mysql://127.0.0.1:3306/records?serverTimezone=UTC";
	private static final String username 	= "root";
	private static final String password 	= "root";
	
	public static void main(String[] args) {
		
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			System.out.println("Connected to database");
			
			// Inserting book data
			createBooks(con, "Good habits bad habits", "Vishwasu", 200);
			// Output:- Record inserted successfully
			
			// Reading book data
			readBooks(con);
			// Output:-
			/*
				Books listed below successfully:
				Title: Wings of fire Author: Shri A.P.J Abdul Kalam Price: 500.0
				Title: Good habits bad habits Author: Vishwasu Price: 200.0
			*/
			
			// Updating book data
			updateBooks(con, "Wings of fire", 730);
			// Output:- Record updated successfully.
			
			// Reading book data after updating record
			readBooks(con);
			// Output:-
			/*
				Books listed below successfully:
				Title: Wings of fire Author: Shri A.P.J Abdul Kalam Price: 730.0
				Title: Good habits bad habits Author: Vishwasu Price: 200.0
			*/
			
			// Deleting book data
			deleteBooks(con, "Shri A.P.J Abdul Kalam");
			// Output:- Record deleted successfully
			
			// Reading book data after deleting record
			readBooks(con);
			// Output:-
			/*
				Books listed below successfully:
				Title: Good habits bad habits Author: Vishwasu Price: 200.0
			*/
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Method for Inserting record
	public static void createBooks(Connection con, String title, String author, double price) throws SQLException {
		
		// create insert query
		String insertQuery = "insert into books(title, author, price) values(?,?,?)";
		
		// create PreparedStatement object
		try(PreparedStatement pst = con.prepareStatement(insertQuery)) {
			
			// set values for fields
			pst.setString(1, title);
			pst.setString(2, author);
			pst.setDouble(3, price);
			
			// execute query
			int rowsInserted = pst.executeUpdate();
			if(rowsInserted > 0) {
				System.out.println("Record inserted successfully");
			}			
			
		}		
	}
	
	// Method for Reading records
	public static void readBooks(Connection con) throws SQLException{
		// create select query
		String selectQuery = "select * from books";
		
		try(Statement st = con.createStatement()) {
			// execute query
			ResultSet rs = st.executeQuery(selectQuery);
			// check if row exist
			boolean rowsExist = rs.next();
			if(rowsExist) {
				System.out.println("Books listed below successfully:");
				while(rowsExist) {
					System.out.println("Title: "+rs.getString(2)+" Author: "+rs.getString(3)+" Price: "+rs.getDouble(4));
					rowsExist = rs.next();
				}
			}
			
			// close the ResultSet object
			rs.close();
		}
	}

	// Method for Updating recordds
	public static void updateBooks(Connection con, String title, double price) throws SQLException {
		// create update query
		String updateQuery = "update books set price = ? where title = ?";
		
		// create PreparedStatement object
		try(PreparedStatement pst = con.prepareStatement(updateQuery)) {
			
			// set values for fields
			pst.setDouble(1, price);
			pst.setString(2, title);
			
			// execute query
			int rowsUpdated = pst.executeUpdate();
			if(rowsUpdated > 0) {
				System.out.println("Record updated successfully.");
			}
		}
	}
	
	// Method for Deleting records
	public static void deleteBooks(Connection con, String author) throws SQLException {
		// create delete query
		String deleteQuery = "delete from books where author = ?";
		
		// create PreparedStatement object
		try(PreparedStatement pst = con.prepareStatement(deleteQuery)) {
			
			// set value for fields
			pst.setString(1, author);
			
			// execute query
			int rowsDeleted = pst.executeUpdate();
			
			if(rowsDeleted > 0) {
				System.out.println("Record deleted successfully");
			}
		}
	}
}
