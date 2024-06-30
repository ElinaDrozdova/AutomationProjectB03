package io.loop.test.practice.day5hw;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Task1 {
    /* 1. go to https://loopcamp.vercel.app/forgot-password.html
2. locate 5 elements, forgot password, email, email input, retrieve password, powered by LOOPCAMP
3. use css
4. verify those elements are displayed */
    WebDriver driver;
    String expected;
    String actual;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/forgot-password.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void areDisplayed(){
        WebElement forgetPasswordHeading = driver.findElement(By.cssSelector("div[class='example']>h2"));
        expected = "Forgot Password";
        actual = forgetPasswordHeading.getText();
        Assert.assertEquals(actual,expected,"Element does NOT match");
        Assert.assertTrue(forgetPasswordHeading.isDisplayed(), "Forgot Password heading is NOT displayed");

        WebElement emailLabel = driver.findElement(By.cssSelector("div[class='large-6 small-12 columns']>label"));
        Assert.assertTrue(emailLabel.isDisplayed(), "Email label is NOT displayed");

        WebElement emailInput = driver.findElement(By.cssSelector("input[type='text']"));
        Assert.assertTrue(emailInput.isDisplayed(), "Email input is NOT displayed");

        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(retrievePasswordButton.isDisplayed(), "Retrieve Password button is NOT displayed");

        WebElement poweredByLoopcamp = driver.findElement(By.cssSelector("div[class='large-4 large-centered columns']"));
        Assert.assertTrue(poweredByLoopcamp.isDisplayed(), "Powered by LOOPCAMP text is NOT displayed");
    }
    }

       

    
