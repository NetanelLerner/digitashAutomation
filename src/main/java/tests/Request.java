package tests;

import org.testng.annotations.Test;
import pages.LandingPage;
import pages.personalWorkPermitRequest.WorkPurpose;

import static utils.DataFaker.*;

public class Request extends BaseTests {

    @Test
    void a() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver, wait);
        landingPage.clickOnNewRequest()
                .clickOnPersonalWorkPermitRequest()
                .clickOnPreRequestButton()
                .clickOnFinancialOption()
                .clickOnVolunteeringOption()
                .clickOnSportsmanOption()
                .clickOnProfessionalOption()
                .clickOnNextButton()
                .clickOnNoOneOption()
                .clickOnYeshivaOption()
                .clickOnAtudaOrHigh22AgeOption()
                .clickOnActivityLevelAOption()
                .clickOnNextButton()
                .sendKeysOnBusinessName(faker().company().name())
                .sendKeysOnEmployerName(faker().name().fullName())
                .sendKeysOnWorkAddress(faker().address().fullAddress())
                .clickOnNextButton()
                .sendKeysOnRole(faker().job().position())
                .sendKeysOnPaymentPerHour(fakeNumBetweenAnd(30, 40))
                .clickOnHourCheckBox()
                .clickOnHCheckBox()
                .clickOnStartDateButton()
                .clickOnDayInMonth(16);
//                .clickOnNextButton();
        Thread.sleep(60000000);
    }
}