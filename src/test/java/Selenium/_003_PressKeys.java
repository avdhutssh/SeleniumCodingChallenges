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
import org.testng.annotations.*;

public class _003_PressKeys {
    WebDriver driver;

    @BeforeSuite
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/key_presses");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider(name = "keysProvider")
    public Object[][] keysProvider() {
        return new Object[][]{
                {Keys.ENTER, "ENTER"},
                {Keys.TAB, "TAB"},
                {Keys.SHIFT, "SHIFT"},
                {Keys.CONTROL, "CONTROL"},
                {Keys.ALT, "ALT"},
                {Keys.ESCAPE, "ESCAPE"},
                {Keys.BACK_SPACE, "BACK_SPACE"},
                {Keys.SPACE, "SPACE"},
                {Keys.ARROW_UP, "UP"},
                {Keys.ARROW_DOWN, "DOWN"},
                {Keys.ARROW_LEFT, "LEFT"},
                {Keys.ARROW_RIGHT, "RIGHT"},
                {Keys.DELETE, "DELETE"},
                {Keys.HOME, "HOME"},
                {Keys.END, "END"},
                {Keys.PAGE_UP, "PAGE_UP"},
                {Keys.PAGE_DOWN, "PAGE_DOWN"},
                {Keys.INSERT, "INSERT"},
                {Keys.F1, "F1"},
                {Keys.F2, "F2"},
                {Keys.F3, "F3"},
                {Keys.F4, "F4"},
                {Keys.F5, "F5"},
                {Keys.F6, "F6"},
                {Keys.F7, "F7"},
                {Keys.F8, "F8"},
                {Keys.F9, "F9"},
                {Keys.F10, "F10"},
                {Keys.F11, "F11"},
                {Keys.F12, "F12"}
        };
    }

    @Test(dataProvider = "keysProvider")
    public void _PressKeys(Keys key, String expected) {
        WebElement inputField = driver.findElement(By.id("target"));
        Actions act = new Actions(driver);
        act.moveToElement(inputField).sendKeys(key).perform();
        String resultText = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(resultText, "You entered: " + expected, "Failed for key: " + expected);
    }
}
