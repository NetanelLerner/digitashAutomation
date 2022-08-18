package pages.personalWorkPermitRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

public class NatureOfTheWork extends HomePage {

    @FindBy(xpath = "//*[text()='סיבה כלכלית']")
    private WebElement financialOptionButton;

    @FindBy(xpath = "//*[text()='התנדבות']")
    private WebElement volunteeringOptionButton;

    @FindBy(xpath = "//*[text()='אומן או ספורטאי מצטיין/פעיל']")
    private WebElement sportsmanOptionButton;

    @FindBy(xpath = "//*[text()='התמחות מקצועית']")
    private WebElement professionalOptionButton;

    @FindBy(xpath = "//*[text()='המשך']")
    private WebElement nextButton;

    public NatureOfTheWork(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public NatureOfTheWork clickOnFinancialOption() {
        super.waitAndClick(financialOptionButton);
        return new NatureOfTheWork(driver,wait);
    }

    public NatureOfTheWork clickOnVolunteeringOption() {
        super.waitAndClick(volunteeringOptionButton);
        return new NatureOfTheWork(driver,wait);
    }

    public NatureOfTheWork clickOnSportsmanOption() {
        super.waitAndClick(sportsmanOptionButton);
        return new NatureOfTheWork(driver,wait);
    }

    public NatureOfTheWork clickOnProfessionalOption() {
        super.waitAndClick(professionalOptionButton);
        return new NatureOfTheWork(driver,wait);
    }

    public IndicationPage clickOnNextButton() {
        super.waitAndClick(nextButton);
        return new IndicationPage(driver,wait);
    }

}
