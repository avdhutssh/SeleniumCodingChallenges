package Demo;

import java.util.HashMap;
import java.util.Map;

public class javaDemo {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6 }; // 6 {1,2,3}

//		_01_BFA(arr, 6);
		_02_Optimized(arr, 6);

	}

	private static void _02_Optimized(int[] arr, int sum) {
		// Time Complexity: O(n)
		// Space Complexity: O(n)
		System.out.println("Optimized Approach");
		Map<Integer, Integer> hm = new HashMap<>();
		for (int num : arr) {
			hm.put(num, sum);
		}
		System.out.println(hm);
		for (int i = 0; i < arr.length; i++) {
			int remainingNum = sum - arr[i];
			System.out.println(remainingNum);
			if (hm.containsKey(remainingNum)) {
				System.out.println(hm.get(arr[i]) + " : " + arr[i] + " : " + remainingNum);
			}
		}

	}

	private static void _01_BFA(int[] arr, int sum) {
		// Time Complexity: O(n^3)
		// Space Complexity: O(1)
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (arr[i] + arr[j] + arr[k] == sum) {
						System.out.println(arr[i] + " : " + arr[j] + " : " + arr[k]);
					}
				}
			}
		}

	}

}
