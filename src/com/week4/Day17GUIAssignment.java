package com.week4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/*
 * @methods defined the methods to perform Create and Read operations on 'student' table
 * @class use the Logger class for logging the exception
 * @caught handling all the exception in the specific Create and Read method
 */

public class Day17GUIAssignment {

	// fields declared and initialized for database connection
	private static final String url 		= "jdbc:mysql://localhost:3306/education?serverTimezone=UTC";
	private static final String username 	= "root";
	private static final String password 	= "root";
	
	// fields declared for components inside JFrame
	private static JTextField nameField, emailField, phoneField;
	private static JButton insertButton;
	
	// defining logger to log if an errors, exceptions occurs
	private static final Logger logger = Logger.getLogger(Day17GUIAssignment.class.getName());
	
	/*
	 * Method to validate Name
	 * @param name Student's full name
	 */
	public static boolean nameValiation(String name) {
		
		// default name is correct
		boolean isValidName = true;
		
		// if name is empty or don't follow the validation
		if(name.isEmpty() || !name.matches("^[a-zA-Z\s]+$")) {			
			isValidName = false;
		}
		
		return isValidName;
	}

	/*
	 * Method to validate Email
	 * @param email Student's email id
	 */
	public static boolean emailValidation(String email) {
		
		// default email is correct
		boolean isValidEmail = true;
		
		// if email is empty or don't follow the validation
		if(email.isEmpty() || !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {			
			isValidEmail = false;
		}
			
		return isValidEmail;
	}
	
	/*
	 * Method to validate Phone No
	 * @param phone Student's phone no
	 */
	public static boolean phoneValidation(String phone) {
		
		// default phone is correct
		boolean isValidPhone = true;
		
		// if phone is empty or don't follow the validation
		if(phone.isEmpty() || !phone.matches("^[6-9]\\d{9}$")) {			
			isValidPhone = false;
		}
			
		return isValidPhone;				
	}
	
	/*
	 * Insert method for creating students
	 * @connection established connection to the database
	 * @components JFrame, JTextField, JLabel, JButton
	 * @logger used logger to log exceptions
	 */
	public static void insertStudent() {
		
		JFrame frame = new JFrame();
		
		// set title for JFrame
		frame.setTitle("Student Management");
		// set size of JFrame
		frame.setSize(500, 350);
		// if user is closing the JFrame window then exit the execution
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set layout which controls the arrangement of components inside JFrame
		frame.setLayout(new GridLayout(5,2)); // using GridLayout the components will be arranged in tabular format, here as 5 rows and 2 columns		
		
		// add name inside the JFrame
		frame.add(new JLabel("Name:"));
		nameField = new JTextField();
		frame.add(nameField);
		
		// add email inside the JFrame
		frame.add(new JLabel("Email:"));
		emailField = new JTextField();
		frame.add(emailField);
		
		// add email inside the JFrame
		frame.add(new JLabel("Phone:"));
		phoneField = new JTextField();
		frame.add(phoneField);
		
		// add button inside the JFrame
		insertButton = new JButton("Submit Details");
		frame.add(insertButton);
		
		insertButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name 	= nameField.getText().trim();
				String email 	= emailField.getText().trim();
				String phone 	= phoneField.getText().trim();
				
				// method to validate name
				boolean isValidName = nameValiation(name);
				// if name validation fails then use JOptionPane to display the error message.
				if(!isValidName) {
					JOptionPane.showMessageDialog(
							null,
							"Please provide valid name",
							"Validation Error",
							JOptionPane.ERROR_MESSAGE);
					nameField.requestFocus(); // once error message is displayed, then place the cursor to get focus over name field.
				}
								
				// method to validate email
				boolean isValidEmail = emailValidation(email);
				// if email validation fails then use JOptionPane to display the error message.
				if(!isValidEmail) {
					JOptionPane.showMessageDialog(
							null,
							"Please provide valid email",
							"Validation Error",
							JOptionPane.ERROR_MESSAGE);
					emailField.requestFocus();
				}
				
				// method to validate phone
				boolean isValidPhone = phoneValidation(phone);
				// if phone validation fails then use JOptionPane to display the error message.
				if(!isValidPhone) {
					JOptionPane.showMessageDialog(
							null,
							"Please provide valid Phone No",
							"Validation Error",
							JOptionPane.ERROR_MESSAGE);
					phoneField.requestFocus();
				}
				
				// if name, phone and email three of them is valid then move further for operations 
				if(isValidName && isValidEmail && isValidPhone) {
					// if email or phone already exist
					String selectQuery = "select * from student where email = ? or phone = ?";
					
					// creating connection
					try(Connection con = DriverManager.getConnection(url, username, password)) {
						
						// create PreparedStatement object for searching details already exist
						PreparedStatement selectPst = con.prepareStatement(selectQuery);
						
						// set values for fields
						selectPst.setString(1, email);
						selectPst.setString(2, phone);
						
						// execute query and assign the table view to ResultSet object
						ResultSet rs = selectPst.executeQuery();
						
						// if data does not exist then further insert details
						if(!rs.next() ) {
							
							// query to insert student
							String insertQuery = "insert into student(name, email, phone) values(?,?,?)";
							
							// create PreparedStatement object for inserting details in table 'student'
							PreparedStatement insertPst = con.prepareStatement(insertQuery);
								
							// set values for fields
							insertPst.setString(1, name);
							insertPst.setString(2, email);
							insertPst.setString(3, phone);
							
							// execute the query
							int rowsInserted = insertPst.executeUpdate();				
							if(rowsInserted > 0) {
								JOptionPane.showMessageDialog(
										null,
										"Student inserted successfully",
										"Success message",
										JOptionPane.INFORMATION_MESSAGE);			
							}
							else {
								JOptionPane.showMessageDialog(
										null,
										"Student record failed to insert.",
										"Error message",
										JOptionPane.ERROR_MESSAGE);				
							}
							
							// closing the PreparedStatement object for inserting details
							insertPst.close();
						}
						else {
							// if data exist then show the message
							JOptionPane.showMessageDialog(
									null,
									"Student already exist. Please use different email or phone",
									"Success message",
									JOptionPane.INFORMATION_MESSAGE);	
						}
						
						// closing the ResultSet object for searching details
						rs.close();
						
						// closing PreparedStatement object for searching details
						selectPst.close();
					}
					catch(Exception e1) {
						// using logger to log exception
						logger.log(Level.SEVERE, "CRUD operation failed due to system failure", e1);
					}
				}
				
			}
			
		});
		
		// if setVisible() is set to true then JFrame window will be visible, if false then JFrame window will not be visible
		frame.setVisible(true);
	}
		
	/*
	 * Select method for reading students
	 * @connection established connection to the database
	 * @components JFrame, JTable
	 * @tableModel DefaultTableModel helps to easily set database data into JTable
	 * @logger used logger to log exceptions
	 */
	public static void selectStudents() {
		
		// select query for reading students data
		String selectQuery = "select * from student";
		
		// creating connection
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			
			// create Statement object for searching student details
			try(Statement st = con.createStatement()) {
				
				// assign student record to ResultSet object
				ResultSet rs = st.executeQuery(selectQuery);
				
				if(rs != null) {
					
					// create JFrame
					JFrame frame = new JFrame("Student Details");
					// set size
					frame.setSize(500, 350);
					
					// constructs a default table with zero columns and zero rows
					DefaultTableModel tableModel = new DefaultTableModel();
					
					// used create table
					JTable table = new JTable(tableModel);
					
					// getting the properties of columns
					ResultSetMetaData rsmd 	= rs.getMetaData();
					
					// getting the no of columns count
					int noOfColumns 		= rsmd.getColumnCount();
					
					// iterate no of columns count and get the name of columns and add it to the table model
					for(int columnIndex = 1; columnIndex <= noOfColumns; columnIndex++) {
						tableModel.addColumn(rsmd.getColumnName(columnIndex)); // add column to table model
					}
					
					boolean isStudentExist = rs.next();
					if(isStudentExist) {
						while(isStudentExist) {
							// create an object array and get the column values for a specific row and assign it to the object array
							Object[] row = new Object[noOfColumns];
							for(int column = 1; column <= noOfColumns; column++) {
								row[column - 1] = rs.getObject(column);
							}
							
							tableModel.addRow(row); // add row to table model
							
							isStudentExist = rs.next(); // move cursor to next row
						}
					}
					else {
						
					}
					
					// provide scrollable view for table
					JScrollPane scroll = new JScrollPane(table);
					// add scroll to JFrame
					frame.add(scroll);
					frame.setVisible(true);
				}
				
			}
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, "CRUD operation failed due to system failure", e);
		}
	}
	
	public static void main(String[] args) {
		
		// method for inserting student using JFrame
		insertStudent();
		
		// method for selecting student using JFrame
		selectStudents();
		
	}

}
