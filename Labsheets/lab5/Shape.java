import java.util.Scanner;

abstract class Shape {
    private String shapeName;
    private String color;

    Shape(String shapeName, String color) {
        this.shapeName = shapeName;
        this.color = color;
    }

    abstract double calculateArea();

    public void displayDetails() {
        System.out.println(shapeName);
        System.out.println("Color: " + color);
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        // Circle
        System.out.println("Enter Circle details: ");
        System.out.print("Shape Name: ");
        String shapeName1 = sc.next();
        System.out.print("Color: ");
        String color1 = sc.nextLine();
        System.out.print("Radius: ");
        Double radius = sc.nextDouble();

        // Rectangle
        System.out.println("Enter Rectangle details: ");
        System.out.print("Shape Name: ");
        String shapeName2 = sc.nextLine();
        System.out.print("Color: ");
        String color2 = sc.nextLine();
        System.out.print("Length: ");
        Double length = sc.nextDouble();
        System.out.print("Breadth: ");
        Double breadth = sc.nextDouble();

        System.out.println("Shape Details:");
        System.out.println("---------------");
        Circle circle = new Circle(shapeName1, color1, radius);
        circle.displayDetails();
        System.out.println(" ");
        Rectangle rectangle = new Rectangle(shapeName2, color2, length, breadth);
        rectangle.displayDetails();
    }
}

class Circle extends Shape {
    private double radius;

    Circle(String shapeName, String color, double radius) {
        super(shapeName, color);
        this.radius = radius;
    }

    public double calculateArea() {
        double area = 3.14 * radius * radius;
        return area;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
    }
}

class Rectangle extends Shape {
    private double length, breadth;

    Rectangle(String shapeName, String color, double length, double breadth) {
        super(shapeName, color);
        this.length = length;
        this.breadth = breadth;
    }

    public double calculateArea() {
        double area = length * breadth;
        return area;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Length: " + length);
        System.out.println("Breadth: " + breadth);
        System.out.println("Area: " + calculateArea());
    }
}
