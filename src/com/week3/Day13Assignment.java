package com.week3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Day13Assignment {

	public static void main(String[] args) {
		
		String url 		= "jdbc:mysql://localhost:3306/games?serverTimezone=UTC";
		String username = "root";
		String password = "root";
		
		// 1. Create(Insert) record in database table
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			// create insert query
			String insertQuery = "insert into cricketer(c_name) values(?)";
			
			// create PreparedStatement for pre-compiled queries
			PreparedStatement pst = con.prepareStatement(insertQuery);
			
			// set values for fields
			pst.setString(1, "Dinesh Kartik");
			int insertedRows = pst.executeUpdate();
			
			if(insertedRows > 0) {
				System.out.println("Record inserted successfully.");		
			}
		}
		catch(SQLException e) {
			System.out.println("Record failed to insert.");
			e.printStackTrace();
		}
		// Output:- Record inserted successfully.
		
		// 2. Read(Select) record in database table
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			// create select query
			String selectQuery = "select * from cricketer";
			
			// create Statement object
			Statement st = con.createStatement();
			
			// execute query
			ResultSet rs = st.executeQuery(selectQuery); // used to execute DQL statements
			
			// move row by row
			boolean rowExist = rs.next();
			if(rowExist) {
				System.out.println("Cricketer details fetched successfully.");
				while(rowExist) {
					int cId 		= rs.getInt(1);
					String cName 	= rs.getString(2);
					System.out.println("Id: "+cId+" Cricketer Name: "+cName);
					rowExist = rs.next();
				}
			}
						
			// close the ResultSet object			
			rs.close();
			
			// close the Statement object
			st.close();
		}
		catch(SQLException e) {
			System.out.println("Record failed to fetched.");	
			e.printStackTrace();
		}
		// Output:-
		/*
			Cricketer details fetched successfully.
			Id: 2 Cricketer Name: Rohit Sharma
			Id: 3 Cricketer Name: Dinesh Kartik
		*/
		
		// 3. Update record in database table
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			// create update query
			String updateQuery = "update cricketer set c_name = ? where c_id = ?";
			
			// create PreparedStatement object
			PreparedStatement pst = con.prepareStatement(updateQuery);
			
			// set values for fields
			pst.setString(1, "Suryakumar Yadav");
			pst.setInt(2, 3);
			
			// execute query
			int rowsUpdated = pst.executeUpdate(); // used to execute DDL and DML and statements
			
			if(rowsUpdated > 0) {
				System.out.println("Record updated successfully.");
			}
			
			// close the PreparedStatement object
			pst.close();
		}
		catch(SQLException e) {
			System.out.println("Record failed to update.");
			e.printStackTrace();
		}
		// Output:- Record updated successfully.
		
		// 4. Delete record from database table
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			// create delete query
			String deleteQuery = "delete from cricketer where c_id = ?";
			
			// create PreparedStatement object
			PreparedStatement pst = con.prepareStatement(deleteQuery);
			
			// set values for fields
			pst.setInt(1, 3);
			
			// execute query
			int rowsDeleted = pst.executeUpdate(); // used to execute DDL and DML and statements
			
			if(rowsDeleted > 0) {
				System.out.println("Record deleted successfully.");				
			}
			
			// close the PreparedStatement object
			pst.close();
			
		}
		catch(SQLException e) {
			System.out.println("Record failed to delete");
			e.printStackTrace();
		}
		// Output:- Record deleted successfully.
		
	}

}
