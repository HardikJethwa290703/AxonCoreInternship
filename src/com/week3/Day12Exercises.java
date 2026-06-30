package com.week3;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// class Product  is declared to hold the products id,name and price
class Product {
	
	String productName;
	double productPrice;
	
	public Product(String productName, double productPrice) {
		this.productName 	= productName;
		this.productPrice 	= productPrice;
	}
	
}

public class Day12Exercises {

	public static void main(String[] args) {
		
		// 1. Create a Java program that connects to MySQL database.
		// Since for database interaction we require a Connection object so we implemented at 'DBConnect' class and use it wherever required
		DBConnect dbConnect = new DBConnect();
		
		// 2. Create a products table with columns: id, name, price.
		try {
			// dbConnect() method present in 'DBConnect' class which returns Connection object
			Connection con = dbConnect.dbConnect();
			
			// create table 'products'
			String query = "create table products(id int primary key auto_increment, name varchar(100) not null, price double(10,2))";
			
			// create Statement object
			Statement st = con.createStatement();
			
			// execute query
			st.executeUpdate(query);
			
			System.out.println("Table created successfully");
			
			// closing the Statement object
			st.close();
			
			// closing the connection
			con.close();
		}
		catch(Exception e) {
			System.out.println("Table failed to create");
			e.printStackTrace();
		}
		// Output:- Table created successfully
		
		// 3. Insert 3 products using PreparedStatement.
		try {
			// dbConnect() method present in 'DBConnect' class which returns Connection object
			Connection con = dbConnect.dbConnect();
			
			// create insert query
			String insertQuery = "insert into products(name, price) values(?,?)";
			
			// create PreparedStatement object for pre-compiled query
			PreparedStatement pst = con.prepareStatement(insertQuery);
			
			// set values for fields
			// created Product as reference array in which we will be storing 3 products
			Product[] products = {new Product("Watch", 8921), new Product("Chair", 200), new Product("Football", 600)};
			for(Product product: products) {
				pst.setString(1, product.productName);
				pst.setDouble(2, product.productPrice);
				pst.executeUpdate();
			}
			System.out.println("Products added successfully.");
			
			// closing the PreparedStatement object
			pst.close();
			
			// closing the connection
			con.close();	
		}
		catch(SQLException e) {
			System.out.println("Failed to add products");
			e.printStackTrace();
		}
		// Output:- Products added successfully.
		
		// 4. Display all products.
		try(Connection con = dbConnect.dbConnect()) {
			// create select query
			String selectQuery = "select * from products";
			
			// create Statement object
			Statement st = con.createStatement();
			
			// execute query and assign it to ResultSet object
			ResultSet rs = st.executeQuery(selectQuery);
			
			// check if data is there and print the data
			while(rs.next()) {
				int pId 		= rs.getInt(1);
				String pName 	= rs.getString(2);
				double pPrice 	= rs.getDouble(3);
				System.out.println("Product details:"); 
				System.out.println("Id: "+pId+" Name: "+pName+" Price: "+pPrice);
			}
			
			System.out.println("Products fetched successfully.");
			
			// closing the Statement object
			st.close();
		}
		catch(SQLException e) {
			System.out.println("Failed to retrieve data");
			e.printStackTrace();
		}
		// Output:-
		/*
			Product details:
			Id: 1 Name: Watch Price: 8921.0
			Product details:
			Id: 2 Name: Chair Price: 200.0
			Product details:
			Id: 3 Name: Football Price: 600.0
			Products fetched successfully.
		*/
		
		// 4. Update the price of one product.
		try(Connection con = dbConnect.dbConnect()) {
			// create update query
			String updateQuery = "update products set price = 300 where id = 2";
			
			// create Statement object
			Statement st = con.createStatement();
			
			// execute query
			st.executeUpdate(updateQuery);
			System.out.println("Product updated successfully.");
			
			// closing the Statement object
			st.close();
		}
		catch(SQLException e) {
			System.out.println("Failed to update procuct data.");
			e.printStackTrace();
		}
		// Output:- Product updated successfully.		
		
		// 5. Delete one product.
		try(Connection con = dbConnect.dbConnect()) {
			// create delete query
			String deleteQuery = "delete from products where id = ?";
			
			// create PreparedStatement object for pre-compiled query
			PreparedStatement pst = con.prepareStatement(deleteQuery);
			
			// set value for fields
			pst.setInt(1, 3);
			System.out.println("Product deleted successfully.");
			
			// execute query
			pst.executeUpdate();
			
			// closing the PreparedStatement object
			pst.close();
			
		}
		catch(SQLException e) {
			System.out.println("Failed delete the product.");
			e.printStackTrace();
		}
		// Output:- Product deleted successfully.
	}

}
