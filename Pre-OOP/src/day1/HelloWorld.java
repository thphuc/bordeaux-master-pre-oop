package day1;

import java.util.Scanner;

/**
 * @author hainm2
 * 
 */

public class HelloWorld {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		Scanner input = new Scanner(System.in);	   	
    	System.out.print("Enter an integer: ");
    	String number = input.next();
    	System.out.println("You entered " + number);
    	System.out.print("Enter an integer: ");
    	number = input.next();
    	System.out.println("You entered " + number);
	}

}
