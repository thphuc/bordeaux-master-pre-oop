package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hainm2 Implement the exercises for Day4
 */
public class Day4 {

	public static void compareArrayvsLinkedList() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		// ArrayList add
		long startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			arrayList.add(i);
		}
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("ArrayList add:  " + duration);
		// LinkedList add
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			linkedList.add(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList add: " + duration);
		// ArrayList get
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			arrayList.get(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList get:  " + duration);
		// LinkedList get
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			linkedList.get(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList get: " + duration);
		// ArrayList remove
		startTime = System.nanoTime();
		for (int i = 9999; i >= 0; i--) {
			arrayList.remove(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList remove:  " + duration);
		// LinkedList remove
		startTime = System.nanoTime();
		for (int i = 9999; i >= 0; i--) {
			linkedList.remove(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList remove: " + duration);
	}
	
	/**
	 * Read file and return the List of words 
	 * 
	 * @param fileName
	 */
	public static List<String> readFileString(String fileName) {
		List<String> result = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			
			while ((line = br.readLine()) != null) {
				result.addAll(Arrays.asList(line.split(" ")));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * Print the content of array
	 * @param arr
	 */
	public static void ex1(List<String> arr) {
		System.out.println("Content:");
		for(String s: arr) 
			System.out.print(s + " ");
		System.out.println();
	}
	
	/**
	 * Print the content of array in reverse order
	 * @param arr
	 */
	public static void ex2(List<String> arr) {
		System.out.println("Content:");
		int size = arr.size();
		for(int i = size-1; i >= 0; i--) 
			System.out.print(arr.get(i) + " ");
		System.out.println();
	}
	
	/**
	 * Print the all words ending in 
	 * @param arr
	 */
	public static void ex3(List<String> arr) {
		System.out.println("Content:");
		int size = arr.size();
		for(int i = size-1; i >= 0; i--) 
			System.out.print(arr.get(i) + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("[+] Compare the performance between ArrayList and LinkedList");
		Day4.compareArrayvsLinkedList();
		String fileName = "data/test.txt";
		List<String> arr = readFileString(fileName);
		System.out.println("[+] Ex1: Print the content of file");
		Day4.ex1(arr);
		System.out.println("[+] Ex2: Print in reverse order");
		Day4.ex2(arr);
	}

}
