package day_01;

import java.util.Scanner;

/**
* 2. Print the sum, multiply, subtract, divide and remainder of two numbers taken from the user input.
* 
* @author phuctran
*
*/
public class Exercise02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the first number: a = ");
		int a = scanner.nextInt();
		System.out.print("Enter the second number: b = ");
		int b = scanner.nextInt();
		scanner.close();

		System.out.println("Sum: a + b = " + (a + b));
		System.out.println("Multiply: a * b = " + (a * b));
		System.out.println("Subtract: a - b = " + (a - b));
		if (b != 0) {
			System.out.println("Divide: a / b = " + (a / b));
			System.out.println("Remainder: a % b = " + (a % b));
		} else {
			System.out.println("Can not devide by 0 (b = 0)");
		}
	}
}
