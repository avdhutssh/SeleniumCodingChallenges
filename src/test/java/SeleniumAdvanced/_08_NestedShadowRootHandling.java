package SeleniumAdvanced;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * This class demonstrates how to handle multiple nested shadow roots in Selenium Java
 * and click on elements with specific data-qa-id attributes.
 * 
 * Shadow DOM allows web developers to encapsulate parts of their web components,
 * making them isolated from the main document. This can make automation challenging
 * as elements inside shadow roots are not directly accessible using standard selectors.
 */
public class _08_NestedShadowRootHandling {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsExecutor;
    
    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        jsExecutor = (JavascriptExecutor) driver;
    }
    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    /**
     * Method 1: Using Selenium 4 native shadow root support
     * This is the recommended approach for Selenium 4.0+
     */
    @Test
    public void handleNestedShadowRootsSelenium4() {
        // Example with a hypothetical page containing nested shadow roots
        driver.get("https://example.com/shadow-dom-page");
        
        try {
            // Step 1: Access the first level shadow root
            WebElement shadowHost1 = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("my-custom-component")));
            SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
            
            // Step 2: Access the second level shadow root (nested inside first)
            WebElement shadowHost2 = shadowRoot1.findElement(By.cssSelector("nested-component"));
            SearchContext shadowRoot2 = shadowHost2.getShadowRoot();
            
            // Step 3: Access the third level shadow root (if exists)
            WebElement shadowHost3 = shadowRoot2.findElement(By.cssSelector("deep-nested-component"));
            SearchContext shadowRoot3 = shadowHost3.getShadowRoot();
            
            // Step 4: Find and click the element with data-qa-id="start-button"
            WebElement startButton = shadowRoot3.findElement(By.cssSelector("[data-qa-id='start-button']"));
            startButton.click();
            
            System.out.println("Successfully clicked start button in nested shadow DOM using Selenium 4");
            
        } catch (Exception e) {
            System.out.println("Error handling nested shadow roots: " + e.getMessage());
        }
    }
    
    /**
     * Method 2: Using JavaScriptExecutor - More flexible approach
     * Works with both older and newer versions of Selenium
     */
    @Test
    public void handleNestedShadowRootsWithJavaScript() {
        driver.get("https://example.com/shadow-dom-page");
        
        try {
            // JavaScript code to traverse nested shadow roots and click the element
            String jsScript = """
                // Function to traverse nested shadow roots
                function findElementInNestedShadowDOM(selectors, targetSelector) {
                    let currentElement = document;
                    
                    // Traverse through each shadow root level
                    for (let i = 0; i < selectors.length; i++) {
                        let element = currentElement.querySelector(selectors[i]);
                        if (!element) {
                            console.log('Element not found at level:', i, 'with selector:', selectors[i]);
                            return null;
                        }
                        
                        if (element.shadowRoot) {
                            currentElement = element.shadowRoot;
                        } else {
                            console.log('No shadow root found at level:', i);
                            return null;
                        }
                    }
                    
                    // Find the target element in the deepest shadow root
                    return currentElement.querySelector(targetSelector);
                }
                
                // Define the path to your nested shadow roots
                const shadowSelectors = [
                    'my-custom-component',      // First level shadow host
                    'nested-component',         // Second level shadow host
                    'deep-nested-component'     // Third level shadow host
                ];
                
                // Find and click the start button
                const startButton = findElementInNestedShadowDOM(shadowSelectors, '[data-qa-id="start-button"]');
                
                if (startButton) {
                    startButton.click();
                    return 'Successfully clicked start button';
                } else {
                    return 'Start button not found in nested shadow DOM';
                }
                """;
            
            String result = (String) jsExecutor.executeScript(jsScript);
            System.out.println("JavaScript execution result: " + result);
            
        } catch (Exception e) {
            System.out.println("Error with JavaScript approach: " + e.getMessage());
        }
    }
    
    /**
     * Method 3: Recursive approach for dynamic shadow DOM traversal
     */
    @Test
    public void handleDynamicNestedShadowRoots() {
        driver.get("https://example.com/shadow-dom-page");
        
        try {
            // JavaScript for recursive shadow DOM traversal
            String recursiveScript = """
                function findElementRecursively(root, targetSelector, visited = new Set()) {
                    // Prevent infinite loops
                    if (visited.has(root)) return null;
                    visited.add(root);
                    
                    // Try to find the element in current context
                    let element = root.querySelector(targetSelector);
                    if (element) return element;
                    
                    // Get all elements that might have shadow roots
                    let allElements = root.querySelectorAll('*');
                    
                    for (let el of allElements) {
                        if (el.shadowRoot) {
                            let found = findElementRecursively(el.shadowRoot, targetSelector, visited);
                            if (found) return found;
                        }
                    }
                    
                    return null;
                }
                
                // Search for the start button recursively
                const startButton = findElementRecursively(document, '[data-qa-id="start-button"]');
                
                if (startButton) {
                    startButton.click();
                    return 'Button clicked successfully via recursive search';
                } else {
                    return 'Button not found in any shadow DOM';
                }
                """;
            
            String result = (String) jsExecutor.executeScript(recursiveScript);
            System.out.println("Recursive search result: " + result);
            
        } catch (Exception e) {
            System.out.println("Error with recursive approach: " + e.getMessage());
        }
    }
    
    /**
     * Method 4: Utility method for reusable shadow DOM traversal
     */
    public WebElement findElementInShadowDOM(String[] shadowHostSelectors, String targetSelector) {
        try {
            SearchContext currentContext = driver;
            
            // Traverse through each level of shadow DOM
            for (String selector : shadowHostSelectors) {
                WebElement shadowHost = currentContext.findElement(By.cssSelector(selector));
                currentContext = shadowHost.getShadowRoot();
            }
            
            // Find the target element in the final shadow root
            return currentContext.findElement(By.cssSelector(targetSelector));
            
        } catch (Exception e) {
            System.out.println("Error traversing shadow DOM: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Method 5: Example usage of the utility method
     */
    @Test
    public void useUtilityMethodForShadowDOM() {
        driver.get("https://example.com/shadow-dom-page");
        
        // Define the path through nested shadow roots
        String[] shadowPath = {
            "my-custom-component",
            "nested-component", 
            "deep-nested-component"
        };
        
        // Find and click the start button
        WebElement startButton = findElementInShadowDOM(shadowPath, "[data-qa-id='start-button']");
        
        if (startButton != null) {
            startButton.click();
            System.out.println("Successfully clicked start button using utility method");
        } else {
            System.out.println("Start button not found using utility method");
        }
    }
    
    /**
     * Method 6: Handle shadow DOM with wait conditions
     */
    @Test
    public void handleShadowDOMWithWaits() {
        driver.get("https://example.com/shadow-dom-page");
        
        try {
            // Wait for the shadow host to be present
            WebElement shadowHost1 = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("my-custom-component")));
            
            // Wait for shadow root to be available (custom wait condition)
            wait.until(driver -> {
                try {
                    return shadowHost1.getShadowRoot() != null;
                } catch (Exception e) {
                    return false;
                }
            });
            
            SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
            
            // Continue with nested shadow roots...
            WebElement shadowHost2 = shadowRoot1.findElement(By.cssSelector("nested-component"));
            SearchContext shadowRoot2 = shadowHost2.getShadowRoot();
            
            // Wait for the target element to be clickable
            WebElement startButton = wait.until(driver -> {
                try {
                    WebElement btn = shadowRoot2.findElement(By.cssSelector("[data-qa-id='start-button']"));
                    return btn.isDisplayed() && btn.isEnabled() ? btn : null;
                } catch (Exception e) {
                    return null;
                }
            });
            
            startButton.click();
            System.out.println("Successfully clicked start button with wait conditions");
            
        } catch (Exception e) {
            System.out.println("Error handling shadow DOM with waits: " + e.getMessage());
        }
    }
    
    /**
     * Method 7: Find multiple elements with same data-qa-id in different shadow roots
     */
    @Test
    public void findMultipleElementsInShadowDOM() {
        driver.get("https://example.com/shadow-dom-page");
        
        String script = """
            function findAllElementsInShadowDOM(targetSelector) {
                let results = [];
                
                function searchInContext(context, path = []) {
                    // Search in current context
                    let elements = context.querySelectorAll(targetSelector);
                    elements.forEach(el => {
                        results.push({
                            element: el,
                            path: [...path]
                        });
                    });
                    
                    // Search in shadow roots
                    let allElements = context.querySelectorAll('*');
                    allElements.forEach(el => {
                        if (el.shadowRoot) {
                            searchInContext(el.shadowRoot, [...path, el.tagName.toLowerCase()]);
                        }
                    });
                }
                
                searchInContext(document);
                return results;
            }
            
            // Find all start buttons
            let allStartButtons = findAllElementsInShadowDOM('[data-qa-id="start-button"]');
            
            // Click the first one found
            if (allStartButtons.length > 0) {
                allStartButtons[0].element.click();
                return `Found ${allStartButtons.length} start buttons, clicked the first one`;
            } else {
                return 'No start buttons found';
            }
            """;
        
        try {
            String result = (String) jsExecutor.executeScript(script);
            System.out.println("Multiple elements search result: " + result);
        } catch (Exception e) {
            System.out.println("Error finding multiple elements: " + e.getMessage());
        }
    }
} 