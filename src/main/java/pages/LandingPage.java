package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends HomePage{

    @FindBy(xpath = "//*[text()='הגשת בקשה חדשה']")
    private WebElement newRequestButton;

    public LandingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public RequestTypePage clickOnNewRequest() {
        super.waitAndClick(newRequestButton);
        return new RequestTypePage(driver,wait);
    }
}
