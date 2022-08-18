package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageObject{

    @FindBy(id = "query")
    private WebElement a;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public HomePage clickSubmit() {
        super.waitAndSendKeys(a, "aaaaaaaaaaaaaaaaaaa");
        return this;
    }
}
