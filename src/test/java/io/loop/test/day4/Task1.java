package io.loop.test.day4;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1 {
    /* 1. go to https://loopcamp.vercel.app/forgot-password.html
2. locate 5 elements, forgot password, email, email input, retrieve password, powered by LOOPCAMP
3. use css
4. verify those elements are displayed
*/
    public static void main(String[] args) {

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://loopcamp.vercel.app/forgot-password.html");
        WebElement forgotPassword = driver.findElement(By.cssSelector("div[class='example']>h2"));
        System.out.println(forgotPassword.getText());
        System.out.println(forgotPassword.isDisplayed());

        if (forgotPassword.isDisplayed()) {
            System.out.println("Element Forgot Password is displayed: Test pass");
        } else {
            System.out.println("Element Forgot Password is NOT displayed: Test fail");
        }

        WebElement eMail = driver.findElement(By.cssSelector("div[class='large-6 small-12 columns']>label"));
        System.out.println(eMail.getText());
        System.out.println(eMail.isDisplayed());

        if (eMail.isDisplayed()) {
            System.out.println("Element E-mail is displayed: Test pass");
        } else {
            System.out.println("Element E-mail is NOT displayed: Test fail");
        }
        WebElement retrievePassword = driver.findElement(By.cssSelector("input[type='text']"));
        System.out.println(retrievePassword.getText());
        System.out.println(retrievePassword.isDisplayed());

        if (retrievePassword.isDisplayed()) {
            System.out.println("Element Retrieve Password is displayed: Test pass");
        } else {
            System.out.println("Element Retrieve Password is NOT displayed: Test fail");
        }

        WebElement eMailInput = driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));
        System.out.println(eMailInput.getText());
        System.out.println(eMailInput.isDisplayed());

        if (eMailInput.isDisplayed()) {
            System.out.println("Element E-mail Input is displayed: Test pass");
        } else {
            System.out.println("Element E-mail Input is NOT displayed: Test fail");
        }
        WebElement poweredByLoopcamp = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        System.out.println(poweredByLoopcamp.getText());
        System.out.println(poweredByLoopcamp.isDisplayed());

        if (poweredByLoopcamp.isDisplayed()) {
            System.out.println("Element Powered By Loopcamp is displayed: Test pass");
        } else {
            System.out.println("Element Powered By Loopcamp is NOT displayed: Test fail");
        }
    }
}