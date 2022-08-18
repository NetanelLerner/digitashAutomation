package pages.personalWorkPermitRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.util.List;

public class IndicationPage extends HomePage {

    @FindBy(xpath = "//*[text()='אף אחת מהאפשרויות לא נכונה לגבי']")
    private WebElement noOneOptionButton;

    @FindBy(xpath = "//*[text()='בן ישיבה']")
    private WebElement yeshivaOptionButton;

    @FindBy(xpath = "//*[text()='עתודאי\\ת מעל גיל 22']")
    private WebElement atudaOrHigh22AgeOptionButton;

    @FindBy(css = ".css-9hw3py")
    private List<WebElement> activityLevelAOptionButton;

    @FindBy(xpath = "//*[text()='המשך']")
    private WebElement nextButton;

    public IndicationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public IndicationPage clickOnNoOneOption() {
        super.waitAndClick(this.noOneOptionButton);
        return this;
    }

    public IndicationPage clickOnYeshivaOption() {
        super.waitAndClick(this.yeshivaOptionButton);
        return this;
    }

    public IndicationPage clickOnAtudaOrHigh22AgeOption() {
        super.waitAndClick(this.atudaOrHigh22AgeOptionButton);
        return this;
    }

    public IndicationPage clickOnActivityLevelAOption() {
        super.waitAndClick(this.activityLevelAOptionButton.get(3));
        return this;
    }

    public AboutTheWorkPage clickOnNextButton() {
        super.waitAndClick(this.nextButton);
        return new AboutTheWorkPage(driver, wait);
    }
}
