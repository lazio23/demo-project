# Demo Project — UI Test Automation Framework

## Overview
This is a **UI Test Automation Framework** built for demonstration purposes.
It automates web application testing using **Java**, **Selenium WebDriver**, and **Cucumber** (BDD).
The framework is designed with **Page Object Model (POM)** and is easily scalable for different projects.

---

## 🛠 Tech Stack
- **Java 17**
- **Maven**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **JUnit/TestNG**
- **Page Object Model (POM)**
- **Git & GitHub**

---

## 📂 Project Structure
src
├── main/java/pages         # Page Object classes
├── test/java/steps         # Step Definitions
├── test/resources/features # Cucumber Feature files
└── tools                   # Utility classes

---

##  How to Run Tests
1. Clone the repository:
   ```bash
   git clone https://github.com/lazio23/demo-project.git

2. Navigate to the project folder:
        cd demo-project

3.	Run tests with Maven:
        mvn clean test

 Example Test Scenario(gherkin)

 Scenario: Navigation Serie A section
   Given Login on the home pages
   And they click on the FOOTBALL tab
   And they select Serie A
   And they select Lazio
   Then they see emblema FC Lazio



Contact:
Kostiantyn Dziuba
📩 Email: will_i_am@ukr.net
💼 GitHub: lazio23