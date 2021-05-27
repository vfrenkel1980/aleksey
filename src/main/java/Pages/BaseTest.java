package Pages;

import Utils.AppiumServer;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import listeners.AllureListener;
import listeners.MyListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
@Listeners({ AllureListener.class })
public class BaseTest {

    public static String testSuiteName;
    public static String testName;
    public static String testMethodName;
    protected AndroidDriver driver;
    protected Logger log;
    public static ThreadLocal<AndroidDriver> tdriver = new ThreadLocal<AndroidDriver>();
    private static AppiumDriverLocalService server;
    public static AppiumServer appium = new AppiumServer();


    // protected SoftAssert softAssert;
//    @BeforeSuite(alwaysRun = true)
//    public static void startAppiumServer() {
//
//        appium.startNewServer("127.0.0.1", 4723, "android");
//    }
//
//    @AfterSuite(alwaysRun = true)
//    public  void stopAppiumServer() {
//        appium.stopNewServer();
//    }



    @BeforeTest(alwaysRun = true)
    public AndroidDriver setup(ITestContext ctx) throws MalformedURLException {

        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);
        log.info("WhatsUpTests");


        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
            capabilities.setCapability("appPackage", "com.whatsapp");
            capabilities.setCapability("appActivity", "com.whatsapp.HomeActivity");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "xiaomi");
            capabilities.setCapability(MobileCapabilityType.UDID, "0c5a84557d33");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
//        capabilities.setCapability(MobileCapabilityType.APP,"");
//        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver <MobileElement>(url, capabilities);
            Assert.assertNotNull(driver);

        } catch (Exception e) {
            log.info("Cause is  :" + e.getCause());
            log.info("Cause is  :" + e.getMessage());
            e.printStackTrace();
        }

        // this.testSuiteName = ctx.getSuite().getName()
        this.testSuiteName = ctx.getCurrentXmlTest().getSuite().getName();
        String temp = ctx.getSuite().getName();
        this.testName = testName;
        // this.testMethodName = method.getName();

        tdriver.set(driver);
        return getDriver();


    }

    public static synchronized AndroidDriver getDriver() {
        return tdriver.get();
    }


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        try {
            driver.quit();
        } catch (Exception e) {
            log.error("Error quit the driver");
        }

    }
}





