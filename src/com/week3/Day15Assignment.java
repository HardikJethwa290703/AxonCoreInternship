package com.week3;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.sql.Date;

public class Day15Assignment {

	private static final String url 		= "jdbc:mysql://localhost:3306/education?serverTimezone=UTC";
	private static final String username 	= "root";
	private static final String password 	= "root";
	
	public static void main(String[] args) {
		
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			
			System.out.println("Connected with database.");
			
			// Insert method for creating students
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
				Java
				Enter course duration for student to enroll:
				45
				Student successfully enrolled in the course
				
				// 3. if student already enrolled with same course and duration(duplicacy handled)
				Enter student email for enrollment:
				kau@gmail.com
				Enter course name for student to enroll:
				java
				Enter course duration for student to enroll:
				45
				Student already enrolled in the course.				
			*/
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	// Insert method for creating students
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
	
	// Insert method for creating courses
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
	
}
