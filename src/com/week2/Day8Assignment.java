package com.week2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class Day8Assignment {

	public static void main(String[] args) {
		// Example of ArrayList:- store collection of elements in ordered and duplicates are allowed.
		ArrayList<String> fruits = new ArrayList<>();
		
		// adding elements
		fruits.add("Chikoo");
		fruits.add("Mango");
		fruits.add("Banana");
		fruits.add("Jackfruit");
		fruits.add("Pineapple");
		
		// retrieving single elements
		System.out.println("Single fruit in the basket: "+fruits.get(2)); // Output:- Single fruit in the basket: Banana
		
		// retrieving all the elements present in the ArrayList fruits
		System.out.println("Below are all the fruits in the basket:");
		for(String fruit: fruits) {
			System.out.println(fruit);
		}
		// Output:-
		/*
			Below are all the fruits in the basket:			
			Chikoo
			Mango
			Banana
			Jackfruit
			Pineapple
		*/
		
		// removing single element
		System.out.println("Fruit removed from the basket: "+fruits.remove(3)); // Output:- Fruit removed from the basket: Jackfruit
		
		// after removal ArrayList elements
		System.out.println("After removal: "+fruits); // Output:- After removal: [Chikoo, Mango, Banana, Pineapple]
		
		// Example of HashSet:- store collection of elements in unordered and no duplicates are allowed.
		HashSet<String> cricketers = new HashSet<>();
		
		// adding elements
		cricketers.add("Rohit Sharma");
		cricketers.add("Virat Kohli");
		cricketers.add("Suryakumar Yadav");
		cricketers.add("Shashank Singh");
		
		// iterating elements through for-each loop
		System.out.println("Below are the list of cricketers:");
		for(String cricketer: cricketers) {
			System.out.println(cricketer);
		}
		// Output:-
		/*
			Below are the list of cricketers:
			Virat Kohli
			Rohit Sharma
			Suryakumar Yadav
			Shashank Singh
		*/
		
		// removing single element
		System.out.println("Remove cricketer Virat kohli from the list: "+(cricketers.remove("Virat Kohli") ? "Successfully Removed" : "Failed To Removed"));
		// Output:- Remove cricketer Virat kohli from the list: Successfully Removed
		
		// remaining element
		System.out.println(cricketers); // Output:- [Rohit Sharma, Suryakumar Yadav, Shashank Singh]
		
		// Example of HashMap:- store collection of elements in key-value pair in unordered and keys are unique and values may be duplicates.
		HashMap<Integer, String> studentMap = new HashMap<>();
		
		// adding elements
		studentMap.put(10, "Kalpit");
		studentMap.put(45, "Kaushik");
		studentMap.put(90, "Rakesh");
		studentMap.put(56, "Dherya");
		
		// retrieving single element
		System.out.println("Calling only one Student: "+studentMap.get(45)); // Output:- Calling only one Student: Kaushik
		
		// fetching all elements
		for(Integer id: studentMap.keySet()) {
			System.out.println("Id: "+id+" Name: "+studentMap.get(id));
		}
		// Output:- 
		/*
			Id: 56 Name: Dherya
			Id: 10 Name: Kalpit
			Id: 90 Name: Rakesh
			Id: 45 Name: Kaushik
		*/
		
		// removing single element
		System.out.println("Student "+studentMap.remove(90)+" is removed"); // Output:- Student Rakesh is removed
		
		// after removal
		System.out.println("After removal: "+studentMap); // Output:- After removal: {56=Dherya, 10=Kalpit, 45=Kaushik}
		
		// Practice Exercises
		// 1. Create an ArrayList of integers, add values, remove a specific value, and print the list.
		ArrayList<Integer> evenNumbers = new ArrayList<>();
		
		// adding element
		evenNumbers.add(2);
		evenNumbers.add(6);
		evenNumbers.add(8);
		 
		// removing element
		System.out.println("Element "+evenNumbers.remove(2)+" is removed"); // Output:- Element 8 is removed, removing element '8' which is at index '2'
		
		// array list containing element after removing specific element
		System.out.println("Even numbers: "+evenNumbers); // Output:- [2, 6]
		
		// 2. Create a HashSet of strings and try adding duplicate values. Print the set and observe.
		HashSet<String> color = new HashSet<>();
		
		// adding elements		
		color.add(null);
		color.add("blue");
		color.add("red");
		color.add("green");
		color.add("green"); // duplicate element
		
		System.out.println("Colors: "+color); // Output:- [null, red, green, blue], duplicate element green is ignored.
		
		// 3. Create a HashMap to store student roll numbers (Integer) as keys and names (String) as values. Add, remove, and retrieve entries.
		HashMap<Integer, String> studentDetails = new HashMap<>();
		
		// adding elements in key-value pair format
		studentDetails.put(5, "Soham");
		studentDetails.put(6, null);
		studentDetails.put(89, "Raj");
		studentDetails.put(45, "Bhavesh");
		studentDetails.put(67, "Aryan");
		
		// accessing single key-value pair
		System.out.println("Accessing single key-value pair: "+studentDetails.get(45)); // Output:- Accessing single key-value pair: Bhavesh
		
		// accessing all the elements in HashMap
		for(Integer studentId: studentDetails.keySet()) {
			System.out.println("Id: "+studentId+" Name: "+studentDetails.get(studentId));
		}
		// Output:-
		/*
			Id: 67 Name: Aryan
			Id: 5 Name: Soham
			Id: 6 Name: null
			Id: 89 Name: Raj
			Id: 45 Name: Bhavesh
		*/
		
		// removing element
		System.out.println("Student "+studentDetails.remove(89)+" is Removed"); // Output:- Student Raj is Removed
		
		// accessing all the elements in HashMap after removal
		for(Integer studentId: studentDetails.keySet()) {
			System.out.println("Id: "+studentId+" Name: "+studentDetails.get(studentId));
		}
		// Output:-
		/*
			Id: 67 Name: Aryan
			Id: 5 Name: Soham
			Id: 6 Name: null
			Id: 45 Name: Bhavesh
		*/
		
		// 4. Write a program to count the frequency of words in a sentence using a HashMap.
		HashMap<Integer, String> touristPlaces = new HashMap<>();				
		
		// adding sentences
		touristPlaces.put(7, "Taj Mahal is the attractive and one of the 7 wonders of the world.");
		touristPlaces.put(5, "Gateway of                    India");
		
		// iterating through hashmap to count number of words present in sentence
		for(Integer touristId: touristPlaces.keySet()) {
			
			// initialize variable countWords as zero, for counting frequency of words in a sentence.
			int countWords = 0;			
			
			// accessing specific sentence through 'touristId' and removing if any trailing and leading spaces are there in every iteration.
			String touristPlace = touristPlaces.get(touristId).trim();
			
			// 'touristWord' is initialized as empty and is used to concatenate the characters present in the word for every sentence and for every iteration we get fresh start.
			String touristWord = "";
			
			// iterating through the sentence present in the HashMap
			for(int i = 0; i < touristPlace.length(); i++) {
				
				// if (touristPlace.charAt(i) == ' ' && !touristWord.equals("")) --> for counting the word in a sentence and on other hand (i == touristPlace.length() - 1 && !touristWord.equals("")) --> it is used to count the word in the sentence who don't have any space or the word is the last word in the sentence
				if((touristPlace.charAt(i) == ' ' || i == touristPlace.length() - 1) && (!touristWord.equals(""))) {					
					touristWord = "";
					countWords++;
				}
				// if there are 'N' number of spaces in the middle of statement then they will be not considered as word
				else if(touristPlace.charAt(i) != ' ') {
					// concatenating characters in the word, for counting the words get help 
					touristWord += touristPlace.charAt(i);
				}
			}
			
			// displaying sentence and frequency of words present in the sentence
			System.out.println("Total count of words present in sentence '"+touristPlace+"' is: "+countWords);
			
		}
		// Output:- 
		/*
			Total count of words present in sentence 'Gateway of                    India' is: 3
			Total count of words present in sentence 'Taj Mahal is the attractive and one of the 7 wonders of the world.' is: 14
		*/
	}

}
