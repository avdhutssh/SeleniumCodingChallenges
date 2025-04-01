package Demo;

import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class demo {

	public static void main(String[] args) {

		String str1 = "Happy BithDay"; // yappaH yaDhtiB
		String str2 = "Hello"; // helo
		_01_reverseOrder(str1);
		System.out.println();
		_02_removeDuplicates(str2);
	}

	private static void _02_removeDuplicates(String str) {

		StringBuilder sb = new StringBuilder();
		Set<Character> hs = new TreeSet<>();
		for (char ch : str.toCharArray()) {
			hs.add(ch);
		}
		for (char ch : hs) {
			sb.append(ch);
		}
		System.out.println(sb.toString());
	}

	private static void _01_reverseOrder(String str) {

		StringBuilder sb = new StringBuilder();
		String[] strArr = str.split(" ");
		for (String word : strArr) {
			System.out.print(reversString(word) + " ");

		}
	}

	static String reversString(String str) {

		Stack<Character> st = new Stack<>();
		for (char ch : str.toCharArray()) {
			st.push(ch);
		}
		StringBuilder sb = new StringBuilder();

		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		return sb.toString();
	}
}
