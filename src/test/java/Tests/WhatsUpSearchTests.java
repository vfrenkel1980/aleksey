package Tests;

import Pages.BaseTest;
import Pages.WhatsUpCallPage;
import Pages.WhatsUpStatusPage;
import Pages.WhatsUpWellcomPage;
import Utils.TestUtilities;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WhatsUpSearchTests  extends BaseTest {

    WhatsUpStatusPage statusPage;
    WhatsUpWellcomPage wellcomePage;
    WhatsUpCallPage callsPage;
    @BeforeClass
    public void setUpVlad()
    {
        wellcomePage= new WhatsUpWellcomPage(getDriver(), log);

    }


    @Test()
    @Description(" Verify search button works properly chats page ")
    public void clickOnSearchButton_ChatsPage() throws InterruptedException {
        String inputText = "Omry";
        log.info("clickOnSearchButton_ChatPage ");
        wellcomePage.clickOnSearchButtonFromChatSectionAndTypeText(inputText);
        TestUtilities.AndroidBack(1);
        String actual=wellcomePage.findSearchresults();
        wellcomePage.clickOnBackButtonInSearch();
        Assert.assertTrue(actual.contains(inputText),"searched text " + inputText + "isnt presented");
        //Assert.assertTrue(1==1,"searched text " + inputText + "isnt presented");
    }


    @Test()
    @Description(" Verify search button works properly status page")
    public void clickOnSearchButton_StatusPage() throws InterruptedException {
        String inputText = "Liora";
        log.info("clickOnSearchButton_StatusPage ");
        statusPage=wellcomePage.click_StatusText();
        callsPage=new WhatsUpCallPage(getDriver(),log);

        statusPage.clickOnSearchButtonFromChatSectionAndTypeText(inputText);
        TestUtilities.AndroidBack(1);
        callsPage.findSearchResults();


        List<String> actualTotal= callsPage.searchResultsAggregate;
        HashSet<String> set = new HashSet<String>(actualTotal);
        List<String> list2 = new ArrayList<String>(set);

        callsPage.clickOnBackButtonInSearch();
        TestUtilities.AndroidBack(1);
        softAssert.assertFalse(set.size() == 0,"no  text " + inputText + " is presented  in search result " + "\n" )  ;
        softAssert.assertTrue  (set.size() == 1 ,"not only searched  text " + inputText + " is presented ");

        try {
            softAssert.assertTrue(list2.get(0).contains(inputText),"searched string  " + inputText + " is not presented");

        } catch (IndexOutOfBoundsException error) {

            log.error(error);
            softAssert.fail("cannt find " +  inputText );

        }


         softAssert.assertAll();


    }


    @Test()
    @Description(" Verify search button works properly calls page")
    public void clickOnSearchButton_CallsPage() throws InterruptedException {
        String inputText = "Пусечка";
        log.info("clickOnSearchButton_CallsPage ");
        callsPage=wellcomePage.click_CallsTextFromOtherpage();
        callsPage.clickOnSearchButtonFromCallsSectionAndTypeText(inputText);
        TestUtilities.AndroidBack(1);
        for (int i=1 ;i< 7;i++) {

            callsPage.findSearchResults();
            TestUtilities.scrollDown_Android();
        }

        List<String> actualTotal= callsPage.searchResultsAggregate;
        HashSet<String> set = new HashSet<String>(actualTotal);
        List<String> list2 = new ArrayList<String>(set);
        callsPage.clickOnBackButtonInSearch();
        TestUtilities.AndroidBack(1);


        softAssert.assertFalse(set.size() == 0,"no  text " + inputText + " is presented  in search result " + "\n" )  ;
        softAssert.assertTrue  (set.size() == 1 ,"not only searched  text " + inputText + " is presented ");


        try {
            softAssert.assertTrue(list2.get(0).contains(inputText),"searched string  " + inputText + " is not presented");

        } catch (IndexOutOfBoundsException error) {

            log.error(error);
            softAssert.fail("cannt find " +  inputText );

        }

        softAssert.assertAll();


    }

}
