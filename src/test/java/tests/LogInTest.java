package tests;

import driver.PlaywrightManagerFactory;
import org.testng.annotations.Test;
public class LogInTest extends PlaywrightManagerFactory{
    @Test
    public void HomePageTest(){
        System.out.println("---Login Test---");
        getPage().navigate("http://playwright.dev");
        System.out.println(getPage().title());

    }
}

