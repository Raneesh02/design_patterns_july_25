package pages.factory;

import org.openqa.selenium.WebDriver;
import pages.WebHomePage;
import pages.interfaces.HomePage;
import pages.mweb.MWebHomePage;
import utilities.PropertyHandler;

public class POFactory {
    public HomePage getHomepage(WebDriver driver){

        if(PropertyHandler.platform.equalsIgnoreCase("mweb")) {
            return new MWebHomePage(driver);
        }
        else{
            return new WebHomePage(driver);
        }
    }

}
