package Pages;

import Utils.TestUtilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WhatsUpWellcomPage extends BasePage {

    public WhatsUpWellcomPage(AndroidDriver driver, Logger log) {
        super(driver, log);
    }

//    private
//    int i;


    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"STATUS\")")
    public AndroidElement statusText;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"CALLS\")")
    public AndroidElement callsText;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"CHATS\")")
    public AndroidElement chatText;


    @AndroidFindBy(xpath ="//android.widget.ImageView[@content-desc=\"More options\"]")
    public AndroidElement menuButton;



    // '" + location[i] + "'
  // String xpath = "//*[@id='switch-account-dropdown_listbox']//li["
  //         + SelUtils.xpathEqualsIgnoreCaseAndSpace(expectedAccount) + "]";

    //@AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[\'" + i + \"']/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    //public AndroidElement listOptions;




//    public void clickOnStatus()
//    {
//        statusText.click();
//    }
//
    public WhatsUpWellcomPage click_ChatTextFromOtherpage() {
        System.out.println("click to chatText");  //change to log.info after to use logger
        Assert.assertTrue(click(chatText)," click to chat text is faild");

        return  new WhatsUpWellcomPage(driver,log);
    }


    public WhatsUpCallPage click_CallsTextFromOtherpage() {
        System.out.println("click to callsText");
        Assert.assertTrue(click(callsText)," click to chat text is faild");

        return  new WhatsUpCallPage(driver,log);
    }





    public WhatsUpStatusPage click_StatusText() {
        log.info("clicking to statusText " +  text(statusText));
        Assert.assertTrue(click(statusText)," click to status text is faild");

        return  new WhatsUpStatusPage(driver,log);
    }
   public String text_Status() {
        //System.out.println("get text to statusText");  //change to log.info after to use logger
        Assert.assertTrue(getTextElement(statusText)," click to status text is faild");
        return text(statusText);
    }


    public String text_Calls() {
       // System.out.println("get text to callText");  //change to log.info after to use logger
        Assert.assertTrue(getTextElement(callsText)," click to status text failed");
        return text(callsText);
    }

    public String text_Chats() {
        //System.out.println("get text to callText");  //change to log.info after to use logger
        Assert.assertTrue(getTextElement(chatText)," click to status text is faild");
        return text(chatText);
    }

    public void clickOnMenuFromChatPage() {
        Assert.assertTrue(click(menuButton)," click on menu failed");



    }


    public  List<String> getTextOfOptions(int  size){
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


//    public void clickOnMenuFromChatPage() {
//
//        System.out.println("click on menu from chat page");  //change to log.info after to use logger
//        Assert.assertTrue(click(menuButton)," click on menu is failed");
//
//    }


}


