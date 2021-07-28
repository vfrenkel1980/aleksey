package Tests.BankTfaxotSite;

import DataProvider.JSONReader;
import Pages.BankTfaxotPagesSite.BankTfahotWellcomPageSite;
import Pages.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BankTfaxotNegativLoginTests extends BaseTest {

    BankTfahotWellcomPageSite bankTfahotWellcomPageSite;




    @BeforeClass
    public void setUpVlad()
    {
        bankTfahotWellcomPageSite= new BankTfahotWellcomPageSite(getDriver(),log);


    }
    @Parameters("path")
    @Test
    @Description("Verify Error Message is correct when password is incorrect")
    public void loginNegativeTest(String path)  {
        log.info("verify error message is correct when typing incorrect password ");
        JSONReader jsonReader = new JSONReader(path);


        bankTfahotWellcomPageSite.clickOnLoginButton();
        bankTfahotWellcomPageSite.switchToIframe();
        bankTfahotWellcomPageSite.type_user_ID(jsonReader.readData("username"));
        bankTfahotWellcomPageSite.type_user_pass(jsonReader.readData("password"));

        bankTfahotWellcomPageSite.clickEnterButton();

        String actualErrorMessage=  bankTfahotWellcomPageSite.getErrorMessage();
        String expectedErrorMessage = "פרטי ההזדהות שהזנת שגויים, באפשרותך לנסות שנית.";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"text " + expectedErrorMessage + "isnt presented");
    }


}
