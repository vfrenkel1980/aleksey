package DriverFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class MobileDriverFactory {


    protected Logger log;
    public static WebDriver driver;
    protected  String udid_phone;
    protected  String appPackage;
    protected  String appActivity;
    protected  String deviceName;



    public MobileDriverFactory(Logger log, String udid_phone, String appPackage, String appActivity, String deviceName) {

        this.log=log;
        this.udid_phone=udid_phone;
        this.appPackage=appPackage;
        this.appActivity=appActivity;
        this.deviceName=deviceName;


    }

    public WebDriver createDriver() {


        log.info("Create driver for android");
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            // capabilities.setCapability(MobileCapabilityType.UDID, "7bd9500e");
            capabilities.setCapability(MobileCapabilityType.UDID, udid_phone);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
            capabilities.setCapability("appWaitDuration",6000);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
           // capabilities.setCapability("android:exported",true);
//        capabilities.setCapability(MobileCapabilityType.APP,"");
//        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"");
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(url, capabilities);

        } catch (Exception e) {
            log.info("Cause is  :" + e.getCause());
            log.info("Cause is  :" + e.getMessage());
            e.printStackTrace();
        }


        return driver;
    }
}
