package io.loop.test.day5;

import org.testng.Assert;
import org.testng.annotations.*;

public class T1_testNG_intro {
    @Test(priority = 1) //to set the priority
    public void test1(){
        System.out.println("Test 1 is running");
        String actual = "Feyruz";
        String expected = "Nadir";
        Assert.assertEquals(actual, expected, "Message from actual ");
    }
    @Test
    public void test2(){
        System.out.println("Test 2 is running");
    }
    @BeforeMethod //the very first method to run (like set up)
    public void setUpMethod(){
        System.out.println("Before method is running");
    }
    @AfterMethod
    public void tearDownMethod()
    {
        System.out.println("After method is running");
    }
    @BeforeClass
    public void setUp()
    {
        System.out.println("Before class is running");
    }
    @AfterClass
    public void tearDown()
    {
        System.out.println("After class is running");
    }
}
