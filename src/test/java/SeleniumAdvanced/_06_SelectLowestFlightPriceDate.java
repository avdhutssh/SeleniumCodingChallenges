package SeleniumAdvanced;

import org.checkerframework.checker.units.qual.min;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        List<WebElement> closeButtons = driver.findElements(By.xpath("(//img[@alt='cross'])[1]"));
        if (!closeButtons.isEmpty() && closeButtons.get(0).isDisplayed()) {
            closeButtons.get(0).click();
            Thread.sleep(2000);
        }
        List<WebElement> iframes = driver.findElements(By.id("webklipper-publisher-widget-container-notification-frame"));
        if (!iframes.isEmpty()) {
            driver.switchTo().frame(iframes.get(0));
            List<WebElement> closeBtns = driver.findElements(By.xpath("//button[contains(@id,'_we_wk_close')]"));
            if (!closeBtns.isEmpty()) {
                closeBtns.get(0).click();
                System.out.println("Closed the notification iframe popup.");
            } else {
                System.out.println("Close button not found inside iframe.");
            }
            driver.switchTo().defaultContent();
        } else {
            System.out.println("Notification iframe not present.");
        }

        driver.findElement(By.xpath("//div[@aria-label='Departure Date inputbox']")).click();
        // String yearMonth = YearMonth.now().toString();  //current month
        String yearMonth = YearMonth.now().plusMonths(1).toString();
        String farePath = "//div[@aria-label='month  " + yearMonth + "']//div[not(contains(@class,'outside-month'))]/span/span[contains(text(),'₹')]";
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,100)");
        jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(farePath)));
        Thread.sleep(2000);

        int lowestFare = driver.findElements(By.xpath(farePath))
                .stream()
                .mapToInt(ele -> Integer.parseInt(ele.getText().replaceAll("[^0-9]", "")))
                .min().getAsInt();

        System.out.println("Lowest fare for " + yearMonth + " is: ₹" + lowestFare);

        NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("en", "IN"));
        String formattedLowestFare = "₹" + numberFormat.format(lowestFare);

        String lowestFarePath = "//div[@aria-label='month  " + yearMonth + "']//div[not(contains(@class,'outside-month'))]/span/span[contains(text(),'" + formattedLowestFare + "')]/..";
        List<WebElement> allDatesWithLowestFare = driver.findElements(By.xpath(lowestFarePath));

        System.out.println("Dates with lowest price (" + formattedLowestFare + "):");
        for (WebElement dateElem : allDatesWithLowestFare) {
            String dateText = dateElem.getText().split("\\n")[0].trim();
            System.out.println("Date: " + dateText);
        }

        Random random = new Random();
        int randomIndex = random.nextInt(allDatesWithLowestFare.size());
        WebElement selectedDateElem = allDatesWithLowestFare.get(randomIndex);

        String selectedDateText = selectedDateElem.getText().split("\\n")[0].trim();
        System.out.println("Selected date with lowest price: " + selectedDateText);

        selectedDateElem.click();
    }
}
