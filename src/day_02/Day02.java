package day_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

import java.util.Scanner;

public class Day02 {
	public static void main(String[] args) {
		final String day02 = "ThisIsDay02";
		System.out.println(String.format("ORIGINAL String is %s\n\n", day02));

		/*
		 * Exercise 1. With a string and an index as user input, print the character
		 * corresponding to this index of the string.
		 */
		System.out.println("----------- START EXERCISE 1---------");
		printCharAt(day02, 3);
//		printCharAt("", 5);
//		printCharAt("Day02", 100);
		System.out.println("----------- END EXERCISE 1 ---------\n\n");

		/*
		 * Exercise 2. With a string as user input, convert it in reverse order.
		 */
		System.out.println("----------- START EXERCISE 2 ---------");
		System.out.println(String.format("Original string: %s", day02));
		String reversedString = reverseString(day02);
		System.out.println(String.format("Reversed string is: %s", reversedString));
		System.out.println("----------- END EXERCISE 2 ---------\n\n");

		/*
		 * Exercise 3. With a string as user input, convert all characters of this
		 * string into upper case and lower case.
		 */
		System.out.println("----------- START EXERCISE 3 ---------");
		System.out.println(String.format("Original string: %s", day02));
		printUppercase(day02);
		printLowercase(day02);
		System.out.println("----------- END EXERCISE 3 ---------\n\n");

		/*
		 * Exercise 4. With a string as user input, print the all characters between two
		 * positions of a string.
		 */
		System.out.println("----------- START EXERCISE 4 ---------");
		System.out.println(String.format("Original string: %s", day02));
		printAllCharactersBetween(day02, 4, 8);
//		printAllCharactersBetween(day02, -1, 8);
//		printAllCharactersBetween(day02, 4, 88);
		System.out.println("----------- END EXERCISE 4 ---------\n\n");

		/*
		 * Exercise 5. With a string as user input, reverse all non-vowel character in
		 * this string.
		 */
		System.out.println("----------- START EXERCISE 5 ---------");
		System.out.println("Reverse all non vowels characters");
		System.out.println(String.format("Original string: %s", day02));
		String reversedNonVowel = reverseAllNonVowelCharacters(day02);
		System.out.println(reversedNonVowel);
		System.out.println(reverseAllNonVowelCharacters("mothAibA"));
		System.out.println("----------- END EXERCISE 5 ---------\n\n");

		/*
		 * Exercise 6. With a string as user input, convert all vowel characters of this
		 * string into Upper case.
		 */
		System.out.println("----------- START EXERCISE 6 ---------");
		System.out.println("Convert all vowel characters to uppercase");
		System.out.println(String.format("Original string: %s", day02));
		System.out.println(convertAllVowelsInStringToUppercase(day02));
		System.out.println("----------- END EXERCISE 6 ---------\n\n");

		/*
		 * Exercise 7. With string as user input, count the number of all vowels in this
		 * string. Test Data: Input the string: w3resource Expected Output: Number of
		 * Vowels in the string: 4
		 */
		System.out.println("----------- START EXERCISE 7 ---------");
		System.out.println(
				String.format("Number of vowels in string \"%s\" : %d", day02, countNumberOfVowelInString(day02)));
		System.out.println(String.format("Number of vowels in string \"%s\" : %d", "w3resource",
				countNumberOfVowelInString("w3resource")));
		System.out.println("----------- END EXERCISE 7 ---------\n\n");

		/*
		 * Exercise 8. With an integer as user input, sum all the digit of this integer.
		 */
		System.out.println("----------- START EXERCISE 8 ---------");
		int number = 12345;
		System.out.println(String.format("Sum all of the digits of the number %d = %d", number,
				sumAllTheDigitsOfAnInteger(number)));
		number = 13579;
		System.out.println(String.format("Sum all of the digits of the number %d = %d", number,
				sumAllTheDigitsOfAnInteger(number)));
		System.out.println("----------- END EXERCISE 8 ---------\n\n");

		/*
		 * Exercise 9. With string as user input, reverse all characters between two
		 * characters of this string.
		 */
		System.out.println("----------- START EXERCISE 9 ---------");
		// System.out.println("Reverse all characters between two characters of a string");
		reverseAllCharactersBetween2Characters("This is a Java program", 's', 'p');
		System.out.println("----------- END EXERCISE 9 ---------\n\n");

		/*
		 * Exercise 10. With an integer n as user input, list the first n Fibonacci
		 * values.
		 */
		System.out.println("----------- START EXERCISE 10 ---------");
		int numberOfFibo = 15;
		System.out.println(String.format("%d first Fibonacci values: ", numberOfFibo));
		printFirstNFibonacciValues(numberOfFibo);
		System.out.println("----------- END EXERCISE 10 ---------\n\n");

		/*
		 * Exercise 11. With a file name as user input and an integer n, read first n
		 * lines from a file.
		 */
		System.out.println("----------- START EXERCISE 11 ---------");
		int numberOfLines = 4;
		String fileName = "test.txt";
		printFistNLineOfFile(fileName, numberOfLines);
		System.out.println("----------- END EXERCISE 11 ---------\n\n");

		/*
		 * Exercise 12. With an integer n as user input, list all prime numbers LESS
		 * than n.
		 */
		System.out.println("----------- START EXERCISE 12 ---------");
		printAllPrimeNumbersLessThanN(30);
		System.out.println("----------- END EXERCISE 12 ---------\n\n");

		/*
		 * Exercise 13.
		 * With a file name as user input, export a file content line by line.
		 */
		System.out.println("----------- START EXERCISE 13 ---------");
		printAllContentOfFile(fileName);
		System.out.println("----------- END EXERCISE 13 ---------\n\n");
		
		/*
		 * Exercise 14. With two strings as user input, compare these strings and print
		 * out the different index (0 if the two string is equal).
		 */
		System.out.println("----------- START EXERCISE 14 ---------");
		String str1 = "ThisIsDay02";
		String str2 = "ThisDayay02abc";
		System.out.println(String.format("Print out different indices of 2 strings: \"%s\" and \"%s\"", str1, str2));
		printOutDifferentIndices(str1, str2);
		System.out.println("----------- END EXERCISE 14 ---------\n\n");

		/*
		 * Exercise 15. With two strings as user input, check if one string contains the
		 * other and print out the index
		 */
		System.out.println("----------- START EXERCISE 15 ---------");
		System.out.println("Check if one string contains the other and print out the index");
		containAt("ThisIsDayis02is", "is");
		System.out.println("----------- END EXERCISE 15 ---------\n\n");

		/*
		 * Exercise 16. With two strings as user input, count the number of one string
		 * contain in the other string.
		 */
		System.out.println("----------- START EXERCISE 16 ---------");
		System.out.println("Count the number of one string contain in the other string");
		countContainTime("ThisIsDayis02is", "is");
		System.out.println("----------- END EXERCISE 16 ---------\n\n");

		/*
		 * Exercise 17. With a string as user input, count the frequency of all
		 * characters in this string.
		 */
		System.out.println("----------- START EXERCISE 17 ---------");
		System.out.println("Count the frequency of all characters in a string");
		countFrequencyOfAllCharactersInString(day02);
		System.out.println("----------- END EXERCISE 17 ---------\n\n");

		/*
		 * Exercise 18. With two strings as user input, concatenation the first string
		 * with the reverse order of the second string.
		 */
		System.out.println("----------- START EXERCISE 18 ---------");
		System.out.println("Concate the first string with the reverse order of the second string");
		concatenateFirstStringWithReverseOfSecondString("Hello", "World");
		System.out.println("----------- END EXERCISE 18 ---------\n\n");
		
		/*
		 * Exercise 19.
		 * With a file name as user input, reverse the content of this file.
		 */
		System.out.println("----------- START EXERCISE 19 ---------");
		System.out.println("Reverse the content of a file");
		reverseContentOfAFile("test.txt");
		System.out.println("----------- END EXERCISE 19 ---------\n\n");
		
		/*
		 * Exercise 21.
		 * With a file name as user input, export a file content line by line.
		 */
		System.out.println("----------- START EXERCISE 21 (duplicated of EXERCISE 13) ---------");
		printAllContentOfFile(fileName);
		System.out.println("----------- END EXERCISE 21 (duplicated of EXERCISE 13) ---------\n\n");

		/*
		 * Exercise 22. With a string as user input, split this string into words.
		 */
		System.out.println("----------- START EXERCISE 22 ---------");
		System.out.println("Split string into words");
		splitStringIntoWords("This is the original string");
		System.out.println("----------- END EXERCISE 22 ---------\n\n");

		/**
		 * Exercise 23. With two strings as user input, print all possible strings which
		 * are concatenation of these given strings .
		 */
		System.out.println("----------- START EXERCISE 23 ---------");
		System.out.println("Print all possible strings which are concatenation of 2 strings");
		printAllConcatenatedStrings("Hello", "World");
		System.out.println("----------- END EXERCISE 23 ---------\n\n");

		/**
		 * Exercise 24. With a string as user input, print all permutation of this
		 * string.
		 */
		System.out.println("----------- START EXERCISE 24 ---------");
		System.out.println("Print all permutation of a string");
		printAllPermutation("abc", "");
		System.out.println("----------- END EXERCISE 24 ---------\n\n");

		/**
		 * Exercise 25. With a string as user input, remove all the duplicate word of
		 * this string.
		 */
		System.out.println("----------- START EXERCISE 25 ---------");
		System.out.println("Remove all the duplicate word of a string");
		removeAllDuplicateWordsInAString("This is a Java program Java is This right?");
		System.out.println("----------- END EXERCISE 25 ---------\n\n");
	}

