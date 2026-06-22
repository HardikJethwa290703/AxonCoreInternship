package com.week2;

// Parent Class
class Animal {
	String breed;
	int numberofLegs;
	
	public void walk() {
		System.out.println("Animal walks fast as well as slow.");
	}
	
	public void eat() {
		System.out.println("Animals eat food to survive");
	}
}

// Child class
// Dog i.e child class extends the Animal i.e parent class, we can see the concept of Inheritance
class Dog extends Animal {
	
	String name;
	
	public void makeSound() {
		System.out.println("Dog sound: Woof!");
	}
	
	// Overridden method of Animal class and calling method of parent class using super keyword and also providing specific implementation	
	@Override
	public void eat() {
		super.eat();
		System.out.println("My dog is vegetarian");
	}
}

// Created Cat as Child class and inheriting Animal as Parent class and demonstrated method overriding concept through method as walk() which is defined in Animal class.
class Cat extends Animal {
	
	// Overridden method of Animal class and providing specific implementation
	@Override
	public void walk() {
		System.out.println("Cat walks quitely!");
	}
}

// Parent class
class Sport {
	int noOfPlayers = 7;
	int score = 0;
	
	public Sport() {
		System.out.println("Sport constructor is called.");
	}
	
	public void displayNoOfPlayers() {
		System.out.println("Have "+noOfPlayers+" no of players.");
	}
	
	public void score() {
		System.out.println("Team score: "+score);		
	}
	
	public void winner() {
		System.out.println("Always one winner is there.");
	}
}

// Child class
// Using super to Access Parent Class Fields
class Cricket extends Sport {
	int noOfPlayers = 10;
	int score = 150;
	
	public Cricket() {
		// Using super to Call Parent Class Constructor
		super(); // Calling Sport Constructor
		System.out.println("Cricket constructor is called.");
	}
	
	public void detailSummary() {
		System.out.println("Child class Cricket no of players: "+noOfPlayers); // Child class noOfPlayers
		System.out.println("Parent class Sport no of players: "+super.noOfPlayers); // Parent class noOfPlayers
	}
}

// Using 'this' to refer to current Object fields
class Teacher {
	String name;
	String subject;
	
	public Teacher() {
		this("Unknown", "Unknown"); // Calling parameterized constructor and initializing default values
	}
	
	public Teacher(String name, String subject) {		
		this.name 		= name; // 'this.name' refers to the field, 'name' refers to the parameter
		this.subject 	= subject; // 'this.subject' refers to the field, 'subject' refers to the parameter
	}
	
	public void displayTeacherDetails() {
		System.out.println("Teacher name is "+this.name+" teaching subject "+this.subject);
	}
}

// Practice Exercises
// Parent class Vehicle
class Vehicle {
	String brand;
	int year;
	
	public void displayInfo() {
		System.out.println("Brand name is: "+brand);
		System.out.println("Rollout year: "+year);
	}
}

// Child class Car Inherits Vehicle
class Car extends Vehicle {
	String name;
	
	@Override
	public void displayInfo() {
		super.displayInfo(); // calling parent class method
		System.out.println("Name of the car is: "+name); // adding more details
	}
}

// Parent Class
class Employee {
	int empId;
	String empName;
	String department;
	String residing;
	
	public Employee() {
		System.out.println("Employee lands on the website, login page is visible");		
	}
	
	public Employee(int empId, String empName, String department) {
		this();
		this.empId 		= empId;
		this.empName 	= empName;
		this.department = department;
	}
	
	public Employee(String residing) {
		this();
		this.residing = residing; 
	}
	
	public void displayEmployeeDetails() {
		System.out.println("Employee "+empName+" having employee Id as "+empId+" working in department "+department+" residing at "+residing);
	}	
	
	public void jobRole() {
		System.out.println("Every employee with their specific job role and honestly working.");
	}
}

// Child class Manager Inherits Vehicle
class Manager extends Employee {
	
	public Manager() {
		super();
	}
	
	@Override
	public void jobRole() {
		System.out.println("Manager is responsible to lead the team and make sure that everyone is coordinating.");
	}
}

// Parent class Shape
class Shape {
	String type;
	
	public Shape() {
		System.out.println("All shapes are the child of mine.");
	}
	
	public double area() {
		return 0;
	}
	
	public double perimeter() {
		return 0;
	}
}

// Child class Rectangle extends Shape
class Rectangles extends Shape {
	double length;
	double breadth;
	
	public Rectangles(double length, double breadth) {
		this.length 	= length;
		this.breadth 	= breadth;
	}
	
	@Override
	public double area() {
		return this.length * this.breadth;
	}
	
	@Override
	public double perimeter() {
		return 2*(this.length+this.breadth);
	}
	
	public void typeOfShape() {
		super.type = "2D";
	}
	
}

//Child class Circle extends Shape
class Circle extends Shape {
	int radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}
	
	@Override
	public double area() {
		return 3.14*(this.radius * this.radius);
	}
	
	@Override
	public double perimeter() {
		return 2*3.14*(this.radius);
	}
	
	public void typeOfShape() {
		super.type = "2D";
	}
	
}

public class Day6Assignment {

