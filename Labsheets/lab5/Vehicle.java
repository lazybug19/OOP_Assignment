import java.util.Scanner;

public class Vehicle {
	private String make;
	private String model;
	private int year;

	public Vehicle(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public void displayDetails() {
		System.out.println("Make: " + make);
		System.out.println("Model: " + model);
		System.out.println("Year: " + year);
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner var = new Scanner(System.in);
		System.out.print("Enter car make: ");
		String make = var.nextLine();
		System.out.print("Enter car model: ");
		String model = var.nextLine();
		System.out.print("Enter manufacturing year: ");
		int year = var.nextInt();
		System.out.print("Enter number of doors: ");
		int numDoors = var.nextInt();
		Car car = new Car(make, model, year, numDoors);
		car.displayDetails();
	}
}

class Car extends Vehicle {
	private int numDoors;

	public Car(String make, String model, int year, int numDoors) {
		super(make, model, year);
		this.numDoors = numDoors;
	}

	public void displayDetails() {
		System.out.println("Car Details: ");
		super.displayDetails();
		System.out.println("Number of Doors: " + numDoors);
	}
}
