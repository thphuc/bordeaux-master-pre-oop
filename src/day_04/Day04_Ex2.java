package day_04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day04_Ex2 {
    public static void main(String[] args) {
        System.out.println("----------- START EXERCISE 2 ---------");
        List<Integer> numbers = readFileContentAsList("numbers.txt");

        System.out.println("*** a. Prints the max, min, average of the numbers. ***");
        printMaxMinAverage(numbers);

        System.out.println("\n\n*** b. Sort all this number using InsertionSort, BubbleSort and HeapSort ***");
        sort(numbers);

        System.out.println("\n\n*** c. Find all prime numbers ***");
        findAllPrimeNumbers(numbers);

        System.out.println("\n\n*** d. Find all Fibonacci numbers ***");
        findAllFibonacciNumbers(numbers);

        System.out.println("\n\n*** e. Remove all duplicated values and print the rest ***");
        removeAllDuplicatedValues(numbers);
//
//        System.out.println("\n\n*** c. Print all words ending with \"s\" ***");
//        printAllWordsEndingWithS(fileContents);
//
//        System.out.println("\n\n*** d. Remove all duplicate words and print the rest ***");
//        removeAllDuplicatedWordsAndPrintTheRest(fileContents);
//
//        System.out.println("\n\n*** e. Find all the duplicated words ***");
//        findAllTheDuplicatedWords(fileContents);

        System.out.println("----------- END EXERCISE 2 ---------\n\n");
    }

    /**
     * Convert file content to list
     *
     * @param fileName
     * @return
     */
    static List<Integer> readFileContentAsList(String fileName) {
        List<Integer> numbers = new ArrayList<Integer>();
        try {
            File file = new File(System.getProperty("user.dir") + "/src/" + fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    if (isNumber(line)) {
                        numbers.add(Integer.parseInt(line));
                    }
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return numbers;
    }

    static void printAllNumbers(List<Integer> numbers) {
        if (numbers != null) {
            for (int i = 0; i < numbers.size(); i++) {
                System.out.print(numbers.get(i).toString());
                if (i < numbers.size() - 1) {
                    System.out.print(", ");
                } else {
                    System.out.println();
                }
            }
        }
    }

    /**
     * Check if a string is a number
     *
     * @param str
     * @return
     */
    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int findMaxNumber(List<Integer> numbers) {
        int max = numbers.get(0);

        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }

        return max;
    }

    private static int findMinNumber(List<Integer> numbers) {
        int min = numbers.get(0);

        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }

        return min;
    }

    private static double calculateAverage(List<Integer> numbers) {
        int total = 0;

        for (int number : numbers) {
            total += number;
        }

        return total * 1.0 / numbers.size();
    }

    private static void printMaxMinAverage(List<Integer> numbers) {
        System.out.println(String.format("Max number: %d", findMaxNumber(numbers)));
        System.out.println(String.format("Min number: %d", findMinNumber(numbers)));
        System.out.println(String.format("Average number: %f", calculateAverage(numbers)));
    }

    private static void swap2Numbers(List<Integer> numbers, int i, int j) {
        Collections.swap(numbers, i, j);
    }

    private static List<Integer> insertionSort(List<Integer> numbers) {
        List<Integer> newNumbers = new ArrayList<>();
        newNumbers.addAll(numbers);

        int size = newNumbers.size();
        for (int i = 1; i < size; i++) {
            int valueToSort = newNumbers.get(i);
            int j = i;
            while (j > 0 && newNumbers.get(j - 1) > valueToSort) {
                swap2Numbers(newNumbers, j, j - 1);
                j--;
            }
            newNumbers.set(j, valueToSort);
        }

        return newNumbers;
    }

    public static List<Integer> bubbleSort(List<Integer> numbers) {
        List<Integer> newNumbers = new ArrayList<>();
        newNumbers.addAll(numbers);

        int size = newNumbers.size();

        for (int i = 0; i < size; i++) {
            for (int j = 1; j < (size - i); j++) {
                if (newNumbers.get(j - 1) > newNumbers.get(j)) {
                    swap2Numbers(newNumbers, j, j - 1);
                }

            }
        }

        return newNumbers;
    }

    private static void sort(List<Integer> numbers) {
        System.out.println("Original numbers: ");
        printAllNumbers(numbers);
        System.out.println("After sort (Insertion Sort):");
        printAllNumbers(insertionSort(numbers));

        System.out.println("----- $$$$$ -----");

        System.out.println("Original numbers: ");
        printAllNumbers(numbers);
        System.out.println("After sort (Bubble Sort):");
        printAllNumbers(bubbleSort(numbers));

        System.out.println("----- $$$$$ -----");

        System.out.println("Original numbers: ");
        printAllNumbers(numbers);
        System.out.println("After sort (Heap Sort): NOT IMPLEMENTED YET");
        //printAllNumbers(bubbleSort(numbers));
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

    static void findAllPrimeNumbers(List<Integer> numbers) {
        List<Integer> primeNumbers = new ArrayList<Integer>();
        for (int number : numbers) {
            if (isPrimeNumber(number)) {
                primeNumbers.add(number);
            }
        }

        printAllNumbers(primeNumbers);
    }

    static boolean isFibonacciNumber(int number) {
        int firstNumber = 0, secondNumber = 1, fibonacciNumber = 0;
        // Find the fibonacci number who is less than and nearest the number we want to check
        while (fibonacciNumber < number) {
            fibonacciNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = fibonacciNumber;
        }

        if (number == fibonacciNumber) {
            return true;
        } else {
            return false;
        }
    }

    static void findAllFibonacciNumbers(List<Integer> numbers) {
        List<Integer> fibonacciNumbers = new ArrayList<Integer>();
        for (int number : numbers) {
            if (isFibonacciNumber(number)) {
                fibonacciNumbers.add(number);
            }
        }

        printAllNumbers(fibonacciNumbers);
    }

    static void removeAllDuplicatedValues(List<Integer> numbers) {
        List<Integer> newNumbers = new ArrayList<Integer>();
        List<Integer> removedNumbers = new ArrayList<Integer>();
        for (int number : numbers) {
            if (!newNumbers.contains(number)) {
                newNumbers.add(number);
            } else {
                removedNumbers.add(number);
            }
        }
        System.out.println("Original numbers:");
        printAllNumbers(numbers);
        System.out.println("Duplicated numbers:");
        printAllNumbers(removedNumbers);
        System.out.println("After removing duplicated numbers:");
        printAllNumbers(newNumbers);
    }
}
