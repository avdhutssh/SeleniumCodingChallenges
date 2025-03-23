package Demo;

public class Exercises {

	public static void main(String[] args) {
		System.out.println(_01_multiply(5, 10)); // 50

		System.out.println("-----------------------------------------");
		
		int[] arr1 = { 1, 4, 8, 15, 17 };
		System.out.println(_02_MaxDiffBetweenAdjacentElementsInArr(arr1)); // 7
		
		System.out.println("-----------------------------------------");
	}

	private static int _02_MaxDiffBetweenAdjacentElementsInArr(int[] arr) {
		// Time complexity: O(n)
		// Space complexity: O(1)
		int maxDiff = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length-1; i++) {
			int diff = arr[i+1] - arr[i];
			maxDiff = Math.max(maxDiff, diff);
			
		}
		return maxDiff;
	}

	private static int _01_multiply(int num1, int num2) {
		// Time complexity: O(num2)
		// Space complexity: O(1)
		int sum = 0;
		for(int i=1;i<=num2;i++) {
			sum+=num1;
		}
		return sum;
	}

}
