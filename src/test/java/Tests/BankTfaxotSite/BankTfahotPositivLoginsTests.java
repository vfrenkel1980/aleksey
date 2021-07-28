package Tests.BankTfaxotSite;

import Pages.BankTfaxotPagesSite.BankTfahotWellcomPageSite;
import Pages.BankTfaxotPagesSite.OverVeshaPageSite;
import Pages.BaseTest;
import io.qameta.allure.Description;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class BankTfahotPositivLoginsTests extends BaseTest {


    BankTfahotWellcomPageSite bankTfahotWellcomPageSite;
    OverVeshaPageSite  overVeshaPageSite;


    @BeforeClass
    public void setUpVlad()
    {
        bankTfahotWellcomPageSite = new BankTfahotWellcomPageSite (getDriver(), log);

    }


    @Test (dataProvider = "JsonData")
    @Description("Verify login with user name and password works fine for bank site")
    public void loginPositiveTest(String data) throws IOException, ParseException {
        String param[]=data.split(",");
        log.info("verify login with user name and password works fine for bank site");
        String expectedTextBeforeLogin = "כניסה לחשבון";
        String actualTextBeforeLogin=  bankTfahotWellcomPageSite.getTitleOfCurrentPage();
        softAssert.assertEquals(actualTextBeforeLogin,expectedTextBeforeLogin,"text " + expectedTextBeforeLogin + "isnt presented");
        bankTfahotWellcomPageSite.clickOnLoginButton();
        bankTfahotWellcomPageSite.switchToIframe();
        bankTfahotWellcomPageSite.type_user_ID(param[0]);
        bankTfahotWellcomPageSite.type_user_pass(param[1]);


        overVeshaPageSite= bankTfahotWellcomPageSite.clickEnterButton();
        String expectedlTextAfterLogin = "איזור אישי";
        String actualTextAfterLogin = overVeshaPageSite.getTitleAfterLogin();

        softAssert.assertTrue(actualTextAfterLogin.contains(expectedlTextAfterLogin),"text " + expectedlTextAfterLogin + "isnt presented");
        softAssert.assertAll();
    }


    @DataProvider(name = "JsonData")
    public Object[] readJson() throws IOException, ParseException {
        JSONParser jsonParser=new JSONParser();
        BufferedReader buff= new BufferedReader(new InputStreamReader(new FileInputStream("src/test/resources/testdata.json"), "UTF-8"));
        Object obj=jsonParser.parse(buff);
        JSONObject searchingJeson=(JSONObject) obj;
        JSONArray searchingJesonArray=(JSONArray)searchingJeson.get("userlogins");
        String arr[]=new String[searchingJesonArray.size()];
        for(int i=0; i<searchingJesonArray.size();i++){
            JSONObject search=(JSONObject)searchingJesonArray.get(i);
            String x=(String)search.get("username");
            String y=(String)search.get("password");
            arr[i]=x+","+y;

        }
        return arr;
    }



}
