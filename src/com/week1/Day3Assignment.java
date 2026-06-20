package com.week1;

import java.util.Scanner;
public class Day3Assignment {
	public static void main(String[] args) {
		
		// if - statement
		int number1 = 20;
		if(number1 % 2 == 0) {
			System.out.println(number1+" is even number.");
		}
		// Sample output: 20 is even number.
		
		// if-else - statement
		if(number1 % 2 == 0) {
			System.out.println(number1+" is even number.");
		}
		else {
			System.out.println(number1+" is odd number.");
		}
		// Sample output: 20 is even number.
		
		// if-else-if-else ladder - statement
		int marks = 65;
		if(marks >= 70) {
			System.out.println("Grade Obtained: A");
		}
		else if(marks >= 55) {
			System.out.println("Grade Obtained: B");
		}
		else if(marks >= 35) {
			System.out.println("Grade Obtained: C");
		}
		else {
			System.out.println("To obtained grade, passing marks is required.");
		}
		// Sample output: Grade Obtained: B
		
		// Nested-if - statement
		int age = 14;
		String citizenship = "Indian";
		if(age >= 18) {
			if(citizenship == "Indian") {
				System.out.println("Eligible to vote.");
			}
			else {
				System.out.println("For voting citizenship must be "+citizenship);
			}
		}
		else {
			System.out.println("Not eligible for voting.");
		}
		// Sample output: Not eligible for voting.
		
		// Swith-case statement
		char fruitLetter = 'B';
		switch(fruitLetter) {
			case 'G':
				System.out.println("You got Guava, it is rich in nutirents and vitamins.");
				break;
			case 'J':
				System.out.println("You got Jackfruit, it helps to reduce heart disease.");
				break;
			case 'B':
				System.out.println("You got Banana, it helps to maintain gut health.");
				break;
			default:
				System.out.println("Your fruit is not there in the basket, please try some other fruit.");				
		}
		// Sample output: You got Banana, it helps to maintain gut health.
		
		// for loop:- print sum of n natural numbers
		int number2 = 6;
		int sumOfNNaturalNumber = 0;
		for(int i = 1; i <= number2; i++) {
			sumOfNNaturalNumber = sumOfNNaturalNumber + i;		
		}
		System.out.println("Sum of first "+number2+" natural number is "+sumOfNNaturalNumber);
		// Sample output: Sum of first 6 natural number is 21
		
		// while loop:- print odd numbers
		int k = 1;
		while(k <= 5) {
			if(k % 2 != 0) {
				System.out.println(k);
			}
			k++;
		}
		// Sample output:
		/*
		 	1
			3
			5 
		*/
		
		// do-while loop:- print numbers 1 to 5
		int l = 1;
		do {
			System.out.println(l);
			l++;
		} while(l <= 5);
		// Sample output:
		/*
		 	1
		 	2
			3
			4
			5 
		*/
		
		// 1. Write a program to find the largest of three numbers using if-else if-else.
		int num1 = 2;
		int num2 = 3;
		int num3 = 5;
		
		if(num1 >= num2 && num1 >= num3) {
			System.out.println(num1+" is the largest");
		}
		else if(num2 >= num1 && num2 >= num3) {
			System.out.println(num2+" is the largest");
		}
		else if(num3 >= num1 && num3 >= num2) {
			System.out.println(num3+" is the largest");
		}
		// Sample output: 5 is the largest
		
		// 2. Write a program to print the day of the week name based on a number (1 to 7) using switch.
		int dayOfTheWeek = 4;
		switch(dayOfTheWeek) {
			case 1: 
				System.out.println("The day is Sunday");
				break;
			case 2:
				System.out.println("The day is Monday");
				break;
			case 3:
				System.out.println("The day is Tuesday");
				break;
			case 4:
				System.out.println("The day is Wednesday");
				break;
			case 5:
				System.out.println("The day is Thursday");
				break;
			case 6:
				System.out.println("The day is Friday");
				break;
			case 7:
				System.out.println("The day is Saturday");
				break;
			default:
				System.out.println("Invalid day!");				
		}
		// Sample output: The day is Wednesday
		
		// 3. Write a program that reads a character and prints if it’s a vowel or consonant.
		char letter = 'c';
		if(letter == 'a' || letter == 'A' || letter == 'e' || letter == 'E' || letter == 'i' || letter == 'I'  || letter == 'o' || letter == 'O' || letter == 'u' || letter == 'U') {
			System.out.println("Alphabet '"+letter+"' is a vowel.");
		}
		else {
			System.out.println("Alphabet '"+letter+"' is a consonant.");
		}
		// Sample output: Alphabet 'c' is a consonant.
		
		// 4. Print the first 10 natural numbers using a for loop.
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		// Sample output:
		/*
			1
			2
			3
			4
			5
			6
			7
			8
			9
			10
		*/
		
		// 5. Calculate the factorial of a number using a while loop.
		int num4 	= 7;
		int sum 	= 1;
		if(num4 == 0) {
			System.out.println("Factorial of '0' is 1");
		}
		else {
			int num5 = num4;
			while(num4 >= 1) {
				sum = sum * num4;
				num4--;
			}
			System.out.println("Factorial of "+num5+" is "+sum);
		}
		// Sample output: Factorial of 7 is 5040
		
		// 6. Use a do-while loop to keep asking the user to enter a positive number until they do so.
		Scanner sc = new Scanner(System.in);
		int positiveNumber;
		do {			
			System.out.println("Enter a positive number:");
			positiveNumber = sc.nextInt();
		} while(positiveNumber <= 0);
		System.out.println("Your have entered positive number "+positiveNumber);
		// Sample output: 
		/* 
			Enter a positive number:
			781
			Your have entered positive number 781
		*/
		
		// 7. Print a pattern using nested loops, e.g., a right-angled triangle of stars:
		/* 
		 	*
			**
			***
			****
			*****
		*/
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		// Sample output:
		/*
			*
			**
			***
			****
			*****
		**/
	}
}