	/**
	 * Get character in a string at index
	 * 
	 * @param input
	 * @param index
	 */
	static void printCharAt(String input, int index) {
		if (input != null && !input.isEmpty()) {
			if (index < input.length()) {
				System.out.println(String.format("Original string: %s", input));
				System.out.println(String.format("Character at index = %d is %s", index, input.charAt(index)));
			} else {
				System.out.println("Invalid index!");
			}
		} else {
			System.out.println("The input string is null or empty. Please try again!");
		}
	}

	/**
	 * Reverse string of an input string
	 * 
	 * @param input
	 * @return Reversed string
	 * 
	 */
	static String reverseString(String input) {
		if (input != null && !input.isEmpty()) {
			String reversedString = new StringBuilder(input).reverse().toString();
			return reversedString;
		}
		return null;
	}

	/**
	 * Print upper case version of an input string
	 * 
	 * @param input
	 */
	static void printUppercase(String input) {
		if (input != null && !input.isEmpty()) {
			System.out.println(String.format("Uppercase: %s", input.toUpperCase()));
		} else {
			System.out.println("The input string is null or empty. Please try again!");
		}
	}

	/**
	 * Print upper case version of an input string
	 * 
	 * @param input
	 */
	static void printLowercase(String input) {
		if (input != null && !input.isEmpty()) {
			System.out.println(String.format("Lowercase: %s", input.toLowerCase()));
		} else {
			System.out.println("The input string is null or empty. Please try again!");
		}
	}

