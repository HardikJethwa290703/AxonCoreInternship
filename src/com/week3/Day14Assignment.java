package com.week3;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Date;
import java.time.LocalDate;
import java.util.InputMismatchException;

public class Day14Assignment {

	private static final String url 		= "jdbc:mysql://localhost:3306/library?serverTimezone=UTC";
	private static final String username 	= "root";
	private static final String password 	= "root";
		
	public static void main(String[] args) {
		
		
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			
			System.out.println("Connection done with database");
			
			// 1. Creating CRUD methods for 'books' table
			// Insert method for inserting books
			insertBooks(con);			
			// Output:- Record inserted successfully.
			/*
				+--------+---------------+------------------------+-----------+
				| bookId | bookName      | bookAuthorName         | bookPrice |
				+--------+---------------+------------------------+-----------+
				|      1 | dummy book    | dummy author           |     23.00 |
				|      2 | wings of fire | Shri A.P.J Abdul Kalam |    345.00 |
				|      3 | Mahabharat    | Ved Vyas               |    500.00 |
				|      4 | Ramayana      | Valmiki                |    600.00 |
				+--------+---------------+------------------------+-----------+
			*/
			
			// Select method for reading the books
			selectBooks(con);
			// Output:-
			/*
				Book details:
				Book Id: 1
				Book Name: dummy book
				Book Author Name: dummy author
				Book Price: 23.0
				---------------------------------------------
				Book Id: 2
				Book Name: wings of fire
				Book Author Name: Shri A.P.J Abdul Kalam
				Book Price: 345.0
				---------------------------------------------
				Book Id: 3
				Book Name: Mahabharat
				Book Author Name: Ved Vyas
				Book Price: 500.0
				---------------------------------------------
				Book Id: 4
				Book Name: Ramayana
				Book Author Name: Valmiki
				Book Price: 600.0
				---------------------------------------------
			*/
			
			// Update method for updating books
			updateBooks(con);
			// Output:-
			/*
				// 1. If not providing book name
				Please provide book name to update the details:

				Please provide book name to update the details or type 'quit' if not required to update the details:
				quit
				
				// 2. if invalid book name provided
				Please provide book name to update the details:
				rama
				Sorry! unable to find out the book you search for update the details. Try again later.
				
				// 3. if valid book name provided
				Please provide book name to update the details:
				wings of fire
				Enter price for provided book name:
				950
				Record Updated successfully.
			*/
			
			// After updating the record, reading the books
			selectBooks(con);
			// Output:-
			/*
				Book details:
				Book Id: 1
				Book Name: dummy book
				Book Author Name: dummy author
				Book Price: 23.0
				---------------------------------------------
				Book Id: 2
				Book Name: wings of fire
				Book Author Name: Shri A.P.J Abdul Kalam
				Book Price: 950.0 // updated record 
				---------------------------------------------
				Book Id: 3
				Book Name: Mahabharat
				Book Author Name: Ved Vyas
				Book Price: 500.0
				---------------------------------------------
				Book Id: 4
				Book Name: Ramayana
				Book Author Name: Valmiki
				Book Price: 600.0
				---------------------------------------------
			*/
			
			// Delete method for deleting books
			deleteBooks(con);
			// Output:-
			/*
				// 1. If not providing book name
				Please provide book name to delete the details:

				Please provide book name to delete the details or type 'quit' if not required to delete the details:
				
				Please provide book name to delete the details or type 'quit' if not required to delete the details:
				quit
				
				// 2. if invalid book name provided
				Please provide book name to delete the details:
				mybook
				Sorry! unable to find out the book you search for deleting the details. Try again later.
				
				// 3. if valid book name provided
				Please provide book name to delete the details:
				dummy book
				Record deleted successfully.
			*/
			
			// After deleting the record, reading the books
			selectBooks(con);
			// Output:-
			/*
				Book details:
				Book Id: 2
				Book Name: wings of fire
				Book Author Name: Shri A.P.J Abdul Kalam
				Book Price: 950.0
				---------------------------------------------
				Book Id: 3
				Book Name: Mahabharat
				Book Author Name: Ved Vyas
				Book Price: 500.0
				---------------------------------------------
				Book Id: 4
				Book Name: Ramayana
				Book Author Name: Valmiki
				Book Price: 600.0
				---------------------------------------------
			*/
			
			// 2. Creating CRUD methods for 'members' table
			// Insert method for inserting members data in 'members' table, inserting books and members data in table 'loans'
			insertMembers(con);
			// Output:-
			/*
				// 1. If not providing bookName, memberName, memberEmail or memberPhone
				Enter member name:

				Enter member phone: 
				
				Enter member email: 
				
				Enter book name: 
				
				Enter book loan amount: 
				23 23
				Enter book loan due date in numbers from current date: 
				1							
				Please provide book name to add the details or type 'quit' if not required to add the details:
				
				Please provide member name to add the details or type 'quit' if not required to add the details:
				
				Please provide member phone to add the details or type 'quit' if not required to add the details:
				
				Please provide member email to add the details or type 'quit' if not required to add the details:
				quit

				// 2. if invalid book name provided
				Enter member name: 
				hardik
				Enter member phone: 
				7843743874
				Enter member email: 
				har@test.com
				Enter book name: 
				my book 	--------> book name can't found in database table 'books'
				Enter book loan amount: 
				67
				Enter book loan due date in numbers from current date: 
				7
				Sorry! unable to add the details since the book name you search for is invalid. Try again later.				

				// 3. if valid book name provided
				Enter member name: 
				hardik
				Enter member phone: 
				8393939393
				Enter member email: 
				har@test..com
				Enter book name: 
				wings of fire
				Enter book loan amount: 
				56
				Enter book loan due date in numbers from current date: 
				5
				Member added successfully.
				Member and Book details added successfully.
			*/
			
			// Select method to read all the members details
			selectMembers(con);
			// Output:-
			/*
				Member details fetched successfully.
				Name: hardik
				Email: har@test.com
				Phone: 89485759392
				----------------------------------
				Name: hardik
				Email: har@test..com
				Phone: 8393939393
				----------------------------------
			*/
			
			// Update method for updating members data in 'members' table
			updateMembers(con);
			// Output:-
			/*
				1. if email of member not found in table 'members'
				Provide email of member for which you wanted to update the details:
				ha
				Provide email of member for which you wanted to update the details or type 'quit' to exit the process:
				ha
				Provide email of member for which you wanted to update the details or type 'quit' to exit the process:
				quit
				
				2. if valid email provided
				Provide email of member for which you wanted to update the details:
				har@test.com
				Please type(name, email, phone) to update one of the detail:
				name
				Enter new name to get update the details:
				hardik jethwa
				Member details updated successfully
			*/
			
			// After updating the detail, read all the members details
			selectMembers(con);
			// Output:-
			/*
				Member details fetched successfully.
				Name: hardik jethwa  --> updated detail
				Email: har@test.com
				Phone: 89485759392
				----------------------------------
				Name: hardik
				Email: har@test..com
				Phone: 8393939393
				----------------------------------
			*/
			
			// Delete method for deleting members data in 'members' table and related data of 'members' and 'books' in 'loans' table
			deleteMembers(con);
			// Output:-
			/*
				Provide email of member for which you wanted to delete the details:
				har@test..com
				Member and associated Book details deleted successfully.
				Member details deleted successfully.
			*/
			
			// Select method to read all the members details
			selectMembers(con);
			// Output:-
			/*
				Member details fetched successfully.
				Name: hardik jethwa  --> updated detail
				Email: har@test.com
				Phone: 89485759392
				----------------------------------
			*/
			
			// Select method to read all the 'members' and 'books' related data from 'loans' table
			selectLoans(con);
			// Output:-
			/*
				Details of Member associated with Books fetched successfully.
				Member Name: hardik
				Member Email: har@test.com
				Member Phone: 8393939393
				Book Name: wings of fire
				Book Loan Date: 2026-07-06
				Book Due Date: 2026-07-11
				-------------------------------
			*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 1. Creating CRUD methods for 'books' table
	// Insert method for inserting books
	public static void insertBooks(Connection con) throws SQLException {
		
		Scanner sc	= new Scanner(System.in);
		
		// asking user to enter book name which need to be added as record into database table 'books'
		System.out.println("Enter book name: ");
		// storing book name in variable as 'bookName'
		String bookName = sc.nextLine();
		
		// if 'bookName' is empty then ask to renter the book name
		while(bookName.isEmpty()) {
			System.out.println("Please enter book name: ");
			bookName = sc.nextLine();
		}
		
		// asking user to enter book author name which need to be added as record into database table 'books'
		System.out.println("Enter book author name: ");
		// storing book author name in variable as 'bookAuthor'
		String bookAuthor = sc.nextLine();
		
		// if 'bookAuthor' is empty then ask to renter the book author name
		while(bookAuthor.isEmpty()) {
			System.out.println("Please enter book author name: ");
			bookAuthor = sc.nextLine();
		}
		
		// asking user to enter book price which need to be added as record into database table 'books'
		System.out.println("Enter book price: ");
		// storing book price in variable as 'bookPrice'
		Double bookPrice = sc.nextDouble();
		
		// insert query for inserting book details in database table 'books'
		String insertQuery = "insert into books(bookName, bookAuthorName, bookPrice) values(?,?,?)";
				
		try(PreparedStatement pst = con.prepareStatement(insertQuery)) {
			
			// set values for fields
			pst.setString(1, bookName);
			pst.setString(2, bookAuthor);
			pst.setDouble(3, bookPrice);
			
			// execute query
			int rowsInserted = pst.executeUpdate();
			
			if(rowsInserted > 0) {
				System.out.println("Record inserted successfully.");
			}			
		}
		// closing the scanner object
		sc.close();
	}

	// Select method for reading the books
	public static void selectBooks(Connection con) throws SQLException{
		
		// select query for reading all the books data from 'books' table
		String selectBooks = "select * from books";
		
		try(Statement st = con.createStatement()) {
			
			ResultSet rs = st.executeQuery(selectBooks);
			
			// check if book data exist
			boolean bookDataExist = rs.next();
			
			if(bookDataExist) {
				System.out.println("Book details:");
				// if book data exist then iterate
				while(bookDataExist) {
					System.out.println("Book Id: "+rs.getInt(1));
					System.out.println("Book Name: "+rs.getString(2));
					System.out.println("Book Author Name: "+rs.getString(3));
					System.out.println("Book Price: "+rs.getDouble(4));
					System.out.println("---------------------------------------------");
					bookDataExist = rs.next();
				}
			}
			else {
				System.out.println("Data not found");
			}
			
			// closing the ResultSet object
			rs.close();
		}
	}
	
	// Update method for updating books
	public static void updateBooks(Connection con) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		// asking user to provide the book name which need to get deleted
		System.out.println("Please provide book name to update the details:");
		// storing the book name in variable as 'bookName'
		String bookName = sc.nextLine();
		
		// query to search in database whether book exist
		String searchBook = "select * from books where bookName = ?";
		
		// initializing updateDetails as 'false' since till the book details didn't get updated
		boolean updateDetails = false;
		
		// loop will execute until the book get updated
		while(!updateDetails) {
			// checking if 'bookName' is not empty
			if(!bookName.isEmpty()) {
				try(PreparedStatement pst = con.prepareStatement(searchBook)) {
					
					// set values for fields
					pst.setString(1, bookName);
					
					// execute query and return the table view to ResultSet to execute row-by-row
					ResultSet rs = pst.executeQuery();
					
					// if book details found then proceed further to update the details into database table as 'books'
					if(rs.next()) {
						
						// asking user to update the price for specific book
						System.out.println("Enter price for provided book name:");
						// storing the book price in variable as 'bookPrice'
						Double bookPrice = sc.nextDouble();
						
						// update query for updating specific book details
						String updateQuery = "update books set bookPrice = ? where bookId = ?";
						
						try(PreparedStatement updatePst = con.prepareStatement(updateQuery)) {
							
							// set values for fields
							updatePst.setDouble(1, bookPrice);
							updatePst.setInt(2, rs.getInt(1));
							
							// execute the query							
							int rowsUpdated = updatePst.executeUpdate();
							
							if(rowsUpdated > 0) {
								System.out.println("Record Updated successfully.");
								// after updating the details initializing 'updateDetails' as true so loop stops
								updateDetails = true;
							}
							
						}
					}
					else {
						// if book details didn't get found then exit the loop
						System.out.println("Sorry! unable to find out the book you search for update the details. Try again later.");
						// bookName = sc.nextLine();
						break;
					}
					
					// closing the ResultSet object
					rs.close();
				}		
			}
			else {
				// if 'bookName' is empty then ask again to provide the 'bookName' or ask to type 'quit' to exit the loop
				System.out.println("Please provide book name to update the details or type 'quit' if not required to update the details:");
				bookName = sc.nextLine();
				if(bookName.equalsIgnoreCase("quit")) {
					break;
				}
			}
		}
		// closing the Scanner object
		sc.close();
	}
	
	// Delete method for deleting books
	public static void deleteBooks(Connection con) throws SQLException {
		
		Scanner sc 		= new Scanner (System.in);
		
		// asking user to provide the book name which need to get deleted
		System.out.println("Please provide book name to delete the details:");
		// storing the book name in variable as 'bookName'
		String bookName = sc.nextLine();
		
		// query to search in database whether book exist
		String selectBook = "select * from books where bookName = ?";
		
		// initializing deleteDetails as 'false' since till the book details didn't get deleted
		boolean deleteDetails = false;
		
		// loop will execute until the book get deleted
		while(!deleteDetails) {
			// checking if 'bookName' is not empty
			if(!bookName.isEmpty()) {
				try(PreparedStatement pst = con.prepareStatement(selectBook)) {
					
					// set values for fields
					pst.setString(1, bookName);
					
					// execute query and return the table view to ResultSet to execute row-by-row
					ResultSet rs = pst.executeQuery();
					
					// if book details found then proceed further to delete the details from database table as 'books'
					if(rs.next()) {
						// delete query for deleting a specific book details
						String deleteQuery = "delete from books where bookId = ?";
						
						try(PreparedStatement deletePst = con.prepareStatement(deleteQuery)) {
							
							// set values for fields
							deletePst.setInt(1, rs.getInt(1));
							
							// execute the query
							int rowsDeleted = deletePst.executeUpdate();
							
							if(rowsDeleted > 0) {
								System.out.println("Record deleted successfully.");
								// after deleting the details initializing 'deleteDetails' as true so loop stops
								deleteDetails = true;
							}
							
						}
					}
					else {
						// if book details didn't get found then exit the loop
						System.out.println("Sorry! unable to find out the book you search for deleting the details. Try again later.");
						// bookName = sc.nextLine();
						break;
					}
					// closing the ResultSet object
					rs.close();
				}
			}
			else {
				// if 'bookName' is empty then ask again to provide the 'bookName' or ask to type 'quit' to exit the loop
				System.out.println("Please provide book name to delete the details or type 'quit' if not required to delete the details:");
				bookName = sc.nextLine();
				if(bookName.equalsIgnoreCase("quit")) {
					break;
				}
			}
		}
		// closing the Scanner object
		sc.close();
	}
	
	// 2. Creating CRUD methods for 'members' table
	// Insert method for inserting members data in 'members' table, inserting books and members data in table 'loans'
	public static void insertMembers(Connection con) throws SQLException {
		
		Scanner sc	= new Scanner(System.in);			
		
		// asking user to enter member name for inserting it in table 'members'
		System.out.println("Enter member name: ");
		// storing member name in variable as 'memberName'
		String memberName = sc.nextLine();
		
		// asking user to enter member phone for inserting it in table 'members'
		System.out.println("Enter member phone: ");
		// storing member phone in variable as 'memberPhone'
		String memberPhone = sc.nextLine();
		
		// asking user to enter member email for inserting it in table 'members'
		System.out.println("Enter member email: ");
		// storing member email in variable as 'memberEmail'
		String memberEmail = sc.nextLine();
		
		// asking user to enter book name for searching it in table 'books'
		System.out.println("Enter book name: ");	
		// storing book name in variable as 'bookName'
		String bookName = sc.nextLine();
		
		// asking user to enter book loan amount for inserting it in table 'loans'
		System.out.println("Enter book loan amount: ");	
		// storing book loan amount in variable as 'bookLoanAmount'
		Double bookLoanAmount = sc.nextDouble();
		
		// clearing the input buffer
		sc.nextLine();
				
		// asking user to enter book loan due date for inserting it in table 'loans'
		System.out.println("Enter book loan due date in numbers from current date: ");	
		// storing book loan due date in variable as 'bookLoanDueDate'
		int bookLoanDueDate = sc.nextInt();
		
		// clearing the input buffer
		sc.nextLine();
		
		// search query for searching the book details in table 'books'
		String searchBook = "select * from books where bookName = ?";
		
		// search query for searching the member details in table 'members'
		// String searchMember = "select * from members where memberName = ?";
		
		boolean insertDetails = false;
		
		while(!insertDetails) {
			if(!bookName.isEmpty() && !memberName.isEmpty() && !memberPhone.isEmpty() && !memberEmail.isEmpty()) {

				// create PreparedStatement statement object
				PreparedStatement pst = con.prepareStatement(searchBook);
					
				// set values for fields
				pst.setString(1, bookName);
				ResultSet bookRs = pst.executeQuery();						
				
				// if book details found then proceed further to insert the details into database table as 'members' and 'loans'
				if(bookRs.next()) {
					
					// insert query for inserting member into 'members' table
					String insertMembers 	= "insert into members(memberName, memberEmail, memberPhone) values(?,?,?)";
					
					// insert query for inserting member and book details into 'loans' table
					String insertLoans 		= "insert into loans(bookId, memberId, bookLoanAmount, bookLoanDate, dueDate) values(?,?,?,?,?)";					
										
					// create PreparedStatement object and get inserted id using constant RETURN_GENERATED_KEYS
					try(PreparedStatement membersPst = con.prepareStatement(insertMembers, PreparedStatement.RETURN_GENERATED_KEYS)) {
						
						// set values for fields
						membersPst.setString(1, memberName);
						membersPst.setString(2, memberEmail);
						membersPst.setString(3, memberPhone);
						
						// execute the query							
						int memberRowsInserted = membersPst.executeUpdate();
						
						if(memberRowsInserted > 0) {
							
							System.out.println("Member added successfully.");
							
							// get inserted id using PreparedStatement object method getGeneratedKeys() 
							ResultSet rs 	= membersPst.getGeneratedKeys();
							
							// moving cursor to the next row
							rs.next();
							
							int memberId 	= rs.getInt(1);
							int bookId 		= bookRs.getInt(1);
							
							try(PreparedStatement loansPst = con.prepareStatement(insertLoans)) {
								loansPst.setInt(1, bookId);
								loansPst.setInt(2, memberId);
								loansPst.setDouble(3, bookLoanAmount);
								
								// Date constructor takes current time in milliseconds as parameter 
								// and it will return the current date in yyyy-mm-dd,
								// when a book is issued to a member the current date is stored which is book loan date 
								Date currentDate 	= new Date(System.currentTimeMillis());
								
								// convert Date to LocalDate for manipulating date
								LocalDate localDate = currentDate.toLocalDate();
								
								// adding number of days so we will get new date
								LocalDate newDate  	= localDate.plusDays(bookLoanDueDate);
								
								// since when setting the date it accepts sql date, therefore converting localdate to sql date, we get book due date
								Date dueDate 		= Date.valueOf(newDate);
								
								loansPst.setDate(4, currentDate); // storing bookLoanDate as current date
								loansPst.setDate(5, dueDate); // book due date on which member needs to return the book
								
								// execute query
								int loanRowsInserted = loansPst.executeUpdate();
								if(loanRowsInserted > 0) {
									System.out.println("Member and Book details added successfully.");									
								}
								
							}
							// after inserting the details initializing 'insertDetails' as true so loop stops
							insertDetails = true;
							
							//closing the ResultSet object
							rs.close();
						}
						
					}
				}
				else {
					// if book details didn't get found then exit the loop
					System.out.println("Sorry! unable to add the details since the book name you search for is invalid. Try again later.");
					// bookName = sc.nextLine();		
					break;					
				}	
				
				// closing the ResultSet object
				bookRs.close();
			}
			else {
				// if 'bookName' is empty then ask again to provide the 'bookName' or ask to type 'quit' to exit the loop similarly for others
				if(bookName.isEmpty()) {
					
					System.out.println("Please provide book name to add the details or type 'quit' if not required to add the details:");
					bookName = sc.nextLine();
					
					if(bookName.equalsIgnoreCase("quit")) {
						break;
					}
				}
				
				if(memberName.isEmpty()) {
					System.out.println("Please provide member name to add the details or type 'quit' if not required to add the details:");
					memberName = sc.nextLine();
					
					if(memberName.equalsIgnoreCase("quit")) {
						break;
					}
				}
				
				if(memberPhone.isEmpty()) {
					System.out.println("Please provide member phone to add the details or type 'quit' if not required to add the details:");
					memberPhone = sc.nextLine();
					if(memberPhone.equalsIgnoreCase("quit")) {
						break;
					}
				}
				
				if(memberEmail.isEmpty()) {
					System.out.println("Please provide member email to add the details or type 'quit' if not required to add the details:");
					memberEmail = sc.nextLine();
					if(memberEmail.equalsIgnoreCase("quit")) {
						break;
					}
				}
				
			}
						
		}		
		// closing the Scanner object
		sc.close();
	}
	
	// Update method for updating members data in 'members' table
	public static void updateMembers(Connection con) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		// asking user to enter the email for which member need to update the details
		System.out.println("Provide email of member for which you wanted to update the details:");
		String memberEmail = sc.next().toLowerCase();
		
		// clean the input buffer
		sc.nextLine();
		
		// select query to search member using email(unique)
		String searchMember = "select * from members where memberEmail = ?";
		
		// create PreparedStatement statement object
		PreparedStatement pst = con.prepareStatement(searchMember);			
		
		// set values for fields
		pst.setString(1, memberEmail);
		
		// execute query
		ResultSet rs = pst.executeQuery();
		
		// initializing updateDetails as 'false' since till the member details didn't get updated
		boolean updateDetails = false;
				
		// loop will execute until the member get updated
		while(!updateDetails) {					
			
			if(rs.next()) {
				
				// ask specific member detail to get updated
				System.out.println("Please type(name, email, phone) to update one of the detail:");
				String updateType 	= sc.next().toLowerCase();
				
				// clearing the input buffer
				sc.nextLine();
				
				// storing old name,email,phone if member data found
				String updateName 	= rs.getString(2);
				String updateEmail 	= rs.getString(3);
				String updatePhone 	= rs.getString(4);
				
				// searching text which user enters(name,email,phone,others)
				switch(updateType) {
					case "name":
						System.out.println("Enter new name to get update the details:");
						// reinitializing new value
						String name = sc.nextLine();
						if(!name.isEmpty()) {
							updateName = name;
						}
						break;
					case "email":
						System.out.println("Enter new email to get update the details:");
						// reinitializing new value
						String email = sc.nextLine();
						if(!email.isEmpty()) {
							updateEmail = email;
						}
						break;
					case "phone":
						System.out.println("Enter new phone to get update the details:");
						// reinitializing new value
						String phone = sc.nextLine();
						if(!phone.isEmpty()) {
							updatePhone = phone;							
						}
						break;
					default:						
						continue;
				}
				
				// update query to update the details
				String updateQuery = "update members set memberName = ?, memberEmail = ?, memberPhone = ? where memberId = ?";
				
				try(PreparedStatement updatePst = con.prepareStatement(updateQuery)) {
					// set values for fields
					updatePst.setString(1, updateName);
					updatePst.setString(2, updateEmail);
					updatePst.setString(3, updatePhone);
					updatePst.setInt(4, rs.getInt(1));
					
					// execute query
					int rowsUpdated = updatePst.executeUpdate();
					if(rowsUpdated > 0) {
						System.out.println("Member details updated successfully");
						updateDetails = true;					
					}
				}				
			}
			else {							
				
				// asking user email again if member not found
				System.out.println("Provide email of member for which you wanted to update the details or type 'quit' to exit the process:");
				memberEmail = sc.next();
				
				if(!memberEmail.equalsIgnoreCase("quit")) {
					
					// create PreparedStatement statement object
					PreparedStatement searchPst = con.prepareStatement(searchMember);
					
					// set values for fields					
					searchPst.setString(1, memberEmail);
					
					// execute query
					rs = searchPst.executeQuery();
					
				}
				else {
					break;
				}
			}
		}
		
		// closing the ResultSet object
		rs.close();
		
		// closing the Scanner object
		sc.close();
	}
	
	// Delete method for deleting members data in 'members' table and related data of 'members' and 'books' in 'loans' table
	public static void deleteMembers(Connection con) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		// asking user to enter the email for which member data will be deleted
		System.out.println("Provide email of member for which you wanted to delete the details:");
		String memberEmail = sc.next().toLowerCase();
		
		// select query to search member using email(unique)
		String searchMember = "select * from members where memberEmail = ?";
				
		// create PreparedStatement statement object
		PreparedStatement pst = con.prepareStatement(searchMember);
				
		// set values for fields
		pst.setString(1, memberEmail);
		
		// execute query
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()) {
			
			// delete the loans detail of the members
			String deleteLoan = "delete from loans where memberId = ?";
			try(PreparedStatement deleteLoanPst = con.prepareStatement(deleteLoan)) {
				// set values for fields
				deleteLoanPst.setInt(1, rs.getInt(1));
				
				// execute query
				int loanDeletedRow = deleteLoanPst.executeUpdate();
				if(loanDeletedRow > 0) {
					System.out.println("Member and associated Book details deleted successfully.");
				}
			}
			
			// delete query to delete the member details
			String deleteMember = "delete from members where memberId = ?";
			
			try(PreparedStatement deletePst = con.prepareStatement(deleteMember)) {
				// set values for fields
				deletePst.setInt(1, rs.getInt(1));
				
				// execute query
				int memberDeletedRow = deletePst.executeUpdate();
				if(memberDeletedRow > 0) {
					System.out.println("Member details deleted successfully.");
				}
			}
			
			
			
		}
		else {
			System.out.println("Email not found, details couldn't be deleted");
		}
		
		// closing the ResultSet object
		rs.close();
		
		// closing the Scanner object
		sc.close();
	}

	// Select method to read all the members details
	public static void selectMembers(Connection con) throws SQLException {
		// select query
		String selectQuery = "select * from members";
		
		try(Statement st = con.createStatement()) {
			// execute query and initialize the view to ResultSet object
			ResultSet rs = st.executeQuery(selectQuery);
			
			boolean memberExist = rs.next();
			if(memberExist) {
				System.out.println("Member details fetched successfully.");
				while(memberExist) {
					System.out.println("Name: "+rs.getString(2));
					System.out.println("Email: "+rs.getString(3));
					System.out.println("Phone: "+rs.getString(4));
					System.out.println("----------------------------------");
					memberExist = rs.next();
				}
			}
			else {
				System.out.println("Member details not found.");
			}
			
			// closing the ResultSet object
			rs.close();
		}
	}
	
	// Select method to read all the 'members' and 'books' related data from 'loans' table
	public static void selectLoans(Connection con) throws SQLException {
		// select query to search associated data between members and books
		String selectQuery = "select * from loans";
		
		// select query to search data in members table
		String selectMember = "select * from members where memberId = ?";
		
		// select query to search data in books table
		String selectBook = "select * from books where bookId = ?";
		
		try(Statement st = con.createStatement()) {
			// execute query and initialize the view to ResultSet object
			ResultSet rs = st.executeQuery(selectQuery);
			
			boolean loanExist = rs.next();
			if(loanExist) {
				System.out.println("Details of Member associated with Books fetched successfully.");
				while(loanExist) {
					
					// create PreparedStatement object
					PreparedStatement selectMemberPst = con.prepareStatement(selectMember);
					
					// set values for fields
					selectMemberPst.setInt(1, rs.getInt(3));
					
					// execute query
					ResultSet memberRs = selectMemberPst.executeQuery();
					
					// move the cursor to next row
					memberRs.next();
					
					// create PreparedStatement objects
					PreparedStatement selectBookPst = con.prepareStatement(selectBook);
						
					// set values for fields
					selectBookPst.setInt(1, rs.getInt(2));
					
					// execute query
					ResultSet bookRs = selectBookPst.executeQuery();
					
					// move the cursor to next row
					bookRs.next();
					
					System.out.println("Member Name: "+memberRs.getString(2));
					System.out.println("Member Email: "+memberRs.getString(3));
					System.out.println("Member Phone: "+memberRs.getString(4));
					System.out.println("Book Name: "+bookRs.getString(2));
					System.out.println("Book Loan Date: "+rs.getDate(5));
					System.out.println("Book Due Date: "+rs.getDate(6));
					System.out.println("-------------------------------");

					// closing the members ResultSet object
					memberRs.close();
					
					// closing the books ResultSet object
					bookRs.close();
					
					loanExist = rs.next();
				}
				
			}
			else {
				System.out.println("Details of Members associated with Books not found.");
			}
			
			// closing the ResultSet object
			rs.close();
		}
	}	
}
