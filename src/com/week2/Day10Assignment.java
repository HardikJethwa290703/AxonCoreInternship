package com.week2;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Day10Assignment {

	public static void main(String[] args) {		
		// Example of FileReader:- Read character from a file
		try {
			FileReader fr = new FileReader("test.txt");
			int i;
			while((i = fr.read()) != -1) { // reading file character by character
				System.out.println((char) i); // since it is integer typecasting to character to pint equivalent character
			}
			fr.close();
		}
		catch(IOException e) {
			System.out.println("Error encountered while reading file: "+e.getMessage());
		}
		// Output:-
		/*
			h
			e
			l
			l
			o
			 
			w
			o
			r
			l
			d
		*/
		
		// Example of BufferedReader:- Read text from a file line by line
		try {
			BufferedReader br = new BufferedReader(new FileReader("test.txt"));
			String text;
			while((text = br.readLine()) != null) { // reading text line by line
				System.out.println(text);
			}
			br.close();
		}
		catch(IOException e) {
			System.out.println("Error encountered while reading file: "+e.getMessage());	
		}
		// Output:- hello world
		
		// Example of Scanner:- reading input from files
		try {
			File file = new File("test.txt");
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Error encountered while reading file: "+e.getMessage());
		}
		// Output:- hello world
		
		// Example of FileWriter:- writing text to a file(overwrites the file)
		try {
			FileWriter fw = new FileWriter("output.txt");
			fw.write("writing to new file"); // writing text to file|
			fw.write("content for filewriter");
			fw.close();
			System.out.println("File written successfully.");
		}
		catch(IOException e) {
			System.out.println("Error encountered while writing file: "+e.getMessage());
		}
		// Output:-	File written successfully.
		
		// Example of FileWriter:- writing text to a file using append mode
		try {
			FileWriter fw = new FileWriter("output.txt", true);
			fw.write("appending content to the file.");
			fw.close();
			System.out.println("Content append successfully.");
		}
		catch(IOException e) {
			System.out.println("Error encountered while writing file: "+e.getMessage());
		}
		// Output:-	Content append successfully.
		
		// Example of try-with resources
		try(BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
			String text;
			while((text = br.readLine()) != null) {
				System.out.println(text);
			}
		}
		catch(IOException e) {
			System.out.println("Error encountered while reading file: "+e.getMessage());
		}
		// Output:- writing to new filecontent for filewriterappending content to the file.
		
		// Practice Exercises
		// 1. Write a program to read a text file using BufferedReader and print its contents.
		try {
			BufferedReader br = new BufferedReader(new FileReader("output.txt")); // reading data line by line
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		}
		catch(IOException e) {
			System.out.println("Error encountered while writing file: "+e.getMessage());
		}
		// Output:- writing to new filecontent for filewriterappending content to the file.
		
		// 2. Write a program to write user input lines to a file using FileWriter until the user types “exit”.
		try {
			Scanner sc 	= new Scanner(System.in); // to take user input
			System.out.println("Enter input to write into file: ");
			String line = sc.nextLine(); // reading line of text
			FileWriter fw = new FileWriter("userInput.txt"); // file writer object is created
			while(!line.equalsIgnoreCase("exit")) { // if user type except 'exit' then writing to file and asking to enter another input
				fw.write(line); // writing text to file
				System.out.println("Enter another input to write into file: ");
				line = sc.nextLine(); // asking to enter user input
			}
			fw.close();
		}
		catch(IOException e) {
			System.out.println("Error encountered while writing file: "+e.getMessage());
		}
		// Output:-
		/*
			Enter input to write into file: 
			yoga maintain mental health balance --> First User Input
			Enter another input to write into file: 
			consistency make the human being to achieve bigger --> Second User Input
			Enter another input to write into file: 
			exit --> if user types 'exit' then program ends

		*/
		
		// 3. Read a file using Scanner and count the number of words.
		try {
			File file 	= new File("test.txt");
			Scanner sc 	= new Scanner(file);
			while(sc.hasNextLine()) {
				String text = sc.nextLine();
				String word = "";
				int countWords = 0;
				for(int i = 0; i < text.length(); i++) {
					if((text.charAt(i) == ' ' || i == text.length()-1) && word != "") {
						word = "";
						countWords++;
					}
					else {
						if(text.charAt(i) != ' ') {
							word+=text.charAt(i);
						}
					}
				}
				System.out.println("Text '"+text+"' contains "+countWords+" words");
			}
			sc.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found or unable to access: "+e.getMessage());
		}
		// Output:- Text 'hello world' contains 2 words
		
		// 4. Append new lines to an existing file
		try {
			FileWriter fr = new FileWriter("userInput.txt", true);
			fr.write("appending new line to an existing file");
			fr.write("world is nowhere what we think");
			fr.close();
			System.out.println("New lines appended to existing file 'userInput.txt'");
		}
		catch(IOException e) {
			System.out.println("Error encountered while reading file: "+e.getMessage());
		}
		// Output:- New lines appended to existing file 'userInput.txt'
		// Below is the content which was appended:
		/*
			appending new line to an existing fileworld is nowhere what we think
		*/
		
		// 5. Use try-with-resources to manage file streams automatically.
		try(BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
		catch(IOException e) {
			System.out.println("Error encountered while reading file: "+e.getMessage());
		}
		// Output:- writing to new filecontent for filewriterappending content to the file.		
	}

}
