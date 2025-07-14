# Selenium & RestAssured Interview Questions (Non-Coding)

---

## Selenium Interview Questions & Answers

1. **What are the different types of waits in Selenium? When would you use each?**
   - **Implicit Wait:** Sets a default wait time for the entire driver instance. Used for simple, static waits.
   - **Explicit Wait:** Waits for a specific condition to occur before proceeding (e.g., element to be clickable). Used for dynamic elements.
   - **Fluent Wait:** Like explicit wait, but with polling frequency and exception ignoring. Used for highly dynamic content.

2. **How do you handle dynamic web elements in Selenium?**
   - Use dynamic XPath/CSS selectors, relative locators, or strategies like indexing, partial attribute matching, or parent-child relationships.
   - Wait for elements to be present/visible using explicit waits.

3. **Explain the Page Object Model (POM) and its advantages.**
   - POM is a design pattern where each page is represented by a class containing locators and methods for actions.
   - Advantages: Improves code reusability, maintainability, readability, and reduces duplication.

4. **How do you handle file uploads and downloads in Selenium WebDriver?**
   - For uploads: Use `sendKeys()` to input file path to `<input type="file">`.
   - For downloads: Set browser preferences to auto-download, or use tools like Robot, AutoIT, or download via API.

5. **What are StaleElementReferenceException and how do you handle it?**
   - Occurs when the referenced element is no longer attached to the DOM.
   - Solution: Re-locate the element before interacting, use waits, or catch and retry.

6. **How do you manage browser sessions and cookies in Selenium?**
   - Use WebDriver's `manage().getCookies()`, `addCookie()`, `deleteCookie()` methods.
   - For session management, reuse the same driver instance or persist cookies between tests.

7. **How do you handle pop-ups, alerts, and browser windows/tabs?**
   - Use `driver.switchTo().alert()` for alerts.
   - Use `driver.switchTo().window(windowHandle)` for windows/tabs.
   - For pop-ups, handle via window handles or by disabling them in browser settings.

8. **How do you run Selenium tests in parallel? What are the challenges?**
   - Use TestNG/JUnit parallel execution, Selenium Grid, or cloud services.
   - Challenges: Test data isolation, thread safety, environment setup, resource contention.

9. **How do you integrate Selenium with CI/CD tools (e.g., Jenkins)?**
   - Use build tools (Maven/Gradle) and configure jobs in Jenkins to trigger tests on code changes or schedules.
   - Publish test reports and artifacts for analysis.

10. **How do you capture screenshots and logs for failed tests?**
    - Use `TakesScreenshot` interface for screenshots.
    - Use logging frameworks (Log4j, SLF4J) and test listeners to capture logs on failure.

11. **How do you handle SSL certificate errors in Selenium?**
    - Set browser capabilities to accept insecure certificates (e.g., `setAcceptInsecureCerts(true)` for Chrome/Firefox).

12. **How do you automate CAPTCHA or 2FA protected flows?**
    - Generally, avoid automating CAPTCHA/2FA (by design). Use test environments with CAPTCHA/2FA disabled or use test hooks/backdoors.

13. **How do you handle Shadow DOM elements?**
    - Use JavaScript execution (`JavascriptExecutor`) to access elements inside Shadow DOM, or use Selenium 4's shadow root support.

14. **How do you design a robust test automation framework using Selenium?**
    - Use POM, modular utilities, configuration management, reporting, logging, and CI/CD integration. Ensure scalability and maintainability.

15. **How do you handle browser compatibility and cross-browser testing?**
    - Use Selenium Grid or cloud services (BrowserStack, Sauce Labs) to run tests on multiple browsers/versions.
    - Maintain browser-specific locators and handle browser quirks.

16. **How do you use Selenium Grid or cloud services (e.g., Sauce Labs, BrowserStack)?**
    - Configure remote WebDriver with desired capabilities and connect to the Grid/cloud endpoint.
    - Use for parallel, distributed, and cross-browser testing.

