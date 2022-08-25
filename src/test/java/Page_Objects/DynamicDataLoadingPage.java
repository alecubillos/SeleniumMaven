package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;
import java.util.Arrays;

public class DynamicDataLoadingPage {

        WebDriver driver;
        public DynamicDataLoadingPage(WebDriver driver){
            this.driver = driver;
        }
        //Elements
        @FindBy(how= How.CSS, using="button#save")
        private WebElement GetNewUserBtn;
        @FindBy(how= How.XPATH, using="//div[contains(text(), 'Name')]")
        private WebElement Name;
        @FindBy(how= How.CSS, using=".panel-body div img")
        private WebElement Image;
        //Methods
        public void clickGetNewUserBtn(){
            Reporter.log("Clicks the Get New User button", true);
            this.GetNewUserBtn.click();
        }
        public WebElement getImage(){
                Common common = PageFactory.initElements(driver, Common.class);
                common.waitForVisibility(this.Image);
                Reporter.log("Waits until the image is displayed and returns its locator", true);
                return this.Image;
        }
        public WebElement getName(){
                Reporter.log("Returns the locator for the Name", true);
                return this.Name;
        }


        public String getName(String type){
                String result=null;
                String textBelowImage = this.getName().getText();
                String segments[] = textBelowImage.split(":");
                String firstText = segments[1];
                String[] arrayName = firstText.split("\\r?\\n|\\r"); //Uses regex to remove line breaks
                if (type.equals("First")){
                        result = arrayName[0];
                }else if (type.equals("Last")){
                        String secondSegment = textBelowImage.split("Last")[1];
                        String lastName = secondSegment.split(":")[1];
                        result = lastName;
                }
                return result;
        }

}
