package DoubtsVerification;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Override_Child_Class extends Override_Parent_Class {
	
	public static void main(String[] args) {
		Override_Child_Class obj = new Override_Child_Class();
		obj.display1();
		obj.display2();
		try {
			obj.display3();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obj.display4();
	}

	@Override
	public void display1() {
		System.out.println("Subclass method1");
	}

	@Override
	public void display2() {
		System.out.println("Subclass method2");
	}

	@Override
	public void display3() throws FileNotFoundException {
		System.out.println("Subclass method3");
	}

	@Override
	public Integer display4() {
		System.out.println("Subclass method4");
		return 3;
	}

//	@Override
//	public void display5() {
//		System.out.println("Subclass method5");
//	}
//
//	@Override
//	static void display6() {
//		System.out.println("Subclass method6");
//	}

	
}
