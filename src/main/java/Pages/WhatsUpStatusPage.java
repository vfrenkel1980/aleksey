package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class WhatsUpStatusPage extends BasePage{


    public WhatsUpStatusPage(AndroidDriver driver, Logger log) {
        super(driver,log);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Мой статус\")")
    public AndroidElement myStatusText;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"СТАТУС\")")
    public AndroidElement statusText;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"xxxx\")")
    public AndroidElement menuButton;


    public String getMyStatusText() {
        log.info("get text of my Status" + text(myStatusText));
        Assert.assertTrue(getTextElement(myStatusText)," click to status text is faild");
        return text(myStatusText);
    }


    public String getTitleOfCurrentPage() {
        log.info("get text of current page" );
        Assert.assertTrue(getTextElement(statusText)," click to status text is faild");
        return text(statusText);
    }


    public void clickOnMenuFromStatusPage() {

        log.info("click on menu from status page");
        Assert.assertTrue(click(menuButton)," click on menu is failed");

    }

}
