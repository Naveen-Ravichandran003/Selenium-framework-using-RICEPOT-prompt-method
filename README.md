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
        LoginSteps -->|Hooks| Hooks[@Before / @After]
    end
    
    subgraph "Core Layer (Selenium)"
        LoginPage -->|Locates| Elements[@FindBy ID]
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
| **R - Role** | **Persona Definition** | The AI was instructed to act as a **Senior QA Automation Architect** with expertise in building scalable, enterprise frameworks. This ensured the code wasn't just "functional" but successfully adhered to design patterns like POM and SOLID principles. |
| **I - Instructions** | **Explicit Directives** | We provided strict technical rules: use **ID locators only** (for stability), use **PageFactory**, and implement **explicit waits** (`WebDriverWait`) instead of unreliable Thread.sleeps or implicit waits. |
| **C - Context** | **Domain Knowledge** | The context was set to **Salesforce Login Automation**, a complex environment often dealing with dynamic elements and A/B testing. The framework was built to handle these specific challenges. |
| **E - Example** | **Few-Shot Learning** | We referenced standard industry coding styles, requiring the code to look like it was written by a human expert—clean indentation, proper variable naming, and comprehensive Javadoc/logging. |
| **P - Parameters** | **Constraints** | We set boundaries: "No flakey tests," "Must support parallel execution," and "Must run on Windows/Chrome." We also mandated the removal of all hardcoded waits (except for visual debug purposes). |
| **O - Output** | **Format & Deliverables** | The output was strictly defined: A Maven project structure, Feature files in Gherkin, distinct Page Object classes, and a robust TestNG runner. |
| **T - Tone** | **Communication Style** | The interaction tone was set to **Professional, Technical, and Concise**. The AI focused on delivering code and architectural explanations rather than conversational filler. |

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

### HTML Report
**👉 [CLICK HERE TO VIEW TEST REPORT](./target/cucumber-reports/cucumber.html)**
*   Contains detailed steps, execution time, and status.
*   **Embedded Screenshots** for validation points and failures.

### Latest Execution Evidence
*(Screenshots are embedded in the HTML report, but also extracted to `target/screenshots/`)*

| Scenario | Screenshot Preview |
| :--- | :--- |
| **Login Page Elements** | ![Login Verify](target/screenshots/screenshot_1.png) |
| **Invalid Login Error** | ![Invalid Login](target/screenshots/screenshot_2.png) |

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
├── target/
│   ├── cucumber-reports/          # HTML & JSON Reports
│   └── screenshots/               # Extracted Failure/Success Screenshots
├── pom.xml                        # Maven Dependencies
├── testng.xml                     # TestNG Reporting Config
└── README.md                      # Documentation
```
