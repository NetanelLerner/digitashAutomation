package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestTypePage extends HomePage{

    //todo: find by inner text
    @FindBy(xpath = "//*[text()='היתר עבודה פרטית']")
    private WebElement workButton;

    public RequestTypePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public PreRequestPage clickOnPersonalWorkPermitRequest() {
        super.waitAndClick(workButton);
        return new PreRequestPage(driver,wait);
    }
}
