package day_04;

import java.util.ArrayList;
import java.util.List;

public class Day04_Ex3 {
    public static void main(String[] args) {
        System.out.println("----------- START EXERCISE 3 ---------");
        System.out.println("*** With two array lists of integers (not sorted) as input,\n " +
                "returns a new list that contains only the duplicate elements both lists.\n" +
                "Example:\n" +
                "With two list [1, 4, 8, 9, 11, 15, 17, 28, 41, 59] " +
                "[4, 7, 11, 17, 19, 20, 23, 28, 37, 59, 81]\n " +
                "The returned list: [4, 11, 17, 28, 59] ***");
        int[] arr1 = {1, 4, 8, 9, 11, 15, 17, 28, 41, 59};
        int[] arr2 = {4, 7, 11, 17, 19, 20, 23, 28, 37, 59, 81};

        findDuplicatedElements(arr1, arr2);

        System.out.println("----------- END EXERCISE 3 ---------\n\n");
    }

    private static void findDuplicatedElements(int[] arr1, int[] arr2) {
        List<Integer> duplicatedNumbers = new ArrayList<Integer>();

        for (int i = 0; i < arr1.length; i++) {
            if (isContainedIn(arr2, arr1[i])) {
                duplicatedNumbers.add(arr1[i]);
            }
        }

        printAllNumbers(duplicatedNumbers);
    }

    /**
     * Check if an array contain a number
     * @param arr
     * @param number
     * @return
     */
    private static boolean isContainedIn(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (number == arr[i]) {
                return true;
            }
        }

        return false;
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
}
