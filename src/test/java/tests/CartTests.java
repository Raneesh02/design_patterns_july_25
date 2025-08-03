package tests;

import Base.BaseTest;
import Base.DriverManager;
import facades.AddToCartFacade;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.FilterSideBar;
import pages.Homepage;
import testdata.Product;

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

        //1. Create the plier data
        //a utility to create the test data
        Product.ProductBuilder productBuilder = new Product.ProductBuilder();
        Product product = productBuilder.setName("Hammer").setQty(2).build();


        //2. validating
        AddToCartFacade addToCartFacade = new AddToCartFacade();
        CartPage cartPage = addToCartFacade.addProductToCart(product.getName(),product.getQty());
        Assert.assertTrue(cartPage.getProductName().contains( product.getName()));
        Assert.assertEquals(cartPage.getProductQty(), String.valueOf(product.getQty()));


    }

    @Test
    public void testCategoryPlier() {
        //1. Create the plier data
        //a utility to create the test data
        Product.ProductBuilder productBuilder = new Product.ProductBuilder();
        Product product = productBuilder.setName("Plier").setQty(10).setPrice(1200).build();

        //2. validating
        AddToCartFacade addToCartFacade = new AddToCartFacade();
        CartPage cartPage = addToCartFacade.addProductToCart(product.getName(),product.getQty());
        Assert.assertTrue(cartPage.getProductName().contains( product.getName()));
        Assert.assertEquals(cartPage.getProductQty(), String.valueOf(product.getQty()));

    }

    // If the test data is already present in application
    //1. separate file to keep the data
    //2. variables in same file
    //3. Dataprovider - class and with file
    //4. Cucumber feature file

    //What about if you have to create it

}
