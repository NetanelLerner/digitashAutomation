package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class PageObject {
    // D-M
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public PageObject(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    // Methods
    public void waitAndClick(WebElement button){
        wait.until(elementToBeClickable(button)).click();
    }

    public void waitAndSendKeys(WebElement field, String value) {
        wait.until(ExpectedConditions.visibilityOf(field)).clear();
        field.sendKeys(value);
    }

    public Boolean URLIsOk(String shouldBeURL){
        if(driver.getCurrentUrl().equals(shouldBeURL)){
            return true;
        }
        return false;
    }

}
