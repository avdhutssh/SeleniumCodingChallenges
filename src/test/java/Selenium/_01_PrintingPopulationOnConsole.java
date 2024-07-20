package Selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class _01_PrintingPopulationOnConsole {
	private WebDriver driver;
	private static final String URL = "https://www.worldometers.info/world-population";
	private static final long DURATION = 5000; // 5 seconds

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}
	}

	private void printPopulationData(WebElement currentPopulation, WebElement todayBirths, WebElement todayDeaths,
			WebElement todayGrowth, WebElement yearBirths, WebElement yearDeaths, WebElement yearGrowth)
			throws InterruptedException {
		long startTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - startTime < DURATION) {
			System.out.println("Current Population is: " + currentPopulation.getText());
			System.out.println("Today Births is: " + todayBirths.getText());
			System.out.println("Today Deaths is: " + todayDeaths.getText());
			System.out.println("Today Growth is: " + todayGrowth.getText());
			System.out.println("Year Births is: " + yearBirths.getText());
			System.out.println("Year Deaths is: " + yearDeaths.getText());
			System.out.println("Year Growth is: " + yearGrowth.getText());
			System.out.println("----------------------------------------");
			Thread.sleep(1000);
		}
	}

	private void printPopulationDataFromList(List<String> relAttributeValues) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - startTime < DURATION) {
			for (String value : relAttributeValues) {
				WebElement element = driver.findElement(By.xpath("//*[@rel='" + value + "']"));
				System.out.println(value + " is: " + element.getText());
			}
			System.out.println("----------------------------------------");
			Thread.sleep(1000);
		}
	}

	private void printPopulationDataFromIndexing() throws InterruptedException {
		long startTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - startTime < DURATION) {
			for (int i = 1; i <= 7; i++) {
				WebElement element = driver
						.findElement(By.xpath("(//*[@class='row']//span[@class='rts-counter'])[" + i + "]"));
				System.out.println(element.getAttribute("rel") + " is: " + element.getText());
			}
			System.out.println("----------------------------------------");
			Thread.sleep(1000);
		}
	}

	@Test(threadPoolSize = 3, invocationCount = 1)
	public void bruteForceApproach() throws InterruptedException {
		System.out.println("Using BFA");
		WebElement currentPopulation = driver.findElement(By.xpath("//*[@rel='current_population']"));
		WebElement todayBirths = driver.findElement(By.xpath("//*[@rel='births_today']"));
		WebElement todayDeaths = driver.findElement(By.xpath("//*[@rel='dth1s_today']"));
		WebElement todayGrowth = driver.findElement(By.xpath("//*[@rel='absolute_growth']"));
		WebElement yearBirths = driver.findElement(By.xpath("//*[@rel='births_this_year']"));
		WebElement yearDeaths = driver.findElement(By.xpath("//*[@rel='dth1s_this_year']"));
		WebElement yearGrowth = driver.findElement(By.xpath("//*[@rel='absolute_growth_year']"));

		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
		wt.until(ExpectedConditions.visibilityOf(currentPopulation));

		printPopulationData(currentPopulation, todayBirths, todayDeaths, todayGrowth, yearBirths, yearDeaths,
				yearGrowth);
	}

	@Test(threadPoolSize = 3, invocationCount = 1)
	public void usingListForXpathAttributeValues() throws InterruptedException {
		System.out.println("Using Xpath Attribute Values in List");
		List<String> relAttributeValues = Arrays.asList("current_population", "births_today", "dth1s_today",
				"absolute_growth", "births_this_year", "dth1s_this_year", "absolute_growth_year");
		printPopulationDataFromList(relAttributeValues);
	}

	@Test(threadPoolSize = 3, invocationCount = 1)
	public void usingXpathIndexing() throws InterruptedException {
		System.out.println("Using Xpath Indexing");
		printPopulationDataFromIndexing();
	}
}
