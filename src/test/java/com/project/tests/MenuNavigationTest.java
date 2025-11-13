package com.project.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MenuNavigationTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void navigateToNotebooks() throws InterruptedException {
        // Create Actions object
        Actions actions = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]")));

        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]")).click();
        System.out.println("Menu navigation successful!");


        // Hover over "Computers" menu
        WebElement computersMenu = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));
        actions.moveToElement(computersMenu).perform();

        Thread.sleep(1000);

        // Click "Notebooks" submenu
        WebElement notebooksLink = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Notebooks')]"));
        notebooksLink.click();

        // Verify title
        String pageTitle = driver.findElement(By.cssSelector("div.page-title h1")).getText();
        Assert.assertEquals(pageTitle, "Notebooks", "You are not on the Notebooks page!");

        System.out.println("Successfully navigated to Notebooks page!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
