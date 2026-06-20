package com.week1;

import java.util.Scanner;
public class Calculator {

	// Defining Class-based methods	
	// 1. Method for calculating addition operation
	public double add(double a, double b) {
		return a + b;
	}
	
	// 2. Method for calculating subtraction operation
	public double subtract(double a, double b) {
		return a - b;
	}
	
	// 3. Method for calculating multiplication operation
	public double multiply(double a, double b) {
		return a * b;
	}
	
	// 4. Method for calculating division operation
	public double divide(double a, double b) {
		return a / b;
	}
	
	// Main method
	public static void main(String[] args) {
		// Scanner object for taking user input.
		Scanner sc = new Scanner(System.in);
		
		// Want to allow user to perform multiple calculation without restarting the program, initializing performCalculation as true.
		boolean performCalculation = true;
		
		// Until performCalculation is 'true' program will execute and ask user to perform multiple calculation without restarting the program.
		while(performCalculation) {
			// Asking user to enter first number.
			System.out.println("Enter first number: ");
			double num1 = sc.nextDouble();			
			
			// if user is entering more then one number, then it will be considered as second number therefore we are clearing the input buffer.
			sc.nextLine();
			
			// Asking user to enter second number.
			System.out.println("Enter second number: ");
			double num2 = sc.nextDouble();
							
			// if user tries to enter something more other then second number then further may InputMismatchException arise therefore we are clearing the input buffer.
			sc.nextLine();

			// Asking user to choose the operation to be performed.
			System.out.println("Choose operator to perform operation(type:- +,-,*,/): ");
			String arithmeticOperationsSymbol;
			arithmeticOperationsSymbol = sc.next();
			
			// if user enters operator other than +,-,*,/ ask user to renter the specified operator to perform operation.
			while(!arithmeticOperationsSymbol.equals("+") && !arithmeticOperationsSymbol.equals("-") && !arithmeticOperationsSymbol.equals("*") && !arithmeticOperationsSymbol.equals("/")) {
				// clearing input buffer so while entering more then one word, only one word is considered and other words are not considered
				sc.nextLine();
				System.out.println("Sorry! you choose invalid operator.");
				System.out.println("Please provide correct operator to perform operation(type:- +,-,*,/): ");
				arithmeticOperationsSymbol = sc.next();
				
			}
			
			// clearing input buffer so while entering more then one word, only one word is considered and other words are not considered
			sc.nextLine();
						
			// Creating object to call the non-static methods which are defined for arithmetic operations outside the main() method.
			Calculator c = new Calculator();
			// Defining switch case to match the operator directly with the cases and calling the specified method for achieving the calculation.
			switch(arithmeticOperationsSymbol) {
				case "+":
					// Calling add() method to perform addition.
					System.out.println("Addition of "+num1+" and "+num2+" is "+c.add(num1, num2));
					break;
				case "-":
					// Calling subtract() method to perform subtraction.
					System.out.println("Subtraction of "+num1+" and "+num2+" is "+c.subtract(num1, num2));
					break;
				case "*":
					// Calling multiply() method to perform multiplication.
					System.out.println("Multiplication of "+num1+" and "+num2+" is "+c.multiply(num1, num2));
					break;
				case "/":
					// handling division by zero, if num2 is '0' then displaying error message and returning result as zero. 
					if(num2 == 0) {
						System.out.println("Number cannot be divided by zero");
						System.out.println("Result: 0");
					}
					else {
						// Calling divide() method to perform division.
						System.out.println("Division of "+num1+" by "+num2+" is "+c.divide(num1, num2));
					}
					break;				
			}			
			
			// Ask if user to perform another calculation
			System.out.println("Do you want to perform another calculation?(type 'y' to continue / 'q' to quit):");
			String performAnotherCalculation;
			performAnotherCalculation = sc.next();
			
			// if user enters input other then y/q then ask user to renter the input
			while(!performAnotherCalculation.equals("y") && !performAnotherCalculation.equals("q")) {
				// clearing input buffer so while entering more then one word, only one word is considered and other words are not considered
				sc.nextLine();
				System.out.println("Do you want to perform another calculation?(type 'y' to continue/'q' to quit):");				
				performAnotherCalculation = sc.next();
			}
			
			// clearing input buffer so while entering more then one word, only one word is considered and other words are not considered
			sc.nextLine();
			
			// if user enters 'q' then reinitializing performCalculation as 'false' and exiting the loop.
			if(performAnotherCalculation.equals("q")) {
				performCalculation = false;
			}
			
			// Sample Input and Output 1: clean user input and output with no error messages
			/*
			Enter first number: 
			12
			Enter second number: 
			34
			Choose operator to perform operation(type:- +,-,*,/): 
			+
			Addition of 12.0 and 34.0 is 46.0
			Do you want to perform another calculation?(type 'y' to continue / 'q' to quit):
			y
			Enter first number: 
			23
			Enter second number: 
			1
			Choose operator to perform operation(type:- +,-,*,/): 
			-
			Subtraction of 23.0 and 1.0 is 22.0
			Do you want to perform another calculation?(type 'y' to continue / 'q' to quit):
			y
			Enter first number: 
			67
			Enter second number: 
			4
			Choose operator to perform operation(type:- +,-,*,/): 
			*
			Multiplication of 67.0 and 4.0 is 268.0
			Do you want to perform another calculation?(type 'y' to continue / 'q' to quit):
			y
			Enter first number: 
			4
			Enter second number: 
			45
			Choose operator to perform operation(type:- +,-,*,/): 
			/
			Division of 4.0 by 45.0 is 0.08888888888888889
			Do you want to perform another calculation?(type 'y' to continue / 'q' to quit):
			q
			*/
			
			// Sample Input and Output 2: if user enter number as 0 while division and if operator is not valid and if types other then 'y' and 'q', all things are handled below.
			/*
			Enter first number: 
			34
			Enter second number: 
			0
			Choose operator to perform operation(type:- +,-,*,/): 
			asas // if random text entered then displaying error message
			Sorry! you choose invalid operator.
			Please provide correct operator to perform operation(type:- +,-,*,/): 
			/
			Number cannot be divided by zero
			Result: 0 // if number is entered as zero then showing error message and result as 0
			Do you want to perform another calculation?(type 'y' to continue / 'q' to quit):
			gdff // if random text enter other then 'y' and 'q' then asking user to provide input again
			Do you want to perform another calculation?(type 'y' to continue/'q' to quit):
			q
			*/
		}
	}

}