	/**
	 * @param input
	 * @param startIndex
	 * @param endIndex
	 */
	static void printAllCharactersBetween(String input, int startIndex, int endIndex) {
		if (input != null && !input.isEmpty()) {
			if (startIndex < 0 || startIndex >= input.length()) {
				System.out.println(String.format("Start index(%d) -> invalid!", startIndex));
				return;
			}
			if (endIndex < 0 || endIndex >= input.length()) {
				System.out.println(String.format("End index(%d) -> invalid!", endIndex));
				return;
			}

			System.out.println(String.format("All characters between %d and %d: %s", startIndex, endIndex,
					input.substring(startIndex, endIndex)));
		} else {
			System.out.println("The input string is null or empty. Please try again!");
		}
	}

	static boolean isVowel(char c) {
		String vowels = "aAeEiIoOuU";
		for (int i = 0; i < vowels.length(); i++) {
			if (vowels.charAt(i) == c) {
				return true;
			}
		}
		return false;
	}

	static String reverseAllNonVowelCharacters(String input) {
		char[] output = new char[input.length()];
		if (input != null && !input.isEmpty()) {
			int lastJIndex = input.length() - 1;
			for (int i = 0; i < input.length() / 2 + 1; i++) {
				if (isVowel(input.charAt(i))) {
					output[i] = input.charAt(i);
				} else {
					for (int j = lastJIndex; j > i; j--) {
						if (isVowel(input.charAt(j))) {
							output[j] = input.charAt(j);
						} else {
							output[i] = input.charAt(j);
							output[j] = input.charAt(i);
							lastJIndex = j - 1;
							break;
						}
					}
				}
			}

			return String.valueOf(output);
		} else {
			System.out.println("The input string is null or empty. Please try again!");
			return null;
		}
	}

