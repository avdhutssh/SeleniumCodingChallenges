package Demo;

public class Exercises {

	public static void main(String[] args) {
		System.out.println(_01_multiply(5, 10)); // 50

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
