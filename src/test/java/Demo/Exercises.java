package Demo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercises {

	public static void main(String[] args) {
		System.out.println(_01_multiply(5, 10)); // 50

		System.out.println("-----------------------------------------");

		int[] arr1 = { 1, 4, 8, 15, 17 };
		System.out.println(_02_MaxDiffBetweenAdjacentElementsInArr(arr1)); // 7

		System.out.println("-----------------------------------------");

		int[] a = { 1, 4, 5, 7 };
		int[] b = { 6, 4, 3, 7 };
		_03_compareArrayAndFindCommon(a, b); // 4 7

		System.out.println("-----------------------------------------");

		_04_Scanner();
		
		System.out.println("-----------------------------------------");

		System.out.println("-----------------------------------------");

		System.out.println("-----------------------------------------");

		System.out.println("-----------------------------------------");

		System.out.println("-----------------------------------------");

		System.out.println("-----------------------------------------");

		System.out.println("-----------------------------------------");
	}

	private static void _04_Scanner() {
		
		int a;
		float b;
		String c;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Intger");
		a = sc.nextInt();
		System.out.println("integer entered is: " + a);

		System.out.println("Enter float");
		b = sc.nextFloat();
		System.out.println("float entered is: " + b);

		System.out.println("Enter string");
		c = sc.next();
		System.out.println("string entered is: " + c);
		
	}

	private static void _03_compareArrayAndFindCommon(int[] a, int[] b) {
		// Time complexity: O(n)
		// Space complexity: O(n)
		Set hs = new HashSet<>();
		for (int num : a) {
			hs.add(num);
		}
		for (int num : b) {
			if (!hs.add(num)) {
				System.out.print(num + " ");
			}
		}
		System.out.println();
	}

	private static int _02_MaxDiffBetweenAdjacentElementsInArr(int[] arr) {
		// Time complexity: O(n)
		// Space complexity: O(1)
		int maxDiff = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			int diff = arr[i + 1] - arr[i];
			maxDiff = Math.max(maxDiff, diff);

		}
		return maxDiff;
	}

	private static int _01_multiply(int num1, int num2) {
		// Time complexity: O(num2)
		// Space complexity: O(1)
		int sum = 0;
		for (int i = 1; i <= num2; i++) {
			sum += num1;
		}
		return sum;
	}

}
