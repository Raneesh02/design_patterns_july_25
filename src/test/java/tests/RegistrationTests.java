package tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationTests extends BaseTest {

    @Test
    public void testError(){
        RegistrationPage registrationPage = new RegistrationPage(driver).navigateByUrl();
        registrationPage.enterFirstName("Itachi");
        registrationPage.enterLastName("Uchiha");
        registrationPage.submitForm();
        Assert.assertTrue(registrationPage.isDobErrorDisplayed(),"Dob error is not displayed");
    }
}
