package io.loop.test.practice.day7hw;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.DocuportUtils;
import io.loop.test.utilities.DocuportWebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.assertEquals;
public class Task2 extends TestBase {
    @Test
    public void test_webTables() throws InterruptedException {
        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement user = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        user.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String expectedFullName = "Alex De Souza";
        String actualFullName = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Full name");
        assertEquals(actualFullName, expectedFullName, "Actual does not match the expected");
        System.out.println("actualFullName = " + actualFullName);

        String expectedUserName = "alexdesouze";
        String actualUserName = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Username");
        assertEquals(actualUserName, expectedUserName, "Actual does not match the expected");
        System.out.println("actualUserName = " + actualUserName);

        String expectedTelephoneNumber = "+994512060042";
        String actualTelephoneNumber = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Phone number");
        assertEquals(actualTelephoneNumber, expectedTelephoneNumber, "Actual does not match the expected");
        System.out.println("actualTelephoneNumber = " + actualTelephoneNumber);

        String expectedRole = "Client";
        String actualRole = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Role");
        assertEquals(actualRole, expectedRole, "Actual does not match the expected");
        System.out.println("actualRole = " + actualRole);

        String expectedAdvisor = "Batch1 Group1";
        String actualAdvisor = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Advisor");
        assertEquals(actualAdvisor, expectedAdvisor, "Actual does not match the expected");
        System.out.println("actualAdvisor = " + actualAdvisor);
    }
    }
