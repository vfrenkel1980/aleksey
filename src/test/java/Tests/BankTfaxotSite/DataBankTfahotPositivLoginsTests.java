package Tests.BankTfaxotSite;

import Pages.BankTfaxotPagesSite.BankTfahotWellcomPageSite;
import Pages.BankTfaxotPagesSite.OverVeshaPageSite;
import Pages.BaseTest;
import Utils.TestUtilities;
import io.qameta.allure.Description;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataBankTfahotPositivLoginsTests extends BaseTest {


    BankTfahotWellcomPageSite bankTfahotWellcomPageSite;
    OverVeshaPageSite  overVeshaPageSite;


    @BeforeClass
    public void setUpVlad()
    {
        bankTfahotWellcomPageSite = new BankTfahotWellcomPageSite (getDriver(), log);

    }


    @Test //(dataProvider = "dp")
    @Description("Verify login with user name and password works fine for bank site")
    public void loginPositiveTest() throws IOException, ParseException {






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
