package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

public class HomePage extends Common {

    WebDriver driver;
    public HomePage(WebDriver driver){
        super(driver);
    }

    //Elements
    @FindBy(how=How.XPATH, using="//*[@id='navbar-brand-centered'] //a[contains(text(), 'Others')]")
    private WebElement OthersBtn;
    @FindBy(how= How.XPATH, using="//a[contains(text(),'Dynamic Data Loading')]")
    private WebElement DynamicDataLoadingLink;

    @FindBy(how=How.XPATH, using="//*[@id='navbar-brand-centered'] //a[contains(text(), 'Input Forms')]")
    private WebElement InputFormsBtn;

    @FindBy(how= How.XPATH, using="//a[contains(text(),'Simple Form Demo')]")
    private WebElement SimpleFormDemoLink;
    //Methods
    public void ClickOthersBtn(){
        super.waitForVisibility(this.OthersBtn);
        this.OthersBtn.click();
        Reporter.log("Clicked the Others button on the top menu", true);
    }
    public void ClickDynamicDataLoadingLink(){
        super.waitForVisibility(this.DynamicDataLoadingLink);
        this.DynamicDataLoadingLink.click();
        Reporter.log("Clicked the DynamicDataLoading option inside the Others menu", true);
    }
    public void ClickInputFormsBtn(){
        super.waitForVisibility(this.InputFormsBtn);
        this.InputFormsBtn.click();
        Reporter.log("Clicked the Input Form button on the top menu", true);
    }
    public void ClickSimpleFormDemoLink(){
        super.waitForVisibility(this.SimpleFormDemoLink);
        this.SimpleFormDemoLink.click();
        Reporter.log("Clicked the Simple Form Demo Link option inside the Input Forms menu", true);
    }
}
