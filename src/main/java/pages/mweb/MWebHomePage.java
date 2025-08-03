package pages.mweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.WebHomePage;
import pages.interfaces.HomePage;

public class MWebHomePage extends WebHomePage implements HomePage {

    By buttonHamburgerCss = By.cssSelector("button[aria-controls='navbarSupportedContent']");

    public MWebHomePage(WebDriver driver) {
        super(driver);
    }

    public void openCategories(){
        waitAndClick(buttonHamburgerCss);
        super.openCategories();
    }

}
