package listeners;//package listeners;

import Pages.BaseTest;
import Utils.TestUtilities;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    Logger log;
    String testName;
    String testMethodName;

    @Override
    public void onTestStart(ITestResult result) {
        this.testMethodName = result.getMethod().getMethodName();
        log.info("[Starting " + testMethodName + "]");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("[Test " + testMethodName + " passed]");
        TestUtilities.takeScreenshot("taking screenshot of " + testMethodName);
        saveTextLog(result.getMethod() + "failed and captured");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("[Test " + testMethodName + " failed]");
        TestUtilities.takeScreenshot("taking screenshot of " + testMethodName);
        saveScreenshot();

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        this.testName = context.getCurrentXmlTest().getName();
        this.log = LogManager.getLogger(testName);
        log.info("[TEST " + testName + " STARTED]");
    }

    @Override
    public void onFinish(ITestContext context) {
        testMethodName      = context.getSuite().getXmlSuite().getName();
        log.info("[ALL " + testMethodName + " FINISHED]");
    }

    @Attachment
    public  byte [] saveScreenshot ()
    {
        return BaseTest.getDriver().getScreenshotAs(OutputType.BYTES);
    }


    @Attachment (value = "{0}",type = "text/plain")
    public  static  String saveTextLog (String message)
    {
        return message;
    }

}
