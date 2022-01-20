package Tests.WhatsUp;

import Pages.BaseTest;
import Pages.whatsappPages.WhatsUpCallPage;
import Pages.whatsappPages.WhatsUpStatusPage;
import Pages.whatsappPages.WhatsUpWellcomPage;
import Utils.TestUtilities;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WhatsUpChatsTests extends BaseTest {



    WhatsUpStatusPage statusPage;
    WhatsUpWellcomPage wellcomePage;
    WhatsUpCallPage callsPage;
    @BeforeClass
    public void setUpVlad()
    {
        wellcomePage= new WhatsUpWellcomPage(getDriver(), log);

    }

    @Test()
    @Description(" VerifylongPressWorkingProperlyGroupOption")
    public void verifylongPressWorkingProperlyGroupOption() throws InterruptedException {
         String inputText = "derug lovim";
         log.info("verifylongPressWorkingProperlyGroupOption ");
         wellcomePage.longPress(inputText);
         wellcomePage.clickOnMenu();
         List<String> actualOptions = wellcomePage.getTextOfOptions(1);
         TestUtilities.AndroidBack(2);
         List<String> expectedMenuOptions = Arrays.asList("Exit group");
         Assert.assertTrue(TestUtilities.compareTwoStringLists2(expectedMenuOptions,actualOptions).isEmpty(),"longPressForGroup not working properly  " + TestUtilities.compareTwoStringLists2(expectedMenuOptions,actualOptions));

    }



    @Test()
    @Description(" VerifylongPressWorkingProperlyContactOption")
    public void verifylongPressWorkingProperlyContactOption() throws InterruptedException {
        String inputText = "Yuval";
        log.info("verifylongPressWorkingProperlyContactOption ");


        wellcomePage.longPress(inputText);
        wellcomePage.clickOnMenu();
        List<String> expectedMenuOptions = Arrays.asList("Add chat shortcut");
        List<String> actualOptions = wellcomePage.getTextOfOptions(1);
        TestUtilities.AndroidBack(2);
        Assert.assertTrue(TestUtilities.compareTwoStringLists2(expectedMenuOptions,actualOptions).isEmpty(),"longPressForContact not working properly  " + TestUtilities.compareTwoStringLists2(expectedMenuOptions,actualOptions));

    }



    @AfterMethod
    public void backToFirstView() throws InterruptedException {

        wellcomePage.getScrollUpUntilTextAndroid();

    }


}
