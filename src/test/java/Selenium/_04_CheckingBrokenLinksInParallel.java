package Selenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class _04_CheckingBrokenLinksInParallel {

	@Test
	public void verifyLinksSerially() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in");

		List<WebElement> anchorLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total Links present on page: " + anchorLinks.size()); // Total Links present on page: 373
		Set<String> urls = new HashSet<>();
		for (WebElement link : anchorLinks) {
			urls.add(link.getAttribute("href"));
		}

		System.out.println("Total Links after removing duplicates: " + urls.size()); // Total Links after removing
																						// duplicates: 338

		long startTime = System.currentTimeMillis();
		urls.stream().forEach(e -> validateUrl(e)); // Time taken: 240.46 seconds
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken serially : " + ((endTime - startTime) / 1000.0));
		driver.quit();

	}

	@Test
	public void verifyLinksParallely() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in");

		List<WebElement> anchorLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total Links present on page: " + anchorLinks.size());

		Set<String> urls = new HashSet<>();
		for (WebElement link : anchorLinks) {
			urls.add(link.getAttribute("href"));
		}

		System.out.println("Total Links after removing duplicates: " + urls.size());

		long startTime = System.currentTimeMillis();
		urls.parallelStream().forEach(e -> validateUrl(e)); // Time taken: 94.268 seconds
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken parallely : " + ((endTime - startTime) / 1000.0));
		driver.quit();

	}


	private void validateUrl(String url) {

		try {
			URL link = new URL(url);
			HttpURLConnection httpConnection = (HttpURLConnection) link.openConnection();
			httpConnection.setConnectTimeout(5000);
			httpConnection.connect();
			if (httpConnection.getResponseCode() >= 400) {
				System.out.println(
						link + " ---> is a broken link and giving msg as : " + httpConnection.getResponseMessage());
			} else {
				System.out.println(link + " ---> " + httpConnection.getResponseMessage() + " is OK");
			}
		} catch (Exception e) {
		}
	}
}
