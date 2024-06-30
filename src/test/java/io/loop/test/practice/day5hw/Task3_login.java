package io.loop.test.practice.day5hw;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Task3_login {

    WebDriver driver;
    String actual;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app/received-docs");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void testForDropdown() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logIn = driver.findElement(By.cssSelector("input[id='input-14']"));
        logIn.sendKeys("b1g3_advisor@gmail.com");

        WebElement inputPassword = driver.findElement(By.cssSelector("input[id='input-15']"));
        inputPassword.sendKeys("Group3");

        WebElement pressLogIn = driver.findElement(By.cssSelector("span[class='v-btn__content']"));
        pressLogIn.click();

        WebElement receivedDocuments = driver.findElement(By.xpath("//*[@href='/received-docs']"));
        receivedDocuments.click();

        WebElement searchButton = driver.findElement(By.xpath("//span[text()='Search']"));
        searchButton.click();

        WebElement status = driver.findElement(By.xpath("//label[.='Status']/.."));
        status.click();

        WebElement inProgress = driver.findElement(By.xpath("//div[text()='In progress']"));
        inProgress.click();

    }
}