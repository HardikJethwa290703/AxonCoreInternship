package com.week1;

public class Day1Assignment {
	 public static void main(String[] args) {
		 
		 // Activity 1:- Run Hello world program
		 System.out.println("Hello World!");
		 System.out.println();
		 // Sample output:- Hello World!
		 
		 // Activity 2:- 
		 // Declare and initialize variables of different types
		 byte percentage 			= 68;
		 short numberOfGoalsScored 	= 10;
		 int ratings 				= 4;
		 long phOfWater 			= 7l;
		 float salary 				= 12321.45f;
		 double population 			= 89121812891218.212;
		 boolean isPassed 			= percentage >= 55 ? true : false;
		 char letter 				= 'J';
		 
		 // Perform arithmetic operations		 
		 int num1 	= 23;
		 float num2 = 45;		
		 int result1 = num1 + (int) num2;	
		 int result2 = (int) num2 -  num1;
		 int result3 = (int) num2 *  num1;
		 int result4 =  num1 /  (int) num2;
		 int result5 = (int) num2 %  num1;		 
		 System.out.println("Addition of "+num1+" and "+num2+" is "+result1);
		 System.out.println("Subtraction of "+num2+" and "+num1+" is "+result2);
		 System.out.println("Multiplication of "+num2+" and "+num1+" is "+result3);
		 System.out.println("Division of "+num1+" by "+num2+" is "+result4);
		 System.out.println("Modulous of "+num2+" by "+num1+" is "+result5);
		 System.out.println();
		 // Sample Output:- 
		 /* 
		  	Addition of 23 and 45.0 is 68
			Subtraction of 45.0 and 23 is 22
			Multiplication of 45.0 and 23 is 1035
			Division of 23 by 45.0 is 0
			Modulous of 45.0 by 23 is 22 
		 */
		 
		 // Day 1 Homework
		 String name 		= "Hardik";
		 int age 			= 22;
		 float height 		= 5.8f;
		 char grade 		= 'O';
		 boolean isStudent 	= false;
		 System.out.println("Name of the person is: "+ name);
		 System.out.println("Age of "+name+" is: "+ age);
		 System.out.println("Height of "+name+" is: "+ height);
 		 System.out.println("Grade obtained by "+name+" is: "+ grade);
 		 System.out.println("Student: "+ isStudent);
 		// Sample Output:- 
 		/* 
		  	Name of the person is: Hardik
			Age of Hardik is: 22
			Height of Hardik is: 5.8
			Grade obtained by Hardik is: O
			Student: false
		*/
		
	}
}
