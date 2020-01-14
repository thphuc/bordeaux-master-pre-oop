package day1;

import java.util.Scanner;

/**
 * @author hainm2
 * Implement the Exercise 3
 * Take width and height of a rectangle and print the area and perimeter.
 */

public class Exercise3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		System.out.println("Enter the width of a rectangle: ");
		int width = input.nextInt();
		System.out.println("Enter the height of a rectangle: ");
		int height = input.nextInt();
		System.out.println("Area is " + (width * height));
		System.out.println("Perimeter is " + 2 * (width + height));
		
		input.close();
	}
}
