package SeleniumAdvanced;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Practical examples of handling Shadow DOM elements using the ShadowDOMUtils utility class
 * 
 * This class demonstrates common real-world scenarios:
 * 1. Clicking buttons inside shadow DOM
 * 2. Handling nested shadow DOM components
 * 3. Working with custom web components
 * 4. Debugging shadow DOM structure
 */
public class _09_ShadowDOMPracticalExample {
    
    private WebDriver driver;
    
    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    /**
     * Example 1: Simple shadow DOM button click
     * This demonstrates the most common scenario - clicking a button inside a single shadow root
     */
    @Test
    public void clickStartButtonInSingleShadowRoot() {
        // Navigate to your application
        driver.get("https://your-app.com/page-with-shadow-dom");
        
        // Define the path to the shadow root
        String[] shadowPath = {"my-component"}; // Single shadow host
        
        // Click the start button using data-qa-id
        boolean success = ShadowDOMUtils.clickElementByDataQaId(driver, shadowPath, "start-button");
        
        if (success) {
            System.out.println("✅ Start button clicked successfully!");
        } else {
            System.out.println("❌ Failed to click start button");
        }
    }
    
    /**
     * Example 2: Nested shadow DOM - Multiple levels
     * This shows how to handle deeply nested shadow DOM components
     */
    @Test
    public void clickButtonInNestedShadowDOM() {
        driver.get("https://your-app.com/nested-components");
        
        // Define the path through multiple shadow roots
        String[] nestedShadowPath = {
            "app-main",                    // Level 1: Main app component
            "user-dashboard",              // Level 2: Dashboard component
            "action-panel",                // Level 3: Action panel component
            "button-group"                 // Level 4: Button group component
        };
        
        // Click the start button in the deeply nested shadow DOM
        boolean clicked = ShadowDOMUtils.clickElementByDataQaId(driver, nestedShadowPath, "start-button");
        
        System.out.println("Nested shadow DOM click result: " + clicked);
    }
    
    /**
     * Example 3: Handling different elements in shadow DOM
     * This shows how to interact with various elements, not just buttons
     */
    @Test
    public void interactWithVariousElementsInShadowDOM() {
        driver.get("https://your-app.com/form-components");
        
        String[] shadowPath = {"form-component", "input-group"};
        
        // Check if an input field exists
        boolean inputExists = ShadowDOMUtils.isElementPresentInShadowDOM(
            driver, shadowPath, "input[data-qa-id='username']");
        System.out.println("Input field exists: " + inputExists);
        
        // Get text from a label
        String labelText = ShadowDOMUtils.getTextFromShadowDOM(
            driver, shadowPath, "label[data-qa-id='username-label']");
        System.out.println("Label text: " + labelText);
        
        // Click a submit button
        ShadowDOMUtils.clickElementByDataQaId(driver, shadowPath, "submit-btn");
    }
    
    /**
     * Example 4: Using JavaScript approach for older Selenium versions
     * This demonstrates the fallback method for compatibility
     */
    @Test
    public void useJavaScriptApproachForShadowDOM() {
        driver.get("https://your-app.com/legacy-components");
        
        String[] shadowPath = {"legacy-component", "action-container"};
        String targetSelector = "[data-qa-id='start-button']";
        
        // Use JavaScript approach instead of native Selenium 4 method
        boolean success = ShadowDOMUtils.clickElementInShadowDOMWithJS(
            driver, shadowPath, targetSelector);
        
        System.out.println("JavaScript approach success: " + success);
    }
    
    /**
     * Example 5: Waiting for elements in shadow DOM
     * This shows how to wait for elements that might load asynchronously
     */
    @Test
    public void waitForElementInShadowDOM() {
        driver.get("https://your-app.com/dynamic-content");
        
        String[] shadowPath = {"dynamic-component"};
        String targetSelector = "[data-qa-id='start-button']";
        
        // Wait up to 10 seconds for the element to appear
        var element = ShadowDOMUtils.waitForElementInShadowDOM(
            driver, shadowPath, targetSelector, 10);
        
        if (element != null) {
            element.click();
            System.out.println("✅ Clicked element after waiting");
        } else {
            System.out.println("❌ Element did not appear within timeout");
        }
    }
    
    /**
     * Example 6: Find and click multiple elements with same data-qa-id
     * This demonstrates handling multiple similar elements across different shadow roots
     */
    @Test
    public void clickMultipleStartButtons() {
        driver.get("https://your-app.com/multiple-components");
        
        // Find and click all elements with data-qa-id="start-button" across all shadow roots
        int clickedCount = ShadowDOMUtils.findAndClickAllElementsWithDataQaId(driver, "start-button");
        
        System.out.println("Total start buttons clicked: " + clickedCount);
    }
    
    /**
     * Example 7: Debug shadow DOM structure
     * This helps you understand the shadow DOM structure when developing tests
     */
    @Test
    public void debugShadowDOMStructure() {
        driver.get("https://your-app.com/complex-components");
        
        // Print the shadow DOM structure for debugging
        System.out.println("=== Shadow DOM Structure Analysis ===");
        ShadowDOMUtils.debugShadowDOMStructure(driver);
    }
    
    /**
     * Example 8: Real-world example with popular web components
     * This shows how to handle common web component libraries
     */
    @Test
    public void handlePopularWebComponents() {
        // Example with Lit Web Components
        driver.get("https://your-app.com/lit-components");
        
        // Common patterns for different web component libraries:
        
        // Lit Components
        String[] litPath = {"lit-app", "lit-button-group"};
        ShadowDOMUtils.clickElementByDataQaId(driver, litPath, "start-button");
        
        // Stencil Components
        String[] stencilPath = {"stencil-wrapper", "stencil-form"};
        ShadowDOMUtils.clickElementByDataQaId(driver, stencilPath, "submit-btn");
        
        // Angular Elements
        String[] angularPath = {"ng-wrapper", "ng-component"};
        ShadowDOMUtils.clickElementByDataQaId(driver, angularPath, "action-button");
    }
    
    /**
     * Example 9: Custom method for specific application needs
     * This shows how to create application-specific helper methods
     */
    @Test
    public void customApplicationSpecificMethod() {
        driver.get("https://your-app.com/dashboard");
        
        // Custom method for your specific application
        clickStartButtonInDashboard();
        
        // Custom method for form submission
        submitFormInShadowDOM("user-form", "John Doe", "john@example.com");
    }
    
    // Helper methods for your specific application
    private void clickStartButtonInDashboard() {
        String[] dashboardPath = {"app-shell", "main-dashboard", "action-panel"};
        ShadowDOMUtils.clickElementByDataQaId(driver, dashboardPath, "start-button");
    }
    
    private void submitFormInShadowDOM(String formType, String name, String email) {
        String[] formPath = {"app-forms", formType};
        
        // You could extend ShadowDOMUtils or create custom methods like this:
        // Fill form fields (you'd need to implement input methods in ShadowDOMUtils)
        // ShadowDOMUtils.sendKeysToElementInShadowDOM(driver, formPath, "[data-qa-id='name']", name);
        // ShadowDOMUtils.sendKeysToElementInShadowDOM(driver, formPath, "[data-qa-id='email']", email);
        
        // Submit the form
        ShadowDOMUtils.clickElementByDataQaId(driver, formPath, "submit-button");
    }
} 