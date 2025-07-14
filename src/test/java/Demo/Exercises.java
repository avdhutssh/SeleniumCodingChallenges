package Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.print.attribute.standard.MediaSize.Other;

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

//		_04_Scanner();

		System.out.println("-----------------------------------------");

		_05_FahrenheitCelsius();

		System.out.println("-----------------------------------------");

		_06_factorial(5); // 120

		System.out.println("-----------------------------------------");

		int[] numbers = new int[] { 1, 2, 5, 6, 7, 3 };
		_07_missingNumber(numbers); // 4

		System.out.println("-----------------------------------------");

		int[] array1 = { 1, 3, 5 };
		int[] array2 = { 2, 4, 5, 6, 3 };
		_08_HT_CommonElementsInArray(array1, array2); // 3,5

		System.out.println("-----------------------------------------");

		int[] nums = { 1, 2, 3, 2, 1, 4, 5, 4, 3 };
		_09_HashSeT_findDuplicatesInArray(nums); // 2 1 4 3

		System.out.println("-----------------------------------------");

		System.out.println("-----------------------------------------");

		System.out.println(_11_HashMap_firstNonRepeatingChar("leetcode")); // l
		System.out.println(_11_HashMap_firstNonRepeatingChar("hello")); // h
		System.out.println(_11_HashMap_firstNonRepeatingChar("aabbcc")); // null

		System.out.println("-----------------------------------------");

		System.out.println(_12_Using_Hashmap_groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
		// [[eat, tea, ate], [tan, nat], [bat]]
		System.out.println(_12_Using_Hashmap_groupAnagrams(new String[] { "abc", "cba", "bac", "foo", "bar" }));
		// [[abc, cba, bac], [foo], [bar]]
		System.out.println(_12_Using_Hashmap_groupAnagrams(
				new String[] { "listen", "silent", "triangle", "integral", "garden", "ranged" }));
		// [[listen, silent], [triangle, integral], [garden, ranged]]

		System.out.println("-----------------------------------------");

		System.out.println(
				Arrays.toString(_13_HashMap_indicesOfTwoNumbersThatGivesTarget(new int[] { 2, 7, 11, 15 }, 9)));
// [0, 1]
		System.out.println(Arrays.toString(_13_HashMap_indicesOfTwoNumbersThatGivesTarget(new int[] { 3, 2, 4 }, 6)));
// [1, 2]
		System.out.println(Arrays.toString(_13_HashMap_indicesOfTwoNumbersThatGivesTarget(new int[] { 3, 3 }, 6)));
// [0, 1]
		System.out.println(
				Arrays.toString(_13_HashMap_indicesOfTwoNumbersThatGivesTarget(new int[] { 1, 2, 3, 4, 5 }, 10)));
// []
		System.out.println(
				Arrays.toString(_13_HashMap_indicesOfTwoNumbersThatGivesTarget(new int[] { 1, 2, 3, 4, 5 }, 7)));
// [2, 3]
		System.out.println(
				Arrays.toString(_13_HashMap_indicesOfTwoNumbersThatGivesTarget(new int[] { 1, 2, 3, 4, 5 }, 3)));
// [0, 1]
		System.out.println(Arrays.toString(_13_HashMap_indicesOfTwoNumbersThatGivesTarget(new int[] {}, 0)));
// []

		System.out.println("-----------------------------------------");

		System.out.println("-----------------------------------------");

		System.out.println("-----------------------------------------");

		System.out.println("-----------------------------------------");

		System.out.println("-----------------------------------------");

		System.out.println("-----------------------------------------");

		System.out.println("-----------------------------------------");

		System.out.println("-----------------------------------------");

		System.out.println("-----------------------------------------");

		System.out.println("-----------------------------------------");
	}

	private static int[] _13_HashMap_indicesOfTwoNumbersThatGivesTarget(int[] arr, int target) {

		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int otherNum = target - arr[i];
			if (hm.containsKey(otherNum)) {
				return new int[] { hm.get(otherNum), i };
			}
			hm.put(arr[i], i);
		}
		return new int[] {};
	}

	private static ArrayList<List<String>> _12_Using_Hashmap_groupAnagrams(String[] strArr) {

		HashMap<String, List<String>> anagramGroup = new HashMap<>();
		for (String str : strArr) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String sortedStr = new String(chars);
			if (anagramGroup.containsKey(sortedStr)) {
				anagramGroup.get(sortedStr).add(str);
			} else {
				List<String> group = new ArrayList<>();
				group.add(str);
				anagramGroup.put(sortedStr, group);
			}
		}
		return new ArrayList<List<String>>(anagramGroup.values());
	}

	private static Character _11_HashMap_firstNonRepeatingChar(String str) {

		HashMap<Character, Integer> hm = new HashMap<>();
		for (char ch : str.toCharArray()) {
			hm.put(ch, hm.getOrDefault(ch, 0) + 1);
		}
		for (char ch : str.toCharArray()) {
			if (hm.get(ch) == 1) {
				return ch;
			}
		}
		return null;
	}

	private static void _09_HashSeT_findDuplicatesInArray(int[] nums) {

		Set<Integer> hs = new HashSet<>();
		for (int num : nums) {
			if (!hs.add(num))
				System.out.print(num + " ");
		}
		System.out.println();
	}

	private static void _08_HT_CommonElementsInArray(int[] arr1, int[] arr2) {

		if (arr2.length > arr1.length) {
			int[] temp = arr1;
			arr1 = arr2;
			arr2 = temp;
		}

		Map<Integer, Boolean> hm = new HashMap<>();
		for (int num : arr1) {
			hm.put(num, true);
		}

		for (int num : arr2) {
			if (hm.containsKey(num)) {
				System.out.print(num + " ");
			}
		}
		System.out.println();
	}

	private static void _07_missingNumber(int[] arr) {
		// TODO Auto-generated method stub
		int totalNum = arr.length + 1;
		int totalSum = totalNum * ((totalNum + 1) / 2);
		int actualSum = 0;
		for (int num : arr) {
			actualSum += num;
		}
		System.out.println(totalSum - actualSum);
	}

	private static void _06_factorial(int num) {
		// Time complexity: O(n)
		// Space complexity: O(1)
		int k = 1;
		int factorial = 1;
		while (k <= num) {
			factorial *= k;
			k++;
		}
		System.out.println(factorial);

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
