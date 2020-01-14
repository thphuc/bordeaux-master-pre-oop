package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

/**
 * @author hainm2
 * Implementation of Exercise for Day 2
 */
public class Day2 {

	/**
	 * Print the character corresponding to this index of the string
	 * 
	 * @param str
	 * @param index
	 * @return Char
	 */
	public char ex1(String str, int index) {
		if (str != null && index >= 0 && index < str.length())
			return str.charAt(index);

		return ' ';
	}

	/**
	 * Convert a string in reverse order
	 * 
	 * @param str
	 * @return Reverse string
	 */
	public String ex2_1(String str) {
		if (str != null) {
			StringBuilder sb = new StringBuilder(str);
			return sb.reverse().toString();
		}

		return null;
	}

	public String ex2_2(String str) {
		if (str != null) {
			char[] strToCharArray = str.toCharArray();
			char[] result = new char[strToCharArray.length];

			// Store result in reverse order into the result
			for (int i = 0; i < strToCharArray.length; i++)
				result[i] = strToCharArray[strToCharArray.length - i - 1];

			return new String(result);
		}

		return null;
	}

	public String ex2_3(String str) {
		if (str != null) {
			char[] strToCharArray = str.toCharArray();
			int left, right = 0;
			right = strToCharArray.length - 1;

			for (left = 0; left < right; left++, right--) {
				// Swap values of left and right
				char temp = strToCharArray[left];
				strToCharArray[left] = strToCharArray[right];
				strToCharArray[right] = temp;
			}

			return new String(strToCharArray);
		}

		return null;
	}

	/**
	 * convert all characters of this string into upper case
	 * 
	 * @param str
	 * @return String
	 */
	public String ex3(String str) {
		if (str != null) {
			return str.toUpperCase();
		}

		return null;
	}

	/**
	 * Count the number of all vowels in the string
	 * 
	 * @param str
	 * @return number of vowels
	 */
	public int ex7(String str) {
		int num = 0;

		if (str != null) {
			char[] c = str.toCharArray();
			for (int i = 0; i < c.length; i++) {
				if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u')
					num++;
			}
		}

		return num;
	}

	/**
	 * Sum all the digit of an integer
	 * 
	 * @param number
	 * @return
	 */
	public int ex8_1(int number) {
		if (number < 0)
			return 0;

		if (number < 10)
			return number;
		else
			return (number % 10) + (int) ex8_1(number / 10);
	}

	public int ex8_2(int number) {
		int m = number, n = 0, sum = 0;
		while (m > 0) {
			n = m % 10;
			sum = sum + n;
			m = m / 10;
		}
		return sum;
	}

	/**
	 * List the first n Fibonacci values
	 * 
	 * @param number n
	 */
	public void ex10(int number) {
		BigInteger a = new BigInteger("0"), b = new BigInteger("0"), c = new BigInteger("1");
//		int a=0, b=0, c=1; 
		System.out.print("Fibonacci Series:");
		for (int i = 1; i <= number; i++) {
			a = b;
			b = c;
			c = a.add(b);
//			c = a + b;
			System.out.print(a + ", ");
		}
		System.out.println();
	}

	/**
	 * Export a file content line by line
	 * 
	 * @param fileName
	 */
	public void ex13(String fileName) {
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = "";			
			line = br.readLine();
			System.out.println("Read file line by line: " + fileName);
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {		
		Day2 d = new Day2();
		String s = "Hello World!";
		int number = 1928;
		int index = 10;
		int a = 5; int b = 7;
		// String Cat
		String msg = "The sum of " + a + " and " + b + " is " + (a+b);
		System.out.println(msg);
		System.out.println("Original String is: " + s);
		System.out.println("[*] Exercise 1:");
		System.out.println("Char at index " + index + " is: " + d.ex1(s, index));
		System.out.println("[*] Exercise 2:");
		System.out.println("Reverse String is: " + d.ex2_1(s));
		System.out.println("Reverse String is: " + d.ex2_2(s));
		System.out.println("Reverse String is: " + d.ex2_3(s));
		System.out.println("[*] Exercise 3:");
		System.out.println("ToUpperCase String is: " + d.ex3(s));
		System.out.println("[*] Exercise 7:");
		System.out.println("Number of vowerls is: " + d.ex7(s));
		System.out.println("[*] Exercise 8:");
		System.out.println("Sum of the digits in an integer is: " + d.ex8_1(number));
		System.out.println("Sum of the digits in an integer is: " + d.ex8_2(number));
		System.out.println("[*] Exercise 10:");
		d.ex10(100);
		String fileName = "data/test.txt";
		System.out.println("[*] Exercise 13:");
		d.ex13(fileName);
	}

}
