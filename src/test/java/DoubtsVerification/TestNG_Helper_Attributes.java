package DoubtsVerification;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_Helper_Attributes {

	int index = 1;
	// Execute One by One to see actual execution

	@Test(priority = 1)
	public void method1() {
		System.out.println("In method1 -> priority attribute");
	}

	@Test(enabled = false)
	public void method2() {
		System.out.println("In method2 -> will not execute -> enabled attribute");
	}

	@Test()
	public void methodFail() {
		Assert.fail("Failed Intentionally");
	}

	@Test(dependsOnMethods = { "methodFail" })
	public void method3() {
		System.out.println("In method3 -> skipped -> dependsOnMethods attribute");
	}

	@Test(dependsOnMethods = { "method1" })
	public void method4() {
		System.out.println("In method4 -> Execute as method1 gets pass-> dependsOnMethods attribute");
	}

	@Test(dependsOnMethods = { "methodFail" }, alwaysRun = true)
	public void method5() {
		System.out.println(
				"In method5 -> Execute eventhough methodFail not executed coz of alwaysRun-> dependsOnMethods and alwaysRun attribute");
	}

	@Test(groups = "Smoke")
	public void method6() {
		System.out.println("In method6 -> groups attribute");
	}

	@Test(dependsOnGroups = { "Smoke" })
	public void method7() {
		System.out.println("In method7 -> Execute as group Smoke gets pass-> dependsOnGroups attribute");
	}

	@Test(description = "Checking how description attribute works")
	public void method8() {
		System.out.println("In method8 -> description attribute");
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { 1 }, { 2 }, { 3 } };
	}

	@Test(dataProvider = "getData")
	public void method9(int num) {
		System.out.println("In method9 -> DataProvider attribute -> " + num);
	}

	@Test(invocationCount = 5)
	public void method10() {
		System.out.println("In method10 -> invocationCount attribute -> " + index++);
	}

}