	static String convertAllVowelsInStringToUppercase(String input) {
		if (input != null && !input.isEmpty()) {
			char[] output = new char[input.length()];
			for (int i = 0; i < input.length(); i++) {
				if (isVowel(input.charAt(i))) {
					output[i] = Character.toUpperCase(input.charAt(i));
				} else {
					output[i] = input.charAt(i);
				}
			}
			return String.copyValueOf(output);
		} else {
			System.out.println("The input string is null or empty. Please try again!");
			return null;
		}
	}

	static int countNumberOfVowelInString(String input) {
		int count = 0;
		if (input != null && !input.isEmpty()) {
			for (int i = 0; i < input.length(); i++) {
				if (isVowel(input.charAt(i))) {
					count++;
				}
			}
			return count;
		} else {
			System.out.println("The input string is null or empty. Please try again!");
			return count;
		}
	}

	static int sumAllTheDigitsOfAnInteger(int number) {
		int sum = 0;
		int newNum = number;
		while (newNum > 0) {
			sum += newNum % 10;
			newNum /= 10;
		}

		return sum;
	}

	static void printFirstNFibonacciValues(int n) {
		int[] f = new int[n];
		f[0] = 0;
		f[1] = 1;

		int i = 0;
		while (i < n) {
			if (i == 0) {
				System.out.println(String.format("%d", f[0]));
			} else if (i == 1) {
				System.out.println(String.format("%d", f[1]));
			} else {
				f[i] = f[i - 1] + f[i - 2];
				System.out.println(String.format("%d", f[i]));
			}
			i++;
		}
	}

	static void printFistNLineOfFile(String fileName, int numberOfLine) {
		System.out.println(String.format("Print %d first lines of %s", numberOfLine, fileName));
		try {
			File file = new File(System.getProperty("user.dir") + "/src/" + fileName);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine() && numberOfLine > 0) {
				String data = scanner.nextLine();
				System.out.println(data);
				numberOfLine--;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	static void printAllContentOfFile(String fileName) {
		System.out.println(String.format("Print all lines of %s", fileName));
		try {
			File file = new File(System.getProperty("user.dir") + "/src/" + fileName);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				System.out.println(data);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Check if a number is a prime number
	 * 
	 * @param number
	 * @return
	 */
	static boolean isPrimeNumber(int number) {
		if (number < 2) {
			return false;
		}

		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}

	static void printAllPrimeNumbersLessThanN(int n) {
		System.out.println(String.format("All prime numbers LESS THAN %d:", n));
		for (int i = 2; i < n; i++) {
			if (isPrimeNumber(i)) {
				System.out.println(String.format("%d", i));
			}
		}
	}

	static void printOutDifferentIndices(String str1, String str2) {
		if (str1 == null || str1.isEmpty() || str2 == null || str1.isEmpty()) {
			System.out.println("At least one string is null or empty. Please provide 2 valid strings!");
			return;
		}

		int length1 = str1.length();
		int length2 = str2.length();
		int minLength = length1;
		if (length1 > length2) {
			minLength = length2;
		}
		boolean hasDiff = false;

		for (int i = 0; i < minLength; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				System.out.println(String.format("%d", i));
				hasDiff = true;
			}
		}

		if (!hasDiff && length1 == length2) {
			System.out.println("2 strings are equal");
		}
	}

	/**
	 * Check if a string contains the order and print the index
	 * 
	 * @param str1
	 * @param str2
	 */
	static void containAt(String str1, String str2) {
		if (str1 == null || str1.isEmpty() || str2 == null || str1.isEmpty()) {
			System.out.println("At least one string is null or empty. Please provide 2 valid strings!");
			return;
		}

		if (str2.length() > str1.length()) {
			System.out.println(String.format("%s does not contain %s", str1, str2));
		}

		int str2Length = str2.length();
		boolean found = false;
		for (int i = 0; i <= str1.length() - str2.length(); i++) {
			if (str1.charAt(i) == str2.charAt(0)) {
				String checkedStr = str1.substring(i, i + str2Length);
				if (checkedStr.equals(str2)) {
					System.out.println(String.format("\"%s\" contains \"%s\" at index = %d", str1, str2, i));
					found = true;
				}
			}
		}

		if (!found) {
			System.out.println(String.format("%s does not contain %s", str1, str2));
		}
	}

	static void countContainTime(String str1, String str2) {
		if (str1 == null || str1.isEmpty() || str2 == null || str1.isEmpty()) {
			System.out.println("At least one string is null or empty. Please provide 2 valid strings!");
			return;
		}

		if (str2.length() > str1.length()) {
			System.out.println(String.format("%s does not contain %s", str1, str2));
		}

		int str2Length = str2.length();
		boolean found = false;
		int count = 0;
		for (int i = 0; i <= str1.length() - str2.length(); i++) {
			if (str1.charAt(i) == str2.charAt(0)) {
				String checkedStr = str1.substring(i, i + str2Length);
				if (checkedStr.equals(str2)) {
					count++;
					found = true;
				}
			}
		}

		if (!found) {
			System.out.println(String.format("%s does not contain %s", str1, str2));
		} else {
			System.out.println(String.format("\"%s\" contains \"%s\" %d times", str1, str2, count));
		}
	}

	static void countFrequencyOfAllCharactersInString(String input) {
		System.out.println(String.format("The string: %s", input));
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			Integer val = map.get(c);

			if (val != null) {
				map.put(c, new Integer(val + 1));
			} else {
				map.put(c, 1);
			}
		}

		Iterator<Entry<Character, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Character, Integer> pair = iterator.next();
			System.out.println(String.format("Character \"%c\" appears %d times.", pair.getKey(), pair.getValue()));
		}
	}

	static void concatenateFirstStringWithReverseOfSecondString(String str1, String str2) {
		StringBuilder strBuilder1 = new StringBuilder(str1);
		StringBuilder strBuilder2 = new StringBuilder(str2);
		String result = strBuilder1.append(strBuilder2.reverse().toString()).toString();
		System.out.println(String.format("Concatenated string: %s", result));
	}

	static void splitStringIntoWords(String input) {
		if (input == null || input.isEmpty()) {
			System.out.println("The input string is null or empty. Please try again!");
			return;
		}
		System.out.println(String.format("Split \"%s\" into words:", input));
		String[] words = input.split(" ");
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}
	}

