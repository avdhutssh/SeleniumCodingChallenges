package DoubtsVerification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

//		int[] nums = { 1, 2, 3, 2, 1, 4, 5, 4, 3 };
//		_09_HashSeT_findDuplicatesInArray(nums); // 2 1 4 3

//		_10_HashMap_findDuplicatesInArray(nums); // 2 1 4 3

//		System.out.println(_11_HashMap_firstNonRepeatingChar("leetcode")); // l
//		System.out.println(_11_HashMap_firstNonRepeatingChar("hello")); // h
//		System.out.println(_11_HashMap_firstNonRepeatingChar("aabbcc")); // null

//		System.out.println(_12_Using_Hashmap_groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
//		// [[eat, tea, ate], [tan, nat], [bat]]
//		System.out.println(_12_Using_Hashmap_groupAnagrams(new String[] { "abc", "cba", "bac", "foo", "bar" }));
//		// [[abc, cba, bac], [foo], [bar]]
//		System.out.println(_12_Using_Hashmap_groupAnagrams(
//				new String[] { "listen", "silent", "triangle", "integral", "garden", "ranged" }));
//		// [[listen, silent], [triangle, integral], [garden, ranged]]
//		System.out.println(
//				Arrays.toString(_13_HashMap_indicesOfTwoNumbersThatGivesTarget(new int[] { 2, 7, 11, 15 }, 9)));
//		// [0, 1]
//		System.out.println(Arrays.toString(_13_HashMap_indicesOfTwoNumbersThatGivesTarget(new int[] { 3, 2, 4 }, 6)));
//		// [1, 2]
//		System.out.println(Arrays.toString(_13_HashMap_indicesOfTwoNumbersThatGivesTarget(new int[] { 3, 3 }, 6)));
//		// [0, 1]
//		System.out.println(
//				Arrays.toString(_13_HashMap_indicesOfTwoNumbersThatGivesTarget(new int[] { 1, 2, 3, 4, 5 }, 10)));
//		// []
//		System.out.println(
//				Arrays.toString(_13_HashMap_indicesOfTwoNumbersThatGivesTarget(new int[] { 1, 2, 3, 4, 5 }, 7)));
//		// [2, 3]
//		System.out.println(
//				Arrays.toString(_13_HashMap_indicesOfTwoNumbersThatGivesTarget(new int[] { 1, 2, 3, 4, 5 }, 3)));
//		// [0, 1]
//		System.out.println(Arrays.toString(_13_HashMap_indicesOfTwoNumbersThatGivesTarget(new int[] {}, 0)));
//		// []

//		List<Integer> myList = List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5); // [1, 2, 3, 4, 5, 6, 7, 8, 9]
//		System.out.println(_14_Set_removeDuplicates(myList));

//		String str1 = "abcdefg"; // should return true
//		String str2 = "hello"; // should return false
//		String str3 = ""; // should return true
//		String str4 = "0123456789"; // should return true
//		String str5 = "abacadaeaf"; // should return false

//		System.out.println(_15_Set_hasUniqueChars(str1));
//		System.out.println(_15_Set_hasUniqueChars(str2));
//		System.out.println(_15_Set_hasUniqueChars(str3));
//		System.out.println(_15_Set_hasUniqueChars(str4));
//		System.out.println(_15_Set_hasUniqueChars(str5));

//		System.out.println(_16_Set_Stream_hasUniqueChars(str1));
//		System.out.println(_16_Set_Stream_hasUniqueChars(str2));
//		System.out.println(_16_Set_Stream_hasUniqueChars(str3));
//		System.out.println(_16_Set_Stream_hasUniqueChars(str4));
//		System.out.println(_16_Set_Stream_hasUniqueChars(str5));

//		int[] arr1 = { 1, 2, 3, 4, 5 };
//		int[] arr2 = { 2, 4, 6, 8, 10 };
//		int target = 7; // [5, 2] [3, 4] [1, 6]
//		List<int[]> pairs = _17_Set_findPairsFromTwoArrays(arr1, arr2, target);
//		printPairs(pairs);

//		int[] arr = { 10, 20, 20, 10, 10, 20, 5, 20 }; // 10 3 20 4 5 1
//		_18_frequencyOfEachElementArray(arr);

//		int[] arr = { 2, 10, 10, 100, 2, 10, 11, 2, 11, 2 }; // 2 10 11
//		_19_duplicateElementsArray(arr);

