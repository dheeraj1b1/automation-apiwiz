package apiwiz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class ScenarioPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @FindBy(xpath = "(//div[@class='btn-sm-v1 ms-2 btn-animate-1'])[1]")
    public WebElement addBtn;

    @FindBy(xpath = "//div[@class='vizualizationDropdown surface-base d-flex flex-column p-1']")
    public WebElement dropdown;

    @FindBy(xpath = "//div[@class='p-2']//p[text()='Add Group']")
    public WebElement addGroupOption;

    @FindBy(xpath = "(//input[@id='formBasicEmail'])[1]")
    public WebElement nameInput;
    
    @FindBy(xpath = "//textarea[@placeholder='Enter description']")
    public WebElement descriptionInput;

    @FindBy(xpath = "(//input[@id='formBasicEmail'])[2]")
    public WebElement summaryInput;

    @FindBy(xpath = "//div[text()='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "(//div[@class='p-2'])[1]")
    public WebElement addScenarioBtn;
    
    public ScenarioPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this); 
    }

    public void selectGroup() throws InterruptedException{
        Thread.sleep(300);
        waitUntilVisible(addBtn).click();
        Thread.sleep(300);
        wait.until(ExpectedConditions.visibilityOf(dropdown));
        Thread.sleep(300);
        addGroupOption.click();
    }

    public void fillFormAndSubmit(String name, String description, String summary) throws InterruptedException {
        waitUntilVisible(nameInput).sendKeys(name);
        Thread.sleep(300);
        waitUntilVisible(descriptionInput).sendKeys(description);
        Thread.sleep(300);
        waitUntilVisible(summaryInput).sendKeys(summary);
        Thread.sleep(300);
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        Thread.sleep(300);
    }

    public void addScenario() throws InterruptedException{
        Thread.sleep(300);
        waitUntilVisible(addBtn).click();
        Thread.sleep(300);
        wait.until(ExpectedConditions.elementToBeClickable(addScenarioBtn)).click();
    }
 

    private WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    
}