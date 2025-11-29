package pages;

import base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import utils.LoggerHelper;
import utils.ScreenshotHelper;

public class LoginPage {

    private final Page page;
    private static final Logger log= LoggerHelper.getLogger(LoginPage.class);

    //Locators
    Locator userNameInput;
    Locator passwordInput;
    Locator loginButton;
    Locator invalidCredentialsMessage;


    public LoginPage(Page page) {
        this.page = page;
        userNameInput = page.locator("#user-name");
        passwordInput=page.locator("#password");
        loginButton=page.locator("#login-button");
        invalidCredentialsMessage=page.locator("h3[data-test='error']");

    }
    //Negative scenario with using invalid creds
    public void enterCredential_invalid()
    {
        log.info("Entering invalid credentials...");
        userNameInput.fill("test");
        passwordInput.fill("test");
        loginButton.click();
        String actualInvalidMessage=invalidCredentialsMessage.textContent();
        String expectedInvalidMessage="Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualInvalidMessage,expectedInvalidMessage,"Text not matching!");
        userNameInput.clear();
        passwordInput.clear();

    }
    //enter credentials

    public void enterUsername(String username)
    {
        log.info("Entering username...");
        userNameInput.fill(username);
        ScreenshotHelper.attachScreenshot(page, "Entered Username");
    }

    public void enterPassword(String password)
    {
        log.info("Entering password...");
        passwordInput.fill(password);
        ScreenshotHelper.attachScreenshot(page, "Entered Password");
    }

    public void clickLogin()
    {
        loginButton.click();
        ScreenshotHelper.attachScreenshot(page, "Clicked Login Button");

    }




}
