package com.week2;

import java.io.*;

// 4. Create a custom exception called InvalidAgeException and use it in a program to validate age input.
class InvalidAgeException extends Exception { // creating custom exception
	public InvalidAgeException(String message) {
		super(message);
	}
}

public class Day9Assignment {

	// Example of throw keyword
	public static void checkAge(int age) {
		if(age < 18) {
			throw new ArithmeticException("Voting restricted - You are under age i.e below 18 years.");
		}
		else {
			System.out.println("Able to vote your right candidate.");
		}
	}
	
	// Example of throws keyword
	// 2. Create a method that reads a file and declares throws IOException. Call it from main and handle the exception.
	public static void readFile(String filename) throws IOException {
		// reads the file which throws exception, here not handled and thrown that exception using throws keyword
		FileReader fileRead 		= new FileReader(filename);
		BufferedReader fileInput 	= new BufferedReader(fileRead);
		
		// print the first line
		System.out.println(fileInput.readLine());
		fileInput.close();
	}
	
	// 4. Create a custom exception called InvalidAgeException and use it in a program to validate age input.	
	public static void validateAge(int age) throws InvalidAgeException{
		if(age < 14) {
			throw new InvalidAgeException("Age is below 14 years, so not able to come in waterpark picnic.");
		}
		else {
			System.out.println("Allowed to come in waterpark picnic.");
		}
	}
	
	public static void main(String[] args) {
		// Practices Exercise
		// Example of try-catch block
		// 1.Write a program to handle division by zero using try-catch.
		try {
			int result = 67/0; // It causes Arithmetic Exception
			System.out.println("Divison result is: "+result);
		}
		catch(ArithmeticException e) {
			System.out.println("Opps! number cannot be divided by zero");
		}
		// Output:- Opps! number cannot be divided by zero
		
		// Example of throws keyword
		// 2. Create a method that reads a file and declares throws IOException. Call it from main and handle the exception
		try {
			readFile("ssss.txt"); // in the method defined the throws keyword to declare IOException
		}
		catch(IOException e) {
			System.out.println("File not found or occurred error while reading the file.");
		}
		// Output:- File not found or occurred error while reading the file.
		
		// Example of Multiple try-catch block
		// 3. Write a program to catch multiple exceptions: ArithmeticException and ArrayIndexOutOfBoundsException.
		try {
			String[] arrFruits = new String[6];
			arrFruits[9] = "Apple"; // it causes ArrayIndexOutOfBoundsException since accessing index which is not there in the array index range
		} catch(ArithmeticException e) {
			System.out.println("Arithmetic Error"); 
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index is not reachable or out of bound");
		} catch(Exception e) {
			System.out.println("General exception");
		}
		// Output:- Array Index is not reachable or out of bound		
		
		// 4. Create a custom exception called InvalidAgeException and use it in a program to validate age input.
		try {
			validateAge(12); // age validation method is created, and thrown explicit and declare the custom exception as InvalidAgeException
		}
		catch(InvalidAgeException e) {
			System.out.println(e.getMessage());
		}
		// Output:- Age is below 14 years, so not able to come in waterpark picnic.
		
		// 5. Demonstrate the use of finally block by opening and closing a resource.		
		// Example of finally block
		try {
			String name = null;
			System.out.println(name.length()); // it causes NullPointerException since cannot find length for string 'null'
		}
		catch(NullPointerException e) {
			System.out.println("There is no length exist for string 'null'");
		}
		finally {
			System.out.println("This block always executes."); // always executes
		}
		// Output:-
		/*
			There is no length exist for string 'null' // exception handled for NullPointerException
			This block always executes. // finally block always executed
		*/
		
		// Example of throw keyword
		// below function contains example which is throwing exception explicitly and it stops the flow of execution of the program, so uncomment the below line to run the program
		// checkAge(12);
		// Output:-
		/*
			Exception in thread "main" java.lang.ArithmeticException: Voting restricted - You are under age i.e below 18 years.
			at com.week2.Day9Assignment.checkAge(Day9Assignment.java:7)
			at com.week2.Day9Assignment.main(Day9Assignment.java:55)
		*/
	}

}
