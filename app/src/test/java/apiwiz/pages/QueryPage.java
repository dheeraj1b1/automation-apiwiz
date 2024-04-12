package apiwiz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


public class QueryPage {
        WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @FindBy (xpath = "//div[@class='btn-sm-v1 ms-2 px-4 btn-animate-1']")
    public WebElement addQueryDataBtn;

    @FindBy (xpath  = "//div[@class = 'mb-1 mt-2 me-3 w-50']//input[@class = 'form-control v1-form-control']")
    public WebElement addQueryKeyInput;
    
    @FindBy (xpath = " //div[@class='d-flex mb-2']//div[@class=' css-1xc3v61-indicatorContainer']")
    public WebElement queryCondBtn;

    @FindBy (xpath  = "//div[text()='Equal To']")
    public WebElement queryCondValue;

    @FindBy (xpath  = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div[3]/div/div[3]/div/div[2]/div")
    public WebElement queryCondValueElementBtn;

    @FindBy (xpath = "//input[@class='form-control v1-form-control my-2 ms-3']")
    public WebElement queryValueInput;

    @FindBy (xpath = "//span[text()='Variables']")
    public WebElement variableBtn;

    @FindBy (xpath  = "//div[@class = 'mb-1 mt-2 me-3']//input[@class = 'form-control v1-form-control']")
    public WebElement addVariableKeyInput;

    @FindBy (xpath  = "//div[@class = 'mb-1 mt-2']//input[@class = 'form-control v1-form-control']")
    public WebElement addVariableConditionInput;

    @FindBy (xpath = "//span[text()='Payload']")
    public WebElement payloadBtn;
    
    @FindBy (xpath = "//span[text()='Headers']")
    public WebElement headersBtn;
    
    @FindBy (xpath = "//span[text()='Query Parameters']")
    public WebElement queryParamBtn;

    @FindBy(xpath = "//div[@class='mb-1 mt-2 w-50']//div[@class=' css-13cymwt-control'")
    public WebElement firstDropdownParent;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div[3]/div/div[3]")
    public WebElement secondDropdownParent;

    @FindBy (xpath = "//span[text()='Response']")
    public WebElement responseBtn;
    

    public QueryPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this); 
    }

    public void fillQueryDetials(String key, String value) throws InterruptedException{
    Thread.sleep(650);
    waitUntilClickable(addQueryDataBtn).click();
    Thread.sleep(500);
    waitUntilVisible(addQueryKeyInput).sendKeys(key);
    Thread.sleep(100);
    waitUntilClickable(queryCondBtn).click();
    Thread.sleep(100);
    // Locate the dropdown menu by its dynamic class name
    WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("css-1nmdiq5-menu")));
    WebElement equalToOption = dropdownMenu.findElement(By.xpath(".//div[contains(text(), 'Equal To')]"));
    actions.moveToElement(equalToOption).click().perform();
    Thread.sleep(1000);
    waitUntilClickable(queryCondValueElementBtn).click();
    Thread.sleep(500);
    WebElement secondDropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("css-1nmdiq5-menu")));
    WebElement secondEqualToOption = secondDropdownMenu.findElement(By.xpath(".//div[contains(text(), 'Equal To')]"));
    actions.moveToElement(secondEqualToOption).click().perform();
    Thread.sleep(500);
    waitUntilVisible(queryValueInput).sendKeys(value);
    Thread.sleep(500);
    waitUntilClickable(variableBtn).click();
    //waitUntilClickable(queryParamBtn).click();
}

    public void fillVariablesDetails(String key, String condition) throws InterruptedException{
        Thread.sleep(650);
        waitUntilClickable(payloadBtn).click();
        Thread.sleep(600);
        waitUntilClickable(addQueryDataBtn).click();
        Thread.sleep(600);
        waitUntilVisible(addVariableKeyInput).sendKeys(key);
        Thread.sleep(600);
        waitUntilVisible(addVariableConditionInput).sendKeys(condition);
        Thread.sleep(600);
        waitUntilClickable(headersBtn).click();
        waitUntilClickable(addQueryDataBtn).click();
        Thread.sleep(600);
        waitUntilVisible(addVariableKeyInput).sendKeys(key);
        Thread.sleep(600);
        waitUntilVisible(addVariableConditionInput).sendKeys(condition);
        Thread.sleep(600);
        waitUntilClickable(queryParamBtn).click();
        Thread.sleep(600);
        waitUntilClickable(addQueryDataBtn).click();
        Thread.sleep(600);
        waitUntilVisible(addVariableKeyInput).sendKeys(key);
        Thread.sleep(600);
        waitUntilVisible(addVariableConditionInput).sendKeys(condition);
        Thread.sleep(600);
        waitUntilClickable(queryParamBtn).click();
        Thread.sleep(600);
        waitUntilClickable(responseBtn).click();
        Thread.sleep(600);
    }

    private WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement waitUntilClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
}
