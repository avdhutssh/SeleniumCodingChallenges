package Selenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class _005_BrokenLinks {

	@Test
	public void findBrokenLinks() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for(WebElement ele : links) {
			String link = ele.getAttribute("href");
			try {
				URL url = new URL(link);
				HttpURLConnection httpConn = (HttpURLConnection)url.openConnection();
				httpConn.setConnectTimeout(3000);
				httpConn.connect();
				
				if(httpConn.getResponseCode()>=400) {
					System.out.println(url + " is broken URL");
				}else {
					System.out.println(url + " is valid URL");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
