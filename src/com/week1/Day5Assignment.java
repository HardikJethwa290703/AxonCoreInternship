package com.week1;

public class Day5Assignment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Creating Object from class Student and accessing fields and methods
		// 4. Experiment by creating objects using different constructors.
		Student s 	= new Student();
		s.name 		= "hardik";
		s.age 		= 45;
		s.rollNo 	= 234;
		s.isPresent = false;
		s.displayStudentDetails();
		// Sample output:-
		/*
			Name of the student is: hardik
			Age of the student hardik is: 45
			Roll no of the student hardik is: 234
			Student hardik is: Not Present
		*/
		
		// Using Student Constructor initialize the Object
		Student s1 = new Student("rohit", 30, 70, true);
		s1.displayStudentDetails();
		// Sample output:-
		/*
			Name of the student is: rohit
			Age of the student rohit is: 30
			Roll no of the student rohit is: 70
			Student rohit is: Present
		*/
		
		// Using Student Constructor initialize the Object with one extra field as grade
		Student s2 = new Student("soham", 23, 89, false, 'D');
		s2.displayStudentReportCardDetails();
		// Sample output:-
		/*
			Name of the student is: soham
			Age of the student soham is: 23
			Roll no of the student soham is: 89
			Student soham is: Not Present
			Grade obtained by the student soham is: D
		*/
		
		// Practise Exercises
		// 1. Create a Book class with fields: title, author, and price. Write constructors to initialize them and a method to display details. Create multiple book objects and display their details.
		// Creating Book Objects from class Book
		Book book1 = new Book("Wings Of Fire", "Dr. APJ Adul Kalam", 45);
		book1.displayBookDetails();
		// Sample output:-
		/*
 			Title of the book is: Wings Of Fire
			Author of the book is: Dr. APJ Adul Kalam
			Price of the book is: 45
		*/
		
		Book book2 = new Book("Rich Dad Poor Dad", "Robert T. Kiyosaki", 370);
		book2.displayBookDetails();
		// Sample output:-
		/*
			Title of the book is: Rich Dad Poor Dad
			Author of the book is: Robert T. Kiyosaki
			Price of the book is: 370
		*/
		
		Book book3 = new Book("Discovery of India", "Jawaharlal Nehruji", 200);
		book3.displayBookDetails();
		// Sample output:-
		/*
 			Title of the book is: Discovery of India
			Author of the book is: Jawaharlal Nehruji
			Price of the book is: 200
		*/
		
		// Creating Rectangle Object from Class Rectangle and initializing the object
		// 2. Create a Rectangle class with fields: length and width. Write methods to calculate area and perimeter. Use constructors to initialize rectangles.
		Rectangle rectangle = new Rectangle(8.4,5.6);
		// calculating area of rectangle
		System.out.println("Area of rectangle is "+rectangle.areaOfRectangle()+" having length as "+rectangle.length+" and width as "+rectangle.width);
		// calculating perimeter of rectangle
		System.out.println("Permiter of rectangle is "+rectangle.perimeterOfRectangle()+" having length as "+rectangle.length+" and width as "+rectangle.width);		
		// Sample output:-
		/*
			Area of rectangle is 47.04 having length as 8.4 and width as 5.6
			Permiter of rectangle is 28.0 having length as 8.4 and width as 5.6
		*/
		
		// Creating BankAccount Object from Class BankAccount and accessing fields and methods
		// 3. Create a BankAccount class with fields: account number, account holder name, and balance. Write constructors and methods to deposit and withdraw money. Display the account details after transactions.
		BankAccount bankAccount = new BankAccount("suresh makwana", 9821928, 89232);
		bankAccount.chkBalance();
		// Sample output:-
		/*
			Bank Account holder name: suresh makwana
			Bank Account No: 9821928
			Balance in the bank account: 89232.0
		*/
		bankAccount.withdrawMoney(2300);
		// Sample output:-
		/*
			Bank Account holder name: suresh makwana
			Bank Account No: 9821928
			Balance remaining in the bank account: 86932.0
		*/
		bankAccount.depositMoney(19092);
		// Sample output:-
		/*
			Bank Account holder name: suresh makwana
			Bank Account No: 9821928
			Balance remaining in the bank account: 106024.0
		*/		
	}

}

// Creating Class as Student
// 4. Experiment by creating objects using different constructors.
class Student {
	// Variables (fields):- Student fields
	String name;
	int age;
	int rollNo;
	boolean isPresent;
	char grade;
	
	// Default Constructor(No-Argument Constructor)
	public Student() {
		
	}
	
