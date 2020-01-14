package day3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author hainm2
 * Implement the exercise for Day 3
 */
public class Day3 {
	
	/**
	 * Find the k largest elements in this array
	 * @param array
	 * @param k
	 */
	public static void ex1_1(int[] array, int k) {
		System.out.print("\nOption 1 (Use Selection Short): ");
		// Use Selection Short 
		for (int i = 0; i < k; i++) {
			int maxIndex = 0;
			// Find the maximum element in unsorted array
			for (int j=i; j<array.length; j++) {
				if (array[maxIndex] < array[j]) {					
					maxIndex = j;				
				}
			}
			// Swap the found value with the first element
			int temp = array[maxIndex];
			array[maxIndex] = array[i];
			array[i] = temp;
			System.out.print(temp + " ");
		}
	}
	
	public static void ex1_2(int[] array, int k) {
		System.out.print("\nOption 2 (Use Bubble Short): ");
		// Use Bubble Short 
		for (int i = 0; i < k; i++) {
			int length = array.length;
			for (int j = 0; j < length-i-1; j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;									
				}
			}

			System.out.print(array[length - i - 1] + " ");
		}
	}
	
	public static void ex1_3(int[] array, int k) {
		System.out.print("\nOption 3 (Java Function): ");
		// Use Java function
		Arrays.sort(array);
		int length = array.length;
		for (int i = 0; i < k; i++) {
			System.out.print(array[length - i - 1] + " ");
		}
	}
	
	public static void ex1_4(int[] array, int k) {
		System.out.print("\nOption 4 (Use Max-Heap): ");
		// Use Max-Heap
		// Creating empty priority queue 
        PriorityQueue<Integer> pQueue =  
             new PriorityQueue<Integer>(Collections.reverseOrder()); 
  
        // Adding items to the pQueue using add()        
        for (int i: array) {
        	pQueue.add(i);
        }
        
        for (int i = 0; i < k; i++) {
			System.out.print(pQueue.remove() + " ");
		}
	} 
	
	public static void ex2_1(int[] array) {
		System.out.print("\nOption 1 (Use Selection Short): ");
		// Use Selection Short
		int length = array.length;
		for (int i=0; i<length; i++) {
			int maxVal = -Integer.MIN_VALUE, maxIndex = -1;
			// Find the maximum element in unsorted array
			for (int j=i; j<length; j++) {
				if (maxVal < array[j]) {
					maxVal = array[j];
					maxIndex = j;				
				}
			}
			// Swap the found value with the first element
			int temp = array[maxIndex];
			array[maxIndex] = array[i];
			array[i] = temp;
			System.out.print(temp + " ");
		}
	}
	
	public static void ex3_1(int[] array, int k) {
		System.out.print("\nOption 1 : ");
        int length = array.length;
        for (int i = 0; i < length; i++) {
        	int sum = 0;
        	for (int j = i ; j < length; j++) {
        		sum += array[j];
        		if (sum == k) {
        			System.out.print("[");
        			for (int temp = i; temp <j; temp++ ) {
        				System.out.print(array[temp] + ", ");
        			}
        			System.out.print(array[j] + "] ");
        		}
        	}
        }
	}
	
	public static void ex4_1(int[] array1, int[] array2) {
		if (array1.length > array2.length) {
        	compareSubArray(array1, array2);
        } else 
        	compareSubArray(array2, array1);
	}
	
	public static void ex5_1(int[] array1, int[] array2) {
		int length1 = array1.length;
        int length2 = array2.length;
        int maxLength = 0, startIndex = 0, endIndex = 0;
        
        for (int i = 0; i < length1; i++) {
        	for (int j = 0; j < length2; j++) {        		
        		if (array1[i] == array2[j]) {
        			int k = 1;
        			for (; k < (length1 - i) && k < (length2 - j); k++) {
        				if (array1[i + k] != array2[j + k])
        					break;
        			}
        			if (k > maxLength) {
        				maxLength = k; 
        				startIndex = i; 
        				endIndex = i + k - 1;
        			}        			
        		}        			
        	}
        }
        System.out.print("Arrays:[");
        for (int i = startIndex; i < endIndex; i++)
        	System.out.print(array1[i] + " ");
        System.out.print(array1[endIndex] + "]");
	}
	
	private static void compareSubArray(int[] array1, int[] array2) {
		int length1 = array1.length;
        int length2 = array2.length;
        
        for (int i = 0; i <= length1 - length2; i++) {
        	int temp = i;
        	for (int j = 0; j < length2; j++) {
        		if (array1[temp++] != array2[j])
        			break;
        		
        		if (j == (length2 - 1)) {
        			System.out.print("True\n");
        			return;
        		}
        	}     	
        }
        System.out.print("False\n");           
	}
	
	private static void ex6_1(int[] array) {
		System.out.print("\nOption 1 (Use Temporal Array): ");
		// Use Selection Short
		int length = array.length;
		int[] tempArr = new int[length];
		int curIndex = 0;
		boolean isWrite = false; 
		for (int i = 0; i < length; i++) {
			isWrite = true;
			for (int j = 0; j < curIndex; j++) {
				if (array[i] == tempArr[j]) {
					isWrite = false;
					break;
				}
			}
			if (isWrite) {
				tempArr[curIndex] = array[i];
				curIndex ++;	
			}
		}
		
		for (int i=0; i<curIndex; i++) {
			System.out.print(tempArr[i] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5; 
		int[] arr1 = {1, 2, 19, 3, -192, 17, 18, -65, 8712, 9823, 176251, 77, 9823};
		System.out.println("[*] Exercise 1: ");
		System.out.print("The " + n + " largest elements in the array : ");
		Day3.ex1_1(arr1, n);
		Day3.ex1_2(arr1, n);
		Day3.ex1_3(arr1, n);
		Day3.ex1_4(arr1, n);
		
		System.out.println("\n\n[*] Exercise 2: ");
		System.out.print("Sorting the array : ");
		Day3.ex2_1(arr1);
		
		int[] arr3 = {4, 2, 3, 3, 7, 2, 4, -10, 20, -4};
		n = 6;
		System.out.println("\n\n[*] Exercise 3: ");
		System.out.print("The continous array whose sum equals to " + n + " is: ");
		Day3.ex3_1(arr3, n);
		
		int[] arr4_1 = {1, 2, 5, 6, 7, 9, 2};
		int[] arr4_2 = {6, 7, 9, 2};
		System.out.println("\n\n[*] Exercise 4: ");
		System.out.print("Check SubArrays: ");
		Day3.ex4_1(arr4_1, arr4_2);
		
		int[] arr5_1 = {1, 2, 5, 6, 7, 9, 2, 4, 1};
		int[] arr5_2 = {6, 7, 9, 2, 4, 1, 3, 8};
		System.out.println("\n[*] Exercise 5: ");
		System.out.print("Find the longest duplicate subarrays: ");
		Day3.ex5_1(arr5_1, arr5_2);
		
		int[] arr6_1 = {1, 2, 5, 6, 7, 9, 2, 4, 1};		
		System.out.println("\n[*] Exercise 6: ");
		System.out.print("Remove duplicate values: ");
		Day3.ex6_1(arr6_1);
	}
}
