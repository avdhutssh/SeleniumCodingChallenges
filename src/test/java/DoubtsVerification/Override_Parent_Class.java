package DoubtsVerification;

import java.io.IOException;

public class Override_Parent_Class {

	public void display1() {
		System.out.println("Superclass method1");
	}

	protected void display2() {
		System.out.println("Superclass method2");
	}

	public void display3() throws IOException {
		System.out.println("Superclass method3");
	}

	public Number display4() {
		System.out.println("Superclass method4");
		return 10;
	}

//	Final and static methods we cannot override.
	final void display5() {
		System.out.println("Superclass method5");
	}

	static void display6() {
		System.out.println("Superclass method6");
	}


	
}
