package Selenium;

import java.net.URI;
import java.time.Duration;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class _05_BrowserAuthPopupHandle {
	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void _01_ByEnteringCredsInUrl() {
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.findElement(By.tagName("p")).getText().trim()
				.equals("Congratulations! You must have the proper credentials.");
	}

	@Test
	public void _02_UsingHasAuthenticationInterface() {
		((HasAuthentication) driver).register(UsernameAndPassword.of("admin", "admin"));
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		driver.findElement(By.tagName("p")).getText().trim()
				.equals("Congratulations! You must have the proper credentials.");
	}

	@Test
	public void _03_UsingURI_Predicate() {
		Predicate<URI> uriPredicate = uri -> uri.getHost().contains("the-internet.herokuapp.com");
		((HasAuthentication) driver).register(uriPredicate, UsernameAndPassword.of("admin", "admin"));
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		driver.findElement(By.tagName("p")).getText().trim()
				.equals("Congratulations! You must have the proper credentials.");
	}

}
