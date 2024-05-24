package pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Homepage extends BasePage {

    By homeMenuOptCss=By.cssSelector("[data-test='nav-home']");
    By categoriesMenuOptCss=By.cssSelector("[data-test='nav-categories']");
    By contactMenuOptCss=By.cssSelector("[data-test='nav-contact']");
    By signInMenuOptCss=By.cssSelector("[data-test='nav-sign-in']");
    By languageMenuOptCss=By.cssSelector("[data-test='language']");

    By categoriesDdnOtpCss=By.cssSelector("[class*='dropdown-menu'][aria-label='nav-categories'] li");
    By brandLogoCss=By.cssSelector("[class='navbar-brand']");
    By footerCss=By.cssSelector("app-footer");



    public Homepage(WebDriver driver) {
        super(driver);
    }

    public void openCategories(){
        waitAndClick(categoriesMenuOptCss);
    }

    public List<String> getCategoriesList(){
        waitForVisible(categoriesDdnOtpCss);
        List<WebElement> elements = driver.findElements(categoriesDdnOtpCss);
        return elements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public void validateHeader(){
        Assert.assertTrue(isDisplayed(brandLogoCss));
        Assert.assertTrue(isDisplayed(homeMenuOptCss));
        Assert.assertTrue(isDisplayed(categoriesMenuOptCss));
        Assert.assertTrue(isDisplayed(contactMenuOptCss));
        Assert.assertTrue(isDisplayed(signInMenuOptCss));
        Assert.assertTrue(isDisplayed(languageMenuOptCss));
    }

    public String getFooterText(){
        return getText(footerCss);
    }

}
