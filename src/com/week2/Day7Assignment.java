package com.week2;

// Define class Calculator and demonstrating Method Overloading concept
class Calculator {
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public static int add(int a, int b, int c) {
		return a + b + c;
	}
	
	public double add(double a, double b) {
		return a + b;
	}
	
}

// Parent class
class Father {
	public void walks() {
		System.out.println("Speed of walking is fast.");
	}
}
// Child class Son, Demonstrating Method Overriding concept
class Son extends Father {
	@Override
	public void walks() {
		System.out.println("If carries some weight, walking is fast.");
	}
}
// Demonstrating concept of Abstraction
// interface Institute declared timings() as public abstract method
interface Institute {
	void timings();
}
// abstract class School implements Institute and defined method body for timings()
abstract class School implements Institute {
	abstract void fees();
	
	@Override
	public void timings() {
		System.out.println("timings to reach is 7 AM and to leave is 12:30");
	}
}

//Class StudentTenthClass inheriting abstract class School
class StudentTenthClass extends School{
	// The fees structure can be different for different class students
	public void fees() {
		System.out.println("Below is class tenth fees:");
		System.out.println("Tution fees: 20000, PT: 500, Science laboratory: 1000, Library: 1000");
	}
} 
// Demonstrating concept of Interface
interface Vehicles {
	// by default public and abstract
	int speedUp(int increment);
	int speedDown(int decrement);
	
	static void changeGear() {
		System.out.println("ChangeGear");
	}
}
// class Bicycle implementing interface Vehicles
class  Bicycle implements Vehicles {
	int speed;
		
	// implementation for abstract method speedUp() declared in Parent class
	@Override
	public int speedUp(int increment) {
		speed += increment;
		return speed;
	}
	
	// implementation for abstract method speedDown() declared in Parent class
	@Override
	public int speedDown(int decrement) {
		speed -= decrement;
		return speed;
	}
	
	public void status() {
		System.out.println("Speed is: "+speed);
	}
	
}

// Multiple Interface:- Multiple Inheritance using Interface concept
interface Swimmable {
	void swim();
}

interface Flyable {
	void fly();
}

// Class Duck implements both interface Swimmable and Flyable which is demonstrating concept of Multiple Inheritance
class Duck implements Swimmable, Flyable {

	@Override
	public void fly() {
		System.out.println("Duck flies");	
	}

	@Override
	public void swim() {
		System.out.println("Duck Swims");
	}
	
}

// Practice Exercises
// 1. Create an interface Shape with methods area() and perimeter(). Implement it in classes Circle and Rectangle.
// interface Shape declared with area() perimeter() as default public abstract method
interface Shapes {
	// public abstract method
	double area();
	double perimeter();
}
// class Rectangle implements Shape and implementing area() and perimeter()
class Rectangle implements Shapes {

	double length;
	double breadth;
	
	// parameterized constructor to initialize fields
	public Rectangle(double length, double breadth) {
		this.length 	= length;
		this.breadth 	= breadth;
	}
	
	// inherited method of interface Shape
	@Override
	public double area() {
		return this.length * this.breadth;
	}

	// inherited method of interface Shape
	@Override
	public double perimeter() {
		return 2 * (this.length + this.breadth);
	}
	
}
//class Circles implements Shape and implementing area() and perimeter()
class Circles implements Shapes {

	double radius;
	
	// parameterized constructor to initialize fields
	public Circles(double radius) {
		this.radius = radius;
	}
	
	// inherited method of interface Shape
	@Override
	public double area() {
		return 3.14 * (this.radius * this.radius);
	}

	// inherited method of interface Shape
	@Override
	public double perimeter() {
		return 2 * 3.14 * this.radius;
	}
	
}

// 2. Create an abstract class Employee with an abstract method calculateSalary(). Create subclasses FullTimeEmployee and PartTimeEmployee that override this method.
// abstract class Employess calculateSalary() method is declared
abstract class Employees {
	abstract int calculateSalary();
}
// class FullTimeEmployee extends Employees and provided method body for calculateSalary()
class FullTimeEmployee extends Employees{

	@Override
	int calculateSalary() {		
		return 20000;
	}
	
}
//class PartTimeEmployee extends Employees and provided method body for calculateSalary()
class PartTimeEmployee extends Employees {

	@Override
	int calculateSalary() {		
		return 12000;
	}
	
}

// 3. Demonstrate polymorphism by creating an array of Animal references that hold objects of subclasses like Dog and Cat, and call their overridden methods.
// class Animals with some of the methods declared and defined
class Animals {
	
	public void eat() {
		System.out.println("Animals eat to survive.");
	}
	
	public void makeSound() {
		System.out.println("Animal makes different sound");
	}
	
	public void walk() {
		System.out.println("Animal walks with their capability");
	}
}
// class Dogs extends Animals by overriding methods eat(), walk() and makeSound()
class Dogs extends Animals{
	
	// Overriding methods
	@Override
	public void eat() {
		System.out.println("Eat to keep health strong.");
	}
	
	@Override
	public void makeSound() {
		System.out.println("Dog sound like Woof!");
	}
	
	@Override
	public void walk() {
		System.out.println("Make sound while running");
	}
}
//class Cats extends Animals by overriding methods eat(), walk() and makeSound()
class Cats extends Animals{
	
	// Overriding methods
	@Override
	public void eat() {
		System.out.println("Eating mouse are been seen many times");
	}
	
	@Override
	public void makeSound() {
		System.out.println("Cat sound like Meow!");
	}
	