//		int[] arr = new int[] { 1, 2, 3, 4, 5 }; // 5, 4, 3, 2, 1
//		_20_ReverseArray_UsingStack(arr);
//		System.out.println("---------------------------");
//		_21_ReverseArrayUsing_Two_Pointer_Technique(arr);

//		int[] arr1 = new int[] { 5, 2, 8, 7, 1 }; // 1 2 5 7 8
//		_22_AscedingOrderArray_BubbleSort(arr1);

//		int[] arr2 = new int[] { 5, 2, 8, 7, 1 }; // 1 2 5 7 8
//		_23_AscedingOrderArray_MaxHeap(arr2);

//		int[] arr1 = { 2, 100, 10, 100, 2, 10, 11, 2, 11, 2 }; // 11
//		int[] arr2 = { 2, 100, 10, 50, 300 }; // 100
//
//		System.out.println(_24_secondLargestNumberArray(arr1));
//		System.out.println(_24_secondLargestNumberArray(arr2));

//		int[] arr1 = { 3, 100, 10, 100, 2, 10, 11, 2, 11, 2 }; // 3
//		int[] arr2 = { 500, 100, 10, 50, 300 }; // 50
//		System.out.println(_25_secondSmallestNumberArray_UsingHeap(arr1));
//		System.out.println(_25_secondSmallestNumberArray_UsingHeap(arr2));

//		System.out.println(_26_secondSmallestNumberArray_UsingTreeSet(arr1));
//		System.out.println(_26_secondSmallestNumberArray_UsingTreeSet(arr2));

//		_27_StringPoolConcept();

//		String str = "    India Is My Country";
//		System.out.println(_28_countNumberOfWordsInString_UsingSplitTrim(str));

//		System.out.println(_29_countNumberOfWordsInString_Tokenizer(str));

//		String str1 = "Madam"; // true
//		String str2 = "Avdhut"; // false
//		String str3 = "A man a plan a canal Panama";
//		_30_isPalindromeString_UsingBFA(str1);
//		_30_isPalindromeString_UsingBFA(str2);
//		_30_isPalindromeString_UsingBFA(str3);

//		String str = "Geeks"; // skeeG
//		System.out.println(_31_reverseString_UsingStack(str));

//		String str1 = "00000123569";// 123569
//		String str2 = "000012356090";// 12356090
//
//		_32_removeLeadingZeros_UsingSubString(str1);
//		_32_removeLeadingZeros_UsingSubString(str2);

//		String str1 = "1230456000";   //1230456
//		String str2 = "00001230456000";   //00001230456
//		
//		_33_removeTrailingZeros_UsingSubString(str1);
//		_33_removeTrailingZeros_UsingSubString(str2);

//		String str = "  geeks for geeks   "; // gfg
//		_34_firstLetterOfEachWordString(str);

//		String str1 = "abcdbeghef"; // 6
//		String str2 = "aaaaaaaaaaaaaaabbbbbbbbbbbbbbbbb"; // 2
//		String str3 = "eddy"; // 2
//		_35_longestSubstringWithoutRepeatingCharacters(str1);
//		_35_longestSubstringWithoutRepeatingCharacters(str2);
//		_35_longestSubstringWithoutRepeatingCharacters(str3);

//		System.out.println(_36_fibonacci_Series(5)); // 0,1,1,2,3

//		int num1 = 153;
//		int num2 = 1634;
//		int num3 = 5767;
//		System.out.println(_37_is_Armstrong_Number(num1));
//		System.out.println(_37_is_Armstrong_Number(num2));
//		System.out.println(_37_is_Armstrong_Number(num3));

//		int num1 = 456; // 654
//		int num2 = 899; // 998
//		System.out.println(_38_ReverseNumber(num1));
//		System.out.println(_38_ReverseNumber(num2));

//		int num1 = 2; // true
//		int num2 = 23; // true
//		int num3 = 55; // false
//		System.out.println(_39_isPrime(num1));
//		System.out.println(_39_isPrime(num2));
//		System.out.println(_39_isPrime(num3));

//		String str = "The best of both worlds"; // 19
//		System.out.println(_40_countNumber_Of_Characters_In_String_Using_BFA(str));
//		System.out.println(_41_countNumber_Of_Characters_In_String_Using_Stream(str));

