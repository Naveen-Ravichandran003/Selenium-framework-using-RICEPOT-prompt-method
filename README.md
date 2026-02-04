# Salesforce Automation Framework - RICEPOT Prompt Method

[![Test Execution Status](https://img.shields.io/badge/Test%20Status-PASS-brightgreen)](./target/cucumber-reports/cucumber.html)
[![Selenium Version](https://img.shields.io/badge/Selenium-4.28.1-blue)](pom.xml)
[![Java Version](https://img.shields.io/badge/Java-21-orange)](pom.xml)

## 📌 Project Overview

This project implements an enterprise-grade **Selenium Automation Framework** for Salesforce, designed using the advanced **RICEPOT Prompt Method**. It features a robust Page Object Model (POM) architecture integrated with **Cucumber BDD** and **TestNG**, ensuring scalability, maintainability, and high-quality reporting.

---

## 🏗️ Architecture Diagram

```mermaid
graph TD
    User((QA Engineer)) -->|Executes| TestRunner[TestRunner / Runner.java]
    TestRunner -->|Triggers| TestNG{TestNG Suite}
    TestNG -->|Runs| Cucumber[Cucumber Features]
    
    subgraph "Test Layer (BDD)"
        Cucumber -->|Steps| LoginSteps[LoginSteps.java]
        LoginSteps -->|Uses| LoginPage[LoginPage.java]
        LoginSteps -->|Hooks| Hooks["@Before / @After"]
    end
    
    subgraph "Core Layer (Selenium)"
        LoginPage -->|Locates| Elements["@FindBy ID"]
        LoginPage -->|Actions| WebDriver[Selenium WebDriver]
        WebDriver -->|Interacts| Browser(Chrome Browser)
    end
    
    subgraph "Reporting & Evidence"
        Hooks -->|Captures| Screenshots[Screenshots (.png)]
        Cucumber -->|Generates| HTMLReport[Cucumber HTML Report]
        Cucumber -->|Generates| JSONReport[Cucumber JSON Report]
    end
```

---

## 🚀 The RICEPOT Method Implementation

This framework is a direct result of advanced **Prompt Engineering** using the **RICEPOT** framework. By carefully structuring the initial request to the AI, we ensured the generated code was production-ready from the first iteration.

### Breakdown of the Prompt Strategy:

| Component | Concept | Application in this Project |
| :--- | :--- | :--- |
| **R - Role** | **Senior QA Automation Architect** |  15+ years experience, specializing in enterprise-scale Selenium/Java/Cucumber frameworks. Expertise in CRM (Salesforce). Focus on stability, scalability, CI/CD readiness, and near-zero technical debt. |
| **I - Instructions** | **Framework Specifications** | **Stack:** Java, Selenium, Cucumber (BDD), TestNG, Maven, POM w/ PageFactory.<br>**Rules:**<br>• Use **ID locators ONLY** (No XPath/CSS).<br>• Use **WebDriverWait ONLY** (No Thread.sleep/Implicit waits).<br>• **Screenshots:** Mandatory for both success and failure.<br>• **Reporting:** Auto-generated HTML reports.<br>• **Exception Handling:** Robust try-catch blocks. |
| **C - Context** | **Domain Specifics** | **Target:** Salesforce Login Page (highly dynamic, A/B testing environment).<br>**Components:** Username, Password, Login Button, 'Remember Me', Error Validation.<br>**Requirement:** Framework must be resilient and stable despite UI changes. |
| **E - Example** | **Code Standards** | provided specific examples of strict `@FindBy(id = "...")` usage to enforce the locator strategy and prevent deviations. |
| **P - Parameters** | **Quality Gates** | • Production-grade architecture.<br>• Zero bad practices.<br>• No redundant or commented code.<br>• Defensive programming mindset.<br>• Pin-point accuracy in validation. |
| **O - Output** | **Deliverables** | **Runnable Code Only** (No explanations).<br>1. Page Object Class<br>2. Cucumber Feature File<br>3. Step Definition Class<br>4. TestNG Runner<br>5. Maven `pom.xml` with reporting config. |
| **T - Tone** | **Interaction Style** | Highly technical, precise, enterprise-grade, code-only output, Architect-level quality. |

### Why use RICEPOT?
Using this method prevents "hallucinations" and generic code generation. It forces the AI to check against a mental checklist of constraints before writing a single line of code, resulting in a framework that is:
*   **More Stable:** By enforcing ID locators and explicit waits.
*   **More Maintainable:** By enforcing POM architecture.
*   **More Reliable:** By setting the "Senior Architect" persona.

---

## 🧪 Test Scenarios

### 1. Verify Login Page Elements
*   **Goal:** Ensure critical UI components are visible upon load.
*   **Validation:** Username field, Password field, Login button.
*   **Evidence:** Explicit screenshot taken.

### 2. Invalid Login Attempt
*   **Goal:** Verify error handling for incorrect credentials.
*   **Validation:** "Error: Please check your username..." message.
*   **Evidence:** Screenshot taken on success or failure.

---

## 📊 Test Reports & Screenshots

The framework automatically generates comprehensive reports after every execution.

### Latest Execution Summary
*   **Date:** 2026-02-04
*   **Total Tests:** 2
*   **Status:** ✅ **PASS** (100%)
*   **Summary:** 2 Passed, 0 Failed

### HTML Report
**👉 [CLICK HERE TO VIEW TEST REPORT](./target/cucumber-reports/cucumber.html)**
*   Contains detailed steps, execution time, and status.
*   **Embedded Screenshots** for validation points and failures.

### Latest Screenshots
*(Extracted from the latest run)*

| Login Verify | Invalid Login |
| :---: | :---: |
| ![Login Verify](./screenshots/screenshot_1.png) | ![Invalid Login](./screenshots/screenshot_2.png) |

---

## 🛠️ Setup & Execution

### Prerequisites
*   Java JDK 21+
*   Maven
*   Google Chrome

### Running Tests (Command Line)
```bash
mvn clean test
```

### Running Tests (IDE / Manual)
1.  Open `src/test/java/com/salesforce/runners/Runner.java`
2.  Run as Java Application.
3.  **Report will auto-open** in your default browser upon completion.

---

## 📁 Project Structure

```
Project Root
├── src/
│   ├── main/java/.../pages/       # Page Object Classes (LoginPage.java)
│   ├── test/java/.../steps/       # Step Definitions (LoginSteps.java)
│   ├── test/java/.../runners/     # Test Runners (TestRunner.java, Runner.java)
│   └── test/resources/features/   # Cucumber Feature Files (.feature)
├── screenshots/                   # Evidence Screenshots (Tracked in Git)
├── target/                        # Build artifacts & Reports (Ignored/Generated)
├── pom.xml                        # Maven Dependencies
├── testng.xml                     # TestNG Reporting Config
├── .gitignore                     # Git exclusion rules
└── README.md                      # Documentation
```
