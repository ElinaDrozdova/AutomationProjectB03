package io.loop.test.practice.day7hw;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.assertEquals;

public class Task4 extends TestBase {
    /*  1. go to https://loopcamp.vercel.app/web-tables.html
    2. create a method to test given field for a given name
    3. test type
    4. test amount
    5. test date
    6. test street
    7. test city
    8. test state
    9. test zip
    10. test card
    11. test card number
    12. test exp */

    public static String returnAnyFieldPizzaOrders(WebDriver driver, String name, String field) throws InterruptedException {
        WebElement element = null;
        String xpath = "";

        switch (field.toLowerCase()){
            case "pizza type":
                xpath = "//td[2][text()='" + name + "']/following-sibling::td[1]";
                element = driver.findElement(By.xpath(xpath));
                break;
         case "amount":
                xpath = "//td[2][text()='" + name + "']/following-sibling::td[2]";
                element = driver.findElement(By.xpath(xpath));
                break;
                case "date":
                xpath = "//td[2][text()='" + name + "']/following-sibling::td[3]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "street":
                xpath = "//td[2][text()='" + name + "']/following-sibling::td[4]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "city":
                xpath = "//td[2][text()='" + name + "']/following-sibling::td[5]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "state":
                xpath = "//td[2][text()='" + name + "']/following-sibling::td[6]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "zip":
                xpath = "//td[2][text()='" + name + "']/following-sibling::td[7]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "card":
                xpath = "//td[2][text()='" + name + "']/following-sibling::td[8]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "card number":
                xpath = "//td[2][text()='" + name + "']/following-sibling::td[9]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "exp":
                xpath = "//td[2][text()='" + name + "']/following-sibling::td[10]";
                element = driver.findElement(By.xpath(xpath));
                break;
            default:throw new InterruptedException("there is not such a field " + field);
        }
        return element.getText().trim();
    }
    @Test
    public void test_webTablePizzaOrder() throws InterruptedException {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String expectedField = "Thin Crust";
        String actualField = returnAnyFieldPizzaOrders(driver, "Alexandra Gray", "pizza type");
        assertEquals(actualField, expectedField, "Actual does not match the expected");
        System.out.println("actualField = " + actualField);

        String expectedAmountField = "3";
        String actualAmountField = returnAnyFieldPizzaOrders(driver, "John Doe", "amount");
        assertEquals(actualAmountField, expectedAmountField, "Actual does not match the expected");
        System.out.println("actualAmountField = " + actualAmountField);

        String expectedDateField = "03/29/2021";
        String actualDateField = returnAnyFieldPizzaOrders(driver, "Stewart Dawidson", "date");
        assertEquals(actualDateField, expectedDateField, "Actual does not match the expected");
        System.out.println("actualDateField = " + actualDateField);

        String expectedStreetField = "35, Rock st.";
        String actualStreetField = returnAnyFieldPizzaOrders(driver, "Bart Fisher", "street");
        assertEquals(actualStreetField, expectedStreetField, "Actual does not match the expected");
        System.out.println("actualStreetField = " + actualStreetField);

        String expectedCityField = "Newcastle";
        String actualCityField = returnAnyFieldPizzaOrders(driver, "Ned Stark", "city");
        assertEquals(actualCityField, expectedCityField, "Actual does not match the expected");
        System.out.println("actualCityField = " + actualCityField);

        String expectedStateField = "US";
        String actualStateField = returnAnyFieldPizzaOrders(driver, "Bob Martin", "state");
        assertEquals(actualStateField, expectedStateField, "Actual does not match the expected");
        System.out.println("actualStateField = " + actualStateField);

        String expectedZipField = "53665";
        String actualZipField = returnAnyFieldPizzaOrders(driver, "Samuel Jackson", "zip");
        assertEquals(actualZipField, expectedZipField , "Actual does not match the expected");
        System.out.println("actualZipField  = " + actualZipField);

        String expectedCardField = "MasterCard";
        String actualCardField = returnAnyFieldPizzaOrders(driver, "Robert Baratheon", "card");
        assertEquals(actualCardField, expectedCardField , "Actual does not match the expected");
        System.out.println("actualCardField  = " + actualCardField);

        String expectedCardNumberField = "776565770000";
        String actualCardNumberField = returnAnyFieldPizzaOrders(driver, "Robert Baratheon", "card number");
        assertEquals(actualCardNumberField, expectedCardNumberField , "Actual does not match the expected");
        System.out.println("actualCardNumberField  = " + actualCardNumberField);

        String expectedExpField = "03/26";
        String actualExpField = returnAnyFieldPizzaOrders(driver, "Robert Baratheon", "exp");
        assertEquals(actualExpField, expectedExpField , "Actual does not match the expected");
        System.out.println("actualExpField  = " + actualExpField);

    }
}

