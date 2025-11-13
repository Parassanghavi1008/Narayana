package com.project.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationWithDataProvider {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register");
    }

    @DataProvider(name = "userData")
    public Object[][] provideData() {
        return TestDataUtil.getRegistrationData();
    }

    @Test(dataProvider = "userData")
    public void registerUser(String firstName, String lastName, String password) {

        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Email")).sendKeys(firstName + System.currentTimeMillis() + "@gmail.com");
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        driver.findElement(By.id("register-button")).click();

        // 🔹 Explicit Wait: Wait until success message appears
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.result")));

        // 🔹 Assertion: Check that message is correct
        String actualMsg = driver.findElement(By.cssSelector("div.result")).getText();
        Assert.assertEquals(actualMsg, "Your registration completed", "Registration message not matched!");

        System.out.println("Registration successful for: " + firstName);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
