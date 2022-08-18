package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.personalWorkPermitRequest.NatureOfTheWork;

public class PreRequestPage extends HomePage{

    @FindBy(id = "preRequestButton")
    private WebElement preRequestButton;

    public PreRequestPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public NatureOfTheWork clickOnPreRequestButton() {
        super.waitAndClick(preRequestButton);
        return new NatureOfTheWork(driver,wait);
    }
}
