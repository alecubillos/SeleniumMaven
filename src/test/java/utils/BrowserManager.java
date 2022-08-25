package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class BrowserManager {
    public static WebDriver getDriver(String browserName, String url){
        WebDriver driver = null;
        if(browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\alejandra.cubillos\\Downloads\\chromedriver.exe");
             driver = new ChromeDriver();
             Reporter.log("The chrome browser is started", true);
        }
        else{
            Assert.assertTrue(false, "No valid WebDriver specified");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Reporter.log("The browser is maximized", true);
        driver.get(url);
        Reporter.log("Navigated to the Url: "+url+"using the Browser: "+browserName, true);
        return driver;
    }
}
