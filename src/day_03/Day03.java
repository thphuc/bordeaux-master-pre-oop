package day_03;

import java.util.ArrayList;

public class Day03 {
    public static void main(String[] args) {
        /*
         * Exercise 1. With an array of integers in any order and a number k, find the k
         * largest elements in this array.
         */
        System.out.println("----------- START EXERCISE 1 ---------");
        int[] arr = new int[]{1, 19, 6, 8, 100, 30, 88, 20, 14, 22};
        int k = 3;
        printKLargestNumbersOfAnArry(arr, k);
        System.out.println("----------- END EXERCISE 1 ---------\n\n");

        /*
         * Exercise 2. With an array of integers in any order, sort this array using
         * Selection Short, Quick Short and Merge Short.
         */
        System.out.println("----------- START EXERCISE 2 ---------");
        testExercise2();
        System.out.println("----------- END EXERCISE 2 ---------\n\n");

        /*
         * Exercise 3. With an array of integers in any order and a number k, find all
         * the continuous subarrays in the given array whose sum equals to an given
         * integer. Expected Output: Original Array: [4, 2, 3, 3, 7, 2, 4] Value of k: 6
         * Total number of continuous subarrays: [4, 2] [3, 3] [2, 4]
         *
         */
        System.out.println("----------- START EXERCISE 3  ---------");
        int[] ex3Arr = new int[]{4, 2, 3, 3, 7, 2, 4, 1, 1, 2, 2};
        int ex3K = 6;
        System.out.print("Original array: ");
        printArray(ex3Arr);
        System.out.println("Find continuous subarrays have sum equal " + ex3K);
        findAllContinousSubArraysWithSum(ex3Arr, ex3K);
        System.out.println("----------- END EXERCISE 3 ---------\n\n");

        /*
         * Exercise 5. With two arrays of integers in any order, check if one array is
         * the subarray of the other.
         */
        System.out.println("----------- START EXERCISE 5 ---------");
        int[] ex5Arr = {1, 3, 5, 7, 9, 10, 12, 14, 16};
        int[] ex5SubArr1 = {9, 10, 12};
        int[] ex5SubArr2 = {9, 10, 12, 13};
        System.out.println("Main (ex5Arr) array:");
        printArray(ex5Arr);
        System.out.println("First array (ex5SubArr1) to test:");
        printArray(ex5SubArr1);

        if (isSubArray(ex5Arr, ex5SubArr1)) {
            System.out.println("ex5SubArr1 is a sub-array");
        } else {
            System.out.println("ex5SubArr1 is not a sub-array");
        }

        System.out.println("Second array (ex5SubArr2) to test:");
        printArray(ex5SubArr2);
        if (isSubArray(ex5Arr, ex5SubArr2)) {
            System.out.println("ex5SubArr2 is a sub-array");
        } else {
            System.out.println("ex5SubArr2 is not a sub-array");
        }
        System.out.println("----------- END EXERCISE 5 ---------\n\n");

        /*
         * Exercise 6. With two arrays of integers in any order, find the longest
         * duplicate subarray between these arrays.
         */
        System.out.println("----------- START EXERCISE 6 ---------");
        System.out.println("Find the longest duplicate subarray between 2 arrays!");
        System.out.println("----------- END EXERCISE 6 ---------\n\n");

        /*
         * Exercise 7. With an arrays of integers, remove all the duplicate values in
         * this arrays.
         */
        System.out.println("----------- START EXERCISE 7 ---------");
        System.out.println("Remove all duplicated values in an array");
        int[] ex7Arr1 = new int[]{1, 2, 4, 14, 4, 11, 9, 11, 24};
        System.out.println("Original array:");
        printArray(ex7Arr1);
        removeAllDuplicatedValuesInAnArray(ex7Arr1);
        System.out.println("----------- END EXERCISE 7 ---------\n\n");

        /*
         * Exercise 8. With two arrays of integers in any order, concatenate these two
         * arrays in accending orders.
         */
        System.out.println("----------- START EXERCISE 8 ---------");
        System.out.println("Concatenate 2 arrays in accending orders.");
        int[] ex8Arr1 = new int[]{1, 2, 4, 14, 9, 11, 24};
        int[] ex8Arr2 = new int[]{14, 8, 9, 12, 14, 18, 20};
        System.out.println("First array:");
        printArray(ex8Arr1);
        System.out.println("Second array:");
        printArray(ex8Arr2);
        concatenateAndSort2Arrays(ex8Arr1, ex8Arr2);
        System.out.println("----------- END EXERCISE 8 ---------\n\n");

        /*
         * Exercise 9. With two arrays of integers, list all the values in the first
         * array which are not in the second array.
         */
        System.out.println("----------- START EXERCISE 9 ---------");
        int[] ex9Arr1 = new int[]{1, 2, 4, 14, 9, 11, 24, 55};
        int[] ex9Arr2 = new int[]{14, 8, 9, 12, 14, 18, 20};
        System.out.println("First array:");
        printArray(ex9Arr1);
        System.out.println("Second array:");
        printArray(ex9Arr2);
        System.out.println("Print all values in the first array which are not in the second array:");
        printAllValuesInFirstArrButNotInSecondArr(ex9Arr1, ex9Arr2);
        System.out.println("----------- END EXERCISE 9 ---------\n\n");
    }

