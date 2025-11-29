Playwright Java Automation Framework – SauceDemo E2E Project

This repository contains a complete, production-style Playwright Java automation framework that automates an end-to-end purchase journey on the SauceDemo application. The project demonstrates how real-world QA teams design scalable, maintainable, and robust UI automation frameworks using modern best practices.

🚀 Project Overview

The framework automates the following workflow:

Navigate to SauceDemo

Login using valid credentials

Read product names from an Excel sheet

Select multiple products dynamically

Capture and sum their prices

Proceed to checkout

Validate the displayed total matches the computed sum

Complete the order

Additionally, the project includes negative scenarios such as invalid login and empty cart checkout attempts.

📁 Project Structure
src/test/java
│
├── base/
│   ├── BaseTest.java
│   └── BasePage.java
│
├── pages/
│   ├── LoginPage.java
│   ├── ProductsPage.java
│   ├── CartPage.java
│   └── CheckoutPage.java
│
├── tests/
│   └── EndToEndCheckoutTest.java
│
├── utils/
│   ├── ExcelReader.java
│   ├── ConfigReader.java
│   ├── LoggerHelper.java
│   ├── ScreenshotHelper.java
│   └── WaitHelper.java
│
resources/
├── config.properties
└── testdata.xlsx



🧱 Key Features
🔹 1. Page Object Model (POM)

Clean separation of locators and actions for high maintainability.

🔹 2. Data-Driven Testing

Product input fetched from Excel using Apache POI.

🔹 3. Logging

Integrated Log4j2 for step-level and debug-level logging.

🔹 4. Reporting

Supports Allure or Extent Reports with screenshots embedded.

🔹 5. Automatic Screenshots

Captured automatically on test failures through TestNG listeners.

🔹 6. Retry Logic

Handles flaky tests using a custom TestNG RetryAnalyzer.

🔹 7. Negative Test Coverage

Invalid credentials

Checkout without products

Wrong product names

🔹 8. Utilities for Reusability

Reusable helpers for:

Waits

Screenshots

Excel data handling

Configuration reading

⚙️ Tech Stack
Component	Technology
UI Automation	Playwright (Java)
Test Runner	TestNG
Logging	Log4j2
Reporting	Allure / Extent
Data Handling	Apache POI (Excel)
Build Tool	Maven
Language	Java
