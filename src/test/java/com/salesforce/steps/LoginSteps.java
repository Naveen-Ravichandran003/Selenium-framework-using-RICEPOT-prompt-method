package com.salesforce.steps;

import com.salesforce.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private Scenario scenario;

    @Before
    public void setup(Scenario scenario) {
        this.scenario = scenario;
        try {
            org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");
            // Disable logging to speed up execution
            System.setProperty("webdriver.chrome.silentOutput", "true");
            driver = new ChromeDriver(options);
            loginPage = new LoginPage(driver);
        } catch (Exception e) {
            throw new RuntimeException("Driver initialization failed: " + e.getMessage());
        }
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        // Removed hard wait to improve execution speed. 
        // Screenshots are still captured in hooks or steps as defined.
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && driver != null) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failure Screenshot");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I navigate to the Salesforce login page")
    public void i_navigate_to_the_salesforce_login_page() {
        try {
            driver.get("https://login.salesforce.com/?locale=in");
        } catch (Exception e) {
            throw new RuntimeException("Navigation failed: " + e.getMessage());
        }
    }

    @When("I enter invalid username {string} and password {string}")
    public void i_enter_invalid_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("the login page elements should be visible")
    public void the_login_page_elements_should_be_visible() {
        Assert.assertTrue(loginPage.isUsernameDisplayed(), "Username field contains NOT displayed");
        Assert.assertTrue(loginPage.isPasswordDisplayed(), "Password field contains NOT displayed");
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button contains NOT displayed");
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedError) {
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError, expectedError, "Error message mismatch");
    }

    @Given("I take a screenshot")
    public void i_take_a_screenshot() {
        if (driver != null) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Explicit Screenshot");
            } catch (Exception e) {
                System.err.println("Failed to take screenshot: " + e.getMessage());
            }
        }
    }
}
