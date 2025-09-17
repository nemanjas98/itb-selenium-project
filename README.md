# itb-selenium-project

## IT Bootcamp Final Selenium Project

This project demonstrates automated testing of the web application [Vue Demo](https://vue-demo.daniel-avellaneda.com/) using **Selenium WebDriver** and **TestNG**. The main goal was to apply **Page Object Model (POM)** principles to build a maintainable, scalable, and readable test automation suite.

---

## Project Architecture

The project follows the **Page Object Model (POM)** design pattern:

* `pages` package – Classes representing web pages or components (e.g., `LoginPage`, `CitiesPage`). Each class encapsulates web elements and interactions, hiding underlying HTML details.
* `tests` package – Test scripts using page objects to perform user actions and verify expected outcomes. This ensures readability and minimizes breakage from UI changes.

---

## Key Technologies

* **Language:** Java  
* **Automation Framework:** Selenium WebDriver  
* **Test Framework:** TestNG  
* **Build Tool:** Maven  

---

## Test Coverage

The suite covers critical user flows and application features:

* **Authentication:** Login/logout, including positive and negative scenarios (invalid credentials, non-existent users).  
* **User Registration:** Input validation, existing user handling, and sign-up workflow.  
* **Admin Panel (Cities):** Full CRUD testing for city management.  
* **Route Protection:** Unauthorized access checks for `/home`, `/profile`, `/admin`.  
* **Localization:** Verifies correct UI translation for Spanish, English, Chinese, Ukrainian, and French.  
* **Profile Management:** Viewing and editing profile data with validation and persistence checks.

---

## Getting Started

Run the following commands to set up and execute the tests:

```bash
git clone https://github.com/nemanjas98/itb-selenium-project.git
cd itb-selenium-project
mvn clean test
```
*Test reports and screenshots for failed tests are generated in the `test-output` folder.*

---

This project demonstrates structured automated testing practices, emphasizing **reusability, readability, and maintainability**.
