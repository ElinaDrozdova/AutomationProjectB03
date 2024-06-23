package io.loop.test.day4;

import io.loop.test.utilities.LoopCampConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task3_DocuportPlaceholders {
    /*1. navigate to docuport application
2. validate placeholders for user name and password
3. without sending username and password click login button
4. validate username and password error messages
*/
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://beta.docuport.app");
        WebElement userPlaceholder = driver.findElement(By.xpath("//label[.='Username or email']"));
        String actualUserPlaceholder = userPlaceholder.getText();

        System.out.println("Actual User Placeholder: " + actualUserPlaceholder);
        if (actualUserPlaceholder.equals("Username or email")) {
            System.out.println("Expected placeholder: Username or email - matches with actual: " + actualUserPlaceholder);
            System.out.println("TEST PASSED");
        } else {
            System.out.println("Expected placeholder: Username or email - DOES NOT match with actual: " + actualUserPlaceholder);
            System.err.println("TEST FAILED");
        }

        WebElement passwordPlaceholder = driver.findElement(By.xpath("//label[.='Password']"));

        String actualPasswordPlaceholder = passwordPlaceholder.getText();
        System.out.println("Actual password Placeholder: " + actualPasswordPlaceholder);

        if (actualPasswordPlaceholder.equals("Password")) {
            System.out.println("Expected placeholder: Password - matches with actual: " + actualPasswordPlaceholder);
            System.out.println("TEST PASSED");
        } else {
            System.out.println("Expected placeholder: Password - DOES NOT match with actual: " + actualPasswordPlaceholder);
            System.err.println("TEST FAILED");
        }
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement errorMessageUser = driver.findElement(By.xpath("//div[.='Please enter your username or email address']"));
        String actualErrorMessageUser = errorMessageUser.getText();

        if (actualErrorMessageUser.equals("Please enter your username or email address")) {
            System.out.println("Expected error message: Please enter your username or email address - matches with actual: " + actualErrorMessageUser);
            System.out.println("TEST PASSED");
        } else {
            System.out.println("Expected error message: Please enter your username or email address - DOES NOT match with actual: " + actualErrorMessageUser);
            System.err.println("TEST FAILED");
        }
        WebElement errorMessagePassword = driver.findElement(By.xpath("//div[.='Please enter your password']"));
        String actualErrorMessagePassword = errorMessagePassword.getText();

        if (actualErrorMessagePassword.equals("Please enter your password")) {
            System.out.println("Expected error message: Please enter your password - matches with actual: " + actualErrorMessagePassword);
            System.out.println("TEST PASSED");
        } else {
            System.out.println("Expected error message: Please enter your password - DOES NOT match with actual: " + actualErrorMessagePassword);
            System.err.println("TEST FAILED");
        }
        driver.quit();
    }
    }

