package tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import pages.HomePage;

public class first extends BaseTests{

    @Test
    void a(){
        HomePage homePage = Selenide.page(HomePage.class);
        homePage.clickSubmit();
    }
}
