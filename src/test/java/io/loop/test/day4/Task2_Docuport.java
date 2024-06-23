package io.loop.test.day4;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2_Docuport {
    /* =============
1. login to docuport application
2. logout from docuport application
3. Validate successful login
4. Validate successful logout
 */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://beta.docuport.app");
        WebElement inputLogin = driver.findElement(By.cssSelector("input[id='input-14']"));
        inputLogin.sendKeys("b1g3_client@gmail.com");
        WebElement inputPassword = driver.findElement(By.cssSelector("input[id='input-15']"));
        inputPassword.sendKeys("Group3");

        WebElement pressLogIn = driver.findElement(By.cssSelector("span[class='v-btn__content']"));
        pressLogIn.click();
        Thread.sleep(5000);
        WebElement chooseAccount = driver.findElement(By.cssSelector("h3[class='text-h6']"));

        System.out.println(chooseAccount.getText());
        System.out.println(chooseAccount.isDisplayed());

        if (chooseAccount.isDisplayed()) {
            System.out.println("Element Choose account is displayed, user is able to log in: Test pass");
        } else {
            System.out.println("Element Choose account is NOT displayed, user is NOT able to log in: Test fail");
        }

        WebElement clickContinue = driver.findElement(By.cssSelector("button[type='submit']"));
        clickContinue.click();

        WebElement clickBG = driver.findElement(By.cssSelector("span[class='body-1 white--text']"));
        clickBG.click();

       WebElement clickLogOut = driver.findElement(By.xpath("//span[text()='Log out']"));

        clickLogOut.click();
       Thread.sleep(5000);
        WebElement loginPageElement = driver.findElement(By.cssSelector("h1[class='text-h5 font-weight-medium mb-6']"));
        if (loginPageElement.isDisplayed()) {
            System.out.println("User successfully logged out: Test pass");
        } else {
            System.out.println("User did NOT log out successfully: Test fail");
        }

        driver.quit();

    }

}
