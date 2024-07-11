package io.loop.test.practice.day7hw;
import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class Task3 extends TestBase {
    /*  1. go to https://loopcamp.vercel.app/
    2. click "Multiple Windows" link
    3. Validate "Powered by Loopcamp" is displayed
    4. Validate title is "Windows"
    5. Click - click here
    6. Switch to new window and validate title */

    @Test
    public void multipleWindowsTest() {
        driver.get("https://loopcamp.vercel.app/");
        WebElement multipleWindows = driver.findElement(By.xpath("//*[contains(text(),'Multiple Windows')]"));
        multipleWindows.click();

        WebElement poweredBy = driver.findElement(By.xpath("//*[contains(text(),'Powered by')]"));
        String actualPoweredBy = poweredBy.getText();
        Assert.assertEquals(actualPoweredBy.trim(), "Powered by LOOPCAMP");

        assertEquals(driver.getTitle(), "Windows", "Results are NOT matching!");

        WebElement clickHere = driver.findElement(By.xpath("//*[contains(text(),'Click Here')]"));
        clickHere.click();

        System.out.println("driver.getTitle() = " + driver.getTitle());

        Set<String> windowHandles = driver.getWindowHandles();

        // here I loop throw and stay at the last window
        for (String each : windowHandles) {
            driver.switchTo().window(each);
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());

     Assert.assertEquals(driver.getTitle(), "New Window");
    }

    }
