package apiwiz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


public class AddScenarioPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @FindBy (xpath = "(//input[@class='form-control v1-form-control'])[1]")
    public WebElement nameInput;
    
    @FindBy (xpath = "(//input[@class='form-control v1-form-control'])[2]")
    public WebElement summaryInput;

    @FindBy (xpath = "(//input[@class='form-control v1-form-control'])[3]")
    public WebElement descriptionInput;

    @FindBy (xpath = "//span[text() = 'Request']")
    public WebElement requestFieldBtn;

    @FindBy (xpath = " (//div[@class=' css-1xc3v61-indicatorContainer'])[1]")
    public WebElement selectConditionBtn;

    @FindBy (xpath = "(//div[@class=' css-1xc3v61-indicatorContainer'])[2]")
    public WebElement selectConditionBtn2;

    @FindBy (xpath = "//div[text() = 'equalTo']")
    public WebElement conditionSelect;
  
    @FindBy (xpath = "//input[@class='form-control v1-form-control']")
    public WebElement reqValueInput;

    @FindBy (xpath = "//span[text() = 'Method']")
    public WebElement reqMethodBtn;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div[3]/div/div[2]/div/div/div[2]/div")
    public WebElement methodValueBtn;

    @FindBy (xpath = "//div[text()='GET']")
    public WebElement selectValue;

    @FindBy (xpath = "//span[text()='Headers']")
    public WebElement headersdBtn;

    @FindBy (xpath = "//div[@class='btn-sm-v1 ms-2 px-4 btn-animate-1']")
    public WebElement addHeaderDataBtn;

    @FindBy (xpath  = "(//input[@class='form-control v1-form-control'])[1]")
    public WebElement addHeaderKeyInput;
    
    @FindBy (xpath = " //div[@class='d-flex mb-2']//div[@class=' css-1xc3v61-indicatorContainer']")
    public WebElement headerCondBtn;

    @FindBy (xpath  = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div[3]/div/div[3]/div/div[2]/div")
    public WebElement headerCondValueElementBtn;

    @FindBy (xpath  = "//div[text()='Equal To']")
    public WebElement headerCondValue;

    @FindBy (xpath = "//input[@class='form-control v1-form-control my-2 ms-3']")
    public WebElement headerValueInput;

    @FindBy (xpath = "//span[text()='Query Parameters']")
    public WebElement queryParamBtn;
    

    public AddScenarioPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this); 
    }

    public void fillBasicInfo(String name, String description, String summary) throws InterruptedException{
        Thread.sleep(650);
        waitUntilVisible(nameInput).sendKeys(name);
        Thread.sleep(300);
        waitUntilVisible(summaryInput).sendKeys(summary);
        Thread.sleep(300);
        waitUntilVisible(descriptionInput).sendKeys(description);
    }

    public void addRequestDetails(String value) throws InterruptedException{
        Thread.sleep(650);
        waitUntilClickable(requestFieldBtn).click();
        Thread.sleep(650);
        waitUntilClickable(selectConditionBtn).click();
        Thread.sleep(500);
        WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("css-1nmdiq5-menu")));
        WebElement equalToOption = dropdownMenu.findElement(By.xpath(".//div[contains(text(), 'equalTo')]"));
        actions.moveToElement(equalToOption).click().perform();
        Thread.sleep(650);
        waitUntilVisible(reqValueInput).sendKeys(value);
        Thread.sleep(650);
        waitUntilClickable(reqMethodBtn).click();
        Thread.sleep(650);
        waitUntilClickable(selectConditionBtn).click();
        Thread.sleep(500);
        WebElement dropdownMenu2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("css-1nmdiq5-menu")));
        WebElement equalToOption2 = dropdownMenu2.findElement(By.xpath(".//div[contains(text(), 'equalTo')]"));
        actions.moveToElement(equalToOption2).click().perform();
        Thread.sleep(500);
        waitUntilClickable(methodValueBtn).click();
        Thread.sleep(650);
        WebElement dropdownMenu3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("css-1nmdiq5-menu")));
        WebElement equalToOption3 = dropdownMenu3.findElement(By.xpath(".//div[contains(text(), 'GET')]"));
        actions.moveToElement(equalToOption3).click().perform();
        waitUntilClickable(headersdBtn).click();
    }

    public void fillHeaderDetials(String key, String value) throws InterruptedException{
        Thread.sleep(650);
        waitUntilClickable(addHeaderDataBtn).click();
        Thread.sleep(500);
        waitUntilVisible(addHeaderKeyInput).sendKeys(key);
        Thread.sleep(100);
        waitUntilClickable(headerCondBtn).click();
        Thread.sleep(100);
        WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("css-1nmdiq5-menu")));
        WebElement equalToOption = dropdownMenu.findElement(By.xpath(".//div[contains(text(), 'Equal To')]"));
        actions.moveToElement(equalToOption).click().perform();
        Thread.sleep(1000);
        waitUntilClickable(headerCondValueElementBtn).click();
        Thread.sleep(500);
        WebElement dropdownMenu2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("css-1nmdiq5-menu")));
        WebElement equalToOption2 = dropdownMenu2.findElement(By.xpath(".//div[contains(text(), 'Equal To')]"));
        actions.moveToElement(equalToOption2).click().perform();
        Thread.sleep(500);
        waitUntilVisible(headerValueInput).sendKeys(value);
        Thread.sleep(500);
        waitUntilClickable(queryParamBtn).click();
    }

    private WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement waitUntilClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
}
