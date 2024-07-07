package io.loop.test.practice.day6hw;

import io.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.testng.Assert.assertEquals;
/* go to https://demoqa.com/alerts
click - click button to see alert
handle alert
click - On button click, alert will appear after 5 seconds
handle alert
click - On button click, confirm box will appear
click ok and validate - You selected Ok
after that do it again this time cancel and validate - You selected Cancel
click - On button click, prompt box will appear
enter "Loop Academy" and validate You entered Loop Academy
 */

public class Day6_Task1 extends TestBase {
    Alert alert;

    @Test
    public void handleFirstAlert() {
       driver.get("https://demoqa.com/alerts");
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
        WebElement clickForInformationAlert = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='alertButton']"))); //way to handle the time until button to become clickable after appearing of advertising pop up window (chatGPT found it for me)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickForInformationAlert);// chatGPT found it for me too. It skrolls  down the window
        clickForInformationAlert.click();
        alert = driver.switchTo().alert();
        alert.accept();
    }
    @Test
    public void handleSecondAlert() throws InterruptedException {driver.get("https://demoqa.com/alerts");
     WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
        WebElement timeAlertButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='timerAlertButton']"))); //way to handle the time until button to become clickable after appearing of advertising pop up window (chatGPT found it for me)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", timeAlertButton);// chatGPT found it for me too. It skrolls  down the window
        timeAlertButton.click();
        Thread.sleep(6000);
        alert = driver.switchTo().alert();
        alert.accept();
    }
    @Test
    public void handleThirdAlert() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
        WebElement confirmBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='confirmButton']"))); //way to handle the time until button to become clickable after appearing of advertising pop up window (chatGPT found it for me)
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmBox);// chatGPT found it for me too. It skrolls  down the window
        confirmBox.click();
        alert = driver.switchTo().alert();
        alert.accept();
        WebElement successMessage = driver.findElement(By.xpath("//span[@id='confirmResult']"));
        String expected = "You selected Ok";
        String actual = successMessage.getText();
        assertEquals(actual, expected, "Actual does not match the expected");
    }
    @Test
    public void handleFourthAlert() {
        driver.get("https://demoqa.com/alerts");
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement promptBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='promtButton']"))); //way to handle the time until button to become clickable after appearing of advertising pop up window (chatGPT found it for me)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", promptBox);// chatGPT found it for me too. It skrolls  down the window
        promptBox.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Loop Academy");
        alert.accept();
        WebElement successMessage = driver.findElement(By.id("promptResult"));
        String expected = "You entered Loop Academy";
        String actual = successMessage.getText();
        assertEquals(actual, expected, "Actual does not match the expected");
    }

}
