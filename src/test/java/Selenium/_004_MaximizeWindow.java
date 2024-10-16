package Selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class _004_MaximizeWindow {

	WebDriver driver;

	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

	@Test
	private void method01() {
		this.driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}

	@Test
	private void method02() {
		this.driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().setSize(new Dimension(1920, 1080));
	}

	@Test
	private void method03() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");
		this.driver = new ChromeDriver(opt);
		driver.get("https://www.google.com");
	}

}
