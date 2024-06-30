package io.loop.test.day5;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class T0_radioButton {
    public static void main(String[] args) throws InterruptedException {
/*
        https://loopcamp.vercel.app/radio-buttons.html
        wait implicitly 10 seconds
         */

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://loopcamp.vercel.app/radio-buttons.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement red = driver.findElement(By.xpath("//input[@id='red']"));
        WebElement green = driver.findElement(By.xpath("//input[@id='green']"));

        //isSelected() isEnabled()

        System.out.println(red.isSelected() + " before clicking");
        red.click();
        Thread.sleep(5000);
        System.out.println(red.isSelected() + " after clicking");
        green.click();

        // isEnabled
        System.out.println(red.isEnabled() + " checking if enabled");
        System.out.println(green.isEnabled() + " checking if enabled");


    }
}