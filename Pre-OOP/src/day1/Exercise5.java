package day1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

/**
 * @author hainm2
 * Convert from integer to hex and binary presentation.
 */
public class Exercise5 {
	public static byte[] shortTo2Bytes(int i) {
		return new byte[] { (byte) ((i >>> 0) & 255), (byte) ((i >>> 8) & 255) };
	}

	public static byte[] intTo4Bytes(int i) {
		return new byte[] { (byte) ((i >>> 0) & 255), (byte) ((i >>> 8) & 255), (byte) ((i >>> 16) & 255),
				(byte) ((i >>> 24) & 255) };
	}

	public static byte[] longTo8Bytes(long j) {
		return new byte[] { (byte) ((int) ((j >>> 0) & 255)), (byte) ((int) ((j >>> 8) & 255)),
				(byte) ((int) ((j >>> 16) & 255)), (byte) ((int) ((j >>> 24) & 255)), (byte) ((int) ((j >>> 32) & 255)),
				(byte) ((int) ((j >>> 40) & 255)), (byte) ((int) ((j >>> 48) & 255)),
				(byte) ((int) ((j >>> 56) & 255)) };
	}

	public static void printCurrentDate() {
		final Date currentTime = new Date();

		final SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy hh:mm:ss a z");

		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		System.out.println("GMT time: " + sdf.format(currentTime));
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int num;
		String number = "";
		while (true) {
			number = input.next();
			try {
				num = Integer.parseInt(number);
				break;
			} catch (Exception e) {
				System.out.println("Re-enter the Number: ");
			}
		}

		System.out.println("Binary: " + String.format("%32s", Integer.toBinaryString(num)).replaceAll(" ", "0"));
		System.out.print("Hex: " + Integer.toHexString(num));

		input.close();
		printCurrentDate();
	}

}
