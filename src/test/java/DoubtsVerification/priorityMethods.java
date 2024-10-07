package DoubtsVerification;

import org.testng.annotations.Test;

public class priorityMethods {

	@Test(priority = 1)
	public void method1() {
		System.out.println("In method1");
	}

	@Test
	public void method2() {
		System.out.println("In method2");
	}

	@Test
	public void method3() {
		System.out.println("In method3");
	}

}
