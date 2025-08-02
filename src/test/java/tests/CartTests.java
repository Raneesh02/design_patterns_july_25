package tests;

import Base.BaseTest;
import Base.DriverManager;
import facades.AddToCartFacade;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.FilterSideBar;
import pages.Homepage;
import pages.ProductDetailPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartTests extends BaseTest {

    @Test
    public void testSortNames(){
        Homepage homepage = new Homepage(DriverManager.getDriver());
        FilterSideBar filterBar = homepage.getFilterBar();
        filterBar.sortBy("Name (A - Z)");
        List<String> productNameList = homepage.getProductNameList();
        ArrayList<String> SortedList = new ArrayList<>(productNameList);
        Collections.sort(SortedList);
        Assert.assertEquals(productNameList, SortedList);
    }

    @Test
    public void testCategory() {
        Homepage homepage = new Homepage(DriverManager.getDriver());
        homepage.getFilterBar().selectFilterCategory("Hammer");

        ProductDetailPage productDetailPage = homepage.selectProduct(1);
        productDetailPage.increaseProductQty(10);
        productDetailPage.addToCart();
        productDetailPage.goToCart();

        CartPage cartPage = new CartPage(DriverManager.getDriver());
        Assert.assertTrue(cartPage.getProductName().contains( "Hammer"));
        Assert.assertEquals(cartPage.getProductQty(), "10");

    }

    @Test
    public void testCategoryPlier() {
        AddToCartFacade addToCartFacade = new AddToCartFacade();
        CartPage cartPage = addToCartFacade.addProductToCart("Plier",10);
        Assert.assertTrue(cartPage.getProductName().contains( "Plier"));
        Assert.assertEquals(cartPage.getProductQty(), "10");

    }




}
