package Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class _03_HighestPriceProductAddCart {
	private WebDriver driver;
	private String URL = "https://www.saucedemo.com/";
	private String creds_User = "standard_user";
	private String creds_Pwd = "secret_sauce";

	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.cssSelector("#user-name")).sendKeys(creds_User);
		driver.findElement(By.cssSelector("#password")).sendKeys(creds_Pwd);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}
	}

	@Test
	public void _01_Using_BFA() throws InterruptedException {
		List<WebElement> items = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
		float highestPrice = 0;
		for (WebElement item : items) {
			String price = item.getText().replace("$", "");
			Float priceFloat = Float.parseFloat(price);
			if (priceFloat > highestPrice) {
				highestPrice = priceFloat;
			}
		}
		String highest = String.valueOf(highestPrice);
		List<WebElement> products = driver.findElements(By.xpath("//*[contains(text(),'$')]"));
		for (int i = 1; i <= products.size(); i++) {
			String value = driver.findElement(By.xpath("(//*[contains(text(),'$')])[" + i + "]")).getText().replace("$",
					"");
			if (value.equals(highest)) {
				driver.findElement(By.xpath("(//*[contains(text(),'$')])[" + i + "]/../button")).click();
			}
		}

	}
}
