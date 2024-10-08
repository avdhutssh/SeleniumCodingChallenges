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
		System.out.println("Highest price in BFA: " + highestPrice);
		List<WebElement> products = driver.findElements(By.xpath("//*[contains(text(),'$')]"));
		for (int i = 1; i <= products.size(); i++) {
			String value = driver.findElement(By.xpath("(//*[contains(text(),'$')])[" + i + "]")).getText().replace("$",
					"");
			if (value.equals(highest)) {
				driver.findElement(By.xpath("(//*[contains(text(),'$')])[" + i + "]/../button")).click();
			}
		}

	}

	@Test
	public void _02_Using_Stream_Max_Min() throws InterruptedException {
		List<WebElement> items = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
		double highestPrice = items.stream().mapToDouble(e -> Double.parseDouble(e.getText().trim().replace("$", "")))
				.max().getAsDouble();
		double lowestPrice = items.stream().mapToDouble(e -> Double.parseDouble(e.getText().trim().replace("$", "")))
				.min().getAsDouble();
		System.out.println("Highest price in Stream: " + highestPrice + " & lowest price in stream: " + lowestPrice);
		driver.findElement(By.xpath("//*[normalize-space()='$" + highestPrice + "']/../button")).click();
		driver.findElement(By.xpath("//*[normalize-space()='$" + lowestPrice + "']/../button")).click();

	}

	@Test
	public void _03_Using_Simple_Iteration() throws InterruptedException {
		List<WebElement> items = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
		double highestPrice = 0;
		for (WebElement ele : items) {
			double price = Double.parseDouble(ele.getText().trim().replace("$", ""));
			if (highestPrice < price) {
				highestPrice = price;
			}
		}
		System.out.println("Highest price in Iteration: " + highestPrice);
		driver.findElement(By.xpath("//*[normalize-space()='$" + highestPrice + "']/../button")).click();
	}

	//to-do
	// @Test
	// public void _04_Using_JS_ScriptInjection() {
	// 	String js_Script = "var max = 0;\r\n"
	// 			+ "document.getElementsByClassName('inventory_item_price').forEach(e=>{\r\n"
	// 			+ "    newVal = parseFloat(e.innerText.split('$')[1]);\r\n" + "    if (max < newVal) {\r\n"
	// 			+ "        max = newVal;\r\n" + "    }\r\n" + "}\r\n" + ");\r\n" + "console.log(max);\r\n"
	// 			+ "var xpathVal = \"//div[normalize-space()='$\" + max + \"']/following-sibling::button[text()='Add to cart']\";\r\n"
	// 			+ "var ele = document.evaluate(xpathVal, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;\r\n"
	// 			+ "ele.click();\r\n" + "";
	// 	WebDriver driver = new ChromeDriver();
	// 	driver.manage().window().maximize();
	// 	driver.get("https://www.saucedemo.com/");
	// 	driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
	// 	driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
	// 	driver.findElement(By.id("login-button")).click();
	// 	JavascriptExecutor js = ((JavascriptExecutor) driver);
	// 	js.executeScript(js_Script);
	// }
}
