package testCases;

import Page_Objects.BasicFirstFormPage;
import Page_Objects.Common;
import Page_Objects.DynamicDataLoadingPage;
import Page_Objects.HomePage;
import Testing_Data.Test_POJO;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserManager;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;


public class Tests {
    String baseUrl = "https://demo.anhtester.com/index.htm";
    WebDriver driver;

    @BeforeTest
    public void beforeTest() throws IOException {
        driver = BrowserManager.getDriver("chrome", baseUrl);
    }

    @Test
    //@Parameters({"browser", "url"})
    public void verifyImageLoaded(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ClickOthersBtn();
        homePage.ClickDynamicDataLoadingLink();
        DynamicDataLoadingPage dynamicDataLoading= PageFactory.initElements(driver,DynamicDataLoadingPage.class);
        dynamicDataLoading.clickGetNewUserBtn();
        WebElement image = dynamicDataLoading.getImage();
        boolean imagePresent = image.isDisplayed();
        Assert.isTrue(imagePresent, "The image was not loaded");
    }
    @Test
    public void verifyFirstName() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ClickOthersBtn();
        homePage.ClickDynamicDataLoadingLink();
        DynamicDataLoadingPage dynamicDataLoading= PageFactory.initElements(driver,DynamicDataLoadingPage.class);
        dynamicDataLoading.clickGetNewUserBtn();
        String firstName = dynamicDataLoading.getName("First");
        Reporter.log("The First Name displayed is: "+firstName, true);
        assertFalse(firstName.isEmpty());
    }
    @Test
    public void verifyLastName() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ClickOthersBtn();
        homePage.ClickDynamicDataLoadingLink();
        DynamicDataLoadingPage dynamicDataLoading= PageFactory.initElements(driver,DynamicDataLoadingPage.class);
        dynamicDataLoading.clickGetNewUserBtn();
        String lastName = dynamicDataLoading.getName("Last");
        Reporter.log("The Last Name displayed is: "+lastName, true);
        assertFalse(lastName.isEmpty());
    }

    @DataProvider(name = "test-message")
    public Object[][] createData1() throws IOException {
        Reporter.log("Fetching testing data from TestData1.json", true);
        File file1 = new File("src/main/resources/TestData1.json");
        Reporter.log("Mapping JSON into POJO with Jackson Library's objectMapper", true);
        Test_POJO test1 = objectMapper.readValue(file1, Test_POJO.class);
        Reporter.log("Return testing object", true);
        return new Object[][] {
                { test1.getInputMessage1()},
                { test1.getInputMessage2()}
        };
    }

    @Test(dataProvider = "test-message")
    public void simpleFormWText(String inputMessage){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ClickInputFormsBtn();
        homePage.ClickSimpleFormDemoLink();
        BasicFirstFormPage firstFormPage = PageFactory.initElements(driver, BasicFirstFormPage.class);
        Common common = PageFactory.initElements(driver, Common.class);
        if(common.isElementPresent(By.cssSelector("[title='Close']"))==true){
            common.clickClosePopUp();
        }
        Reporter.log("The message entered was: "+inputMessage, true);
        String messageDisplayed= firstFormPage.viewMessage(inputMessage);
        Reporter.log("The message displayed was: "+messageDisplayed, true);
        assertEquals(inputMessage, messageDisplayed);
    }
    ObjectMapper objectMapper = new ObjectMapper();
    @DataProvider(name = "test-sum-numbers-letters")
    public Object[][] createData2() throws IOException {
        Reporter.log("Fetching testing data from TestData1.json", true);
        File file1 = new File("src/main/resources/TestData1.json");
        Reporter.log("Mapping JSON into POJO with Jackson Library's objectMapper", true);
        Test_POJO test1 = objectMapper.readValue(file1, Test_POJO.class);
        Reporter.log("Return testing object", true);
        return new Object[][] {
                { test1.getNumber1(), test1.getNumber2() },
                { test1.getNumber3(), test1.getNumber4()}
        };
    }

    @Test(dataProvider = "test-sum-numbers-letters")
    public void simpleFormWNumbers(String number1, String number2) throws IOException {
        driver.get(baseUrl);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ClickInputFormsBtn();
        homePage.ClickSimpleFormDemoLink();
        BasicFirstFormPage firstFormPage = PageFactory.initElements(driver, BasicFirstFormPage.class);
        String totalDisplayed = firstFormPage.viewSum(number1, number2);
        Reporter.log("total displayed is: "+ totalDisplayed, true);
        assertEquals("3", totalDisplayed);
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }


}




