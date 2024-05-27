package tests;

import Base.BaseTest;
import Base.DriverManager;
import Facades.AddToCartFacade;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.FilterSideBar;
import pages.Homepage;
import pages.ProductDetailPage;

public class CartTests extends BaseTest {

    @Test
    public void hammerCartTest(){
        Homepage homepage = new Homepage(DriverManager.getDriver());
        FilterSideBar filterBar = homepage.getFilterBar();
        filterBar.selectFilterCategory("Hammer");
        ProductDetailPage productDetailPage = homepage.selectProduct(1);
        String productName = productDetailPage.getProductName();
        productDetailPage.increaseProductQty(2);
        productDetailPage.addToCart();
        CartPage cartPage = productDetailPage.goToCart();
        Assert.assertTrue(cartPage.isProceedPresent());
        Assert.assertEquals(cartPage.getProductName().trim(), productName.trim());
        Assert.assertEquals(Integer.parseInt(cartPage.getProductQty()), 2);
    }

    @Test
    public void hammerCartTestFacade(){
        AddToCartFacade addToCartFacade = new AddToCartFacade(DriverManager.getDriver());
        CartPage cartPage = addToCartFacade.addProductCategoryToCart("Hammer", 2);
        cartPage.removeProduct();
        Assert.assertFalse(cartPage.isProceedPresent(),"Proceed button should not be present");
    }

}