    private static void printKLargestNumbersOfAnArry(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            System.out.println("Invalid input!");
            return;
        }
        System.out.println("Print k largest element in integers array!");
        System.out.print("Original array: ");
        printArray(arr);
        selectionSort(arr);
        System.out.print(String.format("%d largest numbers: ", k));
        printKElementsInArray(arr, 0, k);
    }

    private static void testExercise2() {
        int[] arr = new int[]{1, 19, 6, 8, 100, 30, 88, 20, 14, 22};

        // Selection sort
        System.out.println("SELECTION SORT");
        System.out.print("Original array: ");
        printArray(arr);
        System.out.print("After sorting: ");
        selectionSort(arr);
        printArray(arr);
        System.out.println("\n**************\n");

        // Quick sort
        arr = new int[]{1, 23, 6, 45, 100, 30, 99, 20, 55, 22};
        System.out.println("QUICK SORT");
        System.out.print("Original array: ");
        printArray(arr);
        System.out.print("After sorting: ");
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
        System.out.println("\n**************\n");

        // Quick sort
        arr = new int[]{1, 23, 57, 43, 30, 99, 20, 98, 22, 35};
        System.out.println("MERGE SORT");
        System.out.print("Original array: ");
        printArray(arr);
        System.out.print("After sorting: ");
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("");
    }

    private static void printKElementsInArray(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print(arr[arr.length - i - 1]);
            if (i < end - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("");
    }

    private static void selectionSort(int[] input) {
        int inputLength = input.length;

        for (int i = 0; i < inputLength - 1; i++) {
            int min = i;

            for (int j = i + 1; j < inputLength; j++) {
                if (input[j] < input[min]) {
                    min = j;
                }
            }

            int temp = input[i];
            input[i] = input[min];
            input[min] = temp;
        }

    }

    public static void quickSort(int[] arr, int start, int end) {
        int partition = partition(arr, start, end);

        if (partition - 1 > start) {
            quickSort(arr, start, partition - 1);
        }
        if (partition + 1 < end) {
            quickSort(arr, partition + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
            }
        }

        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }

    private static void mergeSort(int[] input, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(input, start, mid);
            mergeSort(input, mid + 1, end);
        }

        int i = 0, first = start, last = mid + 1;
        int[] tmp = new int[end - start + 1];

        while (first <= mid && last <= end) {
            tmp[i++] = input[first] < input[last] ? input[first++] : input[last++];
        }
        while (first <= mid) {
            tmp[i++] = input[first++];
        }
        while (last <= end) {
            tmp[i++] = input[last++];
        }
        i = 0;
        while (start <= end) {
            input[start++] = tmp[i++];
        }
    }

    private static void findAllContinousSubArraysWithSum(int[] arr, int sum) {
        if (arr == null) {
            System.out.println("Invalid input!");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == sum) {
                System.out.println(String.format("[%d]", arr[i]));
            } else if (arr[i] < sum) {
                ArrayList<String> strArr = new ArrayList<String>();
                strArr.add("" + arr[i]);
                int newSum = arr[i];
                boolean found = false;
                for (int j = i + 1; j < arr.length; j++) {
                    newSum += arr[j];
                    if (newSum < sum) {
                        strArr.add("" + arr[j]);
                    } else if (newSum == sum) {
                        found = true;
                        strArr.add("" + arr[j]);
                        break;
                    } else {
                        break;
                    }
                }

                if (found) {
                    System.out.print("[");
                    for (int k = 0; k < strArr.size(); k++) {
                        System.out.print(strArr.get(k));
                        if (k < strArr.size() - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println("]");
                }
            }
        }
    }

    static void removeAllDuplicatedValuesInAnArray(int[] arr) {
        int result[] = new int[arr.length];
        int j = 0;
        ArrayList<String> strResult = new ArrayList<String>();
        for (int i : arr) {
            if (!isInArray(result, i)) {
                result[j++] = i;
                strResult.add("" + i);
            }
        }

        // Print result
        System.out.println("Array after removing all duplicated values:");
        System.out.print("[");
        for (String s : strResult) {
            System.out.print(s);
            System.out.print(", ");
        }
        System.out.print("]\n");
    }

    static void concatenateAndSort2Arrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }
        for (int j = 0; j < arr2.length; j++) {
            result[arr1.length + j] = arr2[j];
        }

        selectionSort(result);

        System.out.println("After concatenating and sorting:");

        printArray(result);
    }

    /**
     * Check if an element is in an array or not
     *
     * @param arr
     * @param value
     * @return
     */
    static boolean isInArray(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }

        return false;
    }

    static void printAllValuesInFirstArrButNotInSecondArr(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (!isInArray(arr2, arr1[i])) {
                System.out.println(arr1[i]);
            }
        }
    }

    static boolean isSubArray(int[] mainArr, int[] subArr) {
        if (subArr.length > mainArr.length) {
            return false;
        }

        selectionSort(mainArr);
        selectionSort(subArr);

        for (int i = 0; i < mainArr.length; i++) {
            if (mainArr[i] == subArr[0]) {
                int k = 0;
                boolean found = false;
                for (int j = i; j < i + subArr.length; j++) {
                    if (mainArr[i] != subArr[k++]) {
                        break;
                    }
                }
                if (k == subArr.length - 1) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
