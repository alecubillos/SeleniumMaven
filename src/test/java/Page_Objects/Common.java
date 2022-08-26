package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

public class Common {

        WebDriver driver;
        public Common(WebDriver driver){
            this.driver = driver;
        }
    @FindBy(how= How.CSS, using="[title='Close']")
    public WebElement closePopUp;
        //Methods
    public void clickClosePopUp(){
        this.waitForVisibility(this.closePopUp);
        Reporter.log("The pop up is closed", true);
        this.closePopUp.click();
    }
    public void waitForVisibility(WebElement element) throws Error{
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.visibilityOf(element));
    }
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
