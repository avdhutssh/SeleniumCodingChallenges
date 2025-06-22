package SeleniumAdvanced;

import org.checkerframework.checker.units.qual.min;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.YearMonth;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class _06_SelectLowestFlightPriceDate {

    @Test
    public void _01_getLowestFlightPrice() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.yatra.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//div[@aria-label='Departure Date inputbox']")).click();
        Thread.sleep(2000);
        String yearMonth = YearMonth.now().toString();
        String farePath = "//div[@aria-label='month  " + yearMonth + "']//div[not(contains(@class,'outside-month'))]/span/span[contains(text(),'₹')]";
        System.out.println(farePath);
        int lowestFare = driver.findElements(By.xpath(farePath)).stream().mapToInt(ele -> Integer.parseInt(ele.getText().replaceAll("[^0-9]", ""))).min().getAsInt();
        System.out.println("Lowest fare for " + yearMonth + " is: ₹" + lowestFare);
        NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("en", "IN"));
        String formattesLowestFare = "₹" + numberFormat.format(lowestFare);
        String lowestFarePath = "//div[@aria-label='month  " + yearMonth + "']//div[not(contains(@class,'outside-month'))]/span/span[contains(text(),'" + formattesLowestFare + "')]";
        List<WebElement> allDatesWithLowestfare = driver.findElements(By.xpath(lowestFarePath));
        allDatesWithLowestfare.get(new Random().nextInt(allDatesWithLowestfare.size())).click();

    }
}
