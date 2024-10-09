package DoubtsVerification;

public class _01_PracticeJava {

	public static void main(String[] args) {
		System.out.println(_01_multiply(5, 10));

	}

	private static int _01_multiply(int i, int j) {
		int sum =0;
		int k =1;
		while(k<=j) {
			sum+=i;
			k++;
		}

		return sum;
	}

}
