package Tests;

import Pages.BaseTest;
import Pages.WhatsUpStatusPage;
import Pages.WhatsUpWellcomPage;
import Utils.TestUtilities;
import io.qameta.allure.Description;
import listeners.AllureListener;
import listeners.MyListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({ AllureListener.class })
public class WhatsUpTests  extends BaseTest {

    WhatsUpStatusPage statusPage;
    WhatsUpWellcomPage wellcomePage;
    @BeforeClass
    public void setUpVlad()
    {
        wellcomePage= new WhatsUpWellcomPage(driver, log);

    }


//
//    @Test
//    public void verifyStatusText()  {
//        log.info("starting test verifyStatusText ");
//        //WhatsUpWellcomPage wellcomePage =new WhatsUpWellcomPage(driver);
//        String actualText = statusPage.getTitleOfCurrentPage();
//        Assert.assertEquals(actualText,"СТАТУС","the content is not as expected");
//}

//    @Test
//    public void verifyCallsText()  {
//        log.info("starting test verifyCallsText ");
//        String actualText = wellcomePage.text_Calls();
//        Assert.assertEquals(actualText,"ЗВОНКИ","the content is not as expected");
//
//    }

//    @Test
//    public void verifyMyStatusTextAfterClickingOnStatusButton()  {
//        log.info("starting test verifyMyStatusTextAfterClickingOnStatusButton ");
//        statusPage = wellcomePage.click_StatusText();
//        String expectedMyStatusTextText = statusPage.getMyStatusText();
//        Assert.assertEquals(expectedMyStatusTextText,"Мой статус","the content is not as expected");
//
//    }

    @Test
    @Description ("Verify ЧАТЫ is  presented when clicking on chat button")
    public void clickOnChatButtonAndVerifyChatText()  {
        //log.info("starting test clickOnChatButtonAndVerifyChatText ");
      // WhatsUpWellcomPage wellcomePage = new WhatsUpWellcomPage(getDriver(), log);
        wellcomePage.click_ChatTextFromOtherpage();
        String actualChatText = wellcomePage.text_Chats();
        Assert.assertEquals(actualChatText,"ЧАТЫ2","the content is not as expected");
       // TestUtilities.takeScreenshot("taking screenshot of clickOnChatButtonAndVerifyChatText()");

    }
//
//    @Test (priority = 5)
//    public void clickOnMenuAndVerifyContent_ChatPage() {
//        log.info("starting test clickOnMenuAndVerifyContent_ChatPage ");
//        wellcomePage.click_ChatTextFromOtherpage();
//        wellcomePage.clickOnMenuFromChatPage();
//        List<String> expectedMenuOptions = Arrays.asList("Новая групп", "Новая рассылка",
//                "WhatsApp Web",
//                "Избранные сообщения", "Настройки");
//        List<String> actualOptions = wellcomePage.getTextOfOptions(expectedMenuOptions.size());
//        //Assert.assertEquals(0, TestUtilities.compareTwoStringLists2(expectedMenuOptions,actualOptions));
//        TestUtilities.compareTwoStringLists2(expectedMenuOptions,actualOptions);
//        TestUtilities.compareTwoStringLists2(expectedMenuOptions,actualOptions);
//
//        //softAssert.
//
//        //String expectedChatText = wellcomePage.text_Chats();
//       // Assert.assertEquals(expectedChatText,"ЧАТЫ","the content is not as expected");
//
//    }
//
//
//    @Test
//    public void clcikOnMenuAndVerifyContent_StatusPage() {
//        List<String> expectedOptions = Arrays.asList("Hello", "World!");
//        wellcomePage.click_StatusText();
//        statusPage.clickOnMenuFromStatusPage();
//
//        String expectedChatText = wellcomePage.text_Chats();
//        Assert.assertEquals(expectedChatText,"ЧАТЫ","the content is not as expected");
//
//    }






}

