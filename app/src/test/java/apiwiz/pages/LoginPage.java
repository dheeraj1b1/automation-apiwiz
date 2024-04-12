package apiwiz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @FindBy(name = "username")
    public WebElement usernameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text() = 'Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[text() = 'API Program Dashboard']")
    public WebElement dashboardElement;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[1]/div[8]/div")
    public WebElement apiwizElement;

    @FindBy(xpath = "//div[text()='Scenario Endpoints']")
    public WebElement scenarioEndpointsOption;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this); 
    }

    public void login(String username, String password) throws InterruptedException{
        Thread.sleep(400);
        waitUntilVisible(usernameInput).sendKeys(username);
        Thread.sleep(400);
        waitUntilVisible(passwordInput).sendKeys(password);
        Thread.sleep(400);
        loginButton.click();
        Thread.sleep(400);       
    }

    public void verifyLogin(){
        String actualMessage =  waitUntilVisible(dashboardElement).getText();
        String expectedMessage = "API Program Dashboard";
        assert actualMessage.equals(expectedMessage) : "Login is unsuccessful!!";
    }

    public void goToVisPage(){
        actions.moveToElement(waitUntilVisible(apiwizElement)).perform(); 
        scenarioEndpointsOption.click();
        if (driver.getCurrentUrl().equals("https://acme-team-production.apiwiz.io/api-virtualization-studio/scenario-endpoints")) {
            System.out.println("Successfully navigated to the Scenario Endpoints page.");
        } else {
            System.out.println("Navigation to the Scenario Endpoints page failed.");
        }
    }

    private WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
