package com.week1;

import java.util.Scanner;
public class Day2Assignment {
	public static void main(String[] args) {
		// Example program
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name: ");
		String name = sc.next();
		
		sc.nextLine();
		
		System.out.println("Enter your age: ");
		int age = sc.nextInt();
		
		System.out.println("Hello "+name+"! Your age is "+age);
		System.out.println();
		// Sample Output
		/* 
			Enter your name: 
			hardik
			Enter your age: 
			22
			Hello hardik! Your age is 22
		*/
		
		// Practice Exercise
		// 1. Write a program that asks for two numbers and prints: sum, difference, product, quotient, remainder after division
		System.out.println("Enter first number: ");
		double num1 = sc.nextDouble();
		System.out.println("Enter second number: ");
		double num2 = sc.nextDouble();				System.out.println("The sum of "+num1+" and "+num2+" is: "+(num1+num2));
		System.out.println("The difference of "+num1+" and "+num2+" is: "+(num1-num2));
		System.out.println("Multiplication of "+num1+" and "+num2+" is: "+(num1*num2));
		System.out.println("Quotient of "+num1+" by "+num2+" is: "+(num1/num2));
		System.out.println("Remainder of "+num1+" by "+num2+" is: "+(num1%num2));
		System.out.println();
		// Sample Output
		/*		 
			Enter first number: 
			56
			Enter second number: 
			79
			The sum of 56.0 and 79.0 is: 135.0
			The difference of 56.0 and 79.0 is: -23.0
			Multiplication of 56.0 and 79.0 is: 4424.0
			Quotient of 56.0 by 79.0 is: 0.7088607594936709
			Remainder of 56.0 by 79.0 is: 56.0
		*/
				
		// 2. Write a program that reads a double value and converts it to an integer using type casting, then prints both values.
		System.out.println("Enter length of a square in decimal: ");
		double squareLengthInDecimal 	= sc.nextDouble();
		int squareLengthInInteger 		= (int) squareLengthInDecimal;
		System.out.println("Square length in decimal: "+squareLengthInDecimal);
		System.out.println("Square length in integer: "+squareLengthInInteger);
		System.out.println();
		// Sample Output
		/*
			Enter length of a square in decimal: 
			2301.11
			Square length in decimal: 2301.11
			Square length in integer: 2301
		*/
		
		// 3. Write a program that takes the user’s boolean input (true/false) and prints a message accordingly.
		System.out.println("Our nation prime minister is Shri. Narendra Modiji? (true/false):");
		boolean isModiji = sc.nextBoolean();
		if(isModiji) {
			System.out.println("Your answer is correct, you won a Prize!");
		}
		else {
			System.out.println("You answer is wrong!");
		}
		// Sample Output
		/*
		 	Our nation prime minister is Shri. Narendra Modiji? (true/false):
			false
			You answer is wrong!
		*/
	}
}