//		String str = "Great responsibility "; // r e t s i
//		System.out.println(_42_duplicatesInString_UsingHashSet(str));

//		int num1 = 12;
//		int num2 = 24;
//		_43_swapTwoNumbers_Using_Temp_Variable(num1, num2);
//		_44_swapTwoNumbers_Without_Using_Temp_Variable(num1, num2);

//		char[] arr = { 'a', 'b', 'c', 'd', 'e' }; // e d c b a
//		System.out.println(Arrays.toString(_45_reverseArray_Using_Temp_Array(arr)));

//		char[] arr = { 'a', 'b', 'c', 'd', 'e' }; // e d c b a
//		System.out.println(Arrays.toString(_46_reverseArray_Using_Two_Pointer(arr)));

//		char[] arr = { 'a', 'b', 'c', 'd', 'e' }; // e d c b a
//		System.out.println(Arrays.toString(_47_reverseArray_Using_Stack(arr)));

//		String str1 = "AvdhutSatishShirgaonkar"; // 3
//		String str2 = "UnderTaker Dead$%Man"; // 4
//
//		System.out.println("Using BFA: " + _48_countCapitalizedWordsInString_BFA(str1));
//		System.out.println("Using BFA: " + _48_countCapitalizedWordsInString_BFA(str2));
//
//		System.out.println("Using RegX: " + _49_countCapitalizedWordsInString_RegX(str1));
//		System.out.println("Using RegX: " + _49_countCapitalizedWordsInString_RegX(str2));
//		
//		System.out.println("Using Stream: " + _50_countCapitalizedWordsInString_Stream(str1));
//		System.out.println("Using Stream: " + _50_countCapitalizedWordsInString_Stream(str2));

//		int[] arr = { 4, 3, 25, 6, 7, 8, 9, 2, 3, 10 }; // 4
//		System.out.println(_51_longestConsecutiveOccurrenceOfIntegersInArray_BFA(arr));

//		String str = "a2b3c4"; // aabbbcccc
//		System.out.println("Using String Builder : " + _52_stringOutputAsPerIntStrCombination(str));

//		String str = "aayuipabcabcuioabcdefeg"; // 6
//		System.out.println(_53_longestConsecutiveOccurrenceOfCharactersInString(str));

//		int[] arr = { 10, 3, 5, 6, 2 }; // Output: prod[] = {180, 600, 360, 300, 900}
//
//		System.out.println("Using BFA : " + Arrays.toString(_54_productOfAnArrayExceptSelf_BFA(arr)));
//		System.out.println("Using Prefix and Suffix : " + Arrays.toString(_55_productOfAnArrayExceptSelf_PrefixSuffix(arr)));

//		int[] arr = { 1, 2, 3, 5, 6 }; // 4
//		System.out.println("Using BFA : " + _56_missingNumberInGivenArray_BFA(arr));
//		System.out.println("Using HashSet : " + _57_missingNumberInGivenArray_HashSet(arr));

//		int[] arr = { 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1 }; // 5
//		System.out.println(_58_maximumConsecutiveOnesInarray_BFA(arr));

//		int[] arr = { 5, 7, 7, 8, 8, 10 };
//		int target = 8; // Output: [3, 4]
//
//		System.out.println("Using Linear Iteration: "
//				+ Arrays.toString(_59_first_LastPositionOfNumberInarray_Using_LinearIteration(arr, target)));

//		_60_printNumbers1to100_WithoutUsingAnyLoop(1);

		int[] arr1 = { 1, 0, 2, 0, 3, 0, 0, 0 }; // 1, 2, 3, 0, 0, 0, 0, 0
