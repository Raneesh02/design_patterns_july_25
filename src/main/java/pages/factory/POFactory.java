package pages.factory;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.interfaces.HomePage;
import utilities.PropertyHandler;

public abstract class POFactory {

    public static POFactory getFactory(){
        if(PropertyHandler.platform.equalsIgnoreCase("mweb")) {
            return new MWebPageFactory();
        }
        else{
            return new WebPageFactory();
        }
    }

    public abstract HomePage getHomepage(WebDriver driver);


}
