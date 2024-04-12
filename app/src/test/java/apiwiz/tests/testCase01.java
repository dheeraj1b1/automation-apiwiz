
package apiwiz.tests;

import apiwiz.pages.LoginPage;
import apiwiz.pages.ScenarioPage;
import apiwiz.pages.AddScenarioPage;
import apiwiz.pages.QueryPage;
import apiwiz.pages.ResponsePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite; 
import org.testng.annotations.Test;
import org.openqa.selenium.edge.EdgeDriver;

public class testCase01 {
    WebDriver driver;
    LoginPage loginPage;
    ScenarioPage scenarioPage;
    AddScenarioPage addScenarioPage;
    QueryPage queryPage;
    ResponsePage responsePage;

    @BeforeSuite 
    public void setUp(){
        System.setProperty("webdriver.edge.driver", "C:/Users/User/Documents/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://acme-team-production.apiwiz.io/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        scenarioPage = new ScenarioPage(driver);
        addScenarioPage = new AddScenarioPage(driver);
        queryPage = new QueryPage(driver);
        responsePage = new ResponsePage(driver);
    }
    
    @Test
    public void flowTest() throws InterruptedException{
        Thread.sleep(3000);
        loginPage.login("apiwizItorix", "Apiwiz@123");
        Thread.sleep(1000);
        loginPage.verifyLogin();
        Thread.sleep(2000);
        loginPage.goToVisPage();
        Thread.sleep(2000);
        scenarioPage.selectGroup();
        Thread.sleep(2000);
        scenarioPage.fillFormAndSubmit("Tesing API Virtualisation1", "automating the module1", "automating the module1");
        Thread.sleep(3000);
        scenarioPage.addScenario();
        Thread.sleep(2000); 
        addScenarioPage.fillBasicInfo("dummy1", "dummy1", "dummy1");
        Thread.sleep(2000);
        addScenarioPage.addRequestDetails("/api/v1/dummy");
        Thread.sleep(2500);
        addScenarioPage.fillHeaderDetials("123", "123");
        Thread.sleep(2000);
        queryPage.fillQueryDetials("123", "123");
        Thread.sleep(2000);
        queryPage.fillVariablesDetails("123", "123");
        Thread.sleep(2000);
        String jsonValue = "{\n" +
                  "  \"courage\": -1785628033,\n" +
                  "  \"trick\": false,\n" +
                  "  \"enjoy\": \"himself\",\n" +
                  "  \"skin\": \"some\",\n" +
                  "  \"browserling\": true\n" +
                  "}";
        responsePage.addResponseData("new", "123", "123", jsonValue);
        Thread.sleep(5000);
        responsePage.selectExportAsCollection();
        Thread.sleep(5000);        
    }

    @AfterClass
    public void tearDown(){
        if(driver != null){
            //driver.close();
            driver.quit();
        }
    }
}

