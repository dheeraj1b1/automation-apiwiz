package apiwiz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class ResponsePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    
    @FindBy (xpath = "//span[text()='Response']")
    public WebElement responseBtn;

    @FindBy (xpath = "//span[text()='Cookies']")
    public WebElement cookiesBtn;

    @FindBy (xpath = "//span[text()='Headers']")
    public WebElement headersBtn;

    @FindBy (xpath = "(//input[@class='form-control v1-form-control'])[1]")
    public WebElement keyInput;

    @FindBy (xpath =  "(//input[@class='form-control v1-form-control'])[2]")
    public WebElement valueInput;

    @FindBy (xpath = "//span[text()='Payload']")
    public WebElement payloadBtn;

    @FindBy(xpath = "//div[@class=' css-1xc3v61-indicatorContainer']")
    public WebElement dropDownBtn;

    @FindBy(xpath = "//div[@class='btn-sm-v1 ms-2 px-4 btn-animate-1']")
    public WebElement addHeaderBtn;

    @FindBy(xpath = "//textarea[@class='inputarea monaco-mouse-cursor-text']")
    public WebElement bodyDataInput;
    
    @FindBy (xpath = "//div[text()='Save']")
    public WebElement saveBtn;

    @FindBy (xpath = "//div[@class='header-nav-menu cursor']")
    public WebElement mainMenuBtn;

    @FindBy(xpath = "(//div[@class='show dropdown'])[1]")
    private WebElement dropdownParent;

    @FindBy(xpath = "(//button[@id='dropdown-basic'])[1]")
    private WebElement dropdownButton;

    @FindBy(xpath = "//a[@data-rr-ui-dropdown-item]")
    private List<WebElement> dropdownOptions;
    

    public ResponsePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this); 
    }

    public void addResponseData(String key, String key2, String value, String jsonValue) throws InterruptedException{
        Thread.sleep(650);
        waitUntilClickable(cookiesBtn).click();
        Thread.sleep(650);
        WebElement cookieValueInput = driver.findElement(By.xpath("//input[@class='form-control v1-form-control']"));
        waitUntilVisible(cookieValueInput).sendKeys(key);
        Thread.sleep(650);
        waitUntilClickable(headersBtn).click();
        Thread.sleep(650);
        waitUntilClickable(addHeaderBtn).click();
        Thread.sleep(605);
        waitUntilVisible(keyInput).sendKeys(key2);
        Thread.sleep(650);
        waitUntilVisible(valueInput).sendKeys(value);
        Thread.sleep(650);
        waitUntilClickable(payloadBtn).click();
        Thread.sleep(650);
        waitUntilClickable(dropDownBtn).click();
        WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("css-1nmdiq5-menu")));
        WebElement equalToOption = dropdownMenu.findElement(By.xpath(".//div[contains(text(), 'JSON')]"));
        actions.moveToElement(equalToOption).click().perform();
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", bodyDataInput);
        Thread.sleep(4000);
        bodyDataInput.sendKeys(jsonValue);
        Thread.sleep(1000); 
        waitUntilClickable(saveBtn).click();
        Thread.sleep(3000);    
    }

    public void clickDropdownButton() throws InterruptedException {
        Thread.sleep(650);
        waitUntilClickable(mainMenuBtn).click();
        Thread.sleep(2000);
        waitUntilClickable(dropdownButton).click();
    }

    public void selectExportAsCollection() throws InterruptedException {
         Thread.sleep(600);
        clickDropdownButton();
        wait.until(ExpectedConditions.visibilityOfAllElements(dropdownOptions));
        for (WebElement option : dropdownOptions) {
            if (option.getText().equals("Export as Collection")) {
                Thread.sleep(700);
                option.click();
                break;
            }
        }
    }

    private WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement waitUntilClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
}
