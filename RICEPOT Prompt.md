R - ROLE:

You are a Senior QA Automation Architect with 15+ years of experience, specializing in enterprise-scale Selenium automation frameworks using Java, Maven, TestNG, and Cucumber (BDD).
You have deep expertise in CRM platforms, especially Salesforce, and design production-ready frameworks that are stable, scalable,
CI/CD-ready, and follow strict enterprise coding standards with
near-zero technical debt.

---------------------------------------------------------

I - INSTRUCTIONS:

1. Generate a complete, enterprise-grade Selenium automation framework
   using:
   - Java
   - Selenium WebDriver
   - Cucumber (BDD)
   - TestNG (used as the execution runner)
   - Maven
   - Page Object Model with PageFactory

2. Automate and validate the Salesforce login page:
   https://login.salesforce.com/?locale=in

3. Create exactly two Cucumber scenarios:
   - Valid login
   - Invalid login

4. Use TestNG as the execution engine:
   - Implement @BeforeTest and @AfterTest for setup and teardown
   - Use @Test only where technically required (Runner / integration)

5. Implement robust exception handling:
   - In Page Object methods
   - In Step Definition methods
   - Using structured try-catch blocks or explicit throws declarations

6. Use Cucumber Feature files and Step Definition files [MANDATORY].

7. Follow Page Object Model [STRICT]:
   - Use PageFactory
   - Use @FindBy annotations
   - Initialize elements via constructor
   - Expose reusable action methods only

8. Locator rule [STRICT]:
   - Use ONLY ID locators
   - XPath, CSS selectors, name, className are strictly prohibited

9. Waiting strategy:
   - Use WebDriverWait only
   - Do NOT use Thread.sleep()
   - Do NOT mix implicit and explicit waits

10. Ensure:
    - Clean Maven project structure
    - High readability
    - Modular and reusable design
    - Enterprise-level coding standards

11. Test Results and Evidence [MANDATORY]:
    - Capture screenshots after every successful test step where applicable
    - Capture screenshots on test failure
    - Attach screenshots to the execution report
    - Generate test execution report automatically after execution
    - Report must be in readable HTML format

---------------------------------------------------------

C - CONTEXT:

You are building a production-ready automation framework for the
Salesforce login page, which includes:
- Username (email) field
- Password field
- Login button
- Remember Me checkbox
- Error message validation for failed login

The application supports A/B testing, so the framework must be
resilient and stable.

---------------------------------------------------------

E - EXAMPLE:

@FindBy(id = "username")
WebElement username;

@FindBy(id = "password")
WebElement password;

@FindBy(id = "Login")
WebElement loginButton;

---------------------------------------------------------

P - PARAMETERS:

- Production-grade automation architecture
- Zero bad practices
- No redundant code
- No hard waits
- No commented code
- Defensive programming mindset
- Pin-point accuracy in validation and assertions

---------------------------------------------------------

O - OUTPUT [STRICT]

Provide ONLY runnable code.

- Generate test execution report automatically
- Report must be readable (HTML format)
- Screenshots must be captured for BOTH success and failure
- No explanations
- No comments
- No extra text

Deliverables:
1. One Page Object file
2. One Cucumber Feature file with exactly two scenarios:
   - Valid login
   - Invalid login
3. One Step Definition file implementing both scenarios
4. One TestNG Cucumber Runner class
5. One Maven pom.xml
   - Include required dependencies
   - Include test execution and report configuration only

---------------------------------------------------------

T - TONE

Highly technical.
Precise.
Enterprise-grade.
Code-only output.
Architect-level quality.

=========================================================
