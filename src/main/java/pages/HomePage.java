package pages;

import com.codeborne.selenide.SelenideElement;
import framework.annotations.locators.Find;

public class HomePage extends PageObject{

    @Find(id = "query")
    private SelenideElement a;

    public HomePage clickSubmit() {
        a.sendKeys("aaa");
        return this;
    }
}
