package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class _002_EnterTextWithoutSendKeys_And_Verify {
    WebDriver driver;
    JavascriptExecutor jse;
    String url = "https://automationexercise.com/products";
    String searchPro = "Avdhut";

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void _01_Using_JavaScriptExecutor() {
        WebElement searchTxtBox = driver.findElement(By.id("search_product"));
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value=arguments[1];", searchTxtBox, searchPro);
        WebElement searchBtn = driver.findElement(By.id("submit_search"));
        searchBtn.click();
        String searchText = driver.findElement(By.id("search_product")).getAttribute("value");

        Assert.assertEquals(searchText, searchPro);
        Assert.assertEquals(driver.getCurrentUrl(), url + "?search=" + searchPro);
        driver.quit();
    }

}
