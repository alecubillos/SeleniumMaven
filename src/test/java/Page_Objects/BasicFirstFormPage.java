package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

public class BasicFirstFormPage {
    WebDriver driver;
    public BasicFirstFormPage(WebDriver driver){
        this.driver = driver;
    }
    @FindBy (how= How.CSS, using="input#user-message")
    private WebElement inputMessage;
    @FindBy (how= How.CSS, using="form#get-input button.btn.btn-default")
    private WebElement showMessageBtn;
    @FindBy (how= How.CSS, using="span#display")
    private WebElement messageDisplayed;
    @FindBy (how= How.CSS, using="#sum1")
    private WebElement inputA;
    @FindBy (how= How.CSS, using="#sum2")
    private WebElement inputB;
    @FindBy (how= How.CSS, using="form#gettotal button")
    private WebElement getTotalBtn;
    @FindBy (how= How.CSS, using="span#displayvalue")
    private WebElement getTotalValue;
    //Methods
    public void typeMessage(String message){
        Reporter.log("message is entered", true);
        this.inputMessage.sendKeys(message);
    }
    public void clickShowMessageBtn(){
        Reporter.log("Clicked button to display entered message", true);
        this.showMessageBtn.click();
    }
    public String viewMessage(String message){
        this.typeMessage(message);
        this.clickShowMessageBtn();
        Reporter.log("view message", true);
        return this.messageDisplayed.getText();
    }

    public void enterFirstNumber(String num1){
        this.inputA.sendKeys(num1);
    }
    public void enterSecondNumber(String num2){
        this.inputB.sendKeys(num2);
    }
    public void clickTotalBtn(){
        this.getTotalBtn.click();
    }
    public String viewSum(String num1, String num2){
        this.enterFirstNumber(num1);
        this.enterSecondNumber(num2);
        this.clickTotalBtn();
        return this.getTotalValue.getText();
    }
}
