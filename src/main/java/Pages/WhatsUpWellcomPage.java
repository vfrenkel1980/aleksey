package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WhatsUpWellcomPage extends BasePage {

    public WhatsUpWellcomPage(AndroidDriver driver, Logger log) {
        super(driver, log);
    }

//    private
//    int i;


    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"СТАТУС\")")
    public AndroidElement statusText;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"ЗВОНКИ\")")
    public AndroidElement callsText;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"ЧАТЫ\")")
    public AndroidElement chatText;


    @AndroidFindBy(xpath ="//android.widget.ImageView[@content-desc=\"Ещё\"]")
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
////
//    public WhatsUpWellcomPage click_ChatTextFromOtherpage() {
//        System.out.println("click to chatText");  //change to log.info after to use logger
//        Assert.assertTrue(click(chatText)," click to status text is faild");
//
//        return  new WhatsUpWellcomPage(driver);
//    }

    public void click_ChatTextFromOtherpage() {
        log.info("clicking  to chatText" +  text(chatText)   );
        Assert.assertTrue(click(chatText)," click to status text is faild");
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
        List <String >  temp = new ArrayList<>();
        for(int i=1;i <= size ;) {
            AndroidElement element= (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[" + i + "]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"));
            temp.add(element.getText());
            i = i + 1;
        }
       return temp;
    }


//    public void clickOnMenuFromChatPage() {
//
//        System.out.println("click on menu from chat page");  //change to log.info after to use logger
//        Assert.assertTrue(click(menuButton)," click on menu is failed");
//
//    }


}


