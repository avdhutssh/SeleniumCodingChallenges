package SeleniumAdvanced;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class _04_CheckingBrokenLinksInParallel {

    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.in");
        WebElement continueShopping = driver.findElement(By.xpath("//*[normalize-space(text())='Continue shopping']"));
        if (continueShopping.isDisplayed()) continueShopping.click();
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verifyLinksSerially() {
        List<WebElement> anchorLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total Links present on page: " + anchorLinks.size());
        Set<String> urls = new HashSet<>();
        for (WebElement link : anchorLinks) {
            urls.add(link.getAttribute("href"));
        }

        System.out.println("Total Links after removing duplicates: " + urls.size());

        long startTime = System.currentTimeMillis();
        urls.stream().forEach(e -> {
            if (e != null && !e.isEmpty()) {
                validateUrl(e);
            }
        }); // Time taken: 79.005 seconds
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken serially : " + ((endTime - startTime) / 1000.0));

    }

    @Test
    public void verifyLinksParallely() {
        List<WebElement> anchorLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total Links present on page: " + anchorLinks.size());

        Set<String> urls = new HashSet<>();
        for (WebElement link : anchorLinks) {
            urls.add(link.getAttribute("href"));
        }

        System.out.println("Total Links after removing duplicates: " + urls.size());

        long startTime = System.currentTimeMillis();
        urls.parallelStream().forEach(e -> {
                    if (e != null && !e.isEmpty())
                        validateUrl(e);
                }
        ); // Time taken: 13.81 seconds
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken parallely : " + ((endTime - startTime) / 1000.0));

    }

    @Test
    public void verifyLinksWithThreadPool() {
        List<WebElement> anchorLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total Links present on page: " + anchorLinks.size());

        Set<String> urls = new HashSet<>();
        for (WebElement link : anchorLinks) {
            urls.add(link.getAttribute("href"));
        }

        System.out.println("Total Links after removing duplicates: " + urls.size());

        int numThreads = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        long startTime = System.currentTimeMillis();
        for (String url : urls) {
            executorService.submit(() -> validateUrl(url));
        }
        executorService.shutdownNow();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with ThreadGroups : " + ((endTime - startTime) / 1000.0));
        // Time taken: 60.017 seconds

    }

    private void validateUrl(String url) {

        try {
            URL link = new URL(url);
            HttpURLConnection httpConnection = (HttpURLConnection) link.openConnection();
            httpConnection.setConnectTimeout(5000);
            httpConnection.connect();
            if (httpConnection.getResponseCode() >= 400) {
                System.out.println(
                        link + " ---> is a broken link and giving msg as : " + httpConnection.getResponseMessage());
            } else {
                System.out.println(link + " ---> " + httpConnection.getResponseMessage() + " is OK");
            }
        } catch (Exception e) {
        }
    }
}
