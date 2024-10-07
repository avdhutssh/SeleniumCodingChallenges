package DoubtsVerification;

import org.testng.annotations.Test;

public class priorityMethods {

	@Test(priority = 1)
	public void method1() {
		System.out.println("In method1");
	}

	@Test()
	public void method2() {
		System.out.println("In method2");
	}

	@Test
	public void method3() {
		System.out.println("In method3");
	}
	
//	Conside three @Test annotated methods are there, one is having priority and the other two not then  during execution the methods that are not having priority will execute first as per alphabetical order and  at last the priority method will execute.
//	Means If no priority is given to method, it will execute first
//
//	If priority is negative or 0 then that Test method will execute first unlike previous example 

}
