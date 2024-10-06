package Selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _001_SwitchToWindow {

	@Test
	private void _01_Using_Iterator() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/browser-windows");
		String parentWindowID = driver.getWindowHandle();
		driver.findElement(By.id("windowButton")).click();
		Set<String> childWindowsID = driver.getWindowHandles();
		Iterator<String> it = childWindowsID.iterator();
		while (it.hasNext()) {
			String childID = it.next();
			if (!parentWindowID.equals(childID)) {
				driver.switchTo().window(childID);
				String pageHeading = driver.findElement(By.id("sampleHeading")).getText();
				System.out.println("Heading of child window is " + pageHeading);
			}
		}
		driver.close();
		driver.switchTo().window(parentWindowID);
		Assert.assertEquals("DEMOQA", driver.getTitle());
	}
}
