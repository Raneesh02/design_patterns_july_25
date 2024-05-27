package Facades;

import Base.BasePage;
import Base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.FilterSideBar;
import pages.Homepage;
import pages.ProductDetailPage;

public class
AddToCartFacade extends BasePage {
    public AddToCartFacade(WebDriver driver) {
        super(driver);
    }

    public CartPage addProductCategoryToCart(String productCat, int qty){
        Homepage homepage = new Homepage(DriverManager.getDriver());
        FilterSideBar filterBar = homepage.getFilterBar();
        filterBar.selectFilterCategory(productCat);
        ProductDetailPage productDetailPage = homepage.selectProduct(1);
        String productName = productDetailPage.getProductName();
        productDetailPage.increaseProductQty(qty);
        productDetailPage.addToCart();
        CartPage cartPage = productDetailPage.goToCart();
        Assert.assertTrue(cartPage.isProceedPresent());
        Assert.assertEquals(cartPage.getProductName().trim(), productName.trim());
        Assert.assertEquals(Integer.parseInt(cartPage.getProductQty()), qty);
        return cartPage;
    }


}
