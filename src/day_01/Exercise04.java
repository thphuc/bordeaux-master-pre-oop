package day_01;

import java.util.Scanner;

/*
 * 4. Print the result of Converting temperature from Fahrenheit to Celsius degree
 */
public class Exercise04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Fahrenhit: ");
		int fahrenhit = scanner.nextInt();
	
		scanner.close();
		
		float celsius = (fahrenhit - 32) * 5.0f / 9;

		System.out.println(String.format("Celsius: %.5f", celsius));
	}
}
