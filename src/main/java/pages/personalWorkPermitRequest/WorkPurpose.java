package pages.personalWorkPermitRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.util.List;

public class WorkPurpose extends HomePage {

    @FindBy(id = "textField-profession")
    private WebElement role;

    @FindBy(css = ".MuiSvgIcon-root")
    private List<WebElement> workPeriodIcon;

    private WebElement startDateIconButton = workPeriodIcon.get(0);
    private WebElement endDateIconButton = workPeriodIcon.get(1);

    @FindBy(css = "div[role='presentation']")
    private List<WebElement> daysInMonth;

    @FindBy(css = ".MuiInputBase-input.MuiInput-input.MuiInputBase-inputAdornedEnd")
    private List<WebElement> workPeriodField;

    private WebElement startDateField = workPeriodField.get(0);
    private WebElement endDateField = workPeriodField.get(1);

    @FindBy(id = "textField-sachar")
    private WebElement paymentPerHour;

    @FindBy(xpath = "//*[text()='בשעות לא קבועות']")
    private WebElement h;

    @FindBy(xpath = "//*[text()='בשעות קבועות']")
    private WebElement hour;

    @FindBy(xpath = "//*[text()='המשך']")
    private WebElement nextButton;

    public WorkPurpose(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WorkPurpose sendKeysOnRole(String role) throws InterruptedException {
        super.waitAndSendKeys(this.role, role);
        return new WorkPurpose(driver,wait);
    }

    public WorkPurpose clickOnStartDateButton() {
        super.waitAndClick(this.startDateIconButton);
        return new WorkPurpose(driver,wait);
    }

    public WorkPurpose clickOnEndDateButton() {
        super.waitAndClick(this.endDateIconButton);
        return new WorkPurpose(driver,wait);
    }

    public WorkPurpose clickOnDayInMonth(int day) {
        super.waitAndClick(this.daysInMonth.get(day));
        return new WorkPurpose(driver,wait);
    }

    public WorkPurpose sendKeysOnStartDate(String startDate) {
        super.waitAndSendKeys(this.startDateField, startDate);
        return new WorkPurpose(driver,wait);
    }

    public WorkPurpose sendKeysOnEndDate(String endDate) {
        super.waitAndSendKeys(this.endDateField, endDate);
        return new WorkPurpose(driver,wait);
    }

    public WorkPurpose sendKeysOnPaymentPerHour(String paymentPerHour) {
        super.waitAndSendKeys(this.paymentPerHour, paymentPerHour);
        return new WorkPurpose(driver,wait);
    }

    public WorkPurpose clickOnHCheckBox() {
        super.waitAndClick(this.h);
        return new WorkPurpose(driver,wait);
    }

    public WorkPurpose clickOnHourCheckBox() {
        super.waitAndClick(this.hour);
        return new WorkPurpose(driver,wait);
    }

    public AboutTheWorkPage clickOnNextButton() {
        super.waitAndClick(this.nextButton);
        return new AboutTheWorkPage(driver, wait);
    }

    //todo: לעשות פונקציה שיודעת להחזיר את החודשים עד לחודש הראשון בשנה ואז היא מקבלת מספר ולפיו היא יודעת לאיזה חודש להעביר

}
