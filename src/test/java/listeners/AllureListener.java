package listeners;

import base.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotHelper;

public class AllureListener extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotHelper.attachScreenshot(page, "Failure Screenshot");
    }
}
