import java.util.Scanner;

public class calculator {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first no. : ");
		double num1 = sc.nextDouble();
		System.out.print("Enter first no. : ");
		double num2 = sc.nextDouble();
		System.out.print("Enter operator : ");
		char op = sc.next().charAt(0);
		// char op = operator.charAt(0);
		doCalculate(num1, num2, op);
	}

	public static void doCalculate(double num1, double num2, char op) {
		double result = 0.00;
		switch (op) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			default:
				System.out.println("Invalid operator");
		}
		System.out.println("Result : " + result);
	}
}
