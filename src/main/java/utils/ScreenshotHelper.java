package utils;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;

public class ScreenshotHelper {

    /**
     * Takes screenshot and attaches to Allure Report
     * @param page Playwright Page object
     * @param stepName Name of step for the Allure attachment
     */
    public static void attachScreenshot(Page page, String stepName) {
        try {
            byte[] screenshotBytes = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));

            Allure.addAttachment(stepName, "image/png",
                    new java.io.ByteArrayInputStream(screenshotBytes), ".png");

        } catch (Exception e) {
            System.out.println("Failed to attach screenshot: " + e.getMessage());
        }
    }
}
