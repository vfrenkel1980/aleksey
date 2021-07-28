package Pages.whatsappPages;

import Pages.BasePage;
import Utils.TestUtilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WhatsUpStatusPage extends BasePage {


    public WhatsUpStatusPage(WebDriver driver, Logger log) {
        super(driver,log);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"My status\")")
    public AndroidElement myStatusText;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"STATUS\")")
    public AndroidElement statusText;


    @AndroidFindBy(xpath ="//android.widget.TextView[@content-desc=\"Search\"]")
    public AndroidElement searchIcon;

    @AndroidFindBy(id ="com.whatsapp:id/search_src_text")
    public AndroidElement searchInput;



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


    public  void clickOnSearchButtonFromChatSectionAndTypeText(String text)
    {

        log.info("clicking on statusIcon " +  text(searchIcon));
        Assert.assertTrue(click(searchIcon)," click on icon failed");
        log.info("typing text into searchIcon" +  text(searchInput));
        type(searchInput,text);
    }

}
