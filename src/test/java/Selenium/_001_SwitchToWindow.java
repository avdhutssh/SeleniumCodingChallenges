package Selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class _001_SwitchToWindow {
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

    @AfterTest
    private void tearDown() {
        driver.quit();
    }

    @Test
    public void _01_Using_Iterator() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindowID = driver.getWindowHandle();
        WebElement windowBtn = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        wt.until(ExpectedConditions.visibilityOf(windowBtn));
        try {
            wt.until(ExpectedConditions.elementToBeClickable(windowBtn));
        } catch (Exception e) {
            System.out.println("Element is not clickable: " + e.getMessage());
        }
        windowBtn.click();
        Set<String> childWindowsID = driver.getWindowHandles();
        Iterator<String> it = childWindowsID.iterator();
        while (it.hasNext()) {
            String childID = it.next();
            if (!parentWindowID.equals(childID)) {
                driver.switchTo().window(childID);
                String childPageHeading = driver.findElement(By.tagName("h3")).getText();
                System.out.println("Heading of child window is " + childPageHeading);
                Assert.assertEquals(childPageHeading, "New Window");
                driver.close();
            }
        }
        driver.switchTo().window(parentWindowID);
        String parentPageHeading = driver.findElement(By.tagName("h3")).getText();
        System.out.println("Heading of child window is " + parentPageHeading);
        Assert.assertEquals(parentPageHeading, "Opening a new window");
    }

    @Test
    public void _02_Using_Stream_Array() {
        WebElement windowBtn = driver.findElement(By.id("windowButton"));
        jse.executeScript("arguments[0].scrollIntoView(true)", windowBtn);
        windowBtn.click();

        String[] windowHandles = driver.getWindowHandles().stream().toArray(String[]::new);
        System.out.println("windowHandles.length: " + windowHandles.length);
        try {
            if (windowNumber > windowHandles.length) {
                throw new RuntimeException(String.format(
                        "The specified window number (%s) is greater than the " + "number of windows created (%s).",
                        windowNumber, windowHandles.length));
            }
            driver.switchTo().window(windowHandles[windowNumber - 1]);
            System.out.println("Successfully switched to window number: " + windowNumber);
        } catch (Exception ex) {
            throw new RuntimeException(
                    String.format("Failed to switch to window number %s. The total number of open windows was %s.",
                            windowNumber, windowHandles.length),
                    ex);

        }
        String pageHeading = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println("Heading of child window is " + pageHeading);
        driver.close();
        driver.switchTo().window(windowHandles[0]);
        Assert.assertEquals("DEMOQA", driver.getTitle());
    }
}
