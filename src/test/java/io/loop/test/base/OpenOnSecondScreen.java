package io.loop.test.base;
import io.loop.test.base.TestBase;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class OpenOnSecondScreen extends TestBase {

    @Test
    public void openOnSecondScreen() {
        // Open browser
        driver.get("https://demoqa.com");

        // Get the WebDriver window
        WebDriver.Window window = driver.manage().window();

        // Print current position
        Point currentPosition = window.getPosition();
        System.out.println("Current position: " + currentPosition);

        // Move browser to the second screen
        window.setPosition(new Point(3440, 1440)); // Adjust based on your setup

        // Maximize the browser window
        window.maximize();

        // Print new position
        Point newPosition = window.getPosition();
        System.out.println("New position: " + newPosition);

        // Set the size of the browser window (optional)
        window.setSize(new org.openqa.selenium.Dimension(3440, 1440)); // Adjust as necessary
    }
}
