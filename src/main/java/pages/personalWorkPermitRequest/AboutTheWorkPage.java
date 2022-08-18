package pages.personalWorkPermitRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

public class AboutTheWorkPage extends HomePage {

    @FindBy(id = "textField-work_name")
    private WebElement businessName;

    @FindBy(id = "textField-employer_name")
    private WebElement employerName;

    @FindBy(id = "textField-work_address")
    private WebElement workAddress;

    @FindBy(xpath = "//*[text()='המשך']")
    private WebElement nextButton;

    public AboutTheWorkPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public AboutTheWorkPage sendKeysOnBusinessName(String businessName) {
        super.waitAndSendKeys(this.businessName, businessName);
        return new AboutTheWorkPage(driver, wait);
    }

    public AboutTheWorkPage sendKeysOnEmployerName(String employerName) {
        super.waitAndSendKeys(this.employerName, employerName);
        return new AboutTheWorkPage(driver, wait);
    }

    public AboutTheWorkPage sendKeysOnWorkAddress(String workAddress) {
        super.waitAndSendKeys(this.workAddress, workAddress);
        return new AboutTheWorkPage(driver, wait);
    }

    public WorkPurpose clickOnNextButton() {
        super.waitAndClick(nextButton);
        return new WorkPurpose(driver, wait);
    }
}
