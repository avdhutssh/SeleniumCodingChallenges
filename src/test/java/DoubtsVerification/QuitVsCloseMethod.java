package DoubtsVerification;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class QuitVsCloseMethod {
	WebDriverWait wt;
	WebDriver driver;
	JavascriptExecutor jse;
	int windowNumber = 2;

	@BeforeTest
	private void setup() {
		driver = new ChromeDriver();
		wt = new WebDriverWait(driver, Duration.ofSeconds(10));
		jse = (JavascriptExecutor) driver;
	}
	
	@Test
	public void method01() {
		OpenSiteAndSwitchToChildWindow();
		driver.close();
		
	}
	
	
	@Test
	public void method02() {
		OpenSiteAndSwitchToChildWindow();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.quit();
		
	}
	
	private void OpenSiteAndSwitchToChildWindow() {
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		String parentWindowID = driver.getWindowHandle();
		WebElement windowBtn = driver.findElement(By.id("windowButton"));
		jse.executeScript("arguments[0].scrollIntoView(true)", windowBtn);
		windowBtn.click();
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
	}
}
