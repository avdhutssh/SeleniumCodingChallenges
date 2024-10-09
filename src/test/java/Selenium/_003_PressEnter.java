package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _003_PressEnter {
	String url = "https://automationexercise.com/products";
	String searchPro = "Avdhut";

	@Test
	public void _01_Using_SendKeys() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		WebElement loginBtn = driver.findElement(By.xpath("//*[normalize-space(text())='Signup / Login']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(loginBtn).sendKeys(Keys.ENTER).build().perform();
//		driver.quit();
	}
}
