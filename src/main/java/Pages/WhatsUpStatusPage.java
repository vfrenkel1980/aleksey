package Pages;

import Utils.TestUtilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WhatsUpStatusPage extends BasePage{


    public WhatsUpStatusPage(AndroidDriver driver, Logger log) {
        super(driver,log);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"My status\")")
    public AndroidElement myStatusText;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"STATUS\")")
    public AndroidElement statusText;
    //android.widget.ImageView[@content-desc="More options"]
    @AndroidFindBy(xpath ="//android.widget.ImageView[@content-desc=\"More options\"]")
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


    public List<String> getTextOfOptions(int  size) {
        List <String >  listOfOptions = new ArrayList<>();
        listOfOptions = TestUtilities.getListOfOptionsFromMenu(size);

//        for(int i=1;i <= size ;) {
//            AndroidElement element= (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[" + i + "]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"));
//            sleep(1500);
//           // waitForVisibilityOf (element);
//            temp.add(element.getText());
//            i = i + 1;
        //}
        return listOfOptions;
    }

}
