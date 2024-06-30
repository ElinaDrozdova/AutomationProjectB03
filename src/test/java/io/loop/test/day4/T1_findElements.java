package io.loop.test.day4;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
        1- Open a chrome browser
        2- Go to: https://www.nba.com
        3- Locate all the links in the page.
         */
public class T1_findElements {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.nba.com");
        List<WebElement> nbaLinks = driver.findElements(By.tagName("a"));
        System.out.println("nbaLinks.size() = " + nbaLinks.size());

        List<WebElement> nbsLinksXpath = driver.findElements(By.xpath("//a"));
        System.out.println("nbsLinksXpath.size() = " + nbsLinksXpath.size());

for (WebElement nbaLink:nbaLinks){
    if (!nbaLink.getText().equals("")){
        System.out.println("nbaLink.getText() = " + nbaLinks.size()); //text of links
        System.out.println("nbaLink.getAttribute (\"href\") = " + nbaLink.getAttribute("href")); //links itself
    }
}
        for (int i = 0; i < nbaLinks.size(); i++) {
            if(nbaLinks.get(i).getText().equals("")){
                System.out.println("nbaLinks.get(i).getText()) = " + nbaLinks.get(i).getText());
                System.out.println("nbaLinks.get(i).getAttribute(\"href\") = " + nbaLinks.get(i).getAttribute("href"));
            }
        }
            }

        }
