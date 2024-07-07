package io.loop.test.practice.day6hw;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Day6_Task2 extends TestBase {
    /* go to https://demoqa.com/nestedframes
Validate "Child Iframe" text
Validate "Parent Iframe" text
Validate the "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame."

 */
    @Test
    public void handleIframes() {
        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().frame("frame1");
        driver.switchTo().frame(0);
        WebElement childIframe = driver.findElement(By.xpath("/html/body/p"));
        assertEquals(childIframe.getText(), "Child Iframe", "Actual is NOT matching with the expected");

        driver.switchTo().parentFrame();
        WebElement parentIframe = driver.findElement(By.xpath("//body"));
        assertEquals(parentIframe.getText(), "Parent frame", "Actual is NOT matching with the expected");

        driver.switchTo().defaultContent();

        WebElement sampleNestedIframe = driver.findElement(By.xpath("//div[text()='Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.']"));
        assertEquals(sampleNestedIframe.getText(), "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.", "Actual is NOT matching with the expected");
    }

}
