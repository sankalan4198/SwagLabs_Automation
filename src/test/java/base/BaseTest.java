package base;

import com.microsoft.playwright.*;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.LoggerHelper;


public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    //These are all "protected" because all these will be extendec by child class(test.java extends Base class) so they are protected
    private String baseUrl;
    //BaseUrl is private because it will be only used by BaseTest.java and therefore it cannot be extended and modified by child classes

    private static final Logger log = LoggerHelper.getLogger(BaseTest.class);

    @BeforeClass
    public void setUp() {
        String browserName = ConfigReader.get("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));
        baseUrl = ConfigReader.get("baseURL");

        //Launch Playwright
        playwright = Playwright.create();

        //Select Browser
        switch (browserName) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                log.info("Launching browser...");
                break;

            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(headless));
                log.info("Launching browser...");
                break;

            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                log.info("Launching browser...");
                break;

            default:
                throw new RuntimeException("Invalid browser name in config.properties");
        }

        //Create context for each test
        context=browser.newContext();

        //Create fresh page
        page=context.newPage();

        //Navigate to base URL
        if(baseUrl!=null){
            page.navigate(baseUrl);
            log.debug("Page title: " + page.title());
        }
    }


   /* @AfterMethod
    public void tearDown(){
        if(page!=null)
        {
            page.close();
        }
        if(context!=null)
        {
            context.close();
        }
        if(browser!=null)
        {
            browser.close();
        }
        if(playwright!=null)
        {
            playwright.close();
        }
    }*/
}


