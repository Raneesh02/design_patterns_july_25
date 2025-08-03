package facades;

import Base.DriverManager;
import pages.CartPage;
import pages.Homepage;
import pages.ProductDetailPage;

public class AddToCartFacade {

    public CartPage addProductToCart(String categoryName, int qty){
        Homepage homepage = new Homepage(DriverManager.getDriver());
        homepage.getFilterBar().selectFilterCategory(categoryName);

        ProductDetailPage productDetailPage = homepage.selectProduct(1);
        productDetailPage.increaseProductQty(qty);
        productDetailPage.addToCart();
        return productDetailPage.goToCart();
    }
}
