package Tests.BankTfahot;

import Pages.BankTfaxotPagesMobile.BankTfahotWellcomPage;
import Pages.BankTfaxotPagesMobile.OverVeshavPage;
import Pages.BaseTest;
import Utils.TestUtilities;
import io.qameta.allure.Description;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class BankTfahotPositivLoginsTests extends BaseTest {

    BankTfahotWellcomPage  bankTfahotWellcomPage;
    OverVeshavPage overVeshavPage;


    @BeforeClass
    public void setUpVlad()
    {
        bankTfahotWellcomPage= new BankTfahotWellcomPage(getDriver(),log);

    }


    @Test (dataProvider = "JsonData")
    @Description("Verify title is correct  when application is starting  :userName/Password are correct")
    public void loginPositivеTest(String data )  {
        String param[]=data.split(",");
        log.info("verify login with user name and password works fine ");
        String expectedTextBeforeLogin = "כניסה לחשבון";
        bankTfahotWellcomPage.type_user_ID(param[0]);
        bankTfahotWellcomPage.type_user_pass(param[1]);
        String actualTextBeforeLogin=  bankTfahotWellcomPage.getTitleOfCurrentPage();

        softAssert.assertEquals(actualTextBeforeLogin,expectedTextBeforeLogin,"text " + expectedTextBeforeLogin + "isnt presented");
        overVeshavPage = bankTfahotWellcomPage.clickOnLoginButton();
        String actualTextAfterLogin = overVeshavPage.getTitleAfterLogin();


        String expectedlTextAfterLogin = "יתרה";
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
