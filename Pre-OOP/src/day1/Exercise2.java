package day1;

import java.util.Scanner;

/**
 * @author hainm2
 * Print the sum, multiply, subtract, divide and remainder of two numbers taken 
 * from the user input.
 */
public class Exercise2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	   	
    	System.out.print("Enter the first number: ");
    	double d1, d2;
    	String number = "";
    	while(true) {
    		number = input.next();
    		try {
    			d1 = Double.parseDouble(number);
    			break; 
    		} catch (Exception e) {
    			System.out.println("Re-enter the first Number: ");    			
    		}
    	}
    	System.out.print("Enter the second number: ");
    	
    	while(true) {
    		number = input.next();
    		try {
    			d2 = Double.parseDouble(number);
    			break; 
    		} catch (Exception e) {
    			System.out.println("Re-enter the first Number: ");
    		}
    	}
    	System.out.println("Sum: " + (d1 + d2));
    	System.out.println("Multiplication: " + (d1 * d2));
    	System.out.println("Subtraction: " + (d1 - d2));
    	if (d2 != 0) {
    		System.out.println("Divide: " + (d1 / d2));
    		System.out.println("Remainder: " + (d1 % d2));
    	} else {
    		System.out.println("The second number must not be 0!");
    	}    	
    	
    	input.close();
	}

}
