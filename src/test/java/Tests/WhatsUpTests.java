package Tests;

import Pages.BaseTest;
import Pages.WhatsUpCallPage;
import Pages.WhatsUpStatusPage;
import Pages.WhatsUpWellcomPage;
import Utils.TestUtilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.qameta.allure.Description;
import listeners.AllureListener;
import listeners.MyListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import java.util.Arrays;
import java.util.List;

//@Listeners({ AllureListener.class })
public class WhatsUpTests  extends BaseTest {

    WhatsUpStatusPage statusPage;
    WhatsUpWellcomPage wellcomePage;
    WhatsUpCallPage    callsPage;
    @BeforeClass
    public void setUpVlad()
    {
        wellcomePage= new WhatsUpWellcomPage(getDriver(), log);
        statusPage=new WhatsUpStatusPage(getDriver(),log);
    }


////
    @Test
    @Description ("Verify Status is  presented ")
    public void verifyStatusText()  {
        log.info("starting test verifyStatusText ");
        String actualText = statusPage.getTitleOfCurrentPage();
        Assert.assertEquals(actualText,"STATUS","the content is not as expected");
   }
////
    @Test
    @Description ("Verify Calls is  presented ")
    public void verifyCallsText()  {
        log.info("starting test verifyCallsText ");
        String actualText = wellcomePage.text_Calls();
        Assert.assertEquals(actualText,"CALLS","the content is not as expected");

    }
////
////
    @Test ()
    @Description ("Verify MY STATUS is  presented when clicking on chat button")
    public void verifyMyStatusTextAfterClickingOnStatusButton()  {
        //wellcomePage.click_StatusText();
        String expectedMyStatusTextText = statusPage.getMyStatusText();
        Assert.assertEquals(expectedMyStatusTextText,"My status","the content is not as expected");

    }
////
////
    @Test ()
    @Description ("Verify CHATS is  presented when clicking on chat button")
    public void clickOnChatButtonAndVerifyChatText()  {
        wellcomePage.click_ChatTextFromOtherpage();
        String actualChatText = wellcomePage.text_Chats();
        //TestUtilities.AndroidBack();
        Assert.assertEquals(actualChatText,"CHATS","the content is not as expected");

    }
//
    @Test ()
    @Description (" Verify content of  menu from  Chat page ")
    public void clickOnMenuAndVerifyContent_ChatPage() {
        log.info("starting test clickOnMenuAndVerifyContent_ChatPage ");
        wellcomePage.click_ChatTextFromOtherpage();
        wellcomePage.clickOnMenuFromChatPage();
        List<String> expectedMenuOptions = Arrays.asList("New group","New broadcast","WhatsApp Web","Starred messages","Settings");
        List<String> actualOptions = wellcomePage.getTextOfOptions(5);
        TestUtilities.AndroidBack();
        Assert.assertTrue(TestUtilities.compareTwoStringLists2(expectedMenuOptions,actualOptions).isEmpty());

    }
//
//
    @Test ()
    @Description (" Verify content of  menu from  Status page ")
    public void clickOnMenuAndVerifyContent_StatusPage() {
        log.info("clickOnMenuAndVerifyContent_StatusPage ");
        List<String> expectedMenuOptions = Arrays.asList("Status privacy","Settings");
        wellcomePage.click_StatusText();
        statusPage.clickOnMenuFromStatusPage();
        List<String> actualOptions = statusPage.getTextOfOptions(2);
        TestUtilities.AndroidBack();
        Assert.assertTrue(TestUtilities.compareTwoStringLists2(expectedMenuOptions,actualOptions).isEmpty());

    }


    @Test ()
    @Description (" Verify content of  menu from  Status page ")
    public void clickOnMenuAndVerifyContent_CallsPage() {
        log.info("clickOnMenuAndVerifyContent_CallsPage ");
        List<String> expectedMenuOptions = Arrays.asList("Clear call log","Settings");
        callsPage=wellcomePage.click_CallsTextFromOtherpage();
        callsPage.clickOnMenuFromCallsPage();
        List<String> actualOptions = callsPage.getTextOfOptions(2);
        TestUtilities.AndroidBack();
       // TestUtilities.AndroidBack();
        Assert.assertTrue(TestUtilities.compareTwoStringLists2(expectedMenuOptions,actualOptions).isEmpty());

    }


}

