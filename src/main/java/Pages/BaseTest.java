package Pages;

import DriverFactory.BrowserDriverFactory;
import DriverFactory.MobileDriverFactory;
import Utils.AppiumServer;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import listeners.MyListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@Listeners({ MyListener.class })
public class BaseTest {

    public static String testSuiteName;
    public static String testName;
    public static String testMethodName;
   // public static AndroidDriver driver;
    public static WebDriver driver;
    protected Logger log;
   // public static ThreadLocal<AndroidDriver> tdriver = new ThreadLocal<AndroidDriver>();
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
    private static AppiumDriverLocalService server;
    public static AppiumServer appium = new AppiumServer();
    public 	SoftAssert softAssert;//=new SoftAssert();


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

//
//    @Parameters({"UDID_phone","appPackage","appActivity","deviceName"})
//    @BeforeClass(alwaysRun = true)
//    public AndroidDriver setup(ITestContext ctx , String UDID_phone,String deviceName,String appPackage,String appActivity) throws MalformedURLException {
//        String testName = ctx.getCurrentXmlTest().getName();
//        log = LogManager.getLogger(testName);
//        log.info(testName);
//
//
//        try {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//            capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
//            capabilities.setCapability("appPackage", appPackage);
//            capabilities.setCapability("appActivity", appActivity);
//            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
//           // capabilities.setCapability(MobileCapabilityType.UDID, "7bd9500e");
//            capabilities.setCapability(MobileCapabilityType.UDID, UDID_phone);
//            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
//            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
//            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
////        capabilities.setCapability(MobileCapabilityType.APP,"");
////        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"");
//            URL url = new URL("http://127.0.0.1:4723/wd/hub");
//            driver = new AndroidDriver(url, capabilities);
//
//        } catch (Exception e) {
//            log.info("Cause is  :" + e.getCause());
//            log.info("Cause is  :" + e.getMessage());
//            e.printStackTrace();
//        }
//
//        // this.testSuiteName = ctx.getSuite().getName()
//        this.testSuiteName = ctx.getCurrentXmlTest().getSuite().getName();
//        String temp = ctx.getSuite().getName();
//        this.testName = testName;
//       // this.testMethodName =handleTestMethodName(getClass().getMethod(ctx.getName()));
//
//        tdriver.set(driver);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return getDriver();
//
//
//    }
//    @Parameters({"browser", "URL", "select_phone","UDID_phone","appPackage","appActivity","deviceName"})
//    @BeforeClass(alwaysRun = true)
//    public AndroidDriver setup(ITestContext ctx ,String UDID_phone,String appPackage,String appActivity,String deviceName) throws MalformedURLException {
//        String testName = ctx.getCurrentXmlTest().getName();
//        log = LogManager.getLogger(testName);
//        log.info(testName);
//
//
//        try {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//            capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
//            capabilities.setCapability("appPackage", appPackage);
//            capabilities.setCapability("appActivity", appActivity);
//            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
//           // capabilities.setCapability(MobileCapabilityType.UDID, "7bd9500e");
//            capabilities.setCapability(MobileCapabilityType.UDID, UDID_phone);
//            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
//            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
//            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
////        capabilities.setCapability(MobileCapabilityType.APP,"");
////        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"");
//            URL url = new URL("http://127.0.0.1:4723/wd/hub");
//            driver = new AndroidDriver(url, capabilities);
//
//        } catch (Exception e) {
//            log.info("Cause is  :" + e.getCause());
//            log.info("Cause is  :" + e.getMessage());
//            e.printStackTrace();
//        }
//
//        // this.testSuiteName = ctx.getSuite().getName()
//        this.testSuiteName = ctx.getCurrentXmlTest().getSuite().getName();
//        String temp = ctx.getSuite().getName();
//        this.testName = testName;
//       // this.testMethodName =handleTestMethodName(getClass().getMethod(ctx.getName()));
//
//        tdriver.set(driver);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return getDriver();
//
//
//    }



    @Parameters({"browser", "URL", "select_phone","UDID_phone","appPackage","appActivity","deviceName"})
    @BeforeClass(alwaysRun = true)
    public void setup(ITestContext ctx ,@Optional("chrome") String browser ,@Optional("https://www.amazon.com/") String URL,String select_phone, @Optional String UDID_phone,@Optional String appPackage,@Optional String appActivity,@Optional String deviceName) throws InterruptedException {
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);
        log.info(testName);

            switch (select_phone) {
                case "emulators":
                    BrowserDriverFactory emul_factory = new BrowserDriverFactory(browser, log);
                    tdriver.set(emul_factory.createDriver());
                    getDriver().get(URL);
                    break;
                case "realDevices":
                    MobileDriverFactory real_factory = new MobileDriverFactory(log, UDID_phone,appPackage,appActivity,deviceName);
                    tdriver.set(real_factory.createDriver());
                    break;
            }



        // this.testSuiteName = ctx.getSuite().getName()
        this.testSuiteName = ctx.getCurrentXmlTest().getSuite().getName();
        String temp = ctx.getSuite().getName();
        this.testName = testName;
       // this.testMethodName =handleTestMethodName(getClass().getMethod(ctx.getName()));

       // tdriver.set(driver);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        softAssert = new SoftAssert();
        //getDriver().get(URL);

    }

    @BeforeMethod
    public void  SoftAss() {
        softAssert=new SoftAssert();
    }




    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        try {
            getDriver().quit();
        } catch (Exception e) {
            log.error("Error quit the driver");
        }

    }



}