17. **How do you handle AJAX and JavaScript-heavy applications?**
    - Use explicit waits for AJAX elements, wait for JavaScript execution, or use JavaScriptExecutor for custom waits.

18. **How do you manage test data for Selenium tests?**
    - Use external files (CSV, Excel, JSON), databases, or data factories. Parameterize tests for data-driven testing.

19. **How do you handle iframes and nested frames?**
    - Use `driver.switchTo().frame()` with frame name, index, or WebElement. Switch back with `defaultContent()`.

20. **How do you ensure maintainability and scalability of your Selenium test suite?**
    - Use POM, modular code, reusable utilities, regular refactoring, and CI/CD integration. Review and update tests as application evolves.

---

## RestAssured Interview Questions & Answers

1. **How do you validate response status, headers, and body in RestAssured?**
   - Use assertions: `then().statusCode(200)`, `header()`, `body()` with Hamcrest matchers.

2. **How do you handle authentication (Basic, OAuth, API keys) in RestAssured?**
   - Use `.auth().basic()`, `.oauth2()`, or add headers for API keys.
   - Example: `.header("Authorization", "Bearer token")`

3. **How do you send multipart/form-data requests (file upload) using RestAssured?**
   - Use `.multiPart()` method to attach files and form fields.

4. **How do you validate JSON and XML responses?**
   - Use `.body()` with JSONPath or XMLPath expressions and Hamcrest matchers.

5. **How do you handle dynamic payloads and parameterization in RestAssured?**
   - Use Java objects (POJOs), Maps, or external files (JSON, XML) for payloads. Parameterize using data providers or test frameworks.

6. **How do you chain API requests and use data from one response in another request?**
   - Extract data from response using `.extract()`, store in variables, and use in subsequent requests.

7. **How do you implement request/response logging and reporting?**
   - Use `.log().all()` or `.log().ifValidationFails()`. Integrate with reporting tools (Allure, ExtentReports).

8. **How do you handle SSL certificate issues in API automation?**
   - Use `.relaxedHTTPSValidation()` to bypass SSL errors in test environments.

9. **How do you test negative scenarios and error responses?**
   - Send invalid data, missing headers, or unauthorized requests. Assert on error status codes and messages.

10. **How do you integrate RestAssured with TestNG/JUnit and CI/CD pipelines?**
    - Use RestAssured in test methods, run via TestNG/JUnit, and configure in CI/CD jobs. Publish reports.

11. **How do you mock or stub APIs for testing?**
    - Use tools like WireMock, MockServer, or custom stubs to simulate API responses.

12. **How do you handle rate limiting and retries in API automation?**
    - Implement retry logic with delays, handle 429/503 responses, and respect API rate limits.

13. **How do you validate response time and performance using RestAssured?**
    - Use `.time()` assertion or custom logic to check response times.

14. **How do you handle cookies and session management in API tests?**
    - Use `.cookies()`, `.sessionId()`, and extract/set cookies between requests as needed.

15. **How do you design a maintainable and scalable API automation framework?**
    - Use modular code, utilities for common actions, configuration management, reporting, and CI/CD integration.

16. **How do you handle versioning and backward compatibility in API tests?**
    - Parameterize endpoints, maintain separate test suites for versions, and validate backward compatibility.

17. **How do you test GraphQL or SOAP APIs with RestAssured?**
    - For GraphQL: Send POST requests with query/mutation in body.
    - For SOAP: Set content type to XML and send SOAP envelope in body.

18. **How do you manage test data for API automation?**
    - Use external files, databases, or data factories. Clean up data after tests if needed.

19. **How do you handle file downloads and binary responses?**
    - Use `.asByteArray()` or `.asInputStream()` to process binary responses and save files.

20. **How do you ensure security testing (e.g., injection, auth bypass) in API automation?**
    - Test for common vulnerabilities (SQL injection, XSS, auth bypass) by sending malicious payloads and asserting on secure responses. 