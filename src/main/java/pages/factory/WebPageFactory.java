package pages.factory;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.WebHomePage;
import pages.interfaces.HomePage;

public class WebPageFactory extends POFactory {
    @Override
    public HomePage getHomepage(WebDriver driver) {
        return new WebHomePage(driver);
    }

}
