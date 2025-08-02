package pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationFluentPage extends BasePage {
    String navigationUrl="/auth/register";

    By firstNameCss=By.cssSelector("input[data-test='first-name']");
    By lastNameCss=By.cssSelector("input[data-test='last-name']");
    By dobErrorCss=By.cssSelector("[data-test='dob-error']");
    By registerBtnCss=By.cssSelector("button[data-test='register-submit']");
    By countryDDwnCss=By.cssSelector("select[data-test='country']");
    By phoneErrorCss=By.cssSelector("[data-test='phone-error']");
    By phoneTxtCss=By.cssSelector("input[data-test='phone']");

    //Return this for all the action method which are not already returning something
    //only return this for actions which do not navigate to new page

    public RegistrationFluentPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationFluentPage navigateByUrl(){
        this.driver.get(this.url+navigationUrl);
        return this;
    }


    public RegistrationFluentPage enterFirstName(String name){
        waitAndSendKeys(firstNameCss,name);
        return this;
    }

    public RegistrationFluentPage enterLastName(String name){
        waitAndSendKeys(lastNameCss,name);
        return this;
    }

    public void submitForm(){
        waitAndClick(registerBtnCss);
    }

    public boolean isDobErrorDisplayed(){
        return isDisplayed(dobErrorCss);
    }
    public RegistrationFluentPage selectCountry(String country){
        waitAndSelect(countryDDwnCss, country);
        return this;
    }

    public String getSelectedCountry(){
        return getSelectedOption(countryDDwnCss);
    }
    public String getPhoneError(){
        return getText(phoneErrorCss);
    }
    public boolean isPhoneErrorPresent(){ return isDisplayed(phoneErrorCss);}
    public RegistrationFluentPage enterPhone(String phone){
        waitAndSendKeys(phoneTxtCss,phone);
        return this;
    }
}
