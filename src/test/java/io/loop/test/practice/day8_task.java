package io.loop.test.practice;

import com.github.javafaker.Faker;
import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class day8_task {
    /* task1
 ============
         1. go to url: https://loopcamp.vercel.app/registration_form.html
             2. fill the form
 3. use faker */
    @Test
    public void filling_registration_form() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperties("loopcamp.url"));
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());
        WebElement goToRegistration = Driver.getDriver().findElement(By.xpath("//*[@id='content']/ul/li[41]/a"));
        goToRegistration.click();

        Faker faker = new Faker();
        WebElement inputName = Driver.getDriver().findElement(By.xpath("//*[@id='registrationForm']/div[1]/div/input"));
        inputName.sendKeys(faker.name().firstName());

        WebElement inputLastName = Driver.getDriver().findElement(By.xpath("//*[@id='registrationForm']/div[2]/div/input"));
        inputLastName.sendKeys(faker.name().lastName());

        WebElement userName = Driver.getDriver().findElement(By.xpath("//*[@id='registrationForm']/div[3]/div/input"));
        userName.sendKeys(faker.name().fullName());

        WebElement email = Driver.getDriver().findElement(By.xpath("//*[@id='registrationForm']/div[4]/div/input"));
        email.sendKeys(faker.letterify("???????"));

        WebElement password = Driver.getDriver().findElement(By.xpath("//*[@id='registrationForm']/div[5]/div/input"));
        password.sendKeys(faker.letterify("?????????"));

        WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//*[@id='registrationForm']/div[6]/div/input"));
        phoneNumber.sendKeys(faker.numerify("222-333-33-66"));

        WebElement gender = Driver.getDriver().findElement(By.xpath("//*[@id='registrationForm']/div[7]/div/div[3]/label/input"));
        gender.click();

        WebElement dateOfBirth= Driver.getDriver().findElement(By.xpath("//*[@id='registrationForm']/div[8]/div/input"));
        dateOfBirth.sendKeys(faker.numerify("02/15/1999"));

        WebElement department= Driver.getDriver().findElement(By.xpath("//*[@id='registrationForm']/div[9]/div/select"));
        department.click();

        WebElement chooseDepartment= Driver.getDriver().findElement(By.xpath("//*[@id='registrationForm']/div[9]/div/select/option[2]"));
        chooseDepartment.click();

        WebElement chooseJobTitle= Driver.getDriver().findElement(By.xpath("//*[@id='registrationForm']/div[10]/div/select"));
        chooseJobTitle.click();

        WebElement jobTitle= Driver.getDriver().findElement(By.xpath("//*[@id='registrationForm']/div[10]/div/select/option[3]"));
        jobTitle.click();

        WebElement clickJava= Driver.getDriver().findElement(By.xpath("//*[@id='inlineCheckbox2']"));
        clickJava.click();

    }
}