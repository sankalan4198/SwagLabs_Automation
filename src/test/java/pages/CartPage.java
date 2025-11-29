package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.Logger;
import utils.LoggerHelper;

import java.util.List;

public class CartPage {

    private final Page page;
    private static final Logger log= LoggerHelper.getLogger(CartPage.class);

    Locator yourCart;
    //List<Locator> itemPrices;
    Locator checkOut;
    double totalPrice=0.0;

    public CartPage(Page page)
    {
        this.page=page;
        yourCart=page.locator("xpath=//a[@class='shopping_cart_link']");
        //itemPrices=page.locator("xpath=//*[@class='inventory_item_price']").all();
        checkOut=page.locator("#checkout");

    }

    public void clickOnCart()
    {
        log.info("Navigating to cart...");
        yourCart.click();
    }

    public double getPrices()
    {
        List<Locator> itemPrices = page.locator("xpath=//*[@class='inventory_item_price']").all();

        for(int i=0;i<itemPrices.size();i++)
        {
            String text=itemPrices.get(i).textContent().trim();
            //Remove dollar sign
            String value=text.replace("$","");
            //Convert to double
            double price=Double.parseDouble(value);

            totalPrice=totalPrice+price;
        }
        System.out.println("The total price in cart is: "+totalPrice);
        return totalPrice;

    }

    public void clickCheckOut()
    {
        log.info("Checking Out...");
        checkOut.click();
    }
}
