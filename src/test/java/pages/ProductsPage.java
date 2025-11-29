package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.Logger;
import utils.LoggerHelper;

public class ProductsPage {

    private final Page page;
    private static final Logger log= LoggerHelper.getLogger(ProductsPage.class);

    //Locators
    Locator backpack_addCart;
    Locator bikeLight_addCart;
    String id;


    public ProductsPage(Page page){
        this.page=page;
        backpack_addCart=page.locator("#add-to-cart-sauce-labs-backpack");
        bikeLight_addCart=page.locator("#add-to-cart-sauce-labs-bike-light");
    }

    private String buildAddtoCartSelector(String productKey)
    {
        id="#add-to-cart-"+productKey;
        return id;
    }

    public void click_backPack_addCart(String productKey)
    {
        log.info("Putting Backpack to cart ...");
        //backpack_addCart.click();
        String backPackAddCart=buildAddtoCartSelector(productKey);
        page.locator(backPackAddCart).click();
        page.waitForTimeout(3000);
    }

    /*public void click_bikeLight_addCart()
    {
        log.info("Putting Bike Light to cart ...");
        bikeLight_addCart.click();
    }*/
}
