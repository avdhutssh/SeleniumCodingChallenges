package DoubtsVerification;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	int i = 1;

	@BeforeMethod
	public void setup1() {
		System.out.println(i++ + " " + "BeforeMethod");
	}

	@BeforeTest
	public void setup2() {
		System.out.println(i++ + " " + "BeforeTest");
	}

	@BeforeClass
	public void setup3() {
		System.out.println(i++ + " " + "BeforeClass");
	}

	@BeforeSuite
	public void setup4() {
		System.out.println(i++ + " " + "BeforeSuite");
	}

	@Test
	public void method() {
		System.out.println(i++ + " " + "Test");
	}

	@AfterMethod
	public void tearDown1() {
		System.out.println(i++ + " " + "AfterMethod");
	}

	@AfterTest
	public void tearDown2() {
		System.out.println(i++ + " " + "AfterTest");
	}

	@AfterClass
	public void tearDown3() {
		System.out.println(i++ + " " + "AfterClass");
	}

	@AfterSuite
	public void tearDown4() {
		System.out.println(i++ + " " + "AfterSuite");
	}
}
