package day_01;

import java.util.Scanner;

/*
 * 3. Take width and height of a rectangle and print the area and perimeter. 
 * Test:
 * Width = 5 Height = 8
 * Expected Output
 * Area is 5 * 8 = 40
 * Perimeter is 2 * (5 + 8) = 26
*/
public class Exercise03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter width: width = ");
		int width = scanner.nextInt();
		System.out.print("Enter height: height = ");
		int height = scanner.nextInt();
		scanner.close();

		System.out.println(String.format("Width = %d, Height = %d", width, height));
		System.out.println(String.format("Area is : %d * %d = %d", width, height, (width * height)));
		System.out.println(String.format("Perimeter is 2 * (%d + %d) = %d", width, height, (2 * (width + height))));
	}
}
