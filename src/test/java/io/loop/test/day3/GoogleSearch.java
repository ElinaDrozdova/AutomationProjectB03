package io.loop.test.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    /*
     * Navigate to Google search
     * maximize the page
     * get title of the page
     * get url of the page
     * validate the title, expected title is "Google"
     * validate the url of the page, expected url is "https://www.google.com/"
     * close the brower
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(expectedTitle)){
            System.out.printf("Actual title: " + actualTitle + ", matches expected title: " + expectedTitle + ". => TEST PASS");
        } else {
            System.out.println("Actual title: " + actualTitle + ", DOES NOT MATCH expected title: " + expectedTitle + ". => TEST FAIL");
        }
        String expectedURL = "https://www.google.com";
        String actualURl = driver.getCurrentUrl();

        if(actualURl.contains(expectedURL)){
            System.out.println("Actual url: " + actualURl + ", matches expected url: " + expectedURL + ". => TEST PASS");
        } else {
            System.err.println("Actual url: " + actualURl + ", DOES NOT match expected url: " + expectedURL + ". => TEST FAIL");
        }

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();


    }
}
