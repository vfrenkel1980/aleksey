package Pages;

import Utils.TestUtilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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


    @AndroidFindBy(xpath ="//android.widget.TextView[@content-desc=\"Search\"]")
    public AndroidElement searchIcon;

    @AndroidFindBy(id ="com.whatsapp:id/search_input")
    public AndroidElement searchInput;


    @AndroidFindBy(id ="com.whatsapp:id/search_contact_token")
    public AndroidElement searchedText;

   @AndroidFindBy(xpath ="//android.widget.ImageButton[@content-desc=\"Back\"]")
   public AndroidElement backButton;


    @AndroidFindBy(id ="com.whatsapp:id/conversation_contact_name")
    public AndroidElement conversation_contact_name;
  //  com.whatsapp:id/conversation_contact_name




//     @AndroidFindBy(xpath ="//android.widget.EditText[contains(text(),'Sear')]")
//     public AndroidElement searchInput;


    ///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.EditText


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

    public String text_() {
        //System.out.println("get text to statusText");  //change to log.info after to use logger
        Assert.assertTrue(getTextElement(statusText)," click to status text is faild");
        return text(statusText);
    }

    public String getConversation_Contact_Name() {
        Assert.assertTrue(getTextElement(conversation_contact_name)," click to status text is faild");
        return text(conversation_contact_name);
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

    public void clickOnMenu(){
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


    public  void clickOnSearchButtonFromCallsSectionAndTypeText(String text)
    {

        log.info("clicking on statusIcon " +  text(searchIcon));
        Assert.assertTrue(click(searchIcon)," click on icon failed");
        // AndroidElement = driver.findElement(By.id(""));
        // text(searchInput);
        // click(searchInput);
        // text(searchInput);
        log.info("typing text into searchIcon" +  text(searchInput));
        type(searchInput,text);
    }





    public  void clickOnSearchButtonFromChatSectionAndTypeText(String text)
    {

        log.info("clicking on statusIcon " +  text(searchIcon));
        Assert.assertTrue(click(searchIcon)," click on icon failed");
        log.info("typing text into searchIcon" +  text(searchInput));
        type(searchInput,text);
    }

//    public void clickOnMenuFromChatPage() {
//
//        System.out.println("click on menu from chat page");  //change to log.info after to use logger
//        Assert.assertTrue(click(menuButton)," click on menu is failed");
//
//    }

//
//    public List <WebElement> findSearchresults()
//    {
////        List <WebElement>  searchResults = new ArrayList<>();
////        searchResults = findAll(By.id("ffff"));
////
////
////
////        return searchResults
//
//
//        List < WebElement>  listOfOptions = new ArrayList<>();
//        listOfOptions = findAll(By.id("com.whatsapp:id/conversations_row_contact_name"));
//
////        for(int i=1;i <= size ;) {
////            AndroidElement element= (AndroidElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[" + i + "]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"));
////            sleep(1500);
////           // waitForVisibilityOf (element);
////            temp.add(element.getText());
////            i = i + 1;
//        //}
//        return listOfOptions;
//
//
//
//    }

    public String  findSearchresults()
    {
       String result= text(searchedText);

        return result;

    }

    public void  clickOnBackButtonInSearch()
    {
        click(backButton);

    }





}


