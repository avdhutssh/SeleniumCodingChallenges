package Selenium;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class _03_HighestPriceProductAddCart {
    private WebDriver driver;
    private String URL = "https://www.saucedemo.com/";

    @BeforeTest
    public void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromePrefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);
        String creds_User = driver.findElement(By.id("login_credentials")).getText().split("\n")[1].trim();
        String creds_Pwd = driver.findElement(By.className("login_password")).getText().split("\n")[1].trim();
        System.out.println("Username is " + creds_User);
        System.out.println("Pwd is " + creds_Pwd);
        driver.findElement(By.cssSelector("#user-name")).sendKeys(creds_User);
        driver.findElement(By.cssSelector("#password")).sendKeys(creds_Pwd);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }

    @Test
    public void _01_Using_BFA() {
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        float highestPrice = 0;
        WebElement highestPriceElement = null;
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "").trim();
            float price = Float.parseFloat(priceText);
            if (price > highestPrice) {
                highestPrice = price;
                highestPriceElement = priceElement;
            }
        }
        System.out.println("Highest price: " + highestPrice);
        WebElement productContainer = highestPriceElement.findElement(By.xpath("./ancestor::div[@class='inventory_item']"));
        String productName = productContainer.findElement(By.className("inventory_item_name")).getText();
        System.out.println("Product with highest price: " + productName);
        productContainer.findElement(By.xpath(".//button[contains(text(),'Add to cart')]"))
                .click();
        driver.findElement(By.className("shopping_cart_link")).click();
        WebElement cartItem = driver.findElement(By.className("inventory_item_name"));
        String cartProductName = cartItem.getText();
        System.out.println("Product in cart: " + cartProductName);
        org.testng.Assert.assertEquals(cartProductName, productName, "The product added to cart should match the highest price product.");
    }

    @Test
    public void _02_Using_Stream_Max_Min() throws InterruptedException {
        List<WebElement> items = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
        double highestPrice = items.stream().mapToDouble(e -> Double.parseDouble(e.getText().trim().replace("$", "")))
                .max().getAsDouble();
        double lowestPrice = items.stream().mapToDouble(e -> Double.parseDouble(e.getText().trim().replace("$", "")))
                .min().getAsDouble();
        System.out.println("Highest price in Stream: " + highestPrice + " & lowest price in stream: " + lowestPrice);
        String highestPriceProduct = driver.findElement(By.xpath("//*[normalize-space()='$" + highestPrice + "']/../ancestor::div//*[@class='inventory_item_name ']")).getText();
        String lowestPriceProduct = driver.findElement(By.xpath("//*[normalize-space()='$" + lowestPrice + "']/../ancestor::div//*[@class='inventory_item_name ']")).getText();
        driver.findElement(By.xpath("//*[normalize-space()='$" + highestPrice + "']/../button")).click();
        driver.findElement(By.xpath("//*[normalize-space()='$" + lowestPrice + "']/../button")).click();
        System.out.println("Product with highest price: " + highestPriceProduct);
        System.out.println("Product with lowest price: " + lowestPriceProduct);
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(1000);
        List<WebElement> cartItems = driver.findElements(By.className("inventory_item_name"));
        for (WebElement item : cartItems) {
            System.out.println("Item in cart: " + item.getText());
        }

    }

    @Test
    public void _03_Using_Simple_Iteration() throws InterruptedException {
        List<WebElement> items = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
        double highestPrice = 0;
        for (WebElement ele : items) {
            double price = Double.parseDouble(ele.getText().trim().replace("$", ""));
            if (highestPrice < price) {
                highestPrice = price;
            }
        }
        System.out.println("Highest price in Iteration: " + highestPrice);
        driver.findElement(By.xpath("//*[normalize-space()='$" + highestPrice + "']/../button")).click();
    }

    @Test
    public void _05_Using_AdvancedXPath() {
        // Use XPath to find the price element with the maximum value
        // This XPath finds the inventory_item_price element with the highest price
        WebElement highestPriceElement = driver.findElement(By.xpath(
                "//div[@class='inventory_item_price' and not(. < //div[@class='inventory_item_price'])]"
        ));
        String highestPriceText = highestPriceElement.getText();
        System.out.println("Highest price (XPath): " + highestPriceText);

        // Find the product container and name
        WebElement productContainer = highestPriceElement.findElement(By.xpath("./ancestor::div[@class='inventory_item']"));
        String productName = productContainer.findElement(By.className("inventory_item_name")).getText();
        System.out.println("Product with highest price (XPath): " + productName);

        // Click the Add to cart button
        productContainer.findElement(By.xpath(".//button[contains(text(),'Add to cart')]"))
                .click();

        // Go to cart and verify the product is added
        driver.findElement(By.className("shopping_cart_link")).click();
        WebElement cartItem = driver.findElement(By.className("inventory_item_name"));
        String cartProductName = cartItem.getText();
        System.out.println("Product in cart: " + cartProductName);

        // Assert the product in cart matches the one added
        org.testng.Assert.assertEquals(cartProductName, productName, "The product added to cart should match the highest price product.");
    }

    //to-do
    // @Test
    // public void _04_Using_JS_ScriptInjection() {
    // 	String js_Script = "var max = 0;\r\n"
    // 			+ "document.getElementsByClassName('inventory_item_price').forEach(e=>{\r\n"
    // 			+ "    newVal = parseFloat(e.innerText.split('$')[1]);\r\n" + "    if (max < newVal) {\r\n"
    // 			+ "        max = newVal;\r\n" + "    }\r\n" + "}\r\n" + ");\r\n" + "console.log(max);\r\n"
    // 			+ "var xpathVal = \"//div[normalize-space()='$\" + max + \"']/following-sibling::button[text()='Add to cart']\";\r\n"
    // 			+ "var ele = document.evaluate(xpathVal, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;\r\n"
    // 			+ "ele.click();\r\n" + "";
    // 	WebDriver driver = new ChromeDriver();
    // 	driver.manage().window().maximize();
    // 	driver.get("https://www.saucedemo.com/");
    // 	driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
    // 	driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
    // 	driver.findElement(By.id("login-button")).click();
    // 	JavascriptExecutor js = ((JavascriptExecutor) driver);
    // 	js.executeScript(js_Script);
    // }
}
