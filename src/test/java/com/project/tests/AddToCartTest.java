package com.project.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void addProductToCart() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Apple MacBook Pro 13-inch")));

        driver.findElement(By.linkText("Apple MacBook Pro 13-inch")).click();
        System.out.println("Product selected successfully!");


        // Click on "Apple MacBook Pro 13-inch"
        WebElement macbookLink = driver.findElement(By.linkText("Apple MacBook Pro 13-inch"));
        macbookLink.click();

        // Click on "Add to cart" button
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button-4"));
        addToCartButton.click();

        // Wait a bit for message to appear
        Thread.sleep(2000);

        // Verify success message
        WebElement successMsg = driver.findElement(By.cssSelector("p.content"));
        String messageText = successMsg.getText();
        Assert.assertTrue(messageText.contains("The product has been added to your shopping cart"),
                " Product not added to cart!");

        System.out.println(" Product successfully added to cart!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