	static void printAllConcatenatedStrings(String str1, String str2) {
		System.out.println(String.format("All concatenated strings of \"%s\" and  \"%s\":", str1, str2));
		System.out.println(String.format("%s%s", str1, str2));
		System.out.println(String.format("%s%s", str2, str1));
	}

	static void printAllPermutation(String input, String prefix) {
		int n = input.length();
		if (n == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				printAllPermutation(input.substring(0, i) + input.substring(i + 1, n), prefix + input.charAt(i));
			}
		}
	}

	static void removeAllDuplicateWordsInAString(String input) {
		System.out.println(String.format("Original string: \"%s\"", input));
		String[] words = input.split("\\s+");

		LinkedHashSet<String> lhSetWords = new LinkedHashSet<String>(Arrays.asList(words));

		// join the words again by space
		StringBuilder sbTemp = new StringBuilder();
		int index = 0;

		for (String s : lhSetWords) {
			if (index > 0) {
				sbTemp.append(" ");
			}

			sbTemp.append(s);
			index++;
		}

		System.out.println(String.format("String after removing duplicate words: %s", sbTemp.toString()));
	}
	
	static void reverseAllCharactersBetween2Characters(String input, char firstCharacter, char secondCharacter) {
		System.out.println(String.format("Reverse all characters in \"%s\" between \'%c\' and \'%c\'", input, firstCharacter, secondCharacter));
		if (input == null || input.isEmpty()) {
			System.out.println("The input string is null or empty. Please try again!");
			return;
		}
		
		int firstIndex = input.indexOf(firstCharacter);
		int secondIndex = input.indexOf(secondCharacter);
		if (firstIndex < 0) {
			System.out.println(String.format("String \"%s\" does not contain \"%c\"", input, firstCharacter));
			return;
		}
		
		if (secondIndex < 0) {
			System.out.println(String.format("String \"%s\" does not contain \"%c\"", input, secondCharacter));
			return;
		}
		
		String subString = input.substring(firstIndex, secondIndex);
		String reversedString = new StringBuilder(subString).reverse().toString();
		
		String output = input.replace(subString, reversedString);
		System.out.println(String.format("Output: %s", output));
	}
	
	static void reverseContentOfAFile(String fileName) {
		System.out.println(String.format("Reverse content of %s", fileName));
		StringBuilder strBuilder = new StringBuilder();
		try {
			File file = new File(System.getProperty("user.dir") + "/src/" + fileName);
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				strBuilder.append(data);
				strBuilder.append("\n");
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("The content after reversing:");
		System.out.println(strBuilder.reverse());
	}
}
