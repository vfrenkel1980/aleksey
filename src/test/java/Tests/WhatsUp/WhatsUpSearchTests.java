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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
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
        String searchedTextChat = "Omry";
        log.info("clickOnSearchButton_ChatPage ");
        wellcomePage.clickOnSearchButtonFromChatSectionAndTypeText(searchedTextChat);
        TestUtilities.AndroidBack(1);
        String actual=wellcomePage.findSearchresults();
      //  wellcomePage.clickOnBackButtonInSearch();
        Assert.assertTrue (actual.contains(searchedTextChat),"searched text " + searchedTextChat + "isnt presented");
        //Assert.assertTrue(1==1,"searched text " + inputText + "isnt presented");
    }


    @Test()
    @Description(" Verify search button works properly status page")
    public void clickOnSearchButton_StatusPage() throws InterruptedException {
        String searchedTextStatus = "Lior";
        log.info("clickOnSearchButton_StatusPage ");
        statusPage=wellcomePage.click_StatusText();
        callsPage=new WhatsUpCallPage(getDriver(),log);

        statusPage.clickOnSearchButtonFromChatSectionAndTypeText(searchedTextStatus);
        TestUtilities.AndroidBack(1);
        callsPage.findSearchResults();


        List<String> actualTotal= callsPage.searchResultsAggregate;
        HashSet<String> set = new HashSet<String>(actualTotal);
        List<String> list2 = new ArrayList<String>(set);

        callsPage.clickOnBackButtonInSearch();
        //TestUtilities.AndroidBack(1);
        softAssert.assertFalse(set.size() == 0,"no  text " + searchedTextStatus + " is presented  in search result " + "\n" )  ;
        softAssert.assertTrue  (set.size() == 1 ,"not only searched  text " + searchedTextStatus + " is presented ");

        try {
            softAssert.assertTrue(list2.get(0).contains(searchedTextStatus),"searched string  " + searchedTextStatus + " is not presented");

        } catch (IndexOutOfBoundsException error) {

            log.error(error);
            softAssert.fail("cannt find " +  searchedTextStatus);

        }


         softAssert.assertAll();


    }


    @Test()
    @Description(" Verify search button works properly calls page")
    public void clickOnSearchButton_CallsPage() throws InterruptedException {
        String searchedTextCalls = "Oz";
        log.info("clickOnSearchButton_CallsPage ");
        callsPage=wellcomePage.click_CallsTextFromOtherpage();
        callsPage.clickOnSearchButtonFromCallsSectionAndTypeText(searchedTextCalls);
        TestUtilities.AndroidBack(1);
        for (int i=1 ;i< 7;i++) {

            callsPage.findSearchResults();
            TestUtilities.scrollDown_Android();
        }

        List<String> actualTotal= callsPage.searchResultsAggregate;
        HashSet<String> set = new HashSet<String>(actualTotal);
        List<String> list2 = new ArrayList<String>(set);



        softAssert.assertFalse(set.size() == 0,"no  text " + searchedTextCalls + " is presented  in search result " + "\n" )  ;
        softAssert.assertTrue  (set.size() == 1 ,"not only searched  text " + searchedTextCalls + " is presented ");

        try {
            softAssert.assertTrue(list2.get(0).contains(searchedTextCalls),"searched string  " + searchedTextCalls + " is not presented");

        } catch (IndexOutOfBoundsException error) {

            log.error(error);
            softAssert.fail("cannt find " +  searchedTextCalls );

        }

        softAssert.assertAll();


    }




    @AfterMethod
    public void backToFirstView()
    {

        if(testMethodName.equalsIgnoreCase("clickOnSearchButton_ChatsPage") || testMethodName.equalsIgnoreCase("clickOnSearchButton_StatusPage") ) {
            TestUtilities.AndroidBack(1);
        }
        else
        {
            TestUtilities.AndroidBack(2);
        }


    }



    @BeforeMethod
    public  String handleTestMethodName(Method method)
    {
        return testMethodName = method.getName();


    }

}
