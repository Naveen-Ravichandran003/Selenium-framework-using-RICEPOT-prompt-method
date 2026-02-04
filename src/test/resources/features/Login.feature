Feature: Salesforce Login Functionality

  Background:
    Given I navigate to the Salesforce login page

  Scenario: Verify Login Page Elements
    Then the login page elements should be visible
    And I take a screenshot

  Scenario: Invalid login attempt
    When I enter invalid username "invalid@example.com" and password "WrongPass"
    And I click the login button
    Then I should see an error message "Error: Please check your username and password. If you still can't log in, contact your Salesforce administrator."
    And I take a screenshot
