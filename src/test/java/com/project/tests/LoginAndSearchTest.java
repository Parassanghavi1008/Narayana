package com.project.tests;

import com.project.utils.WaitUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginAndSearchTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/login");
    }

    @Test
    public void loginAndSearchProduct() throws InterruptedException {
        //  Login
        driver.findElement(By.id("Email")).sendKeys("paras.kkwagh@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Paras@123");
        driver.findElement(By.cssSelector("button.login-button")).click();

        Thread.sleep(2000); // temporary delay for stability

        WaitUtil.waitForElementVisible(driver, By.linkText("Log out"), 20);
        System.out.println("Login successful!");


        // Verify "Log out" link is visible
        boolean isLogoutVisible = driver.findElement(By.linkText("Log out")).isDisplayed();
        Assert.assertTrue(isLogoutVisible, "Login failed!");

        // Search for product
        driver.findElement(By.id("small-searchterms")).sendKeys("Apple MacBook Pro 13-inch");
        driver.findElement(By.cssSelector("button.search-box-button")).click();

        // Verify product is displayed
        String productName = driver.findElement(By.cssSelector("h2.product-title a")).getText();
        Assert.assertTrue(productName.contains("MacBook Pro"), "Product not found!");

        // Click product to open details
        driver.findElement(By.cssSelector("h2.product-title a")).click();

        // Verify you are on correct product page
        String productTitle = driver.findElement(By.cssSelector("div.product-name h1")).getText();
        Assert.assertEquals(productTitle, "Apple MacBook Pro 13-inch", "Wrong product page!");

        System.out.println(" Login and search flow successful!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
