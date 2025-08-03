package tests;

import Base.BaseTest;
import Base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.FilterSideBar;
import pages.WebHomePage;
import pages.ProductDetailPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartTests extends BaseTest {

    @Test
    public void testSortNames(){
        WebHomePage homepage = new WebHomePage(DriverManager.getDriver());
        FilterSideBar filterBar = homepage.getFilterBar();
        filterBar.sortBy("Name (A - Z)");
        List<String> productNameList = homepage.getProductNameList();
        ArrayList<String> SortedList = new ArrayList<>(productNameList);
        Collections.sort(SortedList);
        Assert.assertEquals(productNameList, SortedList);
    }

    @Test
    public void testCategory() {
        WebHomePage homepage = new WebHomePage(DriverManager.getDriver());
        homepage.getFilterBar().selectFilterCategory("Hammer");

        ProductDetailPage productDetailPage = homepage.selectProduct(1);
        productDetailPage.increaseProductQty(10);
        productDetailPage.addToCart();
        productDetailPage.goToCart();

        CartPage cartPage = new CartPage(DriverManager.getDriver());
        Assert.assertTrue(cartPage.getProductName().contains( "Hammer"));
        Assert.assertEquals(cartPage.getProductQty(), "10");

    }

}