	@Override
	public void walk() {
		System.out.println("Walks quitely!");
	}
}

// 4. Create an interface Playable with a method play(). Create classes Guitar and Piano implementing Playable.
// interface Playable declared play() as public abstract method
interface Playable {
	void play();
}
// class Guitar implements Playable and providing body for play() method
class Guitar implements Playable{

	@Override
	public void play() {
		System.out.println("Playing guitar");		
	}
	
}
//class Piano implements Playable and providing body for play() method
class Piano implements Playable {

	@Override
	public void play() {
		System.out.println("Playing piano");
	}
	
}

public class Day7Assignment {

	public static void main(String[] args) {
		// Demonstrating Method Overloading concept
		Calculator c = new Calculator();
		System.out.println(c.add(6, 3)); // Output:- 9, method add() having two parameters but has type as int
		System.out.println(c.add(5.6, 4)); // Output:- 9.6, method add() having two parameters but has type as double
		System.out.println(c.add(2, 7, 1)); // Output:- 10, method add() having three parameters but has type as int
		
		// Demonstrating Method Overriding concept
		Father father = new Son(); // Reference of Parent and object of Child
		father.walks(); // Output:- If carries some weight, walking is fast.(Runtime polymorphism)
		
		// Demonstrating concept of Abstraction
		School s = new StudentTenthClass();
		s.fees(); // The fees structure can be different for different class students
		// Sample Output:-
		/*
			Below is class tenth fees:
			Tution fees: 20000, PT: 500, Science laboratory: 1000, Library: 1000
		*/
		
		// Demonstrating concept of Interface
		Vehicles v = new Bicycle(); // Bicycle implements the interface Vehicles
		System.out.println(v.speedUp(12)); // Output:- 12 method define in interface and implementation given in child class
		System.out.println(v.speedDown(3)); // Output:- 9 method define in interface and implementation given in child class
		
		// Demonstrating concept of Multiple Interface or Multiple Inheritance
		Duck duck = new Duck(); // Class Duck implements interface both Swimmable and Flyable
		duck.fly(); // Output:- Duck flies, method inherited from Swimmable interface
		duck.swim(); // Output:- Duck Swims, method inherited from Flyable interface
		
		// Demonstrating concept of polmorphism, abstraction and interfaces
		School school = new StudentTenthClass(); // polymorphism:- reference of parent class and object of child class
		school.timings(); // Output:- timings to reach is 7 AM and to leave is 12:30, declared in interface know as Institute and implemented by abstract class School and inherited by StudentTenthClass
		school.fees(); // declared in School inherited in StudentTenthClass
		// Sample Output for 'school.fees()':-
		/*
			Below is class tenth fees:
			Tution fees: 20000, PT: 500, Science laboratory: 1000, Library: 1000
		*/
		
		// Practice Exercises
		// 1. Create an interface Shape with methods area() and perimeter(). Implement it in classes Circle and Rectangle.
		Rectangle r = new Rectangle(2.3, 4); // parameterized constructor to initialize object
		System.out.println("Area of Rectangle is: "+r.area()); // Output:- Area of Rectangle is: 9.2, declared in interface Shapes and implemented in Rectangle
		System.out.println("Perimeter of Rectangle is: "+r.perimeter()); // Output:- Perimeter of Rectangle is: 12.6, declared in interface Shapes and implemented in Rectangle
		
		Circles circle = new Circles(5); // parameterized constructor to initialize object
		System.out.println("Area of Circle is: "+circle.area()); // Output:- Area of Circle is: 78.5, declared in interface Shapes and implemented in Rectangle
		System.out.println("Perimeter of Circle is: "+circle.perimeter()); // Output:- Perimeter of Circle is: 31.400000000000002, declared in interface Shapes and implemented in Circle
		
		// 2. Create an abstract class Employee with an abstract method calculateSalary(). Create subclasses FullTimeEmployee and PartTimeEmployee that override this method.
		FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
		System.out.println("Full time employee salary will be credited as: "+fullTimeEmployee.calculateSalary()); // Output:- Full time employee salary will be credited as: 20000, method declared in abstract class Employees and provided method body for calculateSalary() in class FullTimeEmployee
		
		PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
		System.out.println("Part time employee salary will be credited as: "+partTimeEmployee.calculateSalary()); // Output:- Part time employee salary will be credited as: 12000, method declared in abstract class Employees and provided method body for calculateSalary() in class PartTimeEmployee
		
		// 3. Demonstrate polymorphism by creating an array of Animal references that hold objects of subclasses like Dog and Cat, and call their overridden methods.
		Animals[] animal = {new Dogs(), new Cats()}; // An array of 'Animals' reference having different object type like Dogs and Cats  
		for(Animals animals: animal) { // iterating through each object and calling overridden methods
			animals.eat();
			animals.makeSound();
			animals.walk();
		}
		// Sample Output:-
		/*
		   	// For object type Dogs
		 	Eat to keep health strong.
			Dog sound like Woof!
			Make sound while running
			
			// For object type Cats
			Eating mouse are been seen many times
			Cat sound like Meow!
			Walks quitely!

		*/
		
		// 4. Create an interface Playable with a method play(). Create classes Guitar and Piano implementing Playable.
		Guitar guitar = new Guitar();
		guitar.play(); // Output:- Playing guitar, declared method in interface Playable and provided method body inside class Guitar
		Piano piano = new Piano();		
		piano.play(); // Output:- Playing piano, declared method in interface Playable and provided method body inside class Piano
		
	}

}