	// Parameterized Constructor:- Initializing Student fields
	public Student(String nameOfStudent, int ageOfStudent, int rollNoOfStudent, boolean isStudentPresent) {
		name 		= nameOfStudent;
		age 		= ageOfStudent;
		rollNo 		= rollNoOfStudent;
		isPresent 	= isStudentPresent;
	}
	
	// Parameterized Constructor:- Initializing Student fields with one extra field as grade
	public Student(String nameOfStudent, int ageOfStudent, int rollNoOfStudent, boolean isStudentPresent, char gradeObtained) {
		name 		= nameOfStudent;
		age 		= ageOfStudent;
		rollNo 		= rollNoOfStudent;
		isPresent 	= isStudentPresent;
		grade 		= gradeObtained;
	}
	
	// Methods(functions):- Displaying Student details
	void displayStudentDetails() {
		System.out.println("Name of the student is: "+name);
		System.out.println("Age of the student "+name+" is: "+age);
		System.out.println("Roll no of the student "+name+" is: "+rollNo);
		System.out.println("Student "+name+" is: "+(isPresent == true ? "Present" : "Not Present"));
	}
	
	// Methods(functions):- Displaying Student details with one extra field as grade
	void displayStudentReportCardDetails() {
		System.out.println("Name of the student is: "+name);
		System.out.println("Age of the student "+name+" is: "+age);
		System.out.println("Roll no of the student "+name+" is: "+rollNo);
		System.out.println("Student "+name+" is: "+(isPresent == true ? "Present" : "Not Present"));
		System.out.println("Grade obtained by the student "+name+" is: "+grade);
	}
}

// Creating Class as Book
// 1. Create a Book class with fields: title, author, and price. Write constructors to initialize them and a method to display details. Create multiple book objects and display their details.
class Book{
	// Variables (fields):- Book fields
	String title;
	String author;
	int price;
	
	// Parameterized Constructor:- Initializing Book fields
	public Book(String bookTitle, String bookAuthor, int bookPrice) {
		title 	= bookTitle;
		author 	= bookAuthor;
		price 	= bookPrice;
	}
	
	// Methods (functions):- Displaying Book details
	public void displayBookDetails() {
		System.out.println("Title of the book is: "+title);
		System.out.println("Author of the book is: "+author);
		System.out.println("Price of the book is: "+price);
	}
}

// Creating Class as Rectangle
// 2. Create a Rectangle class with fields: length and width. Write methods to calculate area and perimeter. Use constructors to initialize rectangles.
class Rectangle {
	// Variables (fields):- Rectangle fields
	double length;
	double width;
	
	// Parameterized Constructor:- Initializing Rectangle fields
	public Rectangle(double l, double w) {
		length = l;
		width = w;
	}
	
	// Methods (functions):- Calculating Area of Rectangle
	public double areaOfRectangle() {
		return length*width;
	}
	
	// Methods (functions):- Calculating Perimeter of Rectangle
	public double perimeterOfRectangle() {
		return 2*(length+width);
	}
}

// Creating Class as BankAccount
// 3. Create a BankAccount class with fields: account number, account holder name, and balance. Write constructors and methods to deposit and withdraw money. Display the account details after transactions.
class BankAccount {
	// Variables (fields):- BankAccount fields
	String accountHolderName;
	int accountNumber;
	double accountBalance;
	
	// Parameterized Constructor:- Initializing BankAccount fields
	public BankAccount(String accountName, int accountNo, double balance) {
		accountHolderName 	= accountName;
		accountNumber 		= accountNo;
		accountBalance		= balance;
	}
	
	// Methods (functions):- Method to check the balance in the bank account
	public void chkBalance() {		
		System.out.println("Bank Account holder name: "+accountHolderName);
		System.out.println("Bank Account No: "+accountNumber);
		System.out.println("Balance in the bank account: "+accountBalance);
	}
	
	// Methods (functions):- Method to deposit money in the bank account
	public void depositMoney(double depositMoney) {
		accountBalance+=depositMoney;
		System.out.println("Bank Account holder name: "+accountHolderName);
		System.out.println("Bank Account No: "+accountNumber);
		System.out.println("Balance remaining in the bank account: "+accountBalance);
	}
	
	// Methods (functions):- Method to withdraw money from the bank account
	public void withdrawMoney(double withdrawMoney) {
		accountBalance-=withdrawMoney;
		System.out.println("Bank Account holder name: "+accountHolderName);
		System.out.println("Bank Account No: "+accountNumber);
		System.out.println("Balance remaining in the bank account: "+accountBalance);
	}
}
