package SeleniumAdvanced;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class _01_PrintingPopulationOnConsole {
    private WebDriver driver;
    String URL = "https://www.worldometers.info/world-population";
    WebDriverWait wt;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wt = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(URL);
        wt.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[normalize-space(text())='retrieving data...']"))));
    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }

    private void printPopulationData(List<WebElement> elements) {
        System.out.println("Current Population is: " + elements.get(0).getText());
        System.out.println("Today Births is: " + elements.get(1).getText());
        System.out.println("Today Deaths is: " + elements.get(2).getText());
        System.out.println("Today Growth is: " + elements.get(3).getText());
        System.out.println("Year Births is: " + elements.get(4).getText());
        System.out.println("Year Deaths is: " + elements.get(5).getText());
        System.out.println("Year Growth is: " + elements.get(6).getText());
        System.out.println("----------------------------------------");
    }

    private void printPopulationDataFromList(List<String> relAttributeValues) throws InterruptedException {
        for (String value : relAttributeValues) {
            WebElement element = driver.findElement(By.xpath("//*[@rel='" + value + "']"));
            System.out.println(value + " is: " + element.getText());
        }
        System.out.println("----------------------------------------");

    }

    @Test()
    public void bruteForceApproach() throws InterruptedException {
        System.out.println("Using BFA");
        WebElement currentPopulation = driver.findElement(By.xpath("//*[@rel='current_population']"));
        WebElement todayBirths = driver.findElement(By.xpath("//*[@rel='births_today']"));
        WebElement todayDeaths = driver.findElement(By.xpath("//*[@rel='dth1s_today']"));
        WebElement todayGrowth = driver.findElement(By.xpath("//*[@rel='absolute_growth']"));
        WebElement yearBirths = driver.findElement(By.xpath("//*[@rel='births_this_year']"));
        WebElement yearDeaths = driver.findElement(By.xpath("//*[@rel='dth1s_this_year']"));
        WebElement yearGrowth = driver.findElement(By.xpath("//*[@rel='absolute_growth_year']"));

        List<WebElement> elements = Arrays.asList(currentPopulation, todayBirths, todayDeaths, todayGrowth,
                yearBirths, yearDeaths, yearGrowth);

        printPopulationData(elements);
    }

    @Test()
    public void usingListForXpathAttributeValues() throws InterruptedException {
        System.out.println("Using Xpath Attribute Values in List");
        List<String> relAttributeValues = Arrays.asList("current_population", "births_today", "dth1s_today",
                "absolute_growth", "births_this_year", "dth1s_this_year", "absolute_growth_year");
        printPopulationDataFromList(relAttributeValues);
    }
}
