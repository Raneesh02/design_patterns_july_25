package pages.factory;

import org.openqa.selenium.WebDriver;
import pages.WebHomePage;
import pages.interfaces.HomePage;
import pages.mweb.MWebHomePage;

public class MWebPageFactory extends POFactory {
    @Override
    public HomePage getHomepage(WebDriver driver) {
        return new MWebHomePage(driver);
    }

}
