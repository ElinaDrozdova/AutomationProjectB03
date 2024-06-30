package io.loop.test.practice.day5hw;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task2 {
    /* 1. login to docuport application
2. logout from docuport application
3. Validate successful login
4. Validate successful logout
 */

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @Test
    public void logInFunctionality() {
        driver.get("https://beta.docuport.app");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement logIn = driver.findElement(By.cssSelector("input[id='input-14']"));
       logIn.sendKeys("b1g3_client@gmail.com");

        WebElement inputPassword = driver.findElement(By.cssSelector("input[id='input-15']"));
        inputPassword.sendKeys("Group3");

        WebElement pressLogIn = driver.findElement(By.cssSelector("span[class='v-btn__content']"));
        pressLogIn.click();

        WebElement clickContinue = driver.findElement(By.cssSelector("button[type='submit']"));
        clickContinue.click();

        WebElement clickBG = driver.findElement(By.cssSelector("span[class='body-1 white--text']"));
        Assert.assertTrue(clickBG.isDisplayed(), "Batch1 Group3 element is NOT displayed. Login was not successful");
        clickBG.click();

        WebElement clickLogOut = driver.findElement(By.xpath("//span[text()='Log out']"));
        clickLogOut.click();

        WebElement loginPageElement = driver.findElement(By.cssSelector("h1[class='text-h5 font-weight-medium mb-6']"));
        Assert.assertTrue(loginPageElement.isDisplayed(), "Login Page is NOT displayed. Logout was not successful");

    }

    }
