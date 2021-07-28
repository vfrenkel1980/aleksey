package Tests;

import Pages.BaseTest;
import Pages.whatsappPages.WhatsUpCallPage;
import Pages.whatsappPages.WhatsUpStatusPage;
import Pages.whatsappPages.WhatsUpWellcomPage;
import Utils.TestUtilities;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SendMessage  extends BaseTest {





    WhatsUpStatusPage statusPage;
    WhatsUpWellcomPage wellcomePage;
    WhatsUpCallPage callsPage;
    @BeforeClass
    public void setUpVlad()
    {
        wellcomePage= new WhatsUpWellcomPage(getDriver(), log);
    }


    @Test()
    @Description(" Verify sending message works properly ")
    public void clickOnContactAndSendMessage() throws InterruptedException {
        String searchedContactText = "Пусечка";
        String inputMessageText = "krasava";
        log.info("verify sending message works properly ");

        TestUtilities.scrollToText_AndroidEmpty(searchedContactText);
        wellcomePage.clickOnTypeMessage(inputMessageText);

        String expectedTextInInputAfterSending = "Type a message";
        String actual = wellcomePage.getTextInputMessage(wellcomePage.typeMessage);

        //String actual = wellcomePage.text(wellcomePage.typeMessage);

        List<String> actualTexts = wellcomePage.findSearchResults();
        String desiredText = actualTexts.get(actualTexts.size() -1);


        softAssert.assertTrue(actual.equalsIgnoreCase(expectedTextInInputAfterSending),"type message field isnot equal to  " +  expectedTextInInputAfterSending );
        softAssert.assertTrue(actualTexts.get(actualTexts.size() -1).equalsIgnoreCase(inputMessageText),"message krasava sent unseccssfully "  );


        softAssert.assertAll();



    }


}
