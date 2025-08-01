package pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

    By increaseBtnId=By.id("btn-increase-quantity");
    By addToCartBtnId=By.id("btn-add-to-cart");
    By cartBtnCss=By.cssSelector("[data-test='nav-cart']");
    By productNameCss=By.cssSelector("[data-test='product-name']");
    By alertToastCss= By.cssSelector("div[role*='alert']");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void increaseProductQty(int qty){
        for(int i=1;i<qty;i++){
            waitAndClick(increaseBtnId);
        }
    }

    public void addToCart(){
        waitAndClick(addToCartBtnId);
        waitForVisible(alertToastCss);
        waitForInVisible(alertToastCss);
    }

    public CartPage goToCart(){
        waitAndClick(cartBtnCss);
        return new CartPage(driver);
    }

    public String getProductName(){
        return getText(productNameCss);
    }


}