	public static void main(String[] args) {
		
		// Demonstrating Inheritance Concept
		Dog dog 			= new Dog();
		dog.name			= "Bintu"; // field from Dog class
		dog.breed 			= "Labrador"; // Inherited field from Animal class
		dog.numberofLegs 	= 4; // Inherited field from Animal class
		
		System.out.println("Name of dog is: "+dog.name);
		System.out.println("Dog "+dog.name+" breed is: "+dog.breed);
		System.out.println("Dog "+dog.name+" has "+dog.numberofLegs+" legs");
		
		dog.walk(); // Inherited method from Animal class
		dog.makeSound(); // method from Dog class
		
		// Sample Input and Output:-
		/*
			Name of dog is: Bintu
			Dog Bintu breed is: Labrador
			Dog Bintu has 4 legs
			Animal walks fast as well as slow.
			Dog sound: Woof!
		*/
		
		// Demonstrating Method Overriding Concept
		// Creating Animal class object.
		Animal animal = new Animal();
		animal.walk(); // Animal class method
		// Creating Cat class object which is inheriting Animal class.
		Cat cat = new Cat();
		cat.walk(); //  Inherited method from Animal class, Overridden method i.e walk().
		
		// Sample Input and Output:-
		/*
			Animal walks fast as well as slow. // Animal class walk() method.
			Cat walks quitely! // Inherited method from Animal class, Overridden method i.e walk(), customized implementation in Cat class.
		*/
		
		// Demonstrating super keyword examples
		// 1. using 'super' calling parent class method
		Dog dog1 = new Dog();
		dog1.eat();
		// Sample Input and Output:-
		/*
			Animals eat food to survive // defined in Animal class, called through super keyword
			My dog is vegetarian // implementation defined in Dog class
		*/
		
		// 
		
		// 2. using 'super' calling parent class fields and also using super calling Parent Class Constructor
		Cricket cricket = new Cricket();
		cricket.detailSummary();
		// Sample Input and Output:-
		/*
		Sport constructor is called.
		Cricket constructor is called.
		Child class Cricket no of players: 10
		Parent class Sport no of players: 7
		*/
		
		// Demonstrating this keyword
		// 1. Using 'this' to refer to current Object fields
		Teacher teacher = new Teacher("Rohini", "English");
		teacher.displayTeacherDetails();
		// Sample Input and Output:- Teacher name is Rohini teaching subject English
		
		// 2. Using this() to Call Another Constructor 
		Teacher teacher1 = new Teacher(); // Default constructor calling the Parametrized constructor
		teacher1.displayTeacherDetails();
		// Sample Input and Output:- Teacher name is Unknown teaching subject Unknown
		
		// Practice Exercises
		// 1. Create a class Vehicle with fields like brand and year, and a method displayInfo().
		// Create a subclass Car that inherits from Vehicle and overrides the displayInfo() method to add more details.
		Car car 	= new Car();
		car.brand 	= "Tata"; // Inherited fields from Parent class Vehicle
		car.year 	= 2026; // Inherited fields from Parent class Vehicle
		car.name	= "Punch"; // Field from Child class Car
		car.displayInfo(); // Inherited method from Parent class Vehicle and added more details under Car
		// Sample Input and Output:-
		/*
			Brand name is: Tata
			Rollout year: 2026
			Name of the car is: Punch
		*/
		
		// 2. Implement a class Employee with fields and constructors.
		// Create a subclass Manager that overrides a method to display role-specific information and uses super to call the parent constructor.
		Manager manager = new Manager();
		manager.jobRole(); // specific job role
		// Sample Input and Output:-
		/*
			Employee lands on the website, login page is visible // Manager child class constructor calling the parent class Employee constructor
			Manager is responsible to lead the team and make sure that everyone is coordinating. // specific job role
		*/
		
		// 3. Demonstrate constructor chaining using this() inside a class with multiple constructors.
		Employee emp1 = new Employee(12, "hardik", "Software Developer"); // parameterized constructor calling default constructor using 'this' keyword
		emp1.displayEmployeeDetails();
		// Sample Input and Output:-
		/* 
			Employee lands on the website, login page is visible // parameterized constructor calling default constructor using 'this' keyword
			Employee hardik having employee Id as 12 working in department Software Developer residing at null
		*/
		Employee emp2 = new Employee("India"); // parameterized constructor calling default constructor using 'this' keyword
		emp2.displayEmployeeDetails();
		// Sample Input and Output:-
		/*
			Employee lands on the website, login page is visible // parameterized constructor calling default constructor using 'this' keyword 
			Employee null having employee Id as 0 working in department null residing at India		
		*/

		// 4. Create a class hierarchy of Shape → Rectangle and Circle, override an area() method, and use super and this keywords as appropriate.
		Rectangles rectangles = new Rectangles(12, 3); // In Rectangles class demonstrated use of this and super keyword
		System.out.println(rectangles.area()); // calling the overridden method
		System.out.println(rectangles.perimeter()); // calling the overridden method
		// Sample Input and Output:-
		/*
			All shapes are the child of mine. // Parent constructor is called
			36.0 // area
			30.0 // perimeter
		*/
		Circle circle = new Circle(6);
		System.out.println(circle.area()); // calling the overridden method
		System.out.println(circle.perimeter()); // calling the overridden method
		// Sample Input and Output:-
		/*
			All shapes are the child of mine. // Parent constructor is called
			113.04 // area
			37.68 // perimeter
		*/	
		
	}

}
