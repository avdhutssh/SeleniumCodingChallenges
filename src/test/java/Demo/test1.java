package Demo;

import java.util.HashMap;
import java.util.Map;

public class test1 {

	public static void main(String[] args) {
		String str = "abcdabce"; // a=2, b=2,c=2, d=1, e=1
		findOccurences(str);

	}

	public static void findOccurences(String str) {
		//time complexity = O(n), space = O(n)
		Map<Character, Integer> hm = new HashMap<>();
		for (char ch : str.toCharArray()) {
			int value = hm.getOrDefault(ch, 0) + 1;
			hm.put(ch, value);

		}
		System.out.println(hm);
	}

}
