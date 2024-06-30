package io.loop.test.practice.day5hw;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task1_herokuapp {
    WebDriver driver;
    String actual;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @Test
    public void testForDropdown() {
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='dropdown']")));
        actual = dropdown.getFirstSelectedOption().getText();
        String expected = "Please select an option";
        Assert.assertEquals(actual, expected, "Actual does not match expected. Test failed");

        dropdown.selectByVisibleText("Option 1");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1", "Actual does not match expected. Test failed");

        dropdown.selectByValue("2");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2", "Actual does not match expected. Test failed");

        WebElement dropdownTitle = driver.findElement(By.xpath("//*[@id='content']/div/h3"));
        expected = "Dropdown List";
        String actualDropdownTitle = dropdownTitle.getText();

        Assert.assertEquals(actualDropdownTitle, expected, "Actual: " + actualDropdownTitle + " does not match expected: " + expected);
    }
}