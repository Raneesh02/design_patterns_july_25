package tests;

import Base.BaseTest;
import Base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationFluentPage;
import pages.RegistrationPage;

public class RegistrationTests extends BaseTest {

    @Test
    public void testDobError(){
        RegistrationPage registrationPage = new RegistrationPage(DriverManager.getDriver());
        registrationPage.navigateByUrl();
        registrationPage.enterFirstName("Itachi");
        registrationPage.enterLastName("Uchiha");
        registrationPage.submitForm();
        Assert.assertTrue(registrationPage.isDobErrorDisplayed(),"Dob error is not displayed");
    }

    @Test
    public void testDobErrorFluent(){
        RegistrationFluentPage registrationFluentPage = new RegistrationFluentPage(DriverManager.getDriver());
        registrationFluentPage.navigateByUrl().enterFirstName("Itachi").enterLastName("Uchiha").submitForm();
        Assert.assertTrue(registrationFluentPage.isDobErrorDisplayed(),"Dob error is not displayed");
    }

    //1. fillFormMethod
    //2. Method Chaining
    //3. Common test setup
    //4. Builder Design Pattern  ==> will discuss on Day 2


    @Test
    public void testCountryDropdown(){
        RegistrationPage registrationPage = new RegistrationPage(DriverManager.getDriver());
        registrationPage.navigateByUrl();
        Assert.assertEquals(registrationPage.getSelectedCountry(),"Your country *");
        registrationPage.selectCountry("India");
        Assert.assertEquals(registrationPage.getSelectedCountry(),"India");
    }

    @Test
    public void testPhoneValidations(){
        RegistrationPage registrationPage = new RegistrationPage(DriverManager.getDriver());
        registrationPage.navigateByUrl();
        registrationPage.enterPhone("hello123");
        registrationPage.submitForm();
        Assert.assertEquals(registrationPage.getPhoneError(),"Only numbers are allowed.");
        registrationPage.enterPhone("7489549876");
        Assert.assertFalse(registrationPage.isPhoneErrorPresent(),"Phone error should be resolved");
    }
}
