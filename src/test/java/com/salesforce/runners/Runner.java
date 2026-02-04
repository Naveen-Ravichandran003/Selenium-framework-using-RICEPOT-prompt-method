package com.salesforce.runners;

import org.testng.TestNG;
import java.util.Collections;
import java.util.List;
import java.awt.Desktop;
import java.io.File;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Starting Execution...");
        TestNG testng = new TestNG();

        // Run via xml to ensure all settings are picked up
        List<String> suites = Collections.singletonList("testng.xml");
        testng.setTestSuites(suites);

        testng.run();
        System.out.println("Execution Completed.");
        
        try {
            File reportFile = new File("target/cucumber-reports/cucumber.html");
            if (reportFile.exists() && Desktop.isDesktopSupported()) {
                System.out.println("Opening Report: " + reportFile.getAbsolutePath());
                Desktop.getDesktop().open(reportFile);
            } else {
                System.out.println("Report file not found or Desktop not supported.");
            }
        } catch (Exception e) {
            System.err.println("Failed to open report automatically: " + e.getMessage());
        }
    }
}
