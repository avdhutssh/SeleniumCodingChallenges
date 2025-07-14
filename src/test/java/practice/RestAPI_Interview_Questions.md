# REST API Interview Questions - Complete Guide

## Table of Contents
1. [Basic Concepts](#basic-concepts)
2. [API vs Web Service vs Microservice](#api-vs-web-service-vs-microservice)
3. [HTTP Status Codes](#http-status-codes)
4. [REST Methods Comparison](#rest-methods-comparison)
5. [Why API Testing is Needed](#why-api-testing-is-needed)
6. [RestAssured Coding Questions](#restassured-coding-questions)
7. [JSON Handling Questions](#json-handling-questions)
8. [Authentication Types in RestAssured](#authentication-types-in-restassured)
9. [OAuth 2.0 Architecture](#oauth-20-architecture)
10. [Authentication vs Authorization](#authentication-vs-authorization)
11. [Advanced REST API Concepts](#advanced-rest-api-concepts)
12. [REST API Testing Interview Questions](#rest-api-testing-interview-questions)
13. [Practical Scenarios](#practical-scenarios)

---

## Basic Concepts

### 1. What is REST API?
**Answer:** REST (Representational State Transfer) is an architectural style for designing networked applications. A REST API is a web service that follows REST principles:
- Stateless
- Client-Server architecture
- Cacheable
- Uniform interface
- Layered system
- Code on demand (optional)

### 2. What are the key principles of REST?
**Answer:**
- **Stateless**: Each request contains all information needed
- **Resource-based**: Everything is a resource with unique URI
- **HTTP methods**: Use standard HTTP methods (GET, POST, PUT, DELETE)
- **Representation**: Resources can have multiple representations (JSON, XML)
- **HATEOAS**: Hypermedia as the Engine of Application State

### 3. What is the difference between REST and RESTful?
**Answer:**
- **REST**: Architectural style/set of principles
- **RESTful**: Web service that implements REST principles

---

## API vs Web Service vs Microservice

### Detailed Comparison Table

| Aspect | API | Web Service | Microservice |
|--------|-----|-------------|--------------|
| **Definition** | Interface for communication between software components | Network-accessible service using web protocols | Small, independent service in distributed architecture |
| **Scope** | Broader concept, can be local or remote | Always network-based | Architecture pattern for building applications |
| **Protocol** | Any protocol (HTTP, TCP, etc.) | HTTP, SOAP, REST | Usually HTTP/REST |
| **Data Format** | Any format | XML, JSON, SOAP | Typically JSON |
| **Independence** | Can be part of monolith | Can be part of monolith | Independently deployable |
| **Communication** | Direct function calls or network | Network-based | Network-based (HTTP, messaging) |
| **Scalability** | Depends on implementation | Limited by monolithic nature | Highly scalable independently |
| **Technology** | Same or different languages | Usually same technology stack | Can use different tech stacks |
| **Deployment** | With main application | With main application | Independent deployment |
| **Example** | Java API, REST API | SOAP Web Service, REST Web Service | User Service, Order Service, Payment Service |

### Key Differences Explained:

**API (Application Programming Interface):**
- Interface contract between software components
- Can be local (within same application) or remote
- Examples: Java Collections API, REST API, GraphQL API

**Web Service:**
- Network-accessible service using web protocols
- Always involves network communication
- Types: SOAP, REST, XML-RPC
- Example: Weather service, Payment gateway service

**Microservice:**
- Architectural approach to build applications
- Small, focused, independently deployable services
- Each service owns its data and business logic
- Example: Netflix architecture, Amazon services

---

## HTTP Status Codes

### Complete Status Codes with Messages

| Code | Message | Description | When to Use |
|------|---------|-------------|-------------|
| **1xx - Informational** |
| 100 | Continue | Request received, continue with request | Large file uploads |
| 101 | Switching Protocols | Server switching protocols | WebSocket upgrade |
| **2xx - Success** |
| 200 | OK | Request successful | Successful GET, PUT |
| 201 | Created | Resource created successfully | Successful POST |
| 202 | Accepted | Request accepted for processing | Async operations |
| 204 | No Content | Successful but no content to return | Successful DELETE |
| **3xx - Redirection** |
| 301 | Moved Permanently | Resource permanently moved | URL changed permanently |
| 302 | Found | Resource temporarily moved | Temporary redirect |
| 304 | Not Modified | Resource not modified since last request | Caching scenarios |
| **4xx - Client Error** |
| 400 | Bad Request | Invalid request syntax | Malformed JSON, missing fields |
| 401 | Unauthorized | Authentication required | Missing/invalid credentials |
| 403 | Forbidden | Access denied | Valid credentials but no permission |
| 404 | Not Found | Resource not found | Invalid endpoint/resource ID |
| 405 | Method Not Allowed | HTTP method not supported | POST on read-only resource |
| 409 | Conflict | Request conflicts with current state | Duplicate resource creation |
| 422 | Unprocessable Entity | Request valid but semantic errors | Validation failures |
| 429 | Too Many Requests | Rate limit exceeded | API rate limiting |
| **5xx - Server Error** |
| 500 | Internal Server Error | Generic server error | Unhandled server exceptions |
| 502 | Bad Gateway | Invalid response from upstream | Proxy/gateway errors |
| 503 | Service Unavailable | Server temporarily unavailable | Maintenance, overload |
| 504 | Gateway Timeout | Upstream server timeout | Slow upstream services |

---

## REST Methods Comparison

### Comprehensive REST Methods Table

| Method | Purpose | Idempotent | Safe | Cacheable | Request Body | Response Body | Use Case |
|--------|---------|------------|------|-----------|--------------|---------------|----------|
| **GET** | Retrieve resource | ✅ Yes | ✅ Yes | ✅ Yes | ❌ No | ✅ Yes | Fetch user details |
| **POST** | Create resource | ❌ No | ❌ No | ❌ No | ✅ Yes | ✅ Yes | Create new user |
| **PUT** | Update/Replace resource | ✅ Yes | ❌ No | ❌ No | ✅ Yes | ✅ Yes | Update entire user |
| **PATCH** | Partial update | ❌ No* | ❌ No | ❌ No | ✅ Yes | ✅ Yes | Update user email |
| **DELETE** | Delete resource | ✅ Yes | ❌ No | ❌ No | ❌ No** | ✅ Optional | Delete user |
| **HEAD** | Get headers only | ✅ Yes | ✅ Yes | ✅ Yes | ❌ No | ❌ No | Check if resource exists |
| **OPTIONS** | Get allowed methods | ✅ Yes | ✅ Yes | ❌ No | ❌ No | ✅ Yes | CORS preflight |

**Notes:**
- *PATCH can be idempotent if designed properly
- **DELETE can have body in some implementations

### Key Concepts Explained:

**Idempotent:** Multiple identical requests have the same effect as a single request
**Safe:** Method doesn't modify server state
**Cacheable:** Response can be cached by clients/proxies

---

## Why API Testing is Needed

### 1. **Data Exchange Validation**
- Verify correct data format (JSON, XML)
- Validate data integrity between systems
- Ensure proper serialization/deserialization

### 2. **Business Logic Testing**
- Test business rules implementation
- Validate calculations and transformations
- Verify workflow processes

### 3. **Integration Testing**
- Test communication between services
- Validate third-party integrations
- Ensure proper error handling

### 4. **Performance Testing**
- Response time validation
- Load testing capabilities
- Scalability assessment

### 5. **Security Testing**
- Authentication mechanisms
- Authorization controls
- Data encryption validation
- Input validation testing

### 6. **Contract Testing**
- API specification compliance
- Backward compatibility
- Version management

### 7. **Early Bug Detection**
- Independent of UI development
- Faster feedback loop
- Cost-effective testing

---

## RestAssured Coding Questions

### 1. Basic GET Request
```java
@Test
public void testGetUser() {
    given()
        .baseUri("https://jsonplaceholder.typicode.com")
    .when()
        .get("/users/1")
    .then()
        .statusCode(200)
        .body("name", equalTo("Leanne Graham"))
        .body("email", equalTo("Sincere@april.biz"));
}
```

### 2. POST Request with JSON Body
```java
@Test
public void testCreateUser() {
    String requestBody = "{\n" +
        "  \"name\": \"John Doe\",\n" +
        "  \"email\": \"john@example.com\",\n" +
        "  \"phone\": \"123-456-7890\"\n" +
        "}";
    
    given()
        .baseUri("https://jsonplaceholder.typicode.com")
        .contentType(ContentType.JSON)
        .body(requestBody)
    .when()
        .post("/users")
    .then()
        .statusCode(201)
        .body("name", equalTo("John Doe"))
        .body("id", notNullValue());
}
```

### 3. PUT Request for Update
```java
@Test
public void testUpdateUser() {
    given()
        .baseUri("https://jsonplaceholder.typicode.com")
        .contentType(ContentType.JSON)
        .body("{\n" +
            "  \"id\": 1,\n" +
            "  \"name\": \"Updated Name\",\n" +
            "  \"email\": \"updated@example.com\"\n" +
            "}")
    .when()
        .put("/users/1")
    .then()
        .statusCode(200)
        .body("name", equalTo("Updated Name"));
}
```

### 4. DELETE Request
```java
@Test
public void testDeleteUser() {
    given()
        .baseUri("https://jsonplaceholder.typicode.com")
    .when()
        .delete("/users/1")
    .then()
        .statusCode(200);
}
```

### 5. Query Parameters
```java
@Test
public void testGetUsersWithQueryParams() {
    given()
        .baseUri("https://jsonplaceholder.typicode.com")
        .queryParam("userId", 1)
    .when()
        .get("/posts")
    .then()
        .statusCode(200)
        .body("size()", greaterThan(0));
}
```

### 6. Path Parameters
```java
@Test
public void testGetUserWithPathParam() {
    given()
        .baseUri("https://jsonplaceholder.typicode.com")
        .pathParam("id", 1)
    .when()
        .get("/users/{id}")
    .then()
        .statusCode(200)
        .body("id", equalTo(1));
}
```

### 7. Headers Validation
```java
@Test
public void testResponseHeaders() {
    given()
        .baseUri("https://jsonplaceholder.typicode.com")
    .when()
        .get("/users")
    .then()
        .statusCode(200)
        .header("Content-Type", "application/json; charset=utf-8")
        .header("Server", notNullValue());
}
```

### 8. Response Time Validation
```java
@Test
public void testResponseTime() {
    given()
        .baseUri("https://jsonplaceholder.typicode.com")
    .when()
        .get("/users")
    .then()
        .statusCode(200)
        .time(lessThan(2000L)); // Response time less than 2 seconds
}
```

### 9. Extract Response Values
```java
@Test
public void testExtractResponseValues() {
    Response response = given()
        .baseUri("https://jsonplaceholder.typicode.com")
    .when()
        .get("/users/1")
    .then()
        .statusCode(200)
        .extract().response();
    
    String name = response.path("name");
    String email = response.path("email");
    
    System.out.println("Name: " + name);
    System.out.println("Email: " + email);
}
```

### 10. File Upload
```java
@Test
public void testFileUpload() {
    given()
        .multiPart("file", new File("test-file.txt"))
        .multiPart("description", "Test file upload")
    .when()
        .post("https://httpbin.org/post")
    .then()
        .statusCode(200)
        .body("files.file", notNullValue());
}
```

---

## JSON Handling Questions

### 1. Parse JSON Response
```java
@Test
public void testParseJsonResponse() {
    Response response = given()
        .baseUri("https://jsonplaceholder.typicode.com")
    .when()
        .get("/users/1");
    
    JsonPath jsonPath = response.jsonPath();
    String name = jsonPath.getString("name");
    String email = jsonPath.getString("email");
    
    Assert.assertEquals("Leanne Graham", name);
    Assert.assertEquals("Sincere@april.biz", email);
}
```

### 2. Validate JSON Array
```java
@Test
public void testJsonArray() {
    given()
        .baseUri("https://jsonplaceholder.typicode.com")
    .when()
        .get("/users")
    .then()
        .statusCode(200)
        .body("size()", equalTo(10))
        .body("name", hasItems("Leanne Graham", "Ervin Howell"))
        .body("[0].name", equalTo("Leanne Graham"));
}
```

### 3. Complex JSON Validation
```java
@Test
public void testComplexJsonValidation() {
    given()
        .baseUri("https://jsonplaceholder.typicode.com")
    .when()
        .get("/users/1")
    .then()
        .statusCode(200)
        .body("address.street", equalTo("Kulas Light"))
        .body("address.geo.lat", equalTo("-37.3159"))
        .body("company.name", equalTo("Romaguera-Crona"));
}
```

### 4. JSON Schema Validation
```java
@Test
public void testJsonSchemaValidation() {
    given()
        .baseUri("https://jsonplaceholder.typicode.com")
    .when()
        .get("/users/1")
    .then()
        .statusCode(200)
        .body(matchesJsonSchemaInClasspath("user-schema.json"));
}
```

### 5. Create JSON using POJO
```java
public class User {
    private String name;
    private String email;
    private String phone;
    
    // Constructors, getters, setters
}

@Test
public void testCreateUserWithPOJO() {
    User user = new User("John Doe", "john@example.com", "123-456-7890");
    
    given()
        .baseUri("https://jsonplaceholder.typicode.com")
        .contentType(ContentType.JSON)
        .body(user)
    .when()
        .post("/users")
    .then()
        .statusCode(201);
}
```

### 6. JSON Path Expressions
```java
@Test
public void testJsonPathExpressions() {
    given()
        .baseUri("https://jsonplaceholder.typicode.com")
    .when()
        .get("/users")
    .then()
        .statusCode(200)
        .body("findAll{it.id > 5}.name", hasSize(5))
        .body("find{it.name == 'Leanne Graham'}.email", equalTo("Sincere@april.biz"));
}
```

---

## Authentication Types in RestAssured

### 1. Basic Authentication
```java
@Test
public void testBasicAuth() {
    given()
        .auth().basic("username", "password")
    .when()
        .get("https://httpbin.org/basic-auth/username/password")
    .then()
        .statusCode(200);
}
```

### 2. Digest Authentication
```java
@Test
public void testDigestAuth() {
    given()
        .auth().digest("username", "password")
    .when()
        .get("https://httpbin.org/digest-auth/auth/username/password")
    .then()
        .statusCode(200);
}
```

### 3. OAuth 1.0
```java
@Test
public void testOAuth1() {
    given()
        .auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecret")
    .when()
        .get("https://api.twitter.com/1.1/account/settings.json")
    .then()
        .statusCode(200);
}
```

### 4. OAuth 2.0 Bearer Token
```java
@Test
public void testOAuth2BearerToken() {
    String accessToken = "your-access-token";
    
    given()
        .auth().oauth2(accessToken)
    .when()
        .get("https://api.github.com/user")
    .then()
        .statusCode(200);
}
```

### 5. API Key Authentication
```java
@Test
public void testApiKeyAuth() {
    given()
        .header("X-API-Key", "your-api-key")
    .when()
        .get("https://api.example.com/data")
    .then()
        .statusCode(200);
}
```

### 6. Custom Authentication Header
```java
@Test
public void testCustomAuthHeader() {
    given()
        .header("Authorization", "Bearer " + getAccessToken())
    .when()
        .get("https://api.example.com/protected-resource")
    .then()
        .statusCode(200);
}
```

### 7. Form-based Authentication
```java
@Test
public void testFormBasedAuth() {
    // First, login to get session
    Response loginResponse = given()
        .formParam("username", "testuser")
        .formParam("password", "testpass")
    .when()
        .post("https://example.com/login");
    
    String sessionId = loginResponse.getCookie("JSESSIONID");
    
    // Use session for subsequent requests
    given()
        .cookie("JSESSIONID", sessionId)
    .when()
        .get("https://example.com/protected-page")
    .then()
        .statusCode(200);
}
```

---

## OAuth 2.0 Architecture

### What is OAuth 2.0?
**Answer:** OAuth 2.0 is an authorization framework that enables applications to obtain limited access to user accounts on an HTTP service. It works by delegating user authentication to the service that hosts the user account and authorizing third-party applications to access the user account.

### OAuth 2.0 Flow Architecture

```
┌─────────────┐                                           ┌───────────────┐
│             │--(A)- Authorization Request ------------->│   Resource    │
│             │                                           │     Owner     │
│             │<-(B)-- Authorization Grant ---------------│               │
│             │                                           └───────────────┘
│             │
│             │                                           ┌───────────────┐
│             │--(C)-- Authorization Grant -------------->│ Authorization │
│    Client   │                                           │     Server    │
│             │<-(D)----- Access Token -------------------│               │
│             │                                           └───────────────┘
│             │
│             │                                           ┌───────────────┐
│             │--(E)----- Access Token ------------------>│    Resource   │
│             │                                           │     Server    │
│             │<-(F)--- Protected Resource ---------------│               │
└─────────────┘                                           └───────────────┘
```

### OAuth 2.0 Grant Types

| Grant Type | Use Case | Flow Description |
|------------|----------|------------------|
| **Authorization Code** | Web applications | Most secure, involves redirect |
| **Implicit** | Single-page applications | Direct token in URL (deprecated) |
| **Resource Owner Password** | Trusted applications | Direct username/password exchange |
| **Client Credentials** | Machine-to-machine | Service-to-service authentication |
| **Refresh Token** | Token renewal | Obtain new access token |

### OAuth 2.0 Components

1. **Resource Owner**: User who owns the data
2. **Client**: Application requesting access
3. **Authorization Server**: Issues access tokens
4. **Resource Server**: Hosts protected resources

### OAuth 2.0 Implementation in RestAssured

```java
// Authorization Code Flow - Step 1: Get Authorization Code
@Test
public void getAuthorizationCode() {
    String authUrl = "https://oauth-provider.com/oauth/authorize?" +
        "response_type=code&" +
        "client_id=your-client-id&" +
        "redirect_uri=https://your-app.com/callback&" +
        "scope=read write";
    
    // User manually visits this URL and gets authorization code
    System.out.println("Visit: " + authUrl);
}

// Step 2: Exchange Authorization Code for Access Token
@Test
public void exchangeCodeForToken() {
    String code = "authorization-code-from-step-1";
    
    Response response = given()
        .contentType(ContentType.URLENC)
        .formParam("grant_type", "authorization_code")
        .formParam("code", code)
        .formParam("redirect_uri", "https://your-app.com/callback")
        .formParam("client_id", "your-client-id")
        .formParam("client_secret", "your-client-secret")
    .when()
        .post("https://oauth-provider.com/oauth/token")
    .then()
        .statusCode(200)
        .extract().response();
    
    String accessToken = response.path("access_token");
    String refreshToken = response.path("refresh_token");
}

// Step 3: Use Access Token
@Test
public void useAccessToken() {
    String accessToken = "your-access-token";
    
    given()
        .auth().oauth2(accessToken)
    .when()
        .get("https://api.example.com/protected-resource")
    .then()
        .statusCode(200);
}

// Client Credentials Flow
@Test
public void clientCredentialsFlow() {
    Response response = given()
        .contentType(ContentType.URLENC)
        .formParam("grant_type", "client_credentials")
        .formParam("client_id", "your-client-id")
        .formParam("client_secret", "your-client-secret")
        .formParam("scope", "read write")
    .when()
        .post("https://oauth-provider.com/oauth/token")
    .then()
        .statusCode(200)
        .extract().response();
    
    String accessToken = response.path("access_token");
}
```

---

## Authentication vs Authorization

### Detailed Comparison

| Aspect | Authentication | Authorization |
|--------|----------------|---------------|
| **Definition** | Verifies "Who you are" | Determines "What you can do" |
| **Purpose** | Identity verification | Permission control |
| **Process** | Login with credentials | Check access rights |
| **When** | Before accessing system | After authentication |
| **Methods** | Username/password, biometrics, tokens | Roles, permissions, ACLs |
| **Example** | Login to Gmail | Access specific emails/folders |
| **Failure Result** | 401 Unauthorized | 403 Forbidden |
| **Data Required** | Credentials (username, password) | User roles, permissions |

### Authentication Types

1. **Basic Authentication**
   - Username and password encoded in Base64
   - Sent in HTTP header: `Authorization: Basic <encoded-credentials>`

2. **Token-based Authentication**
   - JWT (JSON Web Tokens)
   - Session tokens
   - API keys

3. **OAuth Authentication**
   - Delegated authorization
   - Third-party authentication

4. **Multi-factor Authentication (MFA)**
   - Something you know (password)
   - Something you have (phone)
   - Something you are (biometrics)

### Authorization Models

1. **Role-Based Access Control (RBAC)**
   - Users assigned to roles
   - Roles have permissions

2. **Attribute-Based Access Control (ABAC)**
   - Dynamic permissions based on attributes

3. **Access Control Lists (ACL)**
   - Direct user-resource permissions

### Real-world Examples

```java
// Authentication Example
@Test
public void testAuthentication() {
    // This verifies WHO the user is
    given()
        .auth().basic("john.doe", "password123")
    .when()
        .post("/login")
    .then()
        .statusCode(200)
        .body("message", equalTo("Authentication successful"));
}

// Authorization Example
@Test
public void testAuthorization() {
    // This checks WHAT the authenticated user can do
    String token = getAuthToken("john.doe", "password123");
    
    // John can read user data (authorized)
    given()
        .header("Authorization", "Bearer " + token)
    .when()
        .get("/users/profile")
    .then()
        .statusCode(200);
    
    // But John cannot delete users (not authorized)
    given()
        .header("Authorization", "Bearer " + token)
    .when()
        .delete("/users/123")
    .then()
        .statusCode(403); // Forbidden
}
```

---

## Advanced REST API Concepts

### 1. HATEOAS (Hypermedia as the Engine of Application State)
**Definition:** Clients interact with the application entirely through hypermedia provided dynamically by application servers.

```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com",
  "_links": {
    "self": { "href": "/users/1" },
    "edit": { "href": "/users/1/edit" },
    "delete": { "href": "/users/1" },
    "orders": { "href": "/users/1/orders" }
  }
}
```

### 2. Content Negotiation
**Purpose:** Serve different representations based on client preferences.

```java
// Client requests JSON
given()
    .accept(ContentType.JSON)
.when()
    .get("/users/1");

// Client requests XML
given()
    .accept(ContentType.XML)
.when()
    .get("/users/1");
```

### 3. API Versioning Strategies

```java
// URL Path Versioning
given().when().get("/api/v1/users");
given().when().get("/api/v2/users");

// Header Versioning
given()
    .header("API-Version", "1.0")
.when()
    .get("/api/users");

// Query Parameter Versioning
given()
    .queryParam("version", "2.0")
.when()
    .get("/api/users");

// Media Type Versioning
given()
    .accept("application/vnd.api.v1+json")
.when()
    .get("/api/users");
```

### 4. Rate Limiting
**Purpose:** Control the number of requests a client can make.

```java
@Test
public void testRateLimit() {
    for (int i = 0; i < 100; i++) {
        Response response = given()
            .header("X-API-Key", "test-key")
        .when()
            .get("/api/data");
        
        if (response.getStatusCode() == 429) {
            System.out.println("Rate limit hit at request: " + (i + 1));
            String retryAfter = response.getHeader("Retry-After");
            System.out.println("Retry after: " + retryAfter + " seconds");
            break;
        }
    }
}
```

### 5. Caching Strategies

```java
// Cache Control Headers
given()
.when()
    .get("/users")
.then()
    .header("Cache-Control", "max-age=3600")
    .header("ETag", notNullValue());

// Conditional Requests
String etag = given()
    .when().get("/users/1")
    .then().extract().header("ETag");

given()
    .header("If-None-Match", etag)
.when()
    .get("/users/1")
.then()
    .statusCode(304); // Not Modified
```

---

## REST API Testing Interview Questions

### Basic Level Questions

**Q1: What is the difference between SOAP and REST?**
**Answer:**
| Aspect | SOAP | REST |
|--------|------|------|
| Protocol | Protocol | Architectural style |
| Message Format | XML only | JSON, XML, HTML, plain text |
| Transport | HTTP, SMTP, TCP | Primarily HTTP |
| Security | WS-Security | HTTPS, OAuth |
| Performance | Slower (XML overhead) | Faster (lightweight) |
| Caching | Not cacheable | Cacheable |

**Q2: What are the advantages of REST API testing?**
**Answer:**
- Language and platform independent
- Faster than GUI testing
- Better test coverage
- Early detection of bugs
- Easy automation
- Cost-effective

**Q3: What tools can be used for REST API testing?**
**Answer:**
- **Code-based**: RestAssured, Postman Newman, Karate
- **GUI-based**: Postman, Insomnia, SoapUI
- **Command-line**: cURL, HTTPie
- **Load testing**: JMeter, LoadRunner

### Intermediate Level Questions

**Q4: How do you handle dynamic values in API testing?**
**Answer:**
```java
// Extract value from one response and use in another
String userId = given()
    .when().post("/users")
    .then().extract().path("id");

given()
    .pathParam("id", userId)
.when()
    .get("/users/{id}");
```

**Q5: How do you validate JSON schema?**
**Answer:**
```java
given()
.when()
    .get("/users/1")
.then()
    .body(matchesJsonSchemaInClasspath("user-schema.json"));
```

**Q6: How do you handle cookies in RestAssured?**
**Answer:**
```java
// Set cookie
given()
    .cookie("sessionId", "abc123")
.when()
    .get("/profile");

// Extract cookie
String sessionId = given()
    .when().post("/login")
    .then().extract().cookie("JSESSIONID");
```

### Advanced Level Questions

**Q7: How do you implement data-driven testing in RestAssured?**
**Answer:**
```java
@DataProvider
public Object[][] userData() {
    return new Object[][] {
        {"John", "john@example.com"},
        {"Jane", "jane@example.com"}
    };
}

@Test(dataProvider = "userData")
public void testCreateUser(String name, String email) {
    given()
        .contentType(ContentType.JSON)
        .body("{\"name\":\"" + name + "\",\"email\":\"" + email + "\"}")
    .when()
        .post("/users")
    .then()
        .statusCode(201);
}
```

**Q8: How do you handle parallel execution in API testing?**
**Answer:**
```java
// TestNG parallel execution
@Test(threadPoolSize = 5, invocationCount = 10)
public void testParallelExecution() {
    given()
    .when()
        .get("/users")
    .then()
        .statusCode(200);
}
```

**Q9: How do you mock external API dependencies?**
**Answer:**
```java
// Using WireMock
@Test
public void testWithMockedAPI() {
    stubFor(get(urlEqualTo("/external-api/data"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody("{\"status\":\"success\"}")));
    
    // Test your API that calls the mocked external API
    given()
    .when()
        .get("/your-api/endpoint")
    .then()
        .statusCode(200);
}
```

**Q10: How do you implement contract testing?**
**Answer:**
```java
// Consumer contract test
@Test
public void testUserServiceContract() {
    given()
    .when()
        .get("/users/1")
    .then()
        .statusCode(200)
        .body("id", notNullValue())
        .body("name", notNullValue())
        .body("email", matchesPattern(".*@.*\\..*"));
}
```

### Performance Testing Questions

**Q11: How do you measure API response time?**
**Answer:**
```java
@Test
public void testResponseTime() {
    given()
    .when()
        .get("/users")
    .then()
        .time(lessThan(2000L))
        .statusCode(200);
}
```

**Q12: How do you implement load testing for APIs?**
**Answer:**
```java
@Test(invocationCount = 100, threadPoolSize = 10)
public void loadTest() {
    long startTime = System.currentTimeMillis();
    
    given()
    .when()
        .get("/users")
    .then()
        .statusCode(200);
    
    long endTime = System.currentTimeMillis();
    System.out.println("Response time: " + (endTime - startTime) + "ms");
}
```

### Security Testing Questions

**Q13: How do you test for SQL injection in APIs?**
**Answer:**
```java
@Test
public void testSQLInjection() {
    String maliciousInput = "1' OR '1'='1";
    
    given()
        .queryParam("userId", maliciousInput)
    .when()
        .get("/users")
    .then()
        .statusCode(400); // Should return bad request, not 200
}
```

**Q14: How do you test API security headers?**
**Answer:**
```java
@Test
public void testSecurityHeaders() {
    given()
    .when()
        .get("/users")
    .then()
        .header("X-Content-Type-Options", "nosniff")
        .header("X-Frame-Options", "DENY")
        .header("X-XSS-Protection", "1; mode=block");
}
```

---

## Common Interview Questions & Answers

### Q1: What's the difference between PUT and PATCH?
**Answer:**
- **PUT**: Replaces entire resource, idempotent
- **PATCH**: Partial update, may or may not be idempotent

### Q2: How do you handle dynamic JSON responses?
**Answer:** Use JsonPath with wildcards or extract specific values:
```java
.body("data.find{it.status == 'active'}.id", notNullValue())
```

### Q3: How to validate response time in RestAssured?
**Answer:**
```java
.then()
    .time(lessThan(2000L))
```

### Q4: How to handle SSL certificates?
**Answer:**
```java
given()
    .relaxedHTTPSValidation()
.when()
    .get("https://secure-api.com/data");
```

### Q5: What's the difference between 401 and 403?
**Answer:**
- **401 Unauthorized**: Authentication required (login needed)
- **403 Forbidden**: Authenticated but not authorized (permission denied)

---

## Practical Scenarios

### 1. End-to-End Workflow Testing
```java
@Test
public void testCompleteUserWorkflow() {
    // Create user
    Response createResponse = given()
        .contentType(ContentType.JSON)
        .body("{\"name\":\"Test User\",\"email\":\"test@example.com\"}")
    .when()
        .post("/users")
    .then()
        .statusCode(201)
        .extract().response();
    
    int userId = createResponse.path("id");
    
    // Get created user
    given()
        .pathParam("id", userId)
    .when()
        .get("/users/{id}")
    .then()
        .statusCode(200)
        .body("name", equalTo("Test User"));
    
    // Update user
    given()
        .pathParam("id", userId)
        .contentType(ContentType.JSON)
        .body("{\"name\":\"Updated User\"}")
    .when()
        .put("/users/{id}")
    .then()
        .statusCode(200);
    
    // Delete user
    given()
        .pathParam("id", userId)
    .when()
        .delete("/users/{id}")
    .then()
        .statusCode(204);
}
```

### 2. Error Handling Testing
```java
@Test
public void testErrorScenarios() {
    // Test 404 - Not Found
    given()
    .when()
        .get("/users/99999")
    .then()
        .statusCode(404)
        .body("error", equalTo("User not found"));
    
    // Test 400 - Bad Request
    given()
        .contentType(ContentType.JSON)
        .body("{\"invalid\":\"json\"}")
    .when()
        .post("/users")
    .then()
        .statusCode(400)
        .body("error", containsString("validation"));
}
```

### 3. Performance Testing
```java
@Test
public void testAPIPerformance() {
    long startTime = System.currentTimeMillis();
    
    given()
    .when()
        .get("/users")
    .then()
        .statusCode(200)
        .time(lessThan(1000L)); // Response time should be less than 1 second
    
    long endTime = System.currentTimeMillis();
    System.out.println("Response time: " + (endTime - startTime) + "ms");
}
```

---

This comprehensive guide covers all major REST API testing concepts and RestAssured implementation details that are commonly asked in interviews. Practice these examples to master API testing! 