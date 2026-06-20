package com.week1;

import java.util.Arrays;

public class Day4Assignment {

	public static void main(String[] args) {
		// Practice tasks for Arrays
		
		// 1. Find the sum or average of elements.
		int[] arrNumbers;
		arrNumbers = new int[5];
		arrNumbers[0] = 5;
		arrNumbers[1] = 8;
		arrNumbers[2] = 1;
		arrNumbers[3] = 3;
		arrNumbers[4] = 6;
		int sum =  0;
		for(int i: arrNumbers) {
			sum = sum + i;
		}
		System.out.println("Sum is: "+ sum);
		System.out.println("Average is: "+((float) sum/arrNumbers.length));
		// Sample Output:
		/*
			Sum is: 23
			Average is: 4.6
		*/
		
		// 2. Find the maximum or minimum element
		int[] arrNum = {9,2,91,45,34,11,6};
		int minValue = arrNum[0];
		int maxValue = arrNum[0];
		if(arrNum.length == 1) {
			System.out.println("Element "+arrNum[0]+" is the minimum and maximum element in the array");
		}
		else {
			for(int i: arrNum) {				
				if(i <= minValue) {
					minValue = i;
				}
				if(i >= maxValue) {
					maxValue = i;
				}
			}
			System.out.println("Element "+minValue+" is the minimum element in the array.");
			System.out.println("Element "+maxValue+" is the maximum element in the array.");
		}
		// Sample Output:
		/*
			Element 2 is the minimum element in the array.
			Element 91 is the maximum element in the array.
		*/
		
		// 3. Search for a specific value.
		int[] arrScore 	= {23,78,12,9,2,34};
		int searchScore = 78;
		boolean isScore = false;
		for(int i = 0; i < arrScore.length; i++) {
			if(arrScore[i] == searchScore) {
				isScore = true;		
				System.out.println("Your score "+searchScore+" matched at index position "+i);
				break;
			}
		}
		
		if(!isScore) {
			System.out.println("Your score "+searchScore+" doesn't matched.");
		}
		// Sample Output:- Your score 78 matched at index position 1
		
		// 4. Sort the array (using built-in methods like Arrays.sort()).
		char[] arrAlphabets = new char[4]; 
		arrAlphabets[0] = 'z';
		arrAlphabets[1] = 'd';
		arrAlphabets[2] = 'q';
		arrAlphabets[3] = 'b';
		
		// before sorting
		for(char alphabet: arrAlphabets) {
			System.out.println(alphabet);
		}
		// Sample Output:
		/*
			z
			d
			q
			b

		*/
		Arrays.sort(arrAlphabets);
		// after sorting
		for(char alphabet: arrAlphabets) {
			System.out.println(alphabet);
		}
		// Sample Output:
		/*
			b
			d
			q
			z
		*/
		
		// 5. Write a program to find the largest element in a 1D array.
		int[] arrOddNumbers = {35, 101, 23, 67, 111, 41};
		int largestNumber = arrOddNumbers[0];
		if(arrOddNumbers.length == 1) {
			System.out.println("Element "+arrOddNumbers[0]+" is the largest number.");
		}
		else {
			for(int i: arrOddNumbers) {
				if(i >= largestNumber) {
					largestNumber = i;					
				}
			}
			System.out.println("Element "+largestNumber+" is the largest number.");			
		}
		// Sample Output:- Element 111 is the largest number.
		
		// 6. Write a program to add two matrices using 2D arrays.
		int[][] arrMatrix1 = {{1,2,3}, {4,5,6}};
		int[][] arrMatrix2 = {{7,8,9}, {10,11,12}};
		for(int i = 0; i < arrMatrix1.length; i++) {
			for(int j = 0; j < arrMatrix1[i].length; j++) {
				System.out.print(arrMatrix1[i][j] + arrMatrix2[i][j]+" ");
			}
			System.out.println();
		}
		// Sample Output:
		/* 
			8 10 12 
			14 16 18
		*/
		
		// 7. Write a program to transpose a matrix.
		int[][] arrMatrix3 = {{1,2,3}, {4,5,6}};
		for(int column = 0; column < arrMatrix3[0].length; column++) {
			for(int row = 0; row < arrMatrix3.length; row++) {
				System.out.print(arrMatrix3[row][column]+" s");
			}
			System.out.println();
		}
		// Sample output:
		/*
			1 4 
			2 5 
			3 6 
		*/
		
		// 8. Write a program to search for an element in an array.
		String[] arrFruits 			= {"apple", "banana", "mango", "strawberry"};
		
		String searchFruit 			= "Chikoo";
		boolean isFruitAvailable 	= false;
		for(int i = 0; i < arrFruits.length; i++) {
			if(arrFruits[i].equalsIgnoreCase(searchFruit)) {
				isFruitAvailable = true;
				System.out.println("Your fruit "+searchFruit+" is in the basket at position "+i);
				break;
			}
		}
		
		if(!isFruitAvailable) {
			System.out.println("Your fruit "+searchFruit+" is not present in the basket.");
		}
		// Sample Output:- Your fruit Chikoo is not present in the basket.
		
		// 9. Write a program to reverse an array.
		String[] arrCricketer 	= {"Sachin","Dinesh","Rohit","Suryakumar","Virat","Dhoni"};
		int j 					= arrCricketer.length - 1;
		for(int i = 0; i < arrCricketer.length; i++) {
			if(i == j || i > j) {
				break;
			}
			
			String tempString 	= arrCricketer[i];
			arrCricketer[i] 	= arrCricketer[j];
			arrCricketer[j] 	= tempString;
			j--;
		}
		System.out.println("Reverse array: "+Arrays.toString(arrCricketer));
		// Sample output:- Reverse array: [Mohit, Dhoni, Virat, Suryakumar, Rohit, Dinesh, Sachin]
	
		// String Manipulation
		// 1.  Count vowels in a string
		String name 	= "HardIk JethwA";
		int countVowels = 0;
		for(int i = 0; i < name.length(); i++) {
			char alphabet = name.toLowerCase().charAt(i);
			if(alphabet == 'a' || alphabet == 'e' || alphabet == 'i' || alphabet == 'o' || alphabet == 'u') {
				countVowels++;
			}
		}
		System.out.println("Word "+name+" contains "+countVowels+" vowels");
		// Sample output:- Word HardIk JethwA contains 4 vowels
		
		// 2. Reverse a String
		String sentence = "I love my country";
		String reverse  = "";
		for(int i = 0; i < sentence.length(); i++) {
			reverse = sentence.charAt(i) + reverse;
		}
		System.out.println("Reverse of "+sentence+" is "+ reverse);
		// Sample output:- Reverse of I love my country is yrtnuoc ym evol I
		
		// 3. Check if a string is a palindrome
		String palindrome 		= "eye";
		boolean isPalindrome 	= true;
		int k 					= palindrome.length() - 1;
		for(int i = 0; i < palindrome.length(); i++) {
			if(i == k || i > k) {
				break;
			}
			
			if(palindrome.charAt(i) != palindrome.charAt(k)) {
				isPalindrome = false;
				break;
			}
			
			k--;
		}
		
		if(isPalindrome) {
			System.out.println("String "+palindrome+" is palindrome");
		}
		else {
			System.out.println("String "+palindrome+" is not palindrome");
		}
		// Sample output:- String eye is palindrome
		
		// Practice Exercises
		// Arrays
		// 1. Write a program to find the second largest element in a 1D array.
		int[] arrNum3 	= {7,90,23,2,45,67};
		int counter 	= 0;
		for(int i = counter + 1; i < arrNum3.length; i++) {
			
			if(i == arrNum3.length-1) {
				counter++;
				i = counter + 1;
			}
			
			if(arrNum3[counter] > arrNum3[i]) {
				int tempElement 	= arrNum3[counter];
				arrNum3[counter] 	= arrNum3[i];
				arrNum3[i] 			= tempElement;
			}
		}
		System.out.println("Largest no is: "+arrNum3[arrNum3.length-2]);
		// Sample output:- Largest no is: 67
		
		// 2. Write a program to find the sum of all elements in each row and column of a 2D array.
		int[][] arrNum4 	= {{1,2,3},{4,5,6}};
		int sumOfElements 	= 0;
		for(int row = 0; row < arrNum4.length; row++) {
			for(int column = 0; column < arrNum4[row].length; column++) {
				sumOfElements = sumOfElements + arrNum4[row][column];
			}
		}
		System.out.println("Sum of all elements in each row and column of a 2D array: "+sumOfElements);
		// Sample output:- Sum of all elements in each row and column of a 2D array: 21
		
		// 3. Write a program to rotate a 2D matrix by 90 degrees.
		/*
			11 12 13
			14 15 16
		*/
		int[][] arrMatrix5 	= {{11,12,13},{14,15,16}};
		for(int column = 0; column < arrMatrix5[0].length; column++) {
			for(int row = arrMatrix5.length - 1; row >= 0; row--) {
				System.out.print(arrMatrix5[row][column]+" ");
			}
			System.out.println();
		}
		// Sample output:-
		/*
			14 11
			15 12
			16 13
		*/
		
		// Strings
		// 1. Write a program to count the number of words in a sentence.
		String place 	= "             jaipur is known as pink city";
		int countWord 	= 0;
		if(!place.isEmpty()) {
			for(int i = 0; i < place.trim().length(); i++) {			
				if(place.trim().charAt(i) == ' ' || place.trim().length() - 1 == i) {
					countWord++;
				}
			}			
		}
		System.out.println("Number of words in string '"+place+"' is "+countWord);
		// Sample output:- Number of words in string '             jaipur is known as pink city' is 6
		
		// 2. Write a program to convert the first letter of each word in a string to uppercase.
		String historicPlace 	= "taj mahal is one of the 7 wonders";
		String newHistoricPlace = "";
		for(int i = 0; i < historicPlace.length(); i++) {
			if(i == 0) {
				newHistoricPlace+=(char)((int)historicPlace.charAt(i) - 32);
			}
			else if(historicPlace.charAt(i) == ' ') {
				newHistoricPlace+=historicPlace.charAt(i);
				newHistoricPlace+=(char)((int)historicPlace.charAt(i + 1) - 32);
				i++;
			}
			else {
				newHistoricPlace+=historicPlace.charAt(i);
			}
		}
		System.out.println("String "+historicPlace+" each word first letter in uppercase as "+newHistoricPlace);
		// Sample output:- String taj mahal is one of the 7 wonders each word first letter in uppercase as Taj Mahal Is One Of The  Wonders
		
		// 3. Write a program to find and replace a substring within a string.
		String newtonsLaw = "Evey action has an equal and opposite reaction";
		String newString = newtonsLaw.replace("action", "reaction");
		System.out.println(newString);
		// Sample output:- Evey reaction has an equal and opposite rereaction
		
		// 4. Write a program to check whether two strings are anagrams.
		String sense1 		= "nose";
		String sense2 		= "esmo";
		char[] arrSense1 	= sense1.toCharArray();
		char[] arrSense2 	= sense2.toCharArray();
		int anagramCounter 	= 0;
		boolean isAnagram	= false;
		if(sense1.length() == sense2.length()) {
			for(int i = 0; i < arrSense1.length - 1; i++) {
				
				
				if(arrSense1[i] == arrSense2[anagramCounter]) {
					isAnagram = true;
					arrSense2[anagramCounter] = '0';
				}
				else {
					isAnagram = false;
					break;
				}
				
				if(anagramCounter == arrSense2.length - 1) {
					anagramCounter = 0;
				}
				
				anagramCounter++;
			}			
		}
		if(isAnagram) {
			System.out.println("String '"+sense1+"' and '"+sense2+"' are anagrams of each other");
		}
		else {
			System.out.println("String '"+sense1+"' and '"+sense2+"' are not anagrams of each other");
		}
		// Sample output:- String 'nose' and 'esmo' are not anagrams of each other
	}
}
