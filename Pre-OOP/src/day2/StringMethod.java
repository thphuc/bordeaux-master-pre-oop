package day2;

public class StringMethod {
	/**
	 * Implement some examples of String methods
	 */
	public static void testStringMethod() {
		// toUpperCase() method converts this string into uppercase letter
		// and string toLowerCase() method into lowercase letter
		String s = "Sachin";
		System.out.println(s.toUpperCase());// SACHIN
		System.out.println(s.toLowerCase());// sachin
		System.out.println(s);// Sachin(no change in original)

		// string trim() method eliminates white spaces before and after string.
		s = "  Sachin  ";
		System.out.println(s);// Sachin
		System.out.println(s.trim());// Sachin

		s = "Sachin";
		System.out.println(s.startsWith("Sa"));// true
		System.out.println(s.endsWith("n"));// true

		// charAt() method returns a character at specified index
		s = "Sachin";
		System.out.println(s.charAt(0));// S
		System.out.println(s.charAt(3));// h

		// valueOf() method coverts given type such as int, long,
		// float, double, boolean, char and char array into string
		int a = 10;
		s = String.valueOf(a);
		System.out.println(s + 10);

		// replace() method replaces all occurrence of first sequence of character with
		// second sequence of character
		String s1 = "Java is a programming language. Java is a platform. Java is an Island.";
		String replaceString = s1.replace("Java", "Kava");// replaces all occurrences of "Java" to "Kava"
		System.out.println(replaceString);
	}

	/**
	 * Implement some examples of StringBuilder Method
	 */
	public static void testStringBuilderMethod() {
		StringBuffer sb = new StringBuffer("Hello ");
		sb.append("Java");// now original string is changed
		System.out.println(sb);// prints Hello Java

		sb.insert(1, "Java");// now original string is changed
		System.out.println(sb);

		sb.replace(1, 3, "Java");
		System.out.println(sb);

		sb.delete(1, 3);
		System.out.println(sb);

		sb.reverse();
		System.out.println(sb);
	}

	/**
	 * Compare processing time between String and StringBuilder concat
	 * 
	 */
	public static void compare() {
		long startTime = System.currentTimeMillis();
		concatWithString();
		System.out.println("Time taken by Concating with String: " + (System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		concatWithStringBuffer();
		System.out.println(
				"Time taken by Concating with  StringBuffer: " + (System.currentTimeMillis() - startTime) + "ms");
	}

	public static String concatWithString() {
		String t = "Java";
		for (int i = 0; i < 10000; i++) {
			t = t + "Tpoint";
		}
		return t;
	}

	public static String concatWithStringBuffer() {
		StringBuffer sb = new StringBuffer("Java");
		for (int i = 0; i < 10000; i++) {
			sb.append("Tpoint");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringMethod.testStringMethod();
		StringMethod.testStringBuilderMethod();
		StringMethod.compare();
	}

}
