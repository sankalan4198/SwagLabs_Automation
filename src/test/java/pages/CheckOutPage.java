package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.Logger;
import utils.LoggerHelper;

public class CheckOutPage {

    private final Page page;
    private static final Logger log= LoggerHelper.getLogger(CheckOutPage.class);

    Locator firstName;
    Locator lastName;
    Locator postalCode;
    Locator continueButton;
    Locator finishButton;
    Locator checkOut_confirmationText;
    String checkoutConfirmationText;
    double checkOutPrice=0.0;
    Locator itemTotalPrice;

    public CheckOutPage(Page page)
    {
        this.page=page;
        firstName=page.locator("#first-name");
        lastName=page.locator("#last-name");
        postalCode=page.locator("#postal-code");
        continueButton=page.locator("#continue");
        finishButton=page.locator("#finish");
        checkOut_confirmationText=page.locator("h2.complete-header");
        itemTotalPrice= page.locator("div.summary_subtotal_label");
    }

    public void fillDetails()
    {
        log.info("Fill Details on Checkout page...");
        firstName.fill("Sankalan");
        lastName.fill("Paul");
        postalCode.fill("734004");
        page.waitForTimeout(3000);
    }

    public void clickContinueButton()
    {
        continueButton.click();
        page.waitForTimeout(3000);
    }

    public double getCartPrice()
    {
        String text= itemTotalPrice.textContent().trim().replace("Item total: $","");
        checkOutPrice=Double.parseDouble(text);
        System.out.println("The check out price is: "+checkOutPrice);
        return checkOutPrice;
    }

    public void clickFinishButton()
    {
        log.info("Finishing checkout...");
        finishButton.click();
        page.waitForTimeout(3000);
    }

    public String verifyCheckOut()
    {
        log.info("Verifying checkout...");
        checkoutConfirmationText= checkOut_confirmationText.textContent();
        return checkoutConfirmationText;
    }
}
