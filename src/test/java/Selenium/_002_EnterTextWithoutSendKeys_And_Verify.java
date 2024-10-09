package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _002_EnterTextWithoutSendKeys_And_Verify {

	String url = "https://automationexercise.com/products";
	String searchPro = "Avdhut";

	@Test
	public void _01_Using_JavaScriptExecutor() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		WebElement searchTxtBox = driver.findElement(By.id("search_product"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value=arguments[1];", searchTxtBox, searchPro);

		WebElement searchBtn = driver.findElement(By.id("submit_search"));
		searchBtn.click();
		String searchText = driver.findElement(By.id("search_product")).getAttribute("value");

		Assert.assertEquals(searchText, searchPro);
		Assert.assertEquals(driver.getCurrentUrl(), url + "?search=" + searchPro);
		driver.quit();
	}

}
