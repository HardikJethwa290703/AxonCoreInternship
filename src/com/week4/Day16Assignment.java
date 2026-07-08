package com.week4;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Day16Assignment {

	private static final String url 		= "jdbc:mysql://localhost:3306/education?serverTimezone=UTC";
	private static final String username 	= "root";
	private static final String password 	= "root";
	
	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			
			System.out.println("Connected with database.");
			
			// Insert method for creating student records
			insertStudents(con);
			// Output:-
			/*
			 	// 1. if data is incorrect or invalid
			 	Enter student name:
										--> if student name is empty given
				Enter student email:
				jajajjajdd              --> not a valid email id
				Enter student phone:
				5690920921 				--> not a correct mobile no(as per the validation)
				Please enter student name: 
				hahsahss1				--> if student name contains any digit
				Please enter valid student email:
				hsajsss@.				--> not a valid email id
				Please enter valid phone number:
				8920129212
				Please enter student name: 
				kaushik jethwa
				Please enter valid student email:
				kau@gmail.com
				Record inserted successfully
			 	
				// 2. if data is correct or valid
				Enter student name:
				hardik jethwa
				Enter student email:
				har@test.com
				Enter student phone:
				6789201021
				Record inserted successfully
				
				// 3. if student with same email id already exists
				Enter student name:
				kaushik
				Enter student email:
				kau@gmail.com
				Enter student phone:
				8732728282
				Email already exists. Please provide different email.
			*/
			
			// Select method for reading student records
			selectStudents(con);
			// Output:-
			/*
				Student details fetched successfully:
				Name: hardik jethwa, Email: har@test.com, Phone: 6789201021
				Name: kaushik jethwa, Email: kau@gmail.com, Phone: 8920129212
			*/
			
			// Update method for updating student records
			updateStudents(con);
			// Output:-
			/*
				// 1. if 'email' is empty or invalid and not exist in 'student' table
				Enter student email for updating existing record:
																		--> if 'email' is empty
				Please enter student email for updating existing record:
				hardik@gmail.com										--> if 'email' is invalid
				Student record not found.
				
				// 2. if not typing correct record type
				Enter student email for updating existing record:
				har@test.com
				Which type of record want to update(type 'email' or 'phone')?
				quit
				Invalid type of record, try again later!
				
				// 3. if user types email to update is empty then existing email gets updated
				Enter student email for updating existing record:
				har@test.com
				Which type of record want to update(type 'email' or 'phone')?
				email
				Enter new email to get update the details:
															--> if email is empty then old email gets updated
				Student record updated successfully.
				
				// 4. updating email for student
				Enter student email for updating existing record:
				har@test.com
				Which type of record want to update(type 'email' or 'phone')?
				email
				Enter new email to get update the details:
				har@gmail.com
				Student record updated successfully.
			*/
			
			// Select method for reading student records after updating the record
			selectStudents(con);
			// Output:-
			/*
				Student details fetched successfully:
				Name: hardik jethwa, Email: har@gmail.com, Phone: 6789201021
				Name: kaushik jethwa, Email: kau@gmail.com, Phone: 8920129212
			*/
			
			// Delete method for deleting student records
			deleteStudents(con);
			// Output:-
			/*
			 	// 1. if 'email' is empty or invalid and not exist in 'student' table
				Enter student email for deleting existing record:
																		--> if 'email' is empty
				Please enter student email for deleting existing record:
				kkkkkkkahaha@tets.com									--> if 'email' is invalid
				Student record not found. Please use another email id.
				
				// 2. if email found delete the record
				Enter student email for deleting existing record:
				har@gmail.com										--> if 'email' exist in database
				Student record deleted successfully.

			*/
			
			// Insert method for creating courses
			insertCourses(con);
			// Output:-
			/*
				// 1. if data is incorrect or invalid.
				Enter course name:
										--> if course name is empty
				Enter course duration:
				asas					--> if invalid course duration
				Please enter course name: 
				c#
				Please enter valid course duration:
				09						--> if invalid course duration(starting digit must be between range 1 to 9)
				Please enter valid course duration:
				4
				Record inserted successfully
				
				// 2. if data is correct and valid.
				Enter course name:
				java
				Enter course duration:
				45
				Record inserted successfully
				
				// 3. if course with same duration already exist
				Connected with database.
				Enter course name:
				C#
				Enter course duration:
				4
				Course with same duration already exists. Please provide different duration.				
			*/
			
			// Select method for reading course records
			selectCourses(con);
			// Output:-
			/*
				Course details fetched successfully:
				Name: c#, Duration: 4
				Name: java, Duration: 45
			*/
			
			// Update method for updating course records
			updateCourses(con);
			// Output:-
			/*
				// 1. if course or duration are invalid and details not found in database table
				Enter existing course name for updating details:
																	--> if course name is empty
				Enter existing course duration for updating details:
																	--> if course duration is empty
				Please enter existing course name for updating details: 
				ccc													
				Please enter existing valid course duration for updating details:
				44
				Course details are invalid.	--> if course name not found in database table
				
				// 2. if course details are valid but the new duration entered already exist for the same course name
				Enter existing course name for updating details:
				c#
				Enter existing course duration for updating details:
				4
				Enter new course duration for updating details:
				4
				Duration for the course already exist. Try again later with different duration.
				
				// 3. if course details are valid and new duration entered is different for the same course name
				Enter existing course name for updating details:
				c#
				Enter existing course duration for updating details:
				4
				Enter new course duration for updating details:
				35
				Course data updated successfully
			*/
			
			// Select method for reading course records after updating course details
			selectCourses(con);
			// Output:-
			/*
				Course details fetched successfully:
				Name: c#, Duration: 35
				Name: java, Duration: 45
			*/
			
			// Delete method for deleting course records
			deleteCourses(con);
			// Output:-
			/*
				// 1. if course or duration are invalid and details not found in database table
				Enter existing course name for deleting details:
																		--> if course name is empty
				Enter existing course duration for deleting details:
																		--> if course duration is empty
				Please enter existing course name for deleting details: 
				javascript
				Please enter existing valid course duration for deleting details:
				20
				Course details are invalid. --> if course name not found in database table
				
				// 2. if course details are correct then delete the details
				Enter existing course name for deleting details:
				java
				Enter existing course duration for deleting details:
				45
				Course data deleted successfully
			*/
			
			// Select method for reading course records after deleting course details
			selectCourses(con);
			// Output:-
			/*
				Course details fetched successfully:
				Name: c#, Duration: 35
			*/
			
			// Insert method for creating enrollments
			insertEnrollments(con);
			// Output:-
			/*
				// 1. if incorrect student or course details
				Enter student email for enrollment:
															--> invalid email(empty)
				Enter course name for student to enroll:
				java
				Enter course duration for student to enroll:
				56											--> course and duration searched but incorrect duration found
				Please enter valid student email for enrollment: 
				har@ok.com									--> no student with this email exists
				Invalid student details.
				Invalid course details.
				
				// 2. if correct student and course detail found then new enrollment
				Enter student email for enrollment:
				kau@gmail.com
				Enter course name for student to enroll:
				c#
				Enter course duration for student to enroll:
				35
				Student successfully enrolled in the course
				
				// 3. if student already enrolled with same course and duration(duplicacy handled)
				Enter student email for enrollment:
				kau@gmail.com
				Enter course name for student to enroll:
				C#
				Enter course duration for student to enroll:
				35
				Student already enrolled in the course.
			*/
			
			// Select method for reading course records
			selectEnrollments(con);
			// Output:-
			/*
				Student details fetched successfully:
				Student Name: kaushik jethwa
				Student Email: kau@gmail.com
				Student Phone: 8920129212
				Course Name: c#
				Course Duration: 35
				Enrollment date: 08 July 2026
				------------------------------------------
				Student Name: hardik
				Student Email: har@gmail.com
				Student Phone: 8929828282
				Course Name: java
				Course Duration: 45
				Enrollment date: 08 July 2026
				------------------------------------------
			*/
			
			// Update method for updating enrollments
			updateEnrollments(con);
			// Output:-
			/*
				// 1. if invalid or incorrect student or course details
				Enter student email for updating enrollment:
				har@gmai										--> if invalid student email
				Enter old course name for student:
																--> if course name is empty
				Enter old course duration for student:
				5												--> if course duration is invalid checked from database
				Please enter valid student email for updating enrollment: 
				har@gmail.com									--> if student name is valid in database
				Please enter old course name for student: 
				c#												--> if course name is valid in database
				Invalid course details. --> if course name is valid but duration is not valid in database
				
				// 2. if correct student and course detail but not enrolled
				Enter student email for updating enrollment:
				kau@gmail.com
				Enter old course name for student:
				java
				Enter old course duration for student:
				45
				Student not enrolled in the course. Please enroll first then update the details.
				
				// 3. if student is enrolled then ask new course name and duration, but not exist in 'course' table
				Enter student email for updating enrollment:
				kau@gmail.com
				Enter old course name for student:
				c#
				Enter old course duration for student:
				35
				Enter new course name for student to update enrollment:
				javascript
				Enter new course duration for student to update enrollment:
				20
				New course detail couldn't found for updating the enrollment. Try again later by entering valid course detail.

				
				// 4. if student is enrolled and new course name and duration exist in 'course' table, then update the enrollment
				Enter student email for updating enrollment:
				kau@gmail.com
				Enter old course name for student:
				C#
				Enter old course duration for student:
				35
				Enter new course name for student to update enrollment:
				Java
				Enter new course duration for student to update enrollment:
				45
				Student enrollment updated successfully

			*/
						
			// Select method for reading course records after updating the record
			selectEnrollments(con);
			// Output:-
			/*
				Student details fetched successfully:
				Student Name: kaushik jethwa
				Student Email: kau@gmail.com
				Student Phone: 8920129212
				Course Name: java
				Course Duration: 45
				Enrollment date: 08 July 2026
				------------------------------------------
				Student Name: hardik
				Student Email: har@gmail.com
				Student Phone: 8929828282
				Course Name: java
				Course Duration: 45
				Enrollment date: 08 July 2026
				------------------------------------------
			*/
			
			// Delete method for deleting enrollments
			deleteEnrollments(con);
			// Output:-
			/*
				// 1. if invalid or incorrect student or course details				
				Enter student email to delete enrollment:		
																	--> if empty student email
				Enter existing course name for student to delete enrollment:
				python												--> if course name is invalid checked from database
				Enter existing course duration for student to delete enrollment:
				3													--> if course duration is invalid checked from database
				Please enter valid student email to delete enrollment: 
				haha@hash.com										--> if student name is valid in database
				Invalid student details.	--> if student details is invalid
				Invalid course details.	--> if course name is invalid and duration is invalid in database
				
				// 2. if correct student and course detail but not enrolled
				Enter student email to delete enrollment:
				kau@gmail.com
				Enter existing course name for student to delete enrollment:
				C#
				Enter existing course duration for student to delete enrollment:
				35
				Student not enrolled in the course. Please enroll the student.
				
				// 3. if student is enrolled then delete the enrollment
				Enter student email to delete enrollment:
				har@gmail.com
				Enter existing course name for student to delete enrollment:
				Java
				Enter existing course duration for student to delete enrollment:
				45
				Student enrollment deleted successfully.

			*/
						
			// Select method for reading course records after deleting the record
			selectEnrollments(con);
			// Output:-
			/*
				Student details fetched successfully:
				Student Name: kaushik jethwa
				Student Email: kau@gmail.com
				Student Phone: 8920129212
				Course Name: java
				Course Duration: 45
				Enrollment date: 08 July 2026
				------------------------------------------
			*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Insert method for creating student records
	public static void insertStudents(Connection con) throws SQLException {
		
		// Scanner object to take user input
		Scanner sc = new Scanner(System.in);
		
		// asking to enter student name
		System.out.println("Enter student name:");
		String name 		= sc.nextLine();
		
		// define regex for 'name' validation
		boolean isValidName = name.matches("^[a-zA-Z\s]+$"); // name must have small a-z or caps A-Z and space
		
		// asking to enter student email
		System.out.println("Enter student email:");
		String email 		= sc.nextLine();		
		
		// define regex for 'email' validation
		boolean isValidEmail = email.matches("^[a-zA-Z0-9.+_%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"); // can start within the range defined, afterwards '@' character, then domain name, and at last top level domain name with atleast 2 characters
		
		// asking to enter student phone
		System.out.println("Enter student phone:");
		String phone 		= sc.nextLine();
		
		// define regex for 'phone' validation
		boolean isValidPhone = phone.matches("^[6-9]\\d{9}$"); // mobile starting digit will be in range of 6 to 9 and afterwards only 9 digits are allowed and should end with a digit
		
		// check if any of the value is not valid and ask to renter
		while(!isValidName || !isValidEmail || !isValidPhone) {
						
			if(!isValidName) {
				System.out.println("Please enter student name: ");
				name 		= sc.nextLine();
				isValidName = name.matches("^[a-zA-Z\s]+$");
			}
			
			if(!isValidEmail) {
				System.out.println("Please enter valid student email:");
				email 			= sc.nextLine();
				isValidEmail 	= email.matches("^[a-zA-Z0-9.+_%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
			}
			
			if(!isValidPhone) {
				System.out.println("Please enter valid phone number:");
				phone 			= sc.nextLine();
				isValidPhone 	= phone.matches("^[6-9]\\d{9}$");
			}
						
		}			
				
		// select query to search if email already exist
		String selectQuery = "select * from student where email = ?";
		try(PreparedStatement selectPst = con.prepareStatement(selectQuery)) {
			
			// set values for fields
			selectPst.setString(1, email.trim());
			
			// execute query and assign the table view to ResultSet object
			ResultSet rs = selectPst.executeQuery();
			
			// if duplicate 'email' exists
			if(rs.next()) {
				System.out.println("Email already exists. Please provide different email.");
			}
			else {
				// insert query to insert student data
				String insertQuery = "insert into student(name, email, phone) values(?,?,?)";
				
				try(PreparedStatement insertPst = con.prepareStatement(insertQuery)) {
					
					// set values for fields
					insertPst.setString(1, name.trim());
					insertPst.setString(2, email.trim());
					insertPst.setString(3, phone.trim());
					
					int rowsInserted 	= insertPst.executeUpdate();
					String message 		= rowsInserted > 0 ? "Record inserted successfully" : "Record failed to insert";
					System.out.println(message);
				}
			}
			
			// closing the ResultSet Object
			rs.close();
		}
				
		// closing the Scanner object
		sc.close();
	}
	
	// Select method for reading student records 
	public static void selectStudents(Connection con) throws SQLException {
		
		// Select query to fetch all the student record
		String selectQuery = "select * from student";
		
		// create a Statement object
		try(Statement st = con.createStatement()) {

			// execute query and initialize table view to ResultSet object
			ResultSet rs = st.executeQuery(selectQuery);
			
			// if student data exist
			boolean studentExist = rs.next();
			if(studentExist) {
				System.out.println("Student details fetched successfully:");
				// if data exist then iterate the data
				while(studentExist) {
					// using format specifier we can replace concatenation and define format for different datatypes
					System.out.printf("Name: %s, Email: %s, Phone: %s%n", rs.getString(2), rs.getString(3), rs.getString(4));
					// move to next row
					studentExist = rs.next();
				}
			}
			else {
				// if data does not exist
				System.out.println("Data not found");
			}
			
			// closing the ResultSet Object
			rs.close();
		}
	}
	
	// Update method for updating student records
	public static void updateStudents(Connection con) throws SQLException {
		
		// creating Scanner object to ask user input
		Scanner sc = new Scanner(System.in);
		
		// asking user to provide the email against which the record must be updated
		System.out.println("Enter student email for updating existing record:");
		String email = sc.nextLine();
		
		// define regex for 'email' validation
		boolean isValidEmail = email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"); // can start within the range defined, afterwards '@' character, then domain name, and at last top level domain name with atleast 2 characters
		
		// if 'email' is not valid then ask to renter
		while(!isValidEmail) {
			System.out.println("Please enter student email for updating existing record:");
			email = sc.nextLine();
			isValidEmail = email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
		}
		
		// select query for searching the student record based on 'email'(unique)
		String searchQuery = "select * from student where email = ?";
		
		// create PreparedStatement object for searching student record
		PreparedStatement searchPst = con.prepareStatement(searchQuery);
		
		// set values for fields
		searchPst.setString(1, email.trim());
		
		// execute query and assign table view to ResultSet object
		ResultSet searchRs = searchPst.executeQuery();
		
		// if record of student exist then proceed further for updating record
		if(searchRs.next()) {
			
			// at a time only one record will get updated based on type of record
			System.out.println("Which type of record want to update(type 'email' or 'phone')?");
			String typeOfRecord = sc.nextLine().toLowerCase();
			
			// initializing 'updateDetails' as false which means student record is not yet updated
			boolean updateDetails = false;
			
			// initializing newEmail and newPhone as empty so it can be access outside of switch-case, if defined inside switch-case then won't be able to access outside of switch-case
			String newEmail 	= "";
			String newPhone 	= "";
			
			// comparing the type of record to update
			switch(typeOfRecord) {
				case "email":
					System.out.println("Enter new email to get update the details:");
					newEmail = sc.nextLine();
					// if empty then don't ask again, already registered email will get updated
					boolean isValidNewEmail = newEmail.isEmpty() ? true : email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"); // can start within the range defined, afterwards '@' character, then domain name, and at last top level domain name with atleast 2 characters
					while(!isValidNewEmail) {
						System.out.println("Please enter valid new email to get update the details:");
						newEmail = sc.nextLine();
						isValidNewEmail = newEmail.isEmpty() ? true : newEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
					}					
					break;
				case "phone":
					System.out.println("Enter new phone no to get update the details:");
					newPhone = sc.nextLine();
					// if empty then don't ask again, already registered phone will get updated
					boolean isValidNewPhone = newPhone.isEmpty() ? true : newPhone.matches("^[6-9]\\d{9}$"); // mobile starting digit will be in range of 6 to 9 and afterwards only 9 digits are allowed and should end with a digit
					while(!isValidNewPhone) {
						System.out.println("Please enter valid new phone no to get update the details:");
						newPhone = sc.nextLine();
						isValidNewPhone = newPhone.isEmpty() ? true : newPhone.matches("^[6-9]\\d{9}$");
					}
					break;
				default:
					// if invalid record type then initialize the updateDetails as true, so after switch it won't get updated
					System.out.println("Invalid type of record, try again later!");
					updateDetails = true;
			}
			
			// if record not get updated then proceed further to update the details
			if(!updateDetails) {
				
				// update query for updating the student email and phone
				String updateQuery = "update student set email = ?, phone = ? where id = ?";
				
				// create PreparedStatement object for updating student record
				try(PreparedStatement updatePst = con.prepareStatement(updateQuery)) {
					
					// storing existing email and phone, so if user fail to provide the details then this detail get updated in place of new empty details
					updatePst.setString(1, newEmail.isEmpty() ? searchRs.getString(3) : newEmail.trim());
					updatePst.setString(2, newPhone.isEmpty() ? searchRs.getString(4) : newPhone.trim());
					updatePst.setInt(3, searchRs.getInt(1));
					
					// execute query
					int rowsUpdated = updatePst.executeUpdate();
					String message = rowsUpdated > 0 ? "Student record updated successfully." : "Student record failed to updated.";
					System.out.println(message);
				}
				
			}
		}
		else {
			// if student record not found
			System.out.println("Student record not found.");
		}
		
		// closing the ResultSet object for searching the student
		searchRs.close();
		
		// closing the PreparedStatement object for searching the student
		searchPst.close();
		
		// closing the Scanner object
		sc.close();
	}
	
	// Delete method for deleting student records
	public static void deleteStudents(Connection con) throws SQLException {
		
		// creating Scanner object to ask user input
		Scanner sc = new Scanner(System.in);
		
		// asking user to provide the email against which the record must be deleted
		System.out.println("Enter student email for deleting existing record:");
		String email = sc.nextLine();
		
		// define regex for 'email' validation
		boolean isValidEmail = email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"); // can start within the range defined, afterwards '@' character, then domain name, and at last top level domain name with atleast 2 characters
		
		// if 'email' is not valid then ask to renter
		while(!isValidEmail) {
			System.out.println("Please enter student email for deleting existing record:");
			email = sc.nextLine();
			isValidEmail = email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
		}
		
		// select query for searching the student record based on 'email'(unique)
		String searchQuery = "select * from student where email = ?";
		
		// create PreparedStatement object for searching student record
		PreparedStatement searchPst = con.prepareStatement(searchQuery);
		
		// set values for fields
		searchPst.setString(1, email.trim());
		
		// execute query and assign table view to ResultSet object
		ResultSet searchRs = searchPst.executeQuery();
		
		if(searchRs.next()) {
			// delete query for deleting student record
			String deleteQuery = "delete from student where id = ?";
			
			// create PreparedStatement object for deleting student record
			try(PreparedStatement deletePst = con.prepareStatement(deleteQuery);) {
				
				// set values for fields
				deletePst.setInt(1, searchRs.getInt(1));
				
				// execute query
				int rowsDeleted = deletePst.executeUpdate();
				String message = rowsDeleted > 0 ? "Student record deleted successfully." : "Student record failed to delete.";
				System.out.println(message);
			}
		}
		else {
			// if email not found in 'student' table
			System.out.println("Student record not found. Please use another email id.");
		}
		
		// closing the ResultSet object
		searchRs.close();
		
		// closing the PreparedStatement object
		searchPst.close();
		
		// closing the Scanner object
		sc.close();
	}
	
	// Insert method for creating course records
	public static void insertCourses(Connection con) throws SQLException {
		
		// Scanner object to take user input
		Scanner sc = new Scanner(System.in);
		
		// asking to enter course name
		System.out.println("Enter course name:");
		String course 			= sc.nextLine();
		
		// define regex for 'course' validation
		boolean isValidCourse 	= course.matches("^[\\w\\W]+$"); // course name must have small a-z or caps A-Z and any special character
		
		// asking to enter course duration
		System.out.println("Enter course duration:");
		String duration 		= sc.nextLine();
		
		// define regex for 'duration' validation
		boolean isValidDuration = duration.matches("^[1-9]\\d*$"); // duration must be within the range between 1 to 9 and later any digit with zero or more occurences
		
		// check if any of the value is not valid and ask to renter
		while(!isValidCourse || !isValidDuration) {
						
			if(!isValidCourse) {
				System.out.println("Please enter course name: ");
				course 			= sc.nextLine();
				isValidCourse 	= course.matches("^[\\w\\W]+$");
			}
			
			if(!isValidDuration) {
				System.out.println("Please enter valid course duration:");
				duration 		= sc.nextLine();
				isValidDuration = duration.matches("^[1-9]\\d*$");
			}
						
		}			
				
		// select query to search if same course with duration already exist
		String selectQuery = "select * from course where course_name = ? and duration = ?";
		try(PreparedStatement selectPst = con.prepareStatement(selectQuery)) {
			
			// set values for fields
			selectPst.setString(1, course.trim());
			selectPst.setInt(2, Integer.parseInt(duration.trim()));
			
			// execute query and assign the table view to ResultSet object
			ResultSet rs = selectPst.executeQuery();
			
			// if same course with duration already exist
			if(rs.next()) {
				System.out.println("Course with same duration already exists. Please provide different duration.");
			}
			else {
				// insert query to insert course data
				String insertQuery = "insert into course(course_name, duration) values(?,?)";
				
				try(PreparedStatement insertPst = con.prepareStatement(insertQuery)) {
					
					// set values for fields
					insertPst.setString(1, course.trim());
					insertPst.setInt(2, Integer.parseInt(duration.trim()));
					
					int rowsInserted 	= insertPst.executeUpdate();
					String message 		= rowsInserted > 0 ? "Record inserted successfully" : "Record failed to insert";
					System.out.println(message);
				}
			}
			
			// closing the ResultSet Object
			rs.close();
		}
				
		// closing the Scanner object
		sc.close();
	}

	// Select method for reading course records
	public static void selectCourses(Connection con) throws SQLException {
		
		// Select query to fetch all the student record
		String selectQuery = "select * from course";
		
		// create a Statement object
		try(Statement st = con.createStatement()) {

			// execute query and initialize table view to ResultSet object
			ResultSet rs = st.executeQuery(selectQuery);
			
			// if course data exist
			boolean courseExist = rs.next();
			if(courseExist) {
				System.out.println("Course details fetched successfully:");
				// if data exist then iterate the data
				while(courseExist) {
					// using format specifier we can replace concatenation and define format for different datatypes
					System.out.printf("Name: %s, Duration: %d%n", rs.getString(2), rs.getInt(3));
					// move to next row
					courseExist = rs.next();
				}
			}
			else {
				// if data does not exist
				System.out.println("Data not found");
			}
			
			// closing the ResultSet Object
			rs.close();
		}
	}
	
	// Update method for updating course records
	public static void updateCourses(Connection con) throws SQLException {
		
		// Scanner object to take user input
		Scanner sc = new Scanner(System.in);
		
		// asking to enter course name for searching the course details
		System.out.println("Enter existing course name for updating details:");
		String course 			= sc.nextLine();
		
		// define regex for 'course' validation
		boolean isValidCourse 	= course.matches("^[\\w\\W]+$"); // course name must have small a-z or caps A-Z and any special character
		
		// asking to enter course duration for searching the course details
		System.out.println("Enter existing course duration for updating details:");
		String duration 		= sc.nextLine();
		
		// define regex for 'duration' validation
		boolean isValidDuration = duration.matches("^[1-9]\\d*$"); // duration must be within the range between 1 to 9 and later any digit with zero or more occurences
		
		// check if any of the value is not valid and ask to renter
		while(!isValidCourse || !isValidDuration) {
						
			if(!isValidCourse) {
				System.out.println("Please enter existing course name for updating details: ");
				course 			= sc.nextLine();
				isValidCourse 	= course.matches("^[\\w\\W]+$");
			}
			
			if(!isValidDuration) {
				System.out.println("Please enter existing valid course duration for updating details:");
				duration 		= sc.nextLine();
				isValidDuration = duration.matches("^[1-9]\\d*$");
			}
						
		}			
		
		// select query to search if same course with duration already exist
		String selectQuery = "select * from course where course_name = ? and duration = ?";
		try(PreparedStatement selectPst = con.prepareStatement(selectQuery)) {
			
			// set values for fields
			selectPst.setString(1, course.trim());
			selectPst.setInt(2, Integer.parseInt(duration.trim()));
			
			// execute query and assign the table view to ResultSet object
			ResultSet rs = selectPst.executeQuery();
			
			// if same course with duration exist
			if(rs.next()) {
				
				System.out.println("Enter new course duration for updating details:");
				String newDuration 		= sc.nextLine();
				
				// define regex for 'duration' validation
				boolean isValidNewDuration = newDuration.matches("^[1-9]\\d*$"); // duration must be within the range between 1 to 9 and later any digit with zero or more occurences
				
				while(!isValidNewDuration) {
					System.out.println("Please enter new valid course duration for updating details:");
					newDuration 		= sc.nextLine();
					isValidNewDuration 	= newDuration.matches("^[1-9]\\d*$");
				}
				
				// if new duration exist with same course name
				PreparedStatement selectQueryForExistingRecord = con.prepareStatement(selectQuery);
				
				// set values for fields
				selectQueryForExistingRecord.setString(1, course.trim());
				selectQueryForExistingRecord.setInt(2, Integer.parseInt(newDuration.trim()));
				
				// execute query and assign the table view to ResultSet object
				ResultSet existingRs = selectQueryForExistingRecord.executeQuery();
				
				// if new duration does not exist with same course name, then update the details
				if(!existingRs.next()) {
					// update query for updating course data
					String updateQuery = "update course set duration = ? where id = ?";
					
					try(PreparedStatement updatePst = con.prepareStatement(updateQuery)) {
						
						// set values for fields
						updatePst.setInt(1, Integer.parseInt(newDuration.trim()));
						updatePst.setInt(2, rs.getInt(1));
						
						int rowsUpdated 	= updatePst.executeUpdate();
						String message 		= rowsUpdated > 0 ? "Course data updated successfully" : "Record failed to update";
						System.out.println(message);
					}
				}
				else {
					// if new duration exist with same course name
					System.out.println("Duration for the course already exist. Try again later with different duration.");
				}						
				
				// closing the ResultSet Object
				existingRs.close();
				
				// closing the PreparedStatement Object
				selectQueryForExistingRecord.close();
			}
			else {
				// if course details are invalid.
				System.out.println("Course details are invalid.");
			}
			
			// closing the ResultSet Object
			rs.close();
		}
				
		// closing the Scanner object
		sc.close();
	}

	// Delete method for deleting course records
	public static void deleteCourses(Connection con) throws SQLException {
		
		// Scanner object to take user input
		Scanner sc = new Scanner(System.in);
		
		// asking to enter course name for deleting the course details
		System.out.println("Enter existing course name for deleting details:");
		String course 			= sc.nextLine();
		
		// define regex for 'course' validation
		boolean isValidCourse 	= course.matches("^[\\w\\W]+$"); // course name must have small a-z or caps A-Z and any special character
		
		// asking to enter course duration for deleting the course details
		System.out.println("Enter existing course duration for deleting details:");
		String duration 		= sc.nextLine();
		
		// define regex for 'duration' validation
		boolean isValidDuration = duration.matches("^[1-9]\\d*$"); // duration must be within the range between 1 to 9 and later any digit with zero or more occurences
		
		// check if any of the value is not valid and ask to renter
		while(!isValidCourse || !isValidDuration) {
						
			if(!isValidCourse) {
				System.out.println("Please enter existing course name for deleting details: ");
				course 			= sc.nextLine();
				isValidCourse 	= course.matches("^[\\w\\W]+$");
			}
			
			if(!isValidDuration) {
				System.out.println("Please enter existing valid course duration for deleting details:");
				duration 		= sc.nextLine();
				isValidDuration = duration.matches("^[1-9]\\d*$");
			}
						
		}			
		
		// select query to search if same course with duration exists
		String selectQuery = "select * from course where course_name = ? and duration = ?";
		try(PreparedStatement selectPst = con.prepareStatement(selectQuery)) {
			
			// set values for fields
			selectPst.setString(1, course.trim());
			selectPst.setInt(2, Integer.parseInt(duration.trim()));
			
			// execute query and assign the table view to ResultSet object
			ResultSet rs = selectPst.executeQuery();
			
			// if course details exist then proceed further to delete the course detail
			if(rs.next()) {							
				
				// delete query for deleting course detail
				String deleteQuery = "delete from course where id = ?";
				
				try(PreparedStatement deletePst = con.prepareStatement(deleteQuery)) {
					
					// set values for fields
					deletePst.setInt(1, rs.getInt(1));
					
					int rowsDeleted 	= deletePst.executeUpdate();
					String message 		= rowsDeleted > 0 ? "Course data deleted successfully" : "Record failed to delete";
					System.out.println(message);
				}				
				
			}
			else {
				// if course details are invalid.
				System.out.println("Course details are invalid.");
			}
			
			// closing the ResultSet Object
			rs.close();
		}
				
		// closing the Scanner object
		sc.close();
	}
	
	// Insert method for creating enrollments
	public static void insertEnrollments(Connection con) throws SQLException {
		
		// Scanner object to take user input
		Scanner sc = new Scanner(System.in);
		
		// asking to enter student email
		System.out.println("Enter student email for enrollment:");
		String email 			= sc.nextLine();	
		
		// define regex for 'email' validation
		boolean isValidEmail 	= email.matches("^[a-zA-Z0-9.+_%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"); // can start within the range defined, afterwards '@' character, then domain name, and at last top level domain name with atleast 2 characters
		
		// asking to enter course name
		System.out.println("Enter course name for student to enroll:");
		String course 			= sc.nextLine();
		
		// define regex for 'course' validation
		boolean isValidCourse 	= course.matches("^[\\w\\W]+$"); // course name must have small a-z or caps A-Z and any special character
		
		// asking to enter course duration
		System.out.println("Enter course duration for student to enroll:");
		String duration 		= sc.nextLine();
		
		// define regex for 'duration' validation
		boolean isValidDuration = duration.matches("^[1-9]\\d*$"); // duration must be within the range between 1 to 9 and later any digit with zero or more occurences
		
		// check if any of the value is not valid and ask to renter
		while(!isValidEmail || !isValidCourse || !isValidDuration) {
					
			if(!isValidEmail) {
				System.out.println("Please enter valid student email for enrollment: ");
				email 			= sc.nextLine();
				isValidEmail 	= email.matches("^[a-zA-Z0-9.+_%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
			}
			
			if(!isValidCourse) {
				System.out.println("Please enter course name for student to enroll: ");
				course 			= sc.nextLine();
				isValidCourse 	= course.matches("^[\\w\\W]+$");
			}
			
			if(!isValidDuration) {
				System.out.println("Please enter valid course duration for student to enroll:");
				duration 		= sc.nextLine();
				isValidDuration = duration.matches("^[1-9]\\d*$");
			}						
		}			
				
		// select query to search if same course with duration already exist
		String selectCourseQuery 			= "select * from course where course_name = ? and duration = ?";
		
		// create PreparedStatement object for course
		PreparedStatement selectCoursePst 	= con.prepareStatement(selectCourseQuery);
			
		// set values for fields
		selectCoursePst.setString(1, course.trim());
		selectCoursePst.setInt(2, Integer.parseInt(duration.trim()));
		
		// execute query and assign the table view to ResultSet object
		ResultSet courseRs = selectCoursePst.executeQuery();		
		
		// select query to search if email already exist
		String selectStudentQuery = "select * from student where email = ?";
		
		// create PreparedStatement object for student
		PreparedStatement selectStudentPst = con.prepareStatement(selectStudentQuery);
		
		// set values for fields
		selectStudentPst.setString(1, email.trim());
			
		// execute query and assign the table view to ResultSet object
		ResultSet studentRs = selectStudentPst.executeQuery();			
				
		// if course with duration and student data exist
		boolean studentExist 	= studentRs.next();
		boolean courseExist 	= courseRs.next();
		
		// if exist then proceed with enrollment
		if(studentExist && courseExist) {
			
			// select query to search if student already get enrolled
			String selectEnrollmentQuery = "select * from enrollment where student_id = ? and course_id = ?";
			
			// create PreparedStatement object for enrollment
			PreparedStatement selectEnrollmentPst = con.prepareStatement(selectEnrollmentQuery);
			
			// set values for fields
			selectEnrollmentPst.setInt(1, studentRs.getInt(1));
			selectEnrollmentPst.setInt(2, courseRs.getInt(1));
				
			// execute query and assign the table view to ResultSet object
			ResultSet enrollmentRs = selectEnrollmentPst.executeQuery();
			
			// if student is not enrolled then proceed with enrollment
			if(!enrollmentRs.next()) {
				// insert query to enroll the student
				String insertEnrollmentQuery = "insert into enrollment(student_id, course_id, enrollment_date) values(?,?,?)";
				
				// create PreparedStatement object for inserting enrollment record
				PreparedStatement insertEnrollmentPst = con.prepareStatement(insertEnrollmentQuery);
				
				// set values for fields
				insertEnrollmentPst.setInt(1, studentRs.getInt(1));
				insertEnrollmentPst.setInt(2, courseRs.getInt(1));
				insertEnrollmentPst.setDate(3, new Date(System.currentTimeMillis()));
				
				// execute query
				int rowsInserted = insertEnrollmentPst.executeUpdate();
				String message = rowsInserted > 0 ? "Student successfully enrolled in the course" : "Student failed to enrolled in the course";
				System.out.println(message);
				
				// close the Insert Enrollment PreparedStatement object
				insertEnrollmentPst.close();
				
			}
			else {
				// if student already enrolled in the course
				System.out.println("Student already enrolled in the course.");
			}
			
			// close the Enrollment ResultSet object
			enrollmentRs.close();
			
			// close the Select Enrollment PreparedStatement object
			selectEnrollmentPst.close();
		}
		else {
			// if course with duration and student data does not exist
			
			if(!studentExist) {
				System.out.println("Invalid student details.");
			}
			
			if(!courseExist) {
				System.out.println("Invalid course details.");
			}
			
		}
			
		// closing the Course ResultSet Object
		courseRs.close();
		
		// close the Select Course PreparedStatement object
		selectCoursePst.close();
		
		// closing the Student ResultSet Object
		studentRs.close();
				
		// close the Select Student PreparedStatement object
		selectStudentPst.close();
		
		// closing the Scanner object
		sc.close();
	}
	
	// Select method for reading course records
	public static void selectEnrollments(Connection con) throws SQLException {

		// select query for retrieving enrollments
		String selectEnrollmentQuery = "select * from enrollment";
		
		// create PreparedStatement object for enrollment
		Statement selectEnrollmentSt = con.createStatement();		
			
		// execute query and assign the table view to ResultSet object
		ResultSet enrollmentRs = selectEnrollmentSt.executeQuery(selectEnrollmentQuery);
		
		// check if enrollment exist
		boolean enrollmentExist = enrollmentRs.next();
		if(enrollmentExist) {				
			
			System.out.println("Student details fetched successfully:");
			
			// iterate over enrollment data
			while(enrollmentExist) {
				
				// select query for fetching the course detail
				String selectCourseQuery	= "select * from course where id = ?";
				
				// select query for fetching the student detail
				String selectStudentQuery 	= "select * from student where id = ?";

				// create PreparedStatement object for course
				PreparedStatement selectCoursePst = con.prepareStatement(selectCourseQuery);		
				
				// set fields for course
				selectCoursePst.setInt(1, enrollmentRs.getInt(3));
				
				// execute query and assign the table view to ResultSet object
				ResultSet courseRs = selectCoursePst.executeQuery();
				
				// create PreparedStatement object for student
				PreparedStatement selectStudentPst = con.prepareStatement(selectStudentQuery);		
				
				// set fields for student
				selectStudentPst.setInt(1, enrollmentRs.getInt(2));
							
				// execute query and assign the table view to ResultSet object
				ResultSet studentRs = selectStudentPst.executeQuery();
				
				// move cursor to next row for 'student'
				courseRs.next();
				
				// move cursor to next row for 'course'
				studentRs.next();
				
				System.out.println("Student Name: "+studentRs.getString(2));
				System.out.println("Student Email: "+studentRs.getString(3));
				System.out.println("Student Phone: "+studentRs.getString(4));
				System.out.println("Course Name: "+courseRs.getString(2));
				System.out.println("Course Duration: "+courseRs.getInt(3));
				SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
				
				System.out.println("Enrollment date: "+sdf.format(enrollmentRs.getDate(4)));
				System.out.println("------------------------------------------");
				
				// closing ResultSet object for courses
				courseRs.close();
				
				// closing PreparedStatement object for courses
				selectCoursePst.close();
				
				// closing ResultSet object for courses
				studentRs.close();
				
				// closing PreparedStatement object for courses
				selectStudentPst.close();
				
				// move cursor to next row
				enrollmentExist = enrollmentRs.next();							
				
			}
			
			
		}
		else {
			System.out.println("No Enrollment data found.");
		}
		
		// closing the ResultSet Object
		enrollmentRs.close();
		
		// closing the PreparedStatement Object
		selectEnrollmentSt.close();
	}
	
	// Update method for updating enrollments
	public static void updateEnrollments(Connection con) throws SQLException {
		
		// Scanner object to take user input
		Scanner sc = new Scanner(System.in);
		
		// asking to enter student email for searching in 'student' table
		System.out.println("Enter student email for updating enrollment:");
		String email 			= sc.nextLine();	
		
		// define regex for 'email' validation
		boolean isValidEmail 	= email.matches("^[a-zA-Z0-9.+_%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"); // can start within the range defined, afterwards '@' character, then domain name, and at last top level domain name with atleast 2 characters
		
		// asking to enter old course name for searching in 'course' table
		System.out.println("Enter old course name for student:");
		String course 			= sc.nextLine();
		
		// define regex for 'course' validation
		boolean isValidCourse 	= course.matches("^[\\w\\W]+$"); // course name must have small a-z or caps A-Z and any special character
		
		// asking to enter old course duration for searching in 'course' table
		System.out.println("Enter old course duration for student:");
		String duration 		= sc.nextLine();
		
		// define regex for 'duration' validation
		boolean isValidDuration = duration.matches("^[1-9]\\d*$"); // duration must be within the range between 1 to 9 and later any digit with zero or more occurences
		
		// check if any of the value is not valid and ask to renter
		while(!isValidEmail || !isValidCourse || !isValidDuration) {
					
			if(!isValidEmail) {
				System.out.println("Please enter valid student email for updating enrollment: ");
				email 			= sc.nextLine();
				isValidEmail 	= email.matches("^[a-zA-Z0-9.+_%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
			}
			
			if(!isValidCourse) {
				System.out.println("Please enter old course name for student: ");
				course 			= sc.nextLine();
				isValidCourse 	= course.matches("^[\\w\\W]+$");
			}
			
			if(!isValidDuration) {
				System.out.println("Please enter old valid course duration for student:");
				duration 		= sc.nextLine();
				isValidDuration = duration.matches("^[1-9]\\d*$");
			}						
		}			
				
		// select query to search if old course with duration exist
		String selectCourseQuery 			= "select * from course where course_name = ? and duration = ?";
		
		// create PreparedStatement object for course
		PreparedStatement selectCoursePst 	= con.prepareStatement(selectCourseQuery);
		
		// set values for fields
		selectCoursePst.setString(1, course.trim());
		selectCoursePst.setInt(2, Integer.parseInt(duration.trim()));
		
		// execute query and assign the table view to ResultSet object
		ResultSet courseRs = selectCoursePst.executeQuery();		
		
		// select query to search if email already exist
		String selectStudentQuery = "select * from student where email = ?";
		
		// create PreparedStatement object for student
		PreparedStatement selectStudentPst = con.prepareStatement(selectStudentQuery);
		
		// set values for fields
		selectStudentPst.setString(1, email.trim());
			
		// execute query and assign the table view to ResultSet object
		ResultSet studentRs = selectStudentPst.executeQuery();			
				
		// if course with duration and student data exist
		boolean studentExist 	= studentRs.next();
		boolean courseExist 	= courseRs.next();
		
		// check if student exist in 'student' table and course detail exist in 'course' table, then proceed further
		if(studentExist && courseExist) {						
			
			// select query to search if student already enrolled
			String selectEnrollmentQuery = "select * from enrollment where student_id = ? and course_id = ?";
			
			// create PreparedStatement object for enrollment
			PreparedStatement selectEnrollmentPst = con.prepareStatement(selectEnrollmentQuery);
			
			// set values for fields
			selectEnrollmentPst.setInt(1, studentRs.getInt(1));
			selectEnrollmentPst.setInt(2, courseRs.getInt(1));
				
			// execute query and assign the table view to ResultSet object
			ResultSet enrollmentRs = selectEnrollmentPst.executeQuery();
			
			// if student is already enrolled then proceed with updating enrollment
			if(enrollmentRs.next()) {
				
				// asking to enter new course name for searching in 'course' table
				System.out.println("Enter new course name for student to update enrollment:");
				String newCourse 			= sc.nextLine();
				
				// define regex for 'course' validation
				boolean isValidNewCourse 	= newCourse.matches("^[\\w\\W]+$"); // course name must have small a-z or caps A-Z and any special character
				
				// asking to enter new course duration for searching in 'course' table
				System.out.println("Enter new course duration for student to update enrollment:");
				String newDuration 		= sc.nextLine();
				
				// define regex for 'duration' validation
				boolean isValidNewDuration = newDuration.matches("^[1-9]\\d*$"); // duration must be within the range between 1 to 9 and later any digit with zero or more occurences
				
				// check if any of the value is not valid then ask to renter
				while(!isValidNewCourse || !isValidNewDuration) {					
					
					if(!isValidNewCourse) {
						System.out.println("Please enter new course name for student to update enrollment: ");
						newCourse 			= sc.nextLine();
						isValidNewCourse 	= newCourse.matches("^[\\w\\W]+$");
					}
					
					if(!isValidNewDuration) {
						System.out.println("Please enter new valid course duration for student to update enrollment:");
						newDuration 		= sc.nextLine();
						isValidNewDuration	= newDuration.matches("^[1-9]\\d*$");
					}						
				}		
				
				// select query to search if course with duration exist
				String selectNewCourseQuery 			= "select * from course where course_name = ? and duration = ?";
				
				// create PreparedStatement object for course
				PreparedStatement selectNewCoursePst 	= con.prepareStatement(selectNewCourseQuery);
				
				// set values for fields
				selectNewCoursePst.setString(1, newCourse.trim());
				selectNewCoursePst.setInt(2, Integer.parseInt(newDuration.trim()));
				
				// execute query and assign the table view to ResultSet object
				ResultSet newCourseRs = selectNewCoursePst.executeQuery();	
				
				if(newCourseRs.next()) {
					
					// update query for updating enrollment					
					String updateQuery = "update enrollment set course_id = ? where enrollment_id = ?";
					
					// create PreparedStatement object for updating enrollment record
					try(PreparedStatement updateEnrollmentPst = con.prepareStatement(updateQuery)) {
						
						// set values for fields			
						updateEnrollmentPst.setInt(1, newCourseRs.getInt(1));
						updateEnrollmentPst.setInt(2, enrollmentRs.getInt(1));
						
						// execute query
						int rowsUpdated = updateEnrollmentPst.executeUpdate();
						String message = rowsUpdated > 0 ? "Student enrollment updated successfully" : "Student enrollment failed to update";
						System.out.println(message);
					}
				}
				else {
					System.out.println("New course detail couldn't found for updating the enrollment. Try again later by entering valid course detail.");
				}
								
				// closing ResultSet Object for searching new course detail
				newCourseRs.close();
				
				// closing PreparedStatement Object for searching new course detail
				selectNewCoursePst.close();
			}
			else {
				// if student is no enrolled then show the message
				System.out.println("Student not enrolled in the course. Please enroll first then update the details.");
			}
			
			// close the Enrollment ResultSet object
			enrollmentRs.close();
			
			// close the Select Enrollment PreparedStatement object
			selectEnrollmentPst.close();
		}
		else {
			// if course with duration and student data does not exist
			
			if(!studentExist) {
				System.out.println("Invalid student details.");
			}
			
			if(!courseExist) {
				System.out.println("Invalid course details.");
			}
			
		}
			
		// closing the Course ResultSet Object
		courseRs.close();
		
		// close the Select Course PreparedStatement object
		selectCoursePst.close();
		
		// closing the Student ResultSet Object
		studentRs.close();
				
		// close the Select Student PreparedStatement object
		selectStudentPst.close();
		
		// closing the Scanner object
		sc.close();
	}

	// Delete method for deleting enrollments
	public static void deleteEnrollments(Connection con) throws SQLException {
		
		// Scanner object to take user input
		Scanner sc = new Scanner(System.in);
		
		// asking to enter student email for deleting enrollment
		System.out.println("Enter student email to delete enrollment:");
		String email 			= sc.nextLine();	
		
		// define regex for 'email' validation
		boolean isValidEmail 	= email.matches("^[a-zA-Z0-9.+_%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"); // can start within the range defined, afterwards '@' character, then domain name, and at last top level domain name with atleast 2 characters
		
		// asking to enter which course name enrolled against student
		System.out.println("Enter existing course name for student to delete enrollment:");
		String course 			= sc.nextLine();
		
		// define regex for 'course' validation
		boolean isValidCourse 	= course.matches("^[\\w\\W]+$"); // course name must have small a-z or caps A-Z and any special character
		
		// asking to enter course duration enrolled against student
		System.out.println("Enter existing course duration for student to delete enrollment:");
		String duration 		= sc.nextLine();
		
		// define regex for 'duration' validation
		boolean isValidDuration = duration.matches("^[1-9]\\d*$"); // duration must be within the range between 1 to 9 and later any digit with zero or more occurences
		
		// check if any of the value is not valid and ask to renter
		while(!isValidEmail || !isValidCourse || !isValidDuration) {
					
			if(!isValidEmail) {
				System.out.println("Please enter valid student email to delete enrollment: ");
				email 			= sc.nextLine();
				isValidEmail 	= email.matches("^[a-zA-Z0-9.+_%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
			}
			
			if(!isValidCourse) {
				System.out.println("Please enter existing course name for student to delete enrollment: ");
				course 			= sc.nextLine();
				isValidCourse 	= course.matches("^[\\w\\W]+$");
			}
			
			if(!isValidDuration) {
				System.out.println("Please enter existing valid course duration for student to delete enrollment:");
				duration 		= sc.nextLine();
				isValidDuration = duration.matches("^[1-9]\\d*$");
			}						
		}			
				
		// select query to search if course with duration exist in 'course' table
		String selectCourseQuery 			= "select * from course where course_name = ? and duration = ?";
		
		// create PreparedStatement object for course
		PreparedStatement selectCoursePst 	= con.prepareStatement(selectCourseQuery);
			
		// set values for fields
		selectCoursePst.setString(1, course.trim());
		selectCoursePst.setInt(2, Integer.parseInt(duration.trim()));
		
		// execute query and assign the table view to ResultSet object
		ResultSet courseRs = selectCoursePst.executeQuery();		
		
		// select query to search if email exist in 'student' table
		String selectStudentQuery = "select * from student where email = ?";
		
		// create PreparedStatement object for student
		PreparedStatement selectStudentPst = con.prepareStatement(selectStudentQuery);
		
		// set values for fields
		selectStudentPst.setString(1, email.trim());
			
		// execute query and assign the table view to ResultSet object
		ResultSet studentRs = selectStudentPst.executeQuery();			
				
		// if course with duration and student data exist
		boolean studentExist 	= studentRs.next();
		boolean courseExist 	= courseRs.next();
		
		// if exist then proceed with enrollment
		if(studentExist && courseExist) {
			
			// select query to search if student already get enrolled
			String selectEnrollmentQuery = "select * from enrollment where student_id = ? and course_id = ?";
			
			// create PreparedStatement object for enrollment
			PreparedStatement selectEnrollmentPst = con.prepareStatement(selectEnrollmentQuery);
			
			// set values for fields
			selectEnrollmentPst.setInt(1, studentRs.getInt(1));
			selectEnrollmentPst.setInt(2, courseRs.getInt(1));
				
			// execute query and assign the table view to ResultSet object
			ResultSet enrollmentRs = selectEnrollmentPst.executeQuery();
			
			// if student is not enrolled then proceed with enrollment
			if(enrollmentRs.next()) {
				
				// delete query for deleting the enrolled student
				String deleteEnrollmentQuery = "delete from enrollment where enrollment_id = ?";
				
				// create PreparedStatement object for inserting enrollment record								
				try(PreparedStatement deleteEnrollmentPst = con.prepareStatement(deleteEnrollmentQuery)) {
					
					// set values for fields
					deleteEnrollmentPst.setInt(1, enrollmentRs.getInt(1));
					
					// execute query
					int rowsDeleted = deleteEnrollmentPst.executeUpdate();
					String message = rowsDeleted > 0 ? "Student enrollment deleted successfully." : "Student enrollment failed to deleted.";
					System.out.println(message);					
					
				}
				
			}
			else {
				// if student is no enrolled then show the message
				System.out.println("Student not enrolled in the course. Please enroll the student.");
			}
			
			// close the Enrollment ResultSet object
			enrollmentRs.close();
			
			// close the Select Enrollment PreparedStatement object
			selectEnrollmentPst.close();
		}
		else {
			// if course with duration and student data does not exist
			
			if(!studentExist) {
				System.out.println("Invalid student details.");
			}
			
			if(!courseExist) {
				System.out.println("Invalid course details.");
			}
			
		}
			
		// closing the Course ResultSet Object
		courseRs.close();
		
		// close the Select Course PreparedStatement object
		selectCoursePst.close();
		
		// closing the Student ResultSet Object
		studentRs.close();
				
		// close the Select Student PreparedStatement object
		selectStudentPst.close();
		
		// closing the Scanner object
		sc.close();
	}
}
