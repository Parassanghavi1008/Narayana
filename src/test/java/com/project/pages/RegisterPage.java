package com.project.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPage {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register");
    }

    @Test
    public void registerUser() throws InterruptedException {

        // select gender
        driver.findElement(By.id("gender-male")).click();

        // fill text boxes
        driver.findElement(By.id("FirstName")).sendKeys("Paras");
        driver.findElement(By.id("LastName")).sendKeys("Jain");
        driver.findElement(By.id("Email")).sendKeys("paras" + System.currentTimeMillis() + "@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Paras@123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Paras@123");

        // click Register
        driver.findElement(By.id("register-button")).click();

        Thread.sleep(2000); // small pause to see result

        // check success message
        String actualMsg = driver.findElement(By.cssSelector("div.result")).getText();
        Assert.assertEquals(actualMsg, "Your registration completed");

        System.out.println("✅ Registration successful!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
