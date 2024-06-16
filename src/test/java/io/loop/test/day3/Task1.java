package io.loop.test.day3;

import io.loop.test.utilities.LoopCampConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/* Task 1
        ================
        1- Open a chrome browser
2- Go to: https://google.com
        3- Click to Gmail from top right.
        4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google */
public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        WebElement goToGmail = driver.findElement(By.linkText("Gmail"));
        goToGmail.click();
        String expectedGmail = "Gmail";
       String actualGmail = driver.getTitle();

       if(actualGmail.contains(expectedGmail)){
            System.out.println("Expected title: \"" + expectedGmail + "\", matches actual title: \"" + actualGmail + "\" => TEST PASSED");
        } else {
            System.err.println("Expected title: \"" + expectedGmail + "\", DOES NOT MATCH actual title: \"" + actualGmail+ "\" => TEST FAILED");
        }
       driver.navigate().back();
       String actualGoogle = driver.getTitle();
       String expectedGoogle = "Google";
        if(actualGmail.contains(expectedGoogle)){
            System.out.println("Expected title: \"" + expectedGoogle + "\", matches actual title: \"" + actualGoogle + "\" => TEST PASSED");
        } else {
            System.err.println("Expected title: \"" + expectedGoogle + "\", DOES NOT MATCH actual title: \"" + actualGoogle + "\" => TEST FAILED");
        }

      driver.quit();
    }
}
