package com.week3;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Day12Assignment {

	public static void main(String[] args) {
		String url 		= "jdbc:mysql://localhost:3306/studentdb?serverTimezone=UTC";
		String username = "root";
		String password = "root";
		// 1. Creating database table using Statement
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			
			// create table query
			String query = "create table if not exists students(sId int primary key auto_increment, sName varchar(100) not null, sEmail varchar(100))";
			
			// create Statement object
			Statement st = con.createStatement();
			
			st.executeUpdate(query); // used to execute both DML and DDL commands
			System.out.println("Table created successfully.");
			// close Statement object
			st.close();
		}
		catch(SQLException e) {			
			e.printStackTrace();
		}
		// Output:- Table created successfully.
		
		// 2. Inserting records in table 'students'
		try {
			// create connection
			Connection con = DriverManager.getConnection(url, username, password);
			
			// create insert Query
			String insertQuery = "insert into students(sName, sEmail) values('Parag', 'parag12@test.com'), ('Suraj', 'suraj34@test.com')";
			
			// create Statement object
			Statement st = con.createStatement();
			
			// execute query
			st.executeUpdate(insertQuery); // used to execute both DML and DDL commands
			System.out.println("Record inserted successfully.");
			
			// close Statement object
			st.close();
			
			// close the Connection object
			con.close();
		}
		catch(SQLException e) {
			System.out.println("Failed to Insert the data.");
			e.printStackTrace();
		}
		// Output:- Record inserted successfully.
		
		// 3. Updating records in table 'students'
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			// create update query
			String updateQuery = "update students set sEmail = null where sId = 1";
			
			// create Statement object
			Statement st = con.createStatement();
			
			// execute query
			st.executeUpdate(updateQuery); // used to execute both DML and DDL commands
			System.out.println("Record updated successfully.");
			st.close();
		}
		catch(SQLException e) {
			System.out.println("Record failed updated.");
			e.printStackTrace();
		}
		// Output:- Record updated successfully. --> record with sId '1' i.e sName as Parag its email got updated as NULL in database table 'students'.
		
		// 4. Deleting records from table 'students'
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			
			// create delete query
			String deleteQuery = "delete from students where sId = 2";
			
			// create Statement object
			Statement st = con.createStatement();
			
			// execute query
			st.executeUpdate(deleteQuery); // used to execute both DML and DDL commands			
			System.out.println("Record deleted successfully.");			
			
			// close Statement object
			st.close();
		}
		catch(SQLException e) {
			System.out.println("Record failed to deleted");
			e.printStackTrace();
		}
		// Output:- Record deleted successfully. --> record with sId '2' i.e sName as Suraj its record is deleted from database table 'students'.
		
		// 5. Using ResultSet to retrieve data
		try {
			// create connection
			Connection con = DriverManager.getConnection(url, username, password);
			
			// create select query
			String selectQuery = "select * from students";
			
			// create Statement object
			Statement st = con.createStatement();
			
			// store table view in ResultSet object by executing the query
			ResultSet rs = st.executeQuery(selectQuery); // used to execute DQL commands
			
			// check if record exists in the ResultSet object
			System.out.println("Below are the student details:");
			while(rs.next()) {
				int studentId 		= rs.getInt(1);
				String studentName 	= rs.getString("sName");
				String studentEmail = rs.getString("sEmail");				
				System.out.println("Id: "+ studentId +" Name: "+ studentName +" Email: "+ studentEmail);
			}
			
			// close ResultSet object
			rs.close();
			
			// close Statement object
			st.close();
			
			// close the Connection object
			con.close();
			
		}
		catch(SQLException e) {
			System.out.println("Failed to retrieve data");
			e.printStackTrace();
		}
		// Output:-
		/*
			Below are the student details:
			Id: 1 Name: Parag Email: null
			Id: 3 Name: Parag Email: parag12@test.com
			Id: 4 Name: Suraj Email: suraj34@test.com
		*/
		
		// 6. Using PreparedStatement for Parameterized Queries
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			
			// create insert query			
			String insertQuery = "insert into students(sName,sEmail) values(?, ?)";
			
			// create PreparedStatement object for parametrized query
			PreparedStatement pst;
			pst = con.prepareStatement(insertQuery);
			
			// set field values			
			pst.setString(1, "Dhruv");
			pst.setString(2, "dhruv12@test.com");
			
			// execute query
			pst.executeUpdate(); // used to execute both DML and DDL commands		
			
			System.out.println("Record inserted successfully using PreparedStatement.");
			// Output:- Record inserted successfully using PreparedStatement.
			
			// create select query
			String selectQuery = "select * from students where sEmail = ?";
			
			// create compiled query and initialize to PreparedStatement object i.e pst
			pst = con.prepareStatement(selectQuery);
			
			// set field value for searching the record
			pst.setString(1, "dhruv12@test.com");
			
			// execute the query and assign the table view to ResultSet object
			ResultSet rs = pst.executeQuery(); // used to execute the DQL commands
			
			// check if data exist then process it
			System.out.println("Record retrieve successfully:");
			while(rs.next()) {
				String sName 	= rs.getString(2);
				String sEmail 	= rs.getString(3);
				System.out.println("Name: "+sName+" Email: "+sEmail);
			}
			
			// closing the ResultSet object
			rs.close();
			// Output:-
			/*
				Record retrieve successfully:
				Name: Dhruv Email: dhruv12@test.com
			*/
			
			// create update query
			String updateQuery = "update students set sEmail = ? where sId = ?";
			
			// create compiled query and initialize to PreparedStatement object i.e pst
			pst = con.prepareStatement(updateQuery);
			
			// set field value for updating the record
			pst.setString(1, "parag45@test.com");
			pst.setInt(2, 1);
			
			// execute query
			pst.executeUpdate(); // used to execute both DML and DDL commands
			
			System.out.println("Record updated successfully.");
			// Output:- Record updated successfully. --> record with sId '1' i.e sName as Parag its email got updated as 'parag45@test.com' in database table 'students'.
			
			// create delete query
			String deleteQuery = "delete from students where sId = ?";
			
			// create compiled query and initialize to PreparedStatement object i.e pst
			pst = con.prepareStatement(deleteQuery);
			
			// set field value for updating the record
			pst.setInt(1, 1);
			
			// execute query
			pst.executeUpdate(); // used to execute both DML and DDL commands
			
			System.out.println("Record deleted successfully."); 
			// Output:- Record deleted successfully. --> record with sId '1' i.e sName as Parag record get deleted from database table 'students'.
			
			// close the PreparedStatement object
			pst.close();
		}
		catch(SQLException e) {
			System.out.println("Failed to select the record");
			e.printStackTrace();
		}
		
		
	}

}
