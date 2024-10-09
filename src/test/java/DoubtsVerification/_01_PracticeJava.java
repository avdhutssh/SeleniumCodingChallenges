package DoubtsVerification;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class _01_PracticeJava {

	public static void main(String[] args) {
//		System.out.println(_01_multiply(5, 10)); // 50

//		int[] arr1 = { 1, 4, 8, 15, 17 };
//		System.out.println(_02_MaxDiffBetweenAdjacentElementsInArr(arr1)); // 7

//		int[] a = { 1, 4, 5, 7 };
//		int[] b = { 6, 4, 3, 7 };
//		_03_compareArrayAndFindCommon(a, b);  // 4 7

//		_04_Scanner();

//		_05_FahrenheitCelsius();

//		_06_factorial(5); // 120

//		int[] numbers = new int[] { 1, 2, 5, 6, 7, 3 };
//		_07_missingNumber(numbers); // 4

//		int[] array1 = { 1, 3, 5 };
//		int[] array2 = { 2, 4, 5, 6, 3 };
//		_08_HT_CommonElementsInArray(array1, array2);

		int[] nums = { 1, 2, 3, 2, 1, 4, 5, 4, 3 };
//		_09_HashSeT_findDuplicatesInArray(nums); // 2 1 4 3

		_10_HashMap_findDuplicatesInArray(nums); // 2 1 4 3
	}

	private static void _10_HashMap_findDuplicatesInArray(int[] nums) {
		// Time complexity: O(n)
		// Space complexity: O(n)
		Map<Integer, Integer> hm = new HashMap<>();
		for (int num : nums) {
			hm.put(num, hm.getOrDefault(num, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.print(entry.getKey() + " ");
			}
		}

	}

	private static void _09_HashSeT_findDuplicatesInArray(int[] nums) {
		// Time complexity: O(n)
		// Space complexity: O(n)
		Set<Integer> hs = new HashSet<>();
		for (int num : nums) {
			if (!hs.add(num)) {
				System.out.print(num + " ");
			}
		}

	}

	private static void _08_HT_CommonElementsInArray(int[] arr1, int[] arr2) {
		// Time complexity: O(n+m)
		// Space complexity: O(n)
		if (arr2.length > arr1.length) {
			int[] temp = arr2;
			arr2 = arr1;
			arr1 = temp;
		}

		HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
		for (int num : arr1) {
			hm.put(num, true);
		}

		for (int num : arr2) {
			if (hm.containsKey(num)) {
				System.out.println(num);
			}
		}

	}

	private static void _07_missingNumber(int[] arr) {
		// Time complexity: O(n)
		// Space complexity: O(1)
		int totalNum = arr.length + 1;
		int totalSum = totalNum * ((totalNum + 1) / 2);
		int actualSum = 0;
		for (int num : arr) {
			actualSum += num;
		}
		System.out.println("Missing Number is: " + (totalSum - actualSum));
	}

	private static void _06_factorial(int num) {
		int result = 1;
		for (int i = 1; i <= num; i++) {
			result *= i;
		}
		System.out.println(result);
	}

	private static void _05_FahrenheitCelsius() {
		float c;
		float f = 272;

		c = (f - 32) * 5 / 9;
		System.out.println("Temperatue in Celsius = " + c);

	}

	private static void _04_Scanner() {
		int a;
		float b;
		String c;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter integer");
		a = sc.nextInt();
		System.out.println("integer entered is: " + a);

		System.out.println("Enter float");
		b = sc.nextFloat();
		System.out.println("float entered is: " + b);

		System.out.println("Enter string");
		c = sc.next();
		System.out.println("string entered is: " + c);
	}

	public static void _03_compareArrayAndFindCommon(int[] a, int[] b) {

		for (int i = 0; i < a.length; i++) {
			if (a[i] == b[i])
				System.out.print(a[i] + " ");
		}
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

	private static int _01_multiply(int i, int j) {
		// Time complexity: O(j)
		// Space complexity: O(1)
		int sum = 0;
		int k = 1;
		while (k <= j) {
			sum += i;
			k++;
		}

		return sum;
	}

}
