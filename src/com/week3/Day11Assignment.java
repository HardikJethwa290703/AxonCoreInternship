package com.week3;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Day11Assignment {

	public static void main(String[] args) {
		// Working with JDBC
		// 1. Creating connection with database
		Connection con = null; // Defining Connection as null so this connection instance can be used further.
		try {
			// loading the class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create a connection
			String url 		= "jdbc:mysql://127.0.0.1:3306/youtube"; // youtube database is created in MYSQL DBMS
			String username = "root";
			String password = "root";
			
			con = DriverManager.getConnection(url, username, password);
			
			// checking if connection is not closed, then connection successfully established with database
			if(con != null) {
				System.out.println("Connection created");
			}
						
		}
		catch(ClassNotFoundException e) { // if failed to load the the JDBC Driver Class
			System.out.println("Cannot load the JDBC Driver class");
		}
		catch(SQLException e) { // it is used to handle database exception
			System.out.println("Failed to connect with database");
		}
		// Output:- Connection created
		
		// 2. Creating table executing it on database
		try {
			// create a query
			String query = "create table creator(cId int primary key auto_increment, cName varchar(180), cCity varchar(200) default null)";
			
			// create a Statement object
			Statement st = con.createStatement();
			
			// used to execute the query(DML and DDL queries)
			st.executeUpdate(query);
			
			System.out.println("Table Creator is created in database successfully");
			
		}
		catch(SQLException e) {
			System.out.println("Sql exception occured");
			e.printStackTrace();
		}
		// Output:- Table Creator is created in database successfully
		
		// 3. Inserting records in the table 'Creator' using Statement
		try {
			// insert query
			String query = "insert into creator(cName, cCity) values('Param', 'Mumbai'), ('Vrushali', 'Pune')";
			
			// create a Statement object
			Statement st = con.createStatement();
			
			// used to execute the query(DML and DDL queries)
			st.executeUpdate(query);
						
			System.out.println("Record Inserted successfully");
			
		}
		catch(SQLException e) {
			System.out.println("Failed to insert the record!");
			e.printStackTrace();
		}
		// Output:- Record Inserted successfully
		
		// 4. Inserting records in the table 'Creator' using PreparedStatement(dynamic value)
		try {
			// create dynamic or parameterized insert query
			String query = "insert into creator(cName, cCity) values(?,?)";
			
			// create a PreparedStatement object(It is used to create dynamic or parameterized query)
			PreparedStatement pst = con.prepareStatement(query);
			
			// setting the values
			pst.setString(1, "Rohini");
			pst.setString(2, "Bihar"); // for setting the string or varchar values in database
			
			// used to execute the query(DML and DDL queries)
			pst.executeUpdate();
			
			System.out.println("Record Inserted successfully");
		}
		catch(SQLException e) {
			System.out.println("Failed to insert the record!");
			e.printStackTrace();
		}
		// Output:- Record Inserted successfully
		
		// 5. Retrieving records from the table 'Creator' 
		try {
			// retrieving records from table 'Creator'
			String query = "select * from creator";
			
			// create a Statement object
			Statement st = con.createStatement();
			
			// executing DQL statements and returning the table view to ResultSet object
			ResultSet rs = st.executeQuery(query);
			
			// process the data
			System.out.println("Retrieving data from the 'Creator' table:");
			while(rs.next()) { // checking if data exist in the ResultSet object next row
				// if data exist then ResultSet object will move to next row and will be now the current row
				String creatorName = rs.getString("cName"); // accessing value of current row
				String creatorCity = rs.getString("cCity"); // accessing value of current row
				System.out.println("Creator Name is "+creatorName+" and lives in City "+creatorCity);
			}
			
		}
		catch(SQLException e) {
			System.out.println("Unable to fetch data.");
			e.printStackTrace();
		}
		// Output:- 
		/*
			Retrieving data from the 'Creator' table:
			Creator Name is Param and lives in City Mumbai
			Creator Name is Vrushali and lives in City Pune
			Creator Name is Rohini and lives in City Bihar
		*/
		
		// 6. Updating record in the table 'Creator'
		try {
			// update query
			String query = "update creator set cCity = 'surat' where cId = 2";
			
			// create a Statement object
			Statement st = con.createStatement();
			
			// used to execute the query(DML and DDL queries)
			st.executeUpdate(query);
			System.out.println("Record updated successfully.");
		}
		catch(SQLException e) {
			System.out.println("Record failed to update");
			e.printStackTrace();
		}
		// Output:- Record updated successfully. --> record with cId = 2 i.e Vrushali record get updated with new cCity as 'surat'
		
		// 6. Deleting record from the table 'Creator'
		try {
			// delete query
			String query = "delete from creator where cId = 1";
			
			// create a Statement object
			Statement st = con.createStatement();
			
			// used to execute the query(DML and DDL queries)
			st.executeUpdate(query);
			System.out.println("Record deleted successfully.");
		}
		catch(SQLException e) {
			System.out.println("Record failed to delete");
			e.printStackTrace();
		}
		// Output:- Record deleted successfully. --> record with cId = 1 i.e Param record is deleted
	}

}
