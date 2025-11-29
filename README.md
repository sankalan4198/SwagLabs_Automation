<!DOCTYPE html>
<html lang="en">
<head>

</head>

<body>
<div class="container">

<h1>Playwright Java Automation Framework – SauceDemo E2E Project</h1>

<p>
This project demonstrates a clean, production-style automation framework built with <strong>Playwright (Java)</strong>.
It automates an end-to-end purchase flow on the SauceDemo application, including login, product selection, cart validation, and checkout.
</p>

<h2>🔍 Project Highlights</h2>
<ul>
  <li>End-to-end testing: Login → Product Selection → Cart → Checkout</li>
  <li>Product data read from Excel using Apache POI</li>
  <li>Price calculation and validation against checkout summary</li>
  <li>Page Object Model (POM) architecture</li>
  <li>Logging via Log4j2</li>
  <li>Reports via Allure or Extent Reports</li>
  <li>Screenshots captured automatically on failures</li>
  <li>Retry logic for flaky tests</li>
  <li>Negative test cases included</li>
</ul>

<h2>📁 Project Structure</h2>
<pre><code>src/test/java
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
│  
│
resources/
├── config.properties
└── testdata.xlsx</code></pre>
</code></pre>

<h2>🛠 Tech Stack</h2>
<table>
  <tr><th>Component</th><th>Technology</th></tr>
  <tr><td>Automation</td><td>Playwright (Java)</td></tr>
  <tr><td>Test Runner</td><td>TestNG</td></tr>
  <tr><td>Reporting</td><td>Allure / Extent</td></tr>
  <tr><td>Logging</td><td>Log4j2</td></tr>
  <tr><td>Data (Excel)</td><td>Apache POI</td></tr>
  <tr><td>Build Tool</td><td>Maven</td></tr>
</table>

<h2>⚙️ Setup Instructions</h2>

<h3>1. Clone the Repo</h3>
<pre><code>git clone https://github.com/your-username/your-repo.git
cd your-repo
</code></pre>

<h3>2. Install Dependencies</h3>
<pre><code>mvn clean install
</code></pre>

<h3>3. Install Playwright Browsers</h3>
<pre><code>mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
</code></pre>

<h3>4. Update Config</h3>
<pre><code>baseUrl=https://www.saucedemo.com/
username=standard_user
password=secret_sauce
browser=chromium
</code></pre>

<h2>▶️ Running Tests</h2>
<pre><code>mvn test
</code></pre>

<h3>Run TestNG Suite</h3>
<pre><code>mvn test -DsuiteXmlFile=testng.xml
</code></pre>

<h3>Allure Report</h3>
<pre><code>allure serve allure-results
</code></pre>

<h2>🚀 Future Improvements</h2>
<ul>
  <li>CI/CD pipeline (GitHub Actions / Jenkins)</li>
  <li>Parallel execution support</li>
  <li>Docker integration</li>
</ul>

<h2>🤝 Contributing</h2>
<p>Feel free to fork the repo, improve it, and create a pull request.</p>

<p><strong>⭐ If you find this useful, please star the repository!</strong></p>

</div>
</body>
</html>
