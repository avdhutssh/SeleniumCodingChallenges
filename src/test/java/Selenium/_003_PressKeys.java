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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class _003_PressKeys {
    WebDriver driver;

    @BeforeSuite
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/key_presses");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void _01_PressEnter() {
        WebElement inputField = driver.findElement(By.id("target"));
        Actions act = new Actions(driver);
        act.moveToElement(inputField).sendKeys(Keys.ENTER).build().perform();
        String resultText = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(resultText, "You entered: ENTER");
    }
}
