package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class seleniumPractice {
    WebDriver driver;
    WebDriverWait wt;

    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromePrefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wt = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void verifyCart() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.cssSelector(".app_logo")).isDisplayed();
        driver.findElement(By.xpath("//*[normalize-space(text())='Sauce Labs Backpack']/../../following-sibling::div//button")).click();
        WebElement cartBadge = wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".shopping_cart_badge"))));
        Assert.assertEquals(cartBadge.getText(), "1");
    }



}
