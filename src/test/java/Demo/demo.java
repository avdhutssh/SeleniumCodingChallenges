package Demo;

import java.util.ArrayList;
import java.util.List;

public class demo {

	public static void main(String[] args) {
		int[] arr ={1212, 11, 12541254, 00, 444444}; // [12, 1, 1254, 0, 444]
		
		_01_UsingBFA(arr);

	}

	private static void _01_UsingBFA(int[] arr) {
		
		List<String> al = new ArrayList<>();
		for(int num : arr) {
			String str = Integer.toString(num);
			if(str.length()==1) {
				al.add(str);
			}else {
				al.add(str.substring(0,str.length()/2));
			}	
		}
		System.out.println(al);
	}

}
