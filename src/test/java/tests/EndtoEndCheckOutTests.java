package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;
import utils.ExcelReader;
import utils.LoggerHelper;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class EndtoEndCheckOutTests extends BaseTest {

    private static final Logger log = LoggerHelper.getLogger(EndtoEndCheckOutTests.class);

    @Test
    public void verifyUserCanLoginSuccessfully() {
        log.info("Starting Test: Login Functionality");

        // Create page object
        LoginPage loginPage = new LoginPage(page);

        loginPage.enterCredential_invalid();

        // Fetch username & password from config.properties
        String username = ConfigReader.get("username");
        String password = ConfigReader.get("password");

        // Perform login
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        page.waitForTimeout(3000);   // 3 seconds
        loginPage.clickLogin();
        page.waitForURL("**/inventory.html");


        // Assertion: Verify successful navigation to products page
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = page.url();
        log.info("Asserting login success...");
        Assert.assertEquals(actualUrl, expectedUrl, "Login Failed!");

        log.info("Smoke Test Passed: User logged in successfully.");
    }


    @Test(dependsOnMethods = "verifyUserCanLoginSuccessfully")
    public void verifyUserCanAddProduct() throws IOException {
        //Create page object
        ProductsPage productsPage = new ProductsPage(page);

        //Read products key from Excel
        List<String> productKeys = ExcelReader.getProductKeys("Products");
        log.info("Products from Excel: " + productKeys);
        //productsPage.click_backPack_addCart();
        //productsPage.click_bikeLight_addCart();

        for (String productKey : productKeys) {
            productsPage.click_backPack_addCart(productKey);
            page.waitForTimeout(2000);
        }
    }

    @Test(dependsOnMethods ="verifyUserCanAddProduct")
    public void getPrices(){
        CartPage cartPage=new CartPage(page);
        cartPage.clickOnCart();
        page.waitForTimeout(3000);
        cartPage.getPrices();
        cartPage.clickCheckOut();
    }

    @Test(dependsOnMethods = "getPrices")
    public void checkingOut(){
        CheckOutPage checkOutPage= new CheckOutPage(page);
        CartPage cartPage=new CartPage(page);
        checkOutPage.fillDetails();
        checkOutPage.clickContinueButton();
        log.info("Asserting cart price and checkout price...");
        Assert.assertEquals(checkOutPage.getCartPrice(),cartPage.getPrices(),"Prices Do not match!");
        checkOutPage.clickFinishButton();
        String expectedText="Thank you for your order!";
        String actualText=checkOutPage.verifyCheckOut();
        Assert.assertEquals(actualText,expectedText,"CheckOut Failed");
    }


}
