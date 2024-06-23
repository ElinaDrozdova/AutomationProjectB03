package io.loop.test.day4;

import io.loop.test.utilities.LoopCampConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AI {
    /*1. navigate to docuport application
    2. validate placeholders for user name and password
    3. without sending username and password click login button
    4. validate username and password error messages
    */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://beta.docuport.app");

        // Locate the username input element and get its placeholder attribute
        WebElement usernameInput = driver.findElement(By.cssSelector("*[class='v-label theme--light error--text']"));
        String actualUserPlaceholder = usernameInput.getAttribute("placeholder");

        System.out.println("Actual User Placeholder: " + actualUserPlaceholder);

        if (actualUserPlaceholder.equals("Username or email")) {
            System.out.println("Expected placeholder matches with actual");
            System.out.println("TEST PASSED");
        } else {
            System.out.println("Expected placeholder DOES NOT match with actual");
            System.err.println("TEST FAILED");
        }

        // Validate the placeholder for the password input field
        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
        String actualPasswordPlaceholder = passwordInput.getAttribute("placeholder");

        System.out.println("Actual Password Placeholder: " + actualPasswordPlaceholder);

        if (actualPasswordPlaceholder.equals("Password")) {
            System.out.println("Expected placeholder matches with actual");
            System.out.println("TEST PASSED");
        } else {
            System.out.println("Expected placeholder DOES NOT match with actual");
            System.err.println("TEST FAILED");
        }
/*
        // Click the login button without entering username and password
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        // Validate error messages
        WebElement usernameError = driver.findElement(By.cssSelector("div[class*='username-error']"));
        WebElement passwordError = driver.findElement(By.cssSelector("div[class*='password-error']"));

        System.out.println("Username Error Message: " + usernameError.getText());
        System.out.println("Password Error Message: " + passwordError.getText());

        // Clean up
        driver.quit(); */
    }
}