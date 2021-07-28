package Tests.BankTfahot;

import DataProvider.JSONReader;
import Pages.BankTfaxotPagesMobile.BankTfahotWellcomPage;
import Pages.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BankTfaxotNegativLoginTests extends BaseTest {



    BankTfahotWellcomPage bankTfahotWellcomPage;



    @BeforeClass
    public void setUpVlad()
    {
        bankTfahotWellcomPage= new BankTfahotWellcomPage(getDriver(),log);

    }

    @Parameters("path")
    @Test
    @Description("Verify Error Message is correct when password is incorrect")
    public void loginNegativeTest(String path)  {
        log.info("verify error message is correct when typing incorrect password");
        JSONReader jsonReader = new JSONReader(path);
        bankTfahotWellcomPage.type_user_ID(jsonReader.readData("username"));
        bankTfahotWellcomPage.type_user_pass(jsonReader.readData("password"));

        bankTfahotWellcomPage.clickOnLoginButton();
        String actualErrorMessage=  bankTfahotWellcomPage.getErrorMessage();
        String expectedErrorMessage = "הודעת שגיאה";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"text " + expectedErrorMessage + "isnt presented");
    }


}
