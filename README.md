# Narayana E-Commerce & API Automation Suite

## 🌐 Introduction
This project is based on the **NopCommerce demo website**, a sample online shopping platform designed for testing and learning purposes.  
It provides a wide range of e-commerce functionalities such as **user registration, login, product browsing, adding items to the cart, and checkout**.  
In this project, these workflows are automated using **Selenium WebDriver with TestNG**, while API scenarios are validated using **RestAssured** with the ReqRes API.

## 🧠 Project Overview
This project automates both **UI** and **API** test cases for the Narayana Selection Test.

- **UI App:** https://demo.nopcommerce.com/
- **API App:** https://reqres.in/

The suite validates:
- User Registration (with TestNG DataProvider)
- Login, Product Search, Add to Cart, Checkout
- API tests (Create & Get User)

---

## 🧰 Tools & Technologies
- **Language:** Java  
- **Framework:** TestNG  
- **Build Tool:** Maven  
- **Design Pattern:** Page Object Model (POM)  
- **Libraries:** Selenium, RestAssured, WebDriverManager  
- **Waits:** Explicit Wait (WebDriverWait)



---

## 📂 Project Folder Structure
```
Narayana/
│
├── 📁 src
│ ├── 📁 main
│ │ └── 📁 java
│ │ └── com.project
│ │ ├── 📁 base # BaseTest and BasePage classes
│ │ ├── 📁 pages # Page Object classes (LoginPage, RegisterPage, etc.)
│ │ ├── 📁 utils # Utility classes (DriverFactory, WaitUtil, ConfigReader)
│ │ └── 📁 api # API layer classes (API utilities, endpoints)
│ │
│ └── 📁 test
│ └── 📁 java
│ └── com.project.tests # Test classes (LoginTest, AddToCartTest, etc.)
│
├── 📁 test-output # TestNG HTML reports
│
├── 📁 screenshots # Screenshots for failed test cases
│
├── 📄 pom.xml # Maven dependencies and build configuration
│
├── 📄 testng.xml # TestNG suite configuration
│
├── 📄 README.md # Project documentation
```