//		System.out.println("Using Brute Force Approach: " + Arrays.toString(_61_shiftAllZerosOnRight_BFA(arr1)));

		System.out.println(
				"Using In Place Approach: " + Arrays.toString(_62_shiftAllZerosOnRight_Using_InPlaceApproach(arr1)));

	}

	private static int[] _62_shiftAllZerosOnRight_Using_InPlaceApproach(int[] arr) {
		// Time Complexity: O(n)
		// Space Complexity: O(1)

		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[index++] = arr[i];
			}
		}
		while (index < arr.length) {
			arr[index++] = 0;
		}
		return arr;
	}

	private static int[] _61_shiftAllZerosOnRight_BFA(int[] arr) {
		// Time Complexity: O(n)
		// Space Complexity: O(n)
		int index = 0;
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				result[index++] = arr[i];
			}
		}
		return result;
	}

	private static void _60_printNumbers1to100_WithoutUsingAnyLoop(int num) {

		if (num <= 100) {
			System.out.print(num + " ");
			_60_printNumbers1to100_WithoutUsingAnyLoop(num + 1);
		}
	}

	private static int[] _59_first_LastPositionOfNumberInarray_Using_LinearIteration(int[] arr, int target) {
		// Time Complexity: O(n)
		// Space Complexity: O(1)
		int first = -1;
		int last = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				if (first == -1) {
					first = i;
				}
				last = i;
			}
		}
		return new int[] { first, last };
	}

	private static int _58_maximumConsecutiveOnesInarray_BFA(int[] arr) {
		// Time Complexity: O(n)
		// Space Complexity: O(1)
		int count = 0;
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1)
				count++;
			else
				count = 0;
			max = Math.max(max, count);
		}

		return max;
	}

	private static int _57_missingNumberInGivenArray_HashSet(int[] arr) {
		// Time Complexity: O(n)
		// Space Complexity: O(1)
		Set<Integer> hs = new HashSet<>();
		for (int num : arr) {
			hs.add(num);
		}
		for (int i = 1; i <= arr.length; i++) {
			if (!hs.contains(i)) {
				return i;
			}
		}
		return -1;
	}

	private static int _56_missingNumberInGivenArray_BFA(int[] arr) {
		// Time Complexity: O(n)
		// Space Complexity: O(1)
		int totalLen = arr.length + 1;
		int expectedSum = totalLen * (totalLen + 1) / 2;
		int actualSum = 0;
		for (int num : arr) {
			actualSum += num;
		}
		return expectedSum - actualSum;
	}

	private static int[] _55_productOfAnArrayExceptSelf_PrefixSuffix(int[] arr) {
		// Time Complexity: O(n)
		// Space Complexity: O(n)
		int len = arr.length;
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		int[] prod = new int[arr.length];

		left[0] = 1;
		right[len - 1] = 1;

		for (int i = 1; i < left.length; i++) {
			left[i] = arr[i - 1] * left[i - 1];
		}

		for (int i = len - 2; i >= 0; i--) {
			right[i] = arr[i + 1] * right[i + 1];
		}

		for (int i = 0; i < prod.length; i++) {
			prod[i] = left[i] * right[i];
		}

		return prod;
	}

	private static int[] _54_productOfAnArrayExceptSelf_BFA(int[] arr) {
		// Time Complexity: O(n^2)
		// Space Complexity: O(n)
		int[] prod = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int num = 1;
			for (int j = 0; j < arr.length; j++) {
				if (j != i) {
					num *= arr[j];
				}
			}
			prod[i] = num;
		}
		return prod;
	}

	private static int _53_longestConsecutiveOccurrenceOfCharactersInString(String str) {
		// Time complexity: O(n)
		// Space complexity: O(1)
		if (str == null || str.length() == 0) {
			return 0;
		}

		int count = 1;
		int max = 1;
		for (int i = 0; i < str.length() - 1; i++) {
			int num1 = (int) str.charAt(i);
			int num2 = (int) str.charAt(i + 1);
//			if (str.charAt(i) == str.charAt(i - 1) + 1), start i from 1s
			if (num2 - num1 == 1) {
				count++;
			} else {
				count = 1;
			}
			max = Math.max(max, count);
		}

		return max;
	}

	private static String _52_stringOutputAsPerIntStrCombination(String str) {
		// Time Complexity: O(n^2)
		// Space Complexity: O(n)
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isAlphabetic(str.charAt(i))) {
				sb.append(str.charAt(i));
			} else {
				int count = Character.getNumericValue(str.charAt(i));
				for (int j = 1; j < count; j++) {
					sb.append(str.charAt(i - 1));
				}
			}
		}
		return sb.toString();
	}

	private static int _51_longestConsecutiveOccurrenceOfIntegersInArray_BFA(int[] arr) {
		// Time complexity: O(n)
		// Space complexity: O(1)
		int count = 0;
		int max = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] + 1 == arr[i + 1])
				count++;
			else
				count = 0;

			max = Math.max(max, count + 1);
		}

		return max;
	}

	private static int _50_countCapitalizedWordsInString_Stream(String str) {
		// Time complexity: O(n)
		// Space complexity: O(n)
		return (int) str.chars().filter(ch -> Character.isUpperCase(ch)).count();
	}

	private static int _49_countCapitalizedWordsInString_RegX(String str) {
		// Time complexity: O(n)
		// Space complexity: O(1)
		int count = 0;
		Matcher matcher = Pattern.compile("[A-Z]").matcher(str);
		while (matcher.find()) {
			count++;
		}
		return count;
	}

	private static int _48_countCapitalizedWordsInString_BFA(String str) {
		// Time complexity: O(n)
		// Space complexity: O(n)
		int count = 0;
		for (char ch : str.toCharArray()) {
			if (Character.isUpperCase(ch))
				count++;
		}
		return count;
	}

	private static char[] _47_reverseArray_Using_Stack(char[] arr) {
		// Time complexity: O(n)
		// Space complexity: O(n)
		char[] reverseArr = new char[arr.length];
		Stack<Character> st = new Stack<>();
		for (char ch : arr) {
			st.push(ch);
		}
		int index = 0;
		while (!st.isEmpty()) {
			reverseArr[index++] = st.pop();
		}
		return reverseArr;
	}

	private static char[] _46_reverseArray_Using_Two_Pointer(char[] arr) {
		// Time complexity: O(n)
		// Space complexity: O(1)
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		return arr;
	}

	private static char[] _45_reverseArray_Using_Temp_Array(char[] arr) {
		// Time complexity: O(n)
		// Space complexity: O(n)
		char[] temp = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[arr.length - 1 - i];
		}
		return temp;

	}

	private static void _44_swapTwoNumbers_Without_Using_Temp_Variable(int num1, int num2) {
		// Time complexity: O(1)
		// Space complexity: O(1)
		System.out.println("Num1 is : " + num1 + " & Num2 is : " + num2);
		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;

		System.out.println("Num1 is : " + num1 + " & Num2 is : " + num2);

	}

	private static void _43_swapTwoNumbers_Using_Temp_Variable(int num1, int num2) {
		// Time complexity: O(1)
		// Space complexity: O(1)
		System.out.println("Num1 is : " + num1 + " & Num2 is : " + num2);
		int temp = num1;
		num1 = num2;
		num2 = temp;

		System.out.println("Num1 is : " + num1 + " & Num2 is : " + num2);

	}

	private static HashSet<Character> _42_duplicatesInString_UsingHashSet(String str) {
		// Time complexity: O(n)
		// Space complexity: O(n)
		HashSet<Character> hs = new HashSet<>();
		HashSet<Character> duplicates = new HashSet<>();

		for (char ch : str.toCharArray()) {
			if (ch != ' ') {
				if (!hs.add(ch)) {
					duplicates.add(ch);
				}
			}
		}
		return duplicates;
	}

	private static long _41_countNumber_Of_Characters_In_String_Using_Stream(String str) {
		// Time complexity: O(n)
		// Space complexity: O(1)
		return str.chars().filter(ch -> ch != ' ').count();
	}

	private static int _40_countNumber_Of_Characters_In_String_Using_BFA(String str) {
		// Time complexity: O(n)
		// Space complexity: O(1)
		if (str.length() == 0 || str.isEmpty()) {
			return 0;
		}
		int count = 0;
		for (char ch : str.toCharArray()) {
			if (ch != ' ')
				count++;
		}
		return count;
	}

	private static boolean _39_isPrime(int num) {
		// Time complexity: O(sqrt(n))
		// Space complexity: O(1)
		if (num == 2)
			return true;
		else if (num == 1 || num % 2 == 0)
			return false;
		for (int i = 3; i <= Math.sqrt(num); i += 2) {
			if (num % i == 0)
				return false;
		}
		return true;

	}

	private static int _38_ReverseNumber(int num) {
		// Time complexity: O(n)
		// Space complexity: O(1)
		int reverseNum = 0;
		while (num != 0) {
			int reminder = num % 10;
			reverseNum = reverseNum * 10 + reminder;
			num /= 10;
		}
		return reverseNum;
	}

	private static boolean _37_is_Armstrong_Number(int num) {
		// Time complexity: O(d) d-> digits in num
		// Space complexity: O(1)
		int originNum = num;
		int sum = 0;
		int power = Integer.toString(num).length();
		while (num != 0) {
			int digit = num % 10;
			sum += Math.pow(digit, power);
			num /= 10;
		}
		return originNum == sum;
	}

	private static List<Integer> _36_fibonacci_Series(int num) {
		// Time complexity: O(n)
		// Space complexity: O(1)
		int a = 1, b = 1, sum = 0;
		List<Integer> fib = new ArrayList<>();
		for (int i = 1; i <= num; i++) {
			fib.add(sum);
			if (i == 2) {
				sum = 1;
			} else {
				sum += a;
				a = b;
				b = sum;
			}
		}
		return fib;
	}

	private static void _35_longestSubstringWithoutRepeatingCharacters(String str) {
		// Time complexity: O(n)
		// Space complexity: O(n)

		int start = 0;
		int max = 0;
		HashMap<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {

			if (hm.containsKey(str.charAt(i))) {
				start = Math.max(start, hm.get(str.charAt(i)) + 1);
			}
			hm.put(str.charAt(i), i);
			max = Math.max(max, i - start + 1);
		}

		System.out.println(max);
	}

	private static void _34_firstLetterOfEachWordString(String str) {
		// Time Complexity: O(n)
		// Space Complexity: O(n)

		StringBuilder sb = new StringBuilder();
		boolean isSpace = true;
		for (char ch : str.toCharArray()) {
			if (ch != ' ' && isSpace) {
				sb.append(ch);
				isSpace = false;
			}
			if (ch == ' ') {
				isSpace = true;
			}
		}
		System.out.println(sb);
	}

	private static void _33_removeTrailingZeros_UsingSubString(String str) {
		// Time Complexity: O(n)
		// Space Complexity: O(n)
		int end = str.length() - 1;
		while (end >= 0 && str.charAt(end) == '0') {
			end--;
		}
		System.out.println(str.substring(0, end + 1));
	}

	private static void _32_removeLeadingZeros_UsingSubString(String str) {
		// Time Complexity: O(n)
		// Space Complexity: O(n)
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '0') {
				System.out.println(str.substring(i));
				break;
			}
		}
	}

	private static String _31_reverseString_UsingStack(String str) {
		// Time Complexity: O(n)
		// Space Complexity: O(n)
		String reverseStr = "";
		Stack<Character> st = new Stack<>();
		for (char ch : str.toCharArray()) {
			st.push(ch);
		}
		while (!st.isEmpty()) {
			reverseStr += st.pop();
		}
		return reverseStr;
	}

	private static void _30_isPalindromeString_UsingBFA(String str) {
		// Time Complexity: O(n)
		// Space Complexity: O(n)

		boolean isPalindrome = true;
		str = str.trim().replaceAll("\\s+", "").toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				isPalindrome = false;
			}
		}
		if (isPalindrome)
			System.out.println("Given String is Palindrome");
		else
			System.out.println("Given String is Not a Palindrome");
	}

	private static int _29_countNumberOfWordsInString_Tokenizer(String str) {
		// Time Complexity: O(n)
		// Space Complexity: O(1)
		StringTokenizer strToken = new StringTokenizer(str);
		return strToken.countTokens();

	}

	private static int _28_countNumberOfWordsInString_UsingSplitTrim(String str) {
		// Time Complexity: O(n)
		// Space Complexity: O(n)
		return str.trim().split(" ").length;

	}

	private static void _27_StringPoolConcept() {

		String str1 = "Avdhut";
		String str2 = "Avdhut";
		String str3 = new String("Avdhut");

		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
	}

	private static int _26_secondSmallestNumberArray_UsingTreeSet(int[] arr) {
		// Time complexity: O(nlogn)
		// Space complexity: O(n)
		TreeSet<Integer> ts = new TreeSet<>();
		for (int num : arr) {
			ts.add(num);
		}
		return ts.higher(ts.first());
	}

	private static int _25_secondSmallestNumberArray_UsingHeap(int[] arr) {
		// Time complexity: O(nlogk)
		// Space complexity: O(1)
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		HashSet<Integer> unique = new HashSet<>();
		for (int num : arr) {
			if (unique.add(num)) {
				maxHeap.offer(num);
				if (maxHeap.size() > 2) {
					maxHeap.poll();
				}
			}
		}
		return maxHeap.peek();
	}

	private static int _24_secondLargestNumberArray(int[] arr) {
		// Time complexity: O(n)
		// Space complexity: O(1)
		if (arr.length < 2) {
			throw new IllegalArgumentException("Array must contains atleast 2 elements");
		}

		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		for (int num : arr) {
			if (num > largest) {
				secondLargest = largest;
				largest = num;
			} else if (num < largest && num > secondLargest) {
				secondLargest = num;
			}
		}
		return secondLargest;
	}

	private static void _23_AscedingOrderArray_MaxHeap(int[] arr) {
		// Time complexity: O(nlogn)
		// Space complexity: O(n)

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int num : arr) {
			maxHeap.add(num);
		}

		int index = arr.length - 1;

		while (!maxHeap.isEmpty()) {
			arr[index--] = maxHeap.poll();
		}
		System.out.println(Arrays.toString(arr));
	}

	private static void _22_AscedingOrderArray_BubbleSort(int[] arr) {
		// Time complexity: O(n^2)
		// Space complexity: O(1)
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));

	}

	private static void _21_ReverseArrayUsing_Two_Pointer_Technique(int[] arr) {
		// Time complexity: O(n)
		// Space complexity: O(n)

		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}

		System.out.println(Arrays.toString(arr));

	}

	private static void _20_ReverseArray_UsingStack(int[] arr) {
		// Time complexity: O(n)
		// Space complexity: O(n)
		Stack<Integer> st = new Stack<>();
		for (int num : arr) {
			st.add(num);
		}

		while (!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}

	private static void _19_duplicateElementsArray(int[] arr) {
		// Time complexity: O(n)
		// Space complexity: O(n)
		HashSet<Integer> hs = new HashSet<>();
		HashSet<Integer> duplicates = new HashSet<>();
		for (int num : arr) {
			if (!hs.add(num)) {
				duplicates.add(num);
			}
		}

		System.out.println(duplicates);
	}

	private static void _18_frequencyOfEachElementArray(int[] arr) {
		// Time complexity: O(n)
		// Space complexity: O(n)
		LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>();
		for (int num : arr) {
			hm.put(num, hm.getOrDefault(num, 0) + 1);
		}

		System.out.println(hm);

	}

	private static List<int[]> _17_Set_findPairsFromTwoArrays(int[] arr1, int[] arr2, int target) {
		// Time Complexity: O(n + m)
		// Space Complexity: O(n + m)
		List<int[]> pairs = new ArrayList<>();
		HashSet<Integer> hs = new HashSet<>();
		for (int num : arr1) {
			hs.add(num);
		}
		for (int num : arr2) {
			if (hs.contains(target - num)) {
				pairs.add(new int[] { target - num, num });
			}
		}
		return pairs;

	}

	private static void printPairs(List<int[]> pairs) {
		for (int[] pair : pairs) {
			System.out.print(Arrays.toString(pair) + " ");
		}
		System.out.println();
	}

	private static boolean _16_Set_Stream_hasUniqueChars(String str) {
		// Time complexity: O(n)
		// Space complexity: O(n)
		Set<Character> hs = str.chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet());
		return hs.size() == str.length();
	}

	private static boolean _15_Set_hasUniqueChars(String str) {
		// Time complexity: O(n)
		// Space complexity: O(n)
		Set<Character> hs = new HashSet<>();
		for (char ch : str.toCharArray()) {
			if (!hs.add(ch))
				return false;
		}
		return true;
	}

	private static List<Integer> _14_Set_removeDuplicates(List<Integer> myList) {
		// Time complexity: O(n)
		// Space complexity: O(n)
		Set<Integer> hs = new HashSet<>(myList);
		return new ArrayList<Integer>(hs);
	}

	private static int[] _13_HashMap_indicesOfTwoNumbersThatGivesTarget(int[] arr, int target) {
		// Time complexity: O(n)
		// Space complexity: O(n)
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			int otherNum = target - num;
			if (hm.containsKey(otherNum)) {
				return new int[] { hm.get(otherNum), i };
			}
			hm.put(num, i);
		}
		return new int[] {};
	}

	private static List<List<String>> _12_Using_Hashmap_groupAnagrams(String[] strArr) {
		// Time complexity: O(NKlogK)
		// Space complexity: O(NK)
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
		// Time complexity: O(n)
		// Space complexity: O(n)
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
