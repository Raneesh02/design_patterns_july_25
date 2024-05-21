package pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    String navigationUrl="/auth/register";

    By firstNameCss=By.cssSelector("input[data-test='first-name']");
    By lastNameCss=By.cssSelector("input[data-test='last-name']");
    By dobErrorCss=By.cssSelector("[data-test='dob-error']");
    By registerBtnCss=By.cssSelector("button[data-test='register-submit']");



    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage navigateByUrl(){
        this.driver.get(this.url+navigationUrl);
        return this;
    }


    public void enterFirstName(String name){
        waitAndSendKeys(firstNameCss,name);
    }

    public void enterLastName(String name){
        waitAndSendKeys(lastNameCss,name);
    }

    public void submitForm(){
        waitAndClick(registerBtnCss);
    }

    public boolean isDobErrorDisplayed(){
        return isDisplayed(dobErrorCss);
    }
}
